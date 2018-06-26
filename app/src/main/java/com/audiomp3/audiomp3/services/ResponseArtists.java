package com.audiomp3.audiomp3.services;

public class ResponseArtists {

    private int id;
    private String name;
    private String photo;
    private String bio;
    private String createdAt;
    private String updatedAt;

    /**
     *
     * @param updatedAt
     * @param id
     * @param bio
     * @param createdAt
     * @param name
     * @param photo
     */
    public ResponseArtists(int id, String name, String photo, String bio, String createdAt, String updatedAt) {
        super();
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.bio = bio;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }


}
