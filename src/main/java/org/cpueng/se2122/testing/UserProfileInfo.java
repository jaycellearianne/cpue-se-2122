package org.cpueng.se2122.testing;

public class UserProfileInfo extends UserProfile {
    public UserProfileInfo() {
        // no args (default) constructore
    }

    public UserProfileInfo(String firstName, String lastName, String email, String userName) {
        setLastName(lastName);
        setFirstName(firstName);
        setEmail(email);
        setUsername(userName);
    }
}
