package org.wildfly.quickstarts.microprofile;

import jakarta.ws.rs.Produces;

//@Named
//@RequestScoped
public class CreateAccountController {

    @Inject
    private FacesContext facesContext;

    @Inject
    private AccountDao accountDao;

//    @Named
//    @Produces
//    @RequestScoped
    private Account newAccount = new Account();

    public void create() {
        try {
            accountDao.createAccountUser(newAccount);
            String message = "A new user with id " + newAccount.getId() + " has been created successfully";
            facesContext.addMessage(null, new FacesMessage(message));
        } catch (Exception e) {
            String message = "An error has occured while creating the user (see log for details)";
            facesContext.addMessage(null, new FacesMessage(message));
        }
    }
}
