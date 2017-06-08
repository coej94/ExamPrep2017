/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import Entity.Person;
import facade.Facade;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author christian
 */
public class Generator {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Christian_EXT-6_PersistInheritance");
        EntityManager em = emf.createEntityManager();
//        Persistence.generateSchema("Christian_EXT-6_PersistInheritance", null);
        Facade f = new Facade();
        em.getTransaction().begin();
        Person p = new Person("Christian", "Jacobsen", new Date(), 22, true);
        f.add(p);
        em.getTransaction().commit();
        em.close();

    }
}
