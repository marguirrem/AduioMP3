package com.audiomp3.audiomp3.services;

/**
 * Created by marlon on 29/01/18.
 */


public class ResponseRegister {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String updatedAt;
    private String createdAt;
    private String id;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseRegister() {
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
    public ResponseRegister(String first_name, String last_name, String username, String email, String updated_at, String created_at, String id) {
        super();
        this.firstName = first_name;
        this.lastName = last_name;
        this.username = username;
        this.email = email;
        this.updatedAt = updated_at;
        this.createdAt = created_at;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

