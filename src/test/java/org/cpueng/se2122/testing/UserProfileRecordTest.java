package org.cpueng.se2122.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserProfileRecordTest {

    @BeforeAll
    public void setup() {
        // Put all the initialization here before the start of this test suite.
    }

    @BeforeEach
    public void init() {
        // Put all the initialization here before the start of each test.
    }

    @Test
    @DisplayName("All setters and getters should work correctly")
    public void testSettersAndGettersWorkingCorrectly() {
        // Given
        UserProfileRecord userProfile = new UserProfileRecord();

        Long id = 1L;
        String email = "fakeemail@gmail.com";
        String firstName = "John";
        String lastName = "Doe";
        String userName = "johndoe";

        // When
        userProfile.setId(id);
        userProfile.setEmail(email);
        userProfile.setFirstName(firstName);
        userProfile.setLastName(lastName);
        userProfile.setUsername(userName);

        // Then
        assertEquals(userProfile.getId(), id);
        assertEquals(userProfile.getEmail(), email);
        assertEquals(userProfile.getFirstName(), firstName);
        assertEquals(userProfile.getLastName(), lastName);
        assertEquals(userProfile.getUsername(), userName);
    }

    @Test
    @DisplayName("Secondary constructor should work correctly")
    public void testSecondaryConstructorWorkingCorrectly() {
        // Given
        String email = "fakeemail@gmail.com";
        String firstName = "John";
        String lastName = "Doe";
        String userName = "johndoe";

        // When
        UserProfileRecord userProfile = new UserProfileRecord(lastName, firstName, email, userName);

        // Then
        assertEquals(email, userProfile.getEmail());
        assertEquals(firstName, userProfile.getFirstName());
        assertEquals(lastName, userProfile.getLastName());
        assertEquals(userName, userProfile.getUsername());
        assertNull(userProfile.getId());
    }
    
}
