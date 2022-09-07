package org.cpueng.se2122.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserProfileServiceImplTest {

    UserProfileServiceImpl serviceImpl;
    UserProfileDAO dao;
    
    @BeforeAll
    public void setup() {
        // Put all the initialization here before the start of this test suite.
    }

    @BeforeEach
    public void init() {
        // Put all the initialization here before the start of each test.
    }

    @Test
    @DisplayName("Should be able to create user profile successfully")
    public void testCreateUserProfile() {
        dao = new UserProfileDAOMockImpl();
        serviceImpl = new UserProfileServiceImpl(dao);

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
}
