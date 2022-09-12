package org.cpueng.se2122.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserProfileServiceImplTest {

    UserProfileServiceImpl serviceImpl;
    UserProfileDAO dao;
    
    // @BeforeAll
    // public void setup() {
    //     // Put all the initialization here before the start of this test suite.
    // }

    @BeforeEach
    public void init() {
        dao = new UserProfileDAOMockImpl();
        serviceImpl = new UserProfileServiceImpl(dao);
    }

    @Test
    @DisplayName("Should be able to create user profile successfully")
    public void testCreateUserProfile() {
        // Given
        String email = "fakeemail@gmail.com";
        String firstName = "John";
        String lastName = "Doe";
        String userName = "johndoe";

        // When
        serviceImpl.createUserProfile(email, userName, firstName, lastName);

        // Then
        UserProfile userProfileFromDB = dao.find(email);
        assertEquals(email, userProfileFromDB.getEmail());
    }

    @Test
    @DisplayName("Should be able to delete user profile successfully")
    public void testDeleteUserProfile() {
        // Given
        String email = "fakeemail@gmail.com";
        String firstName = "John";
        String lastName = "Doe";
        String userName = "johndoe";

        serviceImpl.createUserProfile(email, userName, firstName, lastName);

        // When
        serviceImpl.deleteUserProfile(email);

        // Then
        UserProfile shoudlBeNullProfile = dao.find(email);
        assertEquals(null, shoudlBeNullProfile);
    }

    @Test
    @DisplayName("Should be able to update user profile successfully")
    public void testUpdateUserProfile() {
        // Given
        String email = "fakeemail@gmail.com";
        String firstName = "John";
        String lastName = "Doe";
        String userName = "johndoe";

        serviceImpl.createUserProfile(email, userName, firstName, lastName);

        // When
        String updatedName = "Jan";
        String updatedLastname = "Bravo";
        String updatedUsername = "johnnybravo";
        serviceImpl.updateUserProfile(email, email, updatedUsername, updatedName, updatedLastname);
    
        // Then
        UserProfile profileFromRecords = dao.find(email);
        assertEquals(updatedName, profileFromRecords.getFirstName());
        assertEquals(updatedLastname, profileFromRecords.getLastName());
        assertEquals(updatedUsername, profileFromRecords.getUsername());
        assertEquals(email, profileFromRecords.getEmail());
    }

    @Test
    @DisplayName("Should be able to find user profile successfully")
    public void testFindUserProfile() {
        // Given
        String email = "fakeemail@gmail.com";
        String firstName = "John";
        String lastName = "Doe";
        String userName = "johndoe";

        serviceImpl.createUserProfile(email, userName, firstName, lastName);

        // When
    
        UserProfile profile = serviceImpl.getUserProfile(email);

        // Then
        UserProfile profileFromDAO = dao.find(email);
        assertEquals(firstName, profileFromDAO.getFirstName());
        assertEquals(lastName, profileFromDAO.getLastName());
        assertEquals(userName, profileFromDAO.getUsername());
        assertEquals(email, profileFromDAO.getEmail());

        assertEquals(firstName, profile.getFirstName());
        assertEquals(lastName, profile.getLastName());
        assertEquals(userName, profile.getUsername());
        assertEquals(email, profile.getEmail());

        assertTrue(profileFromDAO.getFirstName().equals(profile.getFirstName()));
        assertTrue(profileFromDAO.getLastName().equals(profile.getLastName()));
        assertTrue(profileFromDAO.getUsername().equals(profile.getUsername()));
        assertTrue(profileFromDAO.getEmail().equals(profile.getEmail()));
    }

    @Test
    @DisplayName("Should be able to find all user profiles successfully")
    public void testFindAllUserProfiles() {
        // Given
        String email1 = "fakeemail@gmail.com";
        String firstName1 = "John";
        String lastName1 = "Doe";
        String userName1 = "johndoe";

        String email2 = "myown@outlook.com";
        String firstName2 = "Jan";
        String lastName2 = "Bravo";
        String userName2 = "johnnybravo";

        serviceImpl.createUserProfile(email1, userName1, firstName1, lastName1);
        serviceImpl.createUserProfile(email2, userName2, firstName2, lastName2);

        // When
        List<UserProfile> profiles = serviceImpl.getAllUserProfiles();

        assertEquals(2, profiles.size());

        for (int x = 0; x < profiles.size(); x++) {
            UserProfile profile = profiles.get(x);
            if (profile.getEmail().equals(email1)) {
                assertEquals(firstName1, profile.getFirstName());
                assertEquals(lastName1, profile.getLastName());
                assertEquals(userName1, profile.getUsername());
                assertEquals(email1, profile.getEmail());

            } else if (profile.getEmail().equals(email2)) {
                assertEquals(firstName2, profile.getFirstName());
                assertEquals(lastName2, profile.getLastName());
                assertEquals(userName2, profile.getUsername());
                assertEquals(email2, profile.getEmail());

            } else {
                fail();
            }
        }

    }

    @Test
    public void expectErrorWhenEmailIsEmpty() {
        RuntimeException thrown = assertThrows(
            RuntimeException.class, 
            () -> { 
                serviceImpl.createUserProfile(
                null, 
                "username", 
                "firstname", 
                "lastname"); 
            },
            "Expected createUserProfile() to throw, but it didn't");

        assertTrue(thrown.getMessage().contains("Email is required"));
    };

    
}
