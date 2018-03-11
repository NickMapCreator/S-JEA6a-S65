/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.rest;

import domain.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import service.KwetterService;


@Path("users")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    
    @Inject
    private KwetterService ks;
    
    @GET
    @Path("login/{username}/{password}")
    public Boolean login(@PathParam("username") String username, @PathParam("password") String password) {
        return ks.login(username, password);
    }
    
    @GET
    @Path("getAll")
    public List<User> getAllUsers() {
        return ks.getAllUsers();
    }
    
    @GET
    @Path("get/{username}")
    public User getUser(@PathParam("username") String username) {
        return ks.getUser(username);
    }
    
    @GET
    @Path("register/{username}/{password}/{displayName}/{avatar}/{biography}/{location}/{website}/{admin}")
    public boolean register(@PathParam("username") String username, @PathParam("password") String password, @PathParam("displayName") String displayName, @PathParam("avatar") String avatar, @PathParam("biography") String biography, @PathParam("location") String location, @PathParam("website") String website, @PathParam("admin") boolean admin) {
        return ks.register(username, password, displayName, avatar, biography, location, website, admin);
    }
    
    @GET
    @Path("update/{username}/{password}/{displayName}/{avatar}/{biography}/{location}/{website}")
    public boolean updateUser(@PathParam("username") String username, @PathParam("password") String password, @PathParam("displayName") String displayName, @PathParam("avatar") String avatar, @PathParam("biography") String biography, @PathParam("location") String location, @PathParam("website") String website) {
        return ks.updateUser(username, password, displayName, avatar, biography, location, website);
    }
    
    @GET
    @Path("remove/{username}")
    public boolean removeUser(@PathParam("username") String username) {
        return ks.removeUser(username);
    }
    
    @GET
    @Path("toggleAdmin/{username}/{invoker}")
    public boolean toggleAdmin(@PathParam("username") String username, @PathParam("invoker") String invoker) {
        return ks.toggleAdmin(username, invoker);
    }
    
    @GET
    @Path("getFollowers/{username}")
    public List<String> getUserFollowers(@PathParam("username") String username) {
        return ks.getUserFollowers(username);
    }
    
    @GET
    @Path("getFollowing/{username}")
    public List<String> getUserFollowing(@PathParam("username") String username) {
        return ks.getUserFollowing(username);
    }
    
    @GET
    @Path("toggleFollow/{username}/{target}")
    public boolean toggleFollowUser(@PathParam("username") String username, @PathParam("target") String target) {
        return ks.toggleFollowUser(username, target);
    }
    
}