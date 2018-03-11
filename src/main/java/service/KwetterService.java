package service;

import dao.KweetDAO;
import dao.UserDAO;
import domain.Kweet;
import domain.User;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.util.*;

@Stateless
public class KwetterService {

    @Inject @Default
    private UserDAO userDAO;
    @Inject @Default
    private KweetDAO kweetDAO;

    public KwetterService() {
    }

    /**
     * Verify passed credentials for login.
     * @param username Username to verify.
     * @param password Password to verify.
     * @return Whether the credentials were valid or not.
     */
    public boolean login(String username, String password) {
        return userDAO.login(username, password);
    }

    /**
     * Register a new account.
     * @param username User's username.
     * @param password User's password.
     * @param displayName User's display name.
     * @param avatar User's avatar.
     * @param biography User's biography.
     * @param location User's location.
     * @param website User's website.
     * @return Whether registration was successful or not.
     */
    public boolean register(String username, String password, String displayName, String avatar, String biography, String location, String website, boolean isAdmin) {
        User user = new User(username,
                             password,
                             displayName,
                             avatar,
                             biography,
                             location,
                             website,
                             isAdmin);
        return userDAO.register(user);
    }

    /**
     * Update a user's data.
     * @param username User's username.
     * @param password User's password.
     * @param displayName User's display name.
     * @param avatar User's avatar.
     * @param biography User's biography.
     * @param location User's location.
     * @param website User's website.
     * @return Whether updating was successful or not.
     */
    public boolean updateUser(String username, String password, String displayName, String avatar, String biography, String location, String website) {
        return userDAO.updateUser(username,
                             password,
                             displayName,
                             avatar,
                             biography,
                             location,
                             website);
    }

    /**
     * Remove user from database.
     * @param username User's username to remove.
     * @return Whether removal of user was successful or not.
     */
    public boolean removeUser(String username) {
        return userDAO.removeUser(username);
    }

    /**
     * Toggle whether a user is admin or not.
     * @param username User's username to toggle admin rights of.
     * @param invoker User's username that issues to admin right toggle.
     * @return Whether the change of admin priveleges was successful or not.
     */
    public boolean toggleAdmin(String username, String invoker) {
        User issuer = userDAO.getUser(invoker);
        if (issuer == null || !issuer.getIsAdmin())
            return false;

        return userDAO.toggleAdmin(username, invoker);
    }

    /**
     * Search for user with specific username.
     * @param username User's username to look for.
     * @return User object or null if nothing found.
     */
    public User getUser(String username) {
        return userDAO.getUser(username);
    }
    
    /**
     * Get all users.
     * @return List of all users.
     */
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    /**
     * Get all users that follow a user.
     * @param username User's username to get followers of.
     * @return List of followers or null if user not found.
     */
    public List<String> getUserFollowers(String username) {
        return userDAO.getUserFollowers(username);
    }

    /**
     * Get all users that a user is following.
     * @param username User's username to get following of.
     * @return List of following users or null if user not found.
     */
    public List<String> getUserFollowing(String username) {
        return userDAO.getUserFollowing(username);
    }

    /**
     * Toggle whether following a user or not.
     * @param follower Username of account that's following
     * @param followed Username of account that's being followed
     * @return Whether the toggle of following a user was successful or not.
     */
    public boolean toggleFollowUser(String follower, String followed) {
        return userDAO.toggleFollowUser(follower, followed);
    }

    /**
     * Get all kweets from user.
     * @param username User's username to look kweets up of.
     * @return List of kweets from user or null if user not found.
     */
    public List<Kweet> getUserKweets(String username) {
        return kweetDAO.getUserKweets(username);
    }

    /**
     * Get all kweets that are on the timeline of a user.
     * @param username User's username to get timeline of.
     * @return List of timeline kweets or null if user not found.
     */
    public List<Kweet> getTimelineKweets(String username) {
        return kweetDAO.getTimelineKweets(username);
    }

    /**
     * Get all kweets that a user is mentioned in.
     * @param username User's username to get mentioned kweets of.
     * @return List of mentioned kweets or null if user not found.
     */
    public List<Kweet> getMentionKweets(String username) {
        return kweetDAO.getMentionKweets(username);
    }

    /**
     * Get all kweets from a topic.
     * @param topic Name of topic.
     * @return List of kweets on topic or null if topic not found.
     */
    public List<Kweet> getTopicKweets(String topic) {
        return kweetDAO.getTopicKweets(topic);
    }

    /**
     * Get top trending topics.
     * @param amount How many topics to obtain.
     * @return List of trending topics.
     */
    public List<String> getTrendingTopics() {
        return kweetDAO.getTrendingTopics();
    }

    /**
     * Post a kweet as user.
     * @param message Body of kweet.
     * @param username User's username who posts kweet.
     * @return Whether posting the kweet was successful or not.
     */
    public boolean postKweet(String message, String username) {
        return kweetDAO.postKweet(message, username);
    }

    /**
     * Toggle whether liked a kweet or not.
     * @param kweetId ID of kweet to toggle like of.
     * @param username User's username who toggles the like.
     * @return Whether the toggle of liking a kweet was successful or not.
     */
    public boolean likeKweet(long kweetId, String username) {
        return kweetDAO.likeKweet(kweetId, username);
    }

    /**
     * Get all kweets.
     * @return List of all kweets.
     */
    public List<Kweet> getAllKweets() {
        return kweetDAO.getAllKweets();
    }

    /**
     * Remove a kweet.
     * @param kweetId Id of kweet to remove.
     * @return Whether the removal of kweet was successful or not.
     */
    public boolean removeKweet(long kweetId) {
        return kweetDAO.removeKweet(kweetId);
    }
}