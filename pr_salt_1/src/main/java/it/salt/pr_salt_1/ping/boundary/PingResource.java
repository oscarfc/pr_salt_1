package it.salt.pr_salt_1.ping.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author airhacks.com
 */
@Path("ping")
public class PingResource {

    @Inject
    @ConfigProperty(name = "message")
    String message;    
    @Inject
    @ConfigProperty(name = "prova")
    String prova;    

    @GET
    public String ping() {
        return this.message + " Jakarta EE 8 with MicroProfile 3+! " + prova;
    }

}
