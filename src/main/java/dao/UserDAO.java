/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nick de Kort
 */
public interface UserDAO {

    boolean login(String username, String password);
    
    boolean register(User user);
    
    boolean updateUser(String username, String password, String displayName, String avatar, String biography, String location, String website);
    
    boolean removeUser(String username);
    
    boolean toggleAdmin(String username, String invoker);
    
    User getUser(String username);
    
    List<User> getAllUsers();
    
    List<String> getUserFollowers(String username);
            
    List<String> getUserFollowing(String username);
            
    boolean toggleFollowUser(String followedUsername, String followingUsername);
    
}
