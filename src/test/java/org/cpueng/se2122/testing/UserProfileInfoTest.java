package org.cpueng.se2122.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserProfileInfoTest {

    @Test
    @DisplayName("All setters and getters should work correctly")
    public void testSettersAndGettersWorkingCorrectly() {
        // Given
        UserProfileInfo userProfile = new UserProfileInfo();

        String email = "fakeemail@gmail.com";
        String firstName = "John";
        String lastName = "Doe";
        String userName = "johndoe";

        // When
        userProfile.setEmail(email);
        userProfile.setFirstName(firstName);
        userProfile.setLastName(lastName);
        userProfile.setUsername(userName);

        // Then
        assertEquals(email, userProfile.getEmail());
        assertEquals(firstName, userProfile.getFirstName());
        assertEquals(lastName, userProfile.getLastName());
        assertEquals(userName, userProfile.getUsername());
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
        UserProfileInfo userProfile = new UserProfileInfo(firstName, lastName, email, userName);

        // Then
        assertEquals(email, userProfile.getEmail());
        assertEquals(firstName, userProfile.getFirstName());
        assertEquals(lastName, userProfile.getLastName());
        assertEquals(userName, userProfile.getUsername());
    }
    
}
