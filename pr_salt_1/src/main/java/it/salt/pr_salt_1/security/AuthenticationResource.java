/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.salt.pr_salt_1.security;

import it.salt.pr_salt_1.user.User;
import it.salt.pr_salt_1.user.UserStore;
import java.util.Optional;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author oscar.favero
 */
@Path("/authentication")
public class AuthenticationResource {

    @Inject
    UserStore store;

    /**
     *
     * @param credential
     * @return Response
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Credential credential) {
        Optional<User> user = store.search(credential);
        return checkAut(user);
    }

    /**
     *
     * @param usr
     * @param pwd
     * @return Response
     */
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(String usr, String pwd) {
        Optional<User> user = store.search(new Credential(usr, pwd));
        return checkAut(user);
    }

    /**
     *
     * @param user
     * @return
     */
    private Response checkAut(Optional<User> user) {
        if (user.isPresent()) {
            return Response.status(Response.Status.OK)
                    //                    .header("token", token(user.get()))
                    .header("token", "ok")
                    .build();
        }
        return Response.status(Response.Status.NOT_FOUND)
                //                    .header("token", token(user.get()))
                .header("token", "ko")
                .build();
    }
}
