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
public class Kweet implements Serializable {
    
    private Long id;
    private String username;
    private String message;
    private String trend;
    private List<String> likedBy;

    public Kweet() {
    }

    public Kweet(String name, String message) {
        this.username = name;
        this.message = message;
        this.likedBy = new ArrayList<String>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTrend() {
        return trend;
    }

    public void setTrend(String trend) {
        this.trend = trend;
    }

    public boolean isLikedBy(String username) {
        return likedBy.contains(username);
    }

    public void addLikedBy(String username) {
        this.likedBy.add(username);
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
        final Kweet other = (Kweet) obj;
        return Objects.equals(this.username, other.username);
    }
}
