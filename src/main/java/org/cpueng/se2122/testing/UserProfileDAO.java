package org.cpueng.se2122.testing;

import java.io.IOException;
import java.util.List;

public interface UserProfileDAO {
    /**
     * Adds the user profile record to the database.
     * 
     * @param userProfile - the UserProfile object that represents the user profile data being added.
     * @throws IOException - when the UserProfile object does not contain email.
     */
    void add(UserProfile userProfile) throws IOException;

    /**
     * Find user profile record by email.
     * 
     * @param email - the email of the user profile being queried.
     * @return - UserProfile object that represents the user profile record.  Null if not found.
     */
    UserProfile find(String email);

    /**
     * Queries all user profile records from the database. 
     * 
     * @return - list of UserProfile objects that represents all user profile records.
     */
    List<UserProfile> findAll();

    /**
     * Updates a user profile record.  Email is used to find the user profile to update.
     * When the record is found, the record's details are updated using the information supplied.
     *   
     * If the email used for finding the record is different from the email in the supplied
     * updated information, then the associated email for the record will updated too.
     * 
     * @param email - the email to use in order to find the record to be updated.
     * @param updatedUserProfile - the UserProfile object that represents the supplied information to update the record.
     * @throws IOException - when the email is null or when supplied update information email is null.
     */
    void update(String email, UserProfile updatedUserProfile) throws IOException;

    /**
     * Deletes a user profile record by email.
     * 
     * @param email
     */
    void delete(String email);
}
