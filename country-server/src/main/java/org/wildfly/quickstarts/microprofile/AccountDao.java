package org.wildfly.quickstarts.microprofile;


//package org.wildfly.quickstarts.microprofile;

public interface AccountDao {
    Account getForAccountusername(String Accountusername);

    void createAccountUser(Account account);
}