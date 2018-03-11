/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nick de Kort
 */

public class User implements Serializable {
    
    private Long id;
    private String username;
    private String password;
    private String displayName;
    private String avatar;
    private String biography;
    private String location;
    private String website;
    private Boolean isAdmin;
    private List<String> followers;
    private List<String> following;
    
    public User(String username, String password, String displayName, String avatar, String biography, String location, String website, Boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.displayName = displayName;
        this.avatar = avatar;
        this.biography = biography;
        this.location = location;
        this.website = website;
        this.isAdmin = isAdmin;
        this.followers = new ArrayList<String>();
        this.following = new ArrayList<String>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public List<String> getFollowers() {
        return followers;
    }

    public Boolean isFollower(String username) {
        return followers.contains(username);
    }

    public void addFollower(String username) {
        this.followers.add(username);
    }

    public List<String> getFollowing() {
        return following;
    }

    public Boolean isFollowing(String username) {
        return following.contains(username);
    }

    public void addFollowing(String username) {
        this.following.add(username);
    }

    public void removeFollowing(String username) {
        this.following.remove(this.following.indexOf(username));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return Objects.equals(this.username, other.username);
    }
    
}
