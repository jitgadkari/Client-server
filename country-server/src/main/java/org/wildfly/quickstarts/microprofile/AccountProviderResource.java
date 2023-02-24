//package org.wildfly.quickstarts.microprofile;
//
//
//import jakarta.ws.rs.GET;
//import jakarta.ws.rs.Path;
//import jakarta.ws.rs.PathParam;
//import jakarta.ws.rs.Produces;
//import jakarta.ws.rs.core.MediaType;
//import jakarta.ws.rs.core.Response;
//import java.util.HashMap;
//import java.util.Map;
//
//
//@Path("/account")
//public class AccountProviderResource {
//
//    private static final Map<String, Account> accounts = new HashMap<>();
//
//    public AccountProviderResource() {
//        accounts.put("1", new Account("ajit", 12332, 1));
//        accounts.put("2", new Account("karan", 2332, 2));
//        accounts.put("3", new Account("mayur", 4343, 3));
////        accounts.put("4", new Country("Switzerland", "Bern", "CHF"));
////        accounts.put("Netherlands", new Country("Netherlands", "Amsterdam", "EUR"));
////        accounts.put("USA", new Country("USA", "Washington, D.C.", "USD"));
//    }
//
//    @GET
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getByName(@PathParam("id") String id) {
//        Account account = accounts.get(id);
//
//        if (account != null) {
//            return Response.ok(account).build();
//        } else {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        }
//    }
//
//}
