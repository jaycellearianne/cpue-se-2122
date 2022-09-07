package org.cpueng.se2122.testing;

public class UserProfileRecord extends UserProfile implements Recordable {
    private Long id;

    public UserProfileRecord() {

    }

    public UserProfileRecord(String lastName, String firstName, String email, String userName) {
        setLastName(lastName);
        setFirstName(firstName);
        setEmail(email);
        setUsername(userName);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
