package org.cpueng.se2122.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/*
 * This is another version of UserProfileServiceImplTest but uses Mockito's dynamic mocking.
 */
@ExtendWith(MockitoExtension.class)
public class UserProfileServiceImplTest2 {
    
    @Mock
    UserProfileDAO dao;

    @InjectMocks
    UserProfileServiceImpl fixture;

    @Test
    @DisplayName("Should be able to create user profile successfully")
    public void testCreateUserProfile() throws Exception {

        // Given
        String email = "fakeemail@gmail.com";
        String firstName = "John";
        String lastName = "Doe";
        String userName = "johndoe";

        // When
        fixture.createUserProfile(email, userName, firstName, lastName);

        // Then
        ArgumentCaptor<UserProfile> argument = ArgumentCaptor.forClass(UserProfile.class);
        verify(dao).add(argument.capture());
        assertEquals(lastName, argument.getValue().getLastName());
        assertEquals(firstName, argument.getValue().getFirstName());
        assertEquals(userName, argument.getValue().getUsername());
        assertEquals(email, argument.getValue().getEmail());
    }

    @Test
    @DisplayName("Should be able to delete user profile successfully")
    public void testDeleteUserProfile() {

        // Given
        String email = "fakeemail@gmail.com";

        // When
        fixture.deleteUserProfile(email);

        // Then
        verify(dao).delete(eq(email));
    }

    @Test
    @DisplayName("Should be able to update user profile successfully")
    public void testUpdateUserProfile() throws Exception {

        // Given
        String email = "fakeemail@gmail.com";
        String updatedName = "Jan";
        String updatedLastname = "Bravo";
        String updatedUsername = "johnnybravo";

        // When
        fixture.updateUserProfile(email, email, updatedUsername, updatedName, updatedLastname);
    
        // Then
        ArgumentCaptor<UserProfile> argument = ArgumentCaptor.forClass(UserProfile.class);
        verify(dao).update(eq(email), argument.capture());
        assertEquals(updatedLastname, argument.getValue().getLastName());
        assertEquals(updatedName, argument.getValue().getFirstName());
        assertEquals(updatedUsername, argument.getValue().getUsername());
        assertEquals(email, argument.getValue().getEmail());
    }

    @Test
    @DisplayName("Should be able to find user profile successfully")
    public void testFindUserProfile() {

        // Given
        String email = "fakeemail@gmail.com";
        String firstName = "John";
        String lastName = "Doe";
        String userName = "johndoe";

        UserProfile profileToReturn = mock(UserProfile.class);
        when(profileToReturn.getEmail()).thenReturn(email);
        when(profileToReturn.getLastName()).thenReturn(lastName);
        when(profileToReturn.getFirstName()).thenReturn(firstName);
        when(profileToReturn.getUsername()).thenReturn(userName);

        when(dao.find(eq(email))).thenReturn(profileToReturn);

        // When
        UserProfile profile = fixture.getUserProfile(email);

        // Then
        assertNotNull(profile);
        assertEquals(firstName, profile.getFirstName());
        assertEquals(lastName, profile.getLastName());
        assertEquals(userName, profile.getUsername());
        assertEquals(email, profile.getEmail());
    }

    @Test
    @DisplayName("Should be able to find all user profiles successfully")
    public void testFindAllUserProfiles() {

        // Given
        String email1 = "fakeemail@gmail.com";
        String firstName1 = "John";
        String lastName1 = "Doe";
        String userName1 = "johndoe";

        UserProfile profileToReturn1 = mock(UserProfile.class);
        when(profileToReturn1.getEmail()).thenReturn(email1);
        when(profileToReturn1.getLastName()).thenReturn(lastName1);
        when(profileToReturn1.getFirstName()).thenReturn(firstName1);
        when(profileToReturn1.getUsername()).thenReturn(userName1);

        String email2 = "myown@outlook.com";
        String firstName2 = "Jan";
        String lastName2 = "Bravo";
        String userName2 = "johnnybravo";

        UserProfile profileToReturn2 = mock(UserProfile.class);
        when(profileToReturn2.getEmail()).thenReturn(email2);
        when(profileToReturn2.getLastName()).thenReturn(lastName2);
        when(profileToReturn2.getFirstName()).thenReturn(firstName2);
        when(profileToReturn2.getUsername()).thenReturn(userName2);

        List<UserProfile> listToReturn = new ArrayList<>();
        listToReturn.add(profileToReturn1);
        listToReturn.add(profileToReturn2);

        when(dao.findAll()).thenReturn(listToReturn);

        // When
        List<UserProfile> profiles = fixture.getAllUserProfiles();

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
}