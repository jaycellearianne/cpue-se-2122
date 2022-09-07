package org.cpueng.se2122.testing;

import java.util.List;

public interface UserProfileService {
    /**
     * 
     * @param email - email of the user profile to create, and is a required field.
     * @param userName - username of the user profile to create, and is a required field.
     * @param firstName - nullable.
     * @param lastName - nullable.
     */
    void createUserProfile(String email, String userName, String firstName, String lastName);

    /**
     * 
     * @param email - email of the user profile to create, and is a required field.
     * @param userName - username of the user profile to create, and is a required field.
     * @param firstName - nullable 
     * @param lastName - nullable
     */
    void updateUserProfile(String email, String userName, String firstName, String lastName);

    /**
     * 
     * @param email - email of the user profile to query.
     * @return
     */
    UserProfileRecord getUserProfile(String email);

    /**
     * 
     * @return
     */
    List<UserProfileRecord> getAllUserProfiles();

    /**
     * 
     * @param email - email of the user profile to delete.
     */
    void deleteUserProfile(String email);
}
