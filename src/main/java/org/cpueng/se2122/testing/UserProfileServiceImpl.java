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
    public List<UserProfile> getAllUserProfiles() {
        return dao.findAll();
    }

    @Override
    public void deleteUserProfile(String email) {
        if (!StringUtils.isEmpty(email))  {
            dao.delete(email);
        }
    }

    @Override
    public UserProfile getUserProfile(String email) {
        if (!StringUtils.isEmpty(email))  {
            return dao.find(email);
        }

        return null;
    }

    @Override
    public void updateUserProfile(String currentEmail, String newEmail, String userName, String firstName, String lastName) {
        // check email if null
        if (!StringUtils.isEmpty(currentEmail))  {
            
            if (StringUtils.isEmpty(newEmail))  {
                throw new RuntimeException("Email is required");
            }
    
            // check username if null
            if (StringUtils.isEmpty(userName)) {
                throw new RuntimeException("Username is required");
            }
    
            UserProfile updatedUserProfile = new UserProfileInfo();
            updatedUserProfile.setEmail(newEmail);
            updatedUserProfile.setUsername(userName);
            updatedUserProfile.setFirstName(firstName);
            updatedUserProfile.setLastName(lastName);
    
            try {
                dao.update(currentEmail, updatedUserProfile);
                
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
