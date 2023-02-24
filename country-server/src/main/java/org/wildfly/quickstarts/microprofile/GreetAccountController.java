package org.wildfly.quickstarts.microprofile;

public class GreetAccountController {

    @Inject
    private AccountDao accountDao;

    private String Accountusername;

    private String greeting;

    public void greet() {
        Account account = accountDao.getForAccountusername(Accountusername);
        if (account != null) {
            greeting = "Hello, " + account.getFirstName() + " " + account.getLastName() + "!";
        } else {
            greeting = "No such user exists! Use 'emuster' or 'jdoe'";
        }
    }

    public String getUsername() {
        return Accountusername;
    }

    public void setUsername(String Accountusername) {
        this.Accountusername = Accountusername;
    }

    public String getGreeting() {
        return greeting;
    }
}
