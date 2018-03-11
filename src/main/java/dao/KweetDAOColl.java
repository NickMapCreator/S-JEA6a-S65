/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Kweet;
import domain.User;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

/**
 *
 * @author Nick de Kort
 */
@Stateless @Default
public class KweetDAOColl implements KweetDAO {

    CopyOnWriteArrayList<Kweet> kweets = new CopyOnWriteArrayList<>();
    
    @Override
    public List<Kweet> getUserKweets(String username) {
        Stream<Kweet> kweets = this.kweets.stream();
        kweets = kweets.filter(pf -> pf.getName().equals(username));
        return (List<Kweet>) kweets;
    }

    @Override
    public List<Kweet> getTimelineKweets(String username) {
        List<Kweet> resultKweets = new ArrayList<Kweet>();
        
        Stream<Kweet> kweets = this.kweets.stream();
        // Add mentioned tweets
        kweets.filter(pf -> pf.getMessage().contains(username)).findAny().ifPresent(s -> resultKweets.add(s));
        // Add own tweets
        kweets.filter(pf -> pf.getMessage().contains(username)).findFirst().ifPresent(s -> resultKweets.add(s));
        return (List<Kweet>) kweets;
    }

    @Override
    public List<Kweet> getTopicKweets(String topic) {
        List<Kweet> resultKweets = new ArrayList<Kweet>();
        Stream<Kweet> kweets = this.kweets.stream();
        kweets.filter(pf -> pf.getTrend().equals(topic)).findAny().ifPresent(s -> resultKweets.add(s));
        return (List<Kweet>) kweets;
    }

    @Override
    public List<Kweet> getMentionKweets(String username) {
        List<Kweet> resultKweets = new ArrayList<Kweet>();
        
        // Add mentioned tweets
        Stream<Kweet> kweets = this.kweets.stream();
        kweets.filter(pf -> pf.getMessage().contains(username)).findAny().ifPresent(s -> resultKweets.add(s));
        return (List<Kweet>) kweets;
    }

    @Override
    public List<String> getTrendingTopics() {
        Map<String, Long> counts = this.kweets.stream().collect(Collectors.groupingBy(e -> e.getTrend(), Collectors.counting()));
        return new ArrayList<String>();
    }

    @Override
    public boolean postKweet(String username, String message) {
        this.kweets.add(new Kweet(username, message));
        return true;
    }

    @Override
    public boolean likeKweet(long id, String username) {
        Stream<Kweet> kweets = this.kweets.stream();
        kweets.filter(pf -> pf.getId().equals(id)).findFirst().ifPresent(s -> s.addLikedBy(username));
        return true;
    }

    @Override
    public List<Kweet> getAllKweets() {
        return this.kweets;
    }

    @Override
    public boolean removeKweet(long id) {
        Stream<Kweet> kweets = this.kweets.stream();
        Kweet kweet = kweets.filter(pf -> pf.getId().equals(id)).findFirst().orElse(null);
        if (kweet != null) {
            this.kweets.remove(this.kweets.indexOf(kweet));
            return true;
        } else {
            return false;
        }
    }
    
}
