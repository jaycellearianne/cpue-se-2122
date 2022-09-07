package org.cpueng.se2122.testing;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class UserProfileDAODataSaverImpl implements UserProfileDAO {

    DatabaseDriver<UserProfileRecord> databaseDriver;

    public UserProfileDAODataSaverImpl(DatabaseDriver<UserProfileRecord> databaseDriver) {
        this.databaseDriver = databaseDriver;
    }
    
    @Override
    public void add(UserProfile userProfile) throws IOException {
        if (userProfile != null) {
            if (StringUtils.isEmpty(userProfile.getEmail())) {
                throw new IOException("Cannot save user profile, email is required!");
            }
    
            if (StringUtils.isEmpty(userProfile.getUsername())) {
                throw new IOException("Cannot save user profile, username is required!");
            }

            UserProfileRecord record = new UserProfileRecord(
                userProfile.getLastName(), 
                userProfile.getFirstName(), 
                userProfile.getEmail(), 
                userProfile.getUsername());
    
                databaseDriver.add(record);
        }
    }

    @Override
    public UserProfile find(String email) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserProfile> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(String email, UserProfile updatedUserProfile) throws IOException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(String email) {
        // TODO Auto-generated method stub
        
    }

}
