package org.cpueng.se2122.testing;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class UserProfileServiceImpl implements UserProfileService {
    private UserProfileDAO dao;

    public UserProfileServiceImpl(UserProfileDAO dao) {
        this.dao = dao;
    }

    @Override
    public void createUserProfile(String email, String userName, String firstName, String lastName) {
        // check email if null
        if (StringUtils.isEmpty(email))  {
            throw new RuntimeException("Email is required");
        }

        // check username if null
        if (StringUtils.isEmpty(userName)) {
            throw new RuntimeException("Username is required");
        }

        // populate data object
        UserProfile user = new UserProfileInfo();
        user.setEmail(email);
        user.setUsername(userName);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        // send to data access class/object
        try {
            dao.add(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserProfileRecord> getAllUserProfiles() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteUserProfile(String email) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public UserProfileRecord getUserProfile(String email) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateUserProfile(String email, String userName, String firstName, String lastName) {
        // TODO Auto-generated method stub
        
    }
}
