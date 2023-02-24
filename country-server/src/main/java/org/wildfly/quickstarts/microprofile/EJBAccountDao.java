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

//        import javax.ejb.Stateful;
//        import javax.enterprise.inject.Alternative;
//        import javax.inject.Inject;
        import javax.persistence.EntityManager;
        import javax.persistence.NoResultException;
        import javax.persistence.Query;

//@Stateful
//@Alternative
public class EJBAccountDao implements AccountDao {

//    @Inject
    private EntityManager entityManager;

    public EJBAccountDao() {
    }
    public Account getForAccountUsername(String Accountusername) {
        try {
            Query query = entityManager.createQuery("select u from User u where u.name = ?");
            query.setParameter(1, Accountusername);
            return (Account) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void createUser(Account account) {
        entityManager.persist(account);
    }

}
