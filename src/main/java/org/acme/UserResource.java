package org.acme;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/quarkusRestExample")
public class UserResource {

    public static List<User> users = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("users")
    public Response getUsers() {
        return Response.ok(users).build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("users/{idUser}")
    public Response getUser() {
        return Response.ok(users).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("users")
    public Response createUser(User newUser){
        users.add(newUser);
        return Response.ok(newUser).build();
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("user/{idUser}")
    public Response deleteUser(@PathParam("idUser") String idUser){
        boolean remove = users.remove(idUser);
        return  remove ? Response.noContent().build() :
                Response.status(Response.Status.BAD_REQUEST).build();
    }
}
