package org.cpueng.se2122.testing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class UserProfileDAOMockImpl implements UserProfileDAO {
    Map<String, UserProfile> dataMap;

    public UserProfileDAOMockImpl() {
        dataMap = new HashMap<>();
    }

    @Override
    public void add(UserProfile userProfile) throws IOException {
        if (StringUtils.isEmpty(userProfile.getEmail())) {
            throw new IOException();
        }

        dataMap.put(userProfile.getEmail(), userProfile);
    }

    @Override
    public UserProfile find(String email) {
        if (!StringUtils.isEmpty(email)) {
            return dataMap.get(email);
        }
        
        return null;
    }

    @Override
    public List<UserProfile> findAll() {
        return new ArrayList<>(dataMap.values());
    }

    @Override
    public void update(String email, UserProfile updatedUserProfile) throws IOException {
        if (StringUtils.isEmpty(email)) {
            throw new IOException();
        }

        if (StringUtils.isEmpty(updatedUserProfile.getEmail())) {
            throw new IOException();
        }
        

        if (email != updatedUserProfile.getEmail()) {
            dataMap.remove(email);
            dataMap.put(updatedUserProfile.getEmail(), updatedUserProfile);
        } else {
            dataMap.put(email, updatedUserProfile);
        }
    }

    @Override
    public void delete(String email) {
        if (!StringUtils.isEmpty(email)) {
            dataMap.remove(email);
        }
    }
}
