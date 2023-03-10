package org.wildfly.quickstarts.microprofile;



/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
//package org.jboss.as.quickstarts.greeter.domain;

        import javax.inject.Inject;
        import javax.persistence.EntityManager;
        import javax.persistence.NoResultException;
        import javax.persistence.Query;
        import javax.transaction.SystemException;
        import javax.transaction.UserTransaction;

public class ManageBeanAccountDao implements AccountDao {

    @Inject
    private EntityManager entityManager;

    @Inject
    private UserTransaction utx;

    public Account getForAccountusername(String Accountusername) {
        try {
            Account account;
            try {
                utx.begin();
                Query query = entityManager.createQuery("select u from User u where u.username = :username");
                query.setParameter("name", Accountusername);
                account = (Account) query.getSingleResult();
            } catch (NoResultException e) {
                account = null;
            }
            utx.commit();
            return account;
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (SystemException se) {
                throw new RuntimeException(se);
            }
            throw new RuntimeException(e);
        }
    }

    public void createUser(Account account) {
        try {
            try {
                utx.begin();
                entityManager.persist(account);
            } finally {
                utx.commit();
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (SystemException se) {
                throw new RuntimeException(se);
            }
            throw new RuntimeException(e);
        }
    }
}
