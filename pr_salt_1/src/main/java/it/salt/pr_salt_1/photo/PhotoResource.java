/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.salt.pr_salt_1.photo;

import it.salt.pr_salt_1.user.UserStore;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author oscar.favero
 */
@Path("/photo")
@RolesAllowed("users")
public class PhotoResource {

    @Context
    ResourceContext resource;

    @Inject
    PhotoStore store;

    @Inject
    UserStore userStore;

    private Long id;
    private String site;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Photo find() {
        return store.findByIdAndSite(id, site).orElseThrow(() -> new NotFoundException());
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSite(String site) {
        this.site = site;
    }

}
