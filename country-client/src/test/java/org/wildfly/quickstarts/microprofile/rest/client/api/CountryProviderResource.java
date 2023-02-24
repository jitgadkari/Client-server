package org.wildfly.quickstarts.microprofile.rest.client.api;

import org.wildfly.quickstarts.microprofile.rest.client.model.Country;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/")
@ApplicationScoped
public class CountryProviderResource {

//    private static final Map<String, Country> countries = new HashMap<>();
    private static final Map<String, Country> countries = new HashMap<>();
    public CountryProviderResource() {
        countries.put("France", new Country("France", "Paris", "EUR"));
//        countries.put("1",new Country( balance "20");
//        countries.put("1", new Country("jit", 123, "EUR"));
//        countries.put("2", new Country("karan", "Paris", "EUR"));
//        countries.put("3", new Country("roy", "Paris", "EUR"));


    }

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByName(@PathParam("name") String name) {
        Country country = countries.get(name);

        if (country != null) {
            return Response.ok(country).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
