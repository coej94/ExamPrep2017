/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author christian
 */
public class Facade implements iFacade{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Christian_EXT-6_PersistInheritance");
    EntityManager em = emf.createEntityManager();
    
    @Override
    public void add(Person p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void edit(Person p) {
        em.getTransaction().begin();
        em.find(Person.class, p);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public Person find() {
        Person p = new Person();
        try {
            em.getTransaction().begin();
            return em.find(Person.class, p);
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Person p) {
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        em.close();
    }
    
}
