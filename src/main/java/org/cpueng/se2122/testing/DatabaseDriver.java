package org.cpueng.se2122.testing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseDriver<T extends Recordable> {
    private Map<Long, T> dataMap;
    private int transactionCounter;

    public DatabaseDriver() {
        dataMap = new HashMap<>();
    }

    public void add(T entity) throws IOException {
        if (entity == null) {
            throw new IOException("Data being added is empty!");
        }

        transactionCounter++;
        String idStr = "" + transactionCounter;

        dataMap.put(Long.parseLong(idStr), entity);
    }

    public T find(Long id) throws IOException {
        if (id == null) {
            throw new IOException("ID should not be empty!");
        }

        return dataMap.get(id);
    }

    public List<T> findAll() {
        List<T> dataList = new ArrayList<>(dataMap.values());
        return dataList;
    }

    public void update(Long id, T entity) throws IOException {
        if (id != null) {
            entity.setId(id);
            dataMap.put(entity.getId(), entity);
        }
    }

    public void delete(Long id) {
        if (id != null) {
            dataMap.remove(id);
        }
    }
}
