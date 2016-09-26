package com.rakeup.rakeup.objects;

/**
 * Created by emre on 30.08.16.
 */
public class User {
    
    private long id;
    private String name;
    private String username;
    private String password;
    private byte[] picture;

    public User() {
    }

    public User(long id, String name, String username) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.picture = picture;
    }

    public User(long id, String name, String username, byte[] picture) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.picture = picture;
    }

    public User(long id, String name, String username, String password, byte[] picture) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.picture = picture;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() { return "@" + username; }

    public String getPassword() {
        return password;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setId(long id) {
    
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPicture(byte[] profilepicture) {
        this.picture = profilepicture;
    }
}
