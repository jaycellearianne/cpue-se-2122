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
     * @param currentEmail - current email.
     * @param newEmail - new email of the user profile to create, and is a required field. If different 
     *                  from the current email, then this will replace the current email as the new
     *                  identifier for the user profile.
     * 
     * @param userName - username of the user profile to create, and is a required field.
     * @param firstName - nullable 
     * @param lastName - nullable
     */
    void updateUserProfile(String currentEmail, String newEmail, String userName, String firstName, String lastName);

    /**
     * 
     * @param email - email of the user profile to query.
     * @return
     */
    UserProfile getUserProfile(String email);

    /**
     * 
     * @return
     */
    List<UserProfile> getAllUserProfiles();

    /**
     * 
     * @param email - email of the user profile to delete.
     */
    void deleteUserProfile(String email);
}
