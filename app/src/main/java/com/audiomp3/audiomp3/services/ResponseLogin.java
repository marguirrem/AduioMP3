package com.audiomp3.audiomp3.services;

public class ResponseLogin {

    private String first_name;
    private String last_name;
    private String username;
    private String email;
    private String updatedAt;
    private String createdAt;
    private String id;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseLogin() {
    }

    /**
     *
     * @param id
     * @param updated_at
     * @param last_name
     * @param username
     * @param email
     * @param created_at
     * @param first_name
     */
    public ResponseLogin(String first_name, String last_name, String username, String email,
                         String updated_at, String created_at, String id) {
        super();
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.email = email;
        this.updatedAt = updated_at;
        this.createdAt = created_at;
        this.id = id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



}
