/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.rest;

import domain.Kweet;
import domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import service.KwetterService;


@Path("kweets")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
public class KweetResource {
    
    @Inject
    private KwetterService ks;
    
    @GET
    @Path("getUser/{username}")
    public List<Kweet> getUserKweets(@PathParam("username") String username) {
        return this.ks.getUserKweets(username);
    }

    @GET
    @Path("getTimeline/{username}")
    public List<Kweet> getTimelineKweets(@PathParam("username") String username) {
        return this.ks.getTimelineKweets(username);
    }

    @GET
    @Path("getTopic/{username}")
    public List<Kweet> getTopicKweets(@PathParam("topic") String topic) {
        return this.ks.getTopicKweets(topic);
    }

    @GET
    @Path("getMention/{username}")
    public List<Kweet> getMentionKweets(@PathParam("username") String username) {
        return ks.getMentionKweets(username);
    }

    @GET
    @Path("getTrendingTopics")
    public List<String> getTrendingTopics() {
        return this.ks.getTrendingTopics();
    }

    @GET
    @Path("post/{username}/{message}")
    public boolean postKweet(@PathParam("username") String username, @PathParam("message") String message) {
        return this.ks.postKweet(message, username);
    }

    @GET
    @Path("like/{id}/{username}")
    public boolean likeKweet(@PathParam("id") long id, @PathParam("username") String username) {
        return this.ks.likeKweet(id, username);
    }

    @GET
    @Path("getAll")
    public List<Kweet> getAllKweets() {
        return this.ks.getAllKweets();
    }

    @GET
    @Path("remove/{id}")
    public boolean removeKweet(@PathParam("id") long id) {
        return this.ks.removeKweet(id);
    }
    
}