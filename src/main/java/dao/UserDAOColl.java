/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

@Stateless @Default
public class UserDAOColl implements UserDAO {

    CopyOnWriteArrayList<User> users = new CopyOnWriteArrayList<>();

    public UserDAOColl() {
        //
    }
    
    @PostConstruct
    private void init(){
       System.out.println("UserDaoColl");
    }
    
    @Override
    public boolean login(String username, String password)
    {
        Stream<User> users = this.users.stream();
        users = users.filter(pf -> pf.getUsername().equals(username));
        users = users.filter(pf -> pf.getPassword().equals(password));
        User foundUser = users.findFirst().orElse(null);
        return (foundUser != null);
    }
    
    @Override
    public boolean register(User user)
    {
        this.users.add(user);
        return true;
    }
    
    @Override
    public boolean updateUser(String username, String password, String displayName, String avatar, String biography, String location, String website)
    {
        Stream<User> users = this.users.stream();
        users = users.filter(pf -> pf.getUsername().equals(username));
        User user = users.findFirst().orElse(null);
        user.setPassword(password);
        user.setDisplayName(displayName);
        user.setAvatar(avatar);
        user.setBiography(biography);
        user.setLocation(location);
        user.setWebsite(website);
        return true;
    }
    
    @Override
    public boolean toggleAdmin(String username, String invoker)
    {
        Stream<User> users = this.users.stream();
        
        // Check if invoker is actually an admin
        Stream<User> adminUsers = users.filter(pf -> pf.getUsername().equals(invoker) && pf.getIsAdmin());
        User adminUser = adminUsers.findFirst().orElse(null);
        if (adminUser == null) return false;
        
        // Toggle the user's admin status
        users = users.filter(pf -> pf.getUsername().equals(username));
        User user = users.findFirst().orElse(null);
        user.setIsAdmin(!user.getIsAdmin());
        return true;
    }
    
    @Override
    public User getUser(String username)
    {
        Stream<User> users = this.users.stream();
        users = users.filter(pf -> pf.getUsername().equals(username));
        return users.findFirst().orElse(null);
    }
    
    @Override
    public List<User> getAllUsers()
    {
        return this.users;
    }
    
    @Override
    public List<String> getUserFollowers(String username)
    {
        Stream<User> users = this.users.stream();
        users = users.filter(pf -> pf.getUsername().equals(username));
        User user = users.findFirst().orElse(null);
        return user.getFollowers();
    }
            
    @Override
    public List<String> getUserFollowing(String username)
    {
        Stream<User> users = this.users.stream();
        users = users.filter(pf -> pf.getUsername().equals(username));
        User user = users.findFirst().orElse(null);
        return user.getFollowing();
    }
            
    @Override
    public boolean toggleFollowUser(String follower, String followed)
    {
        Stream<User> users = this.users.stream();
        Stream<User> followingUsers = users.filter(pf -> pf.getUsername().equals(follower));
        User followingUser = followingUsers.findFirst().orElse(null);
        if (followingUser == null) return false;
        if (followingUser.isFollowing(followed)) {
            followingUser.removeFollowing(followed);
        }
        
        Stream<User> followerUsers = users.filter(pf -> pf.getUsername().equals(followed));
        User followerUser = followerUsers.findFirst().orElse(null);
        if (followingUser == null) return false;
        if (followingUser.isFollower(follower)) {
            followingUser.removeFollowing(follower);
        }
        return true;
    } 

    @Override
    public boolean removeUser(String username) {
        Stream<User> users = this.users.stream();
        users = users.filter(pf -> pf.getUsername().equals(username));
        User user = users.findFirst().orElse(null);
        if (user == null) return false;
        this.users.remove(user);
        return true;
    }
  
}
