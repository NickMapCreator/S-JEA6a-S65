/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Kweet;
import domain.User;
import java.util.List;

/**
 *
 * @author Nick de Kort
 */
public interface KweetDAO {

    List<Kweet> getUserKweets(String username);

    List<Kweet> getTimelineKweets(String username);

    List<Kweet> getMentionKweets(String username);
    
    List<Kweet> getTopicKweets(String topic);
    
    List<String> getTrendingTopics();
    
    boolean postKweet(String username, String message);
    
    boolean likeKweet(long id, String username);

    List<Kweet> getAllKweets();

    boolean removeKweet(long id);
    
}
