/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.ProjectUser;
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
        /*LAVER TABELLERNE I DATABASEN*/
        //Persistence.generateSchema("Christian_EXT-5_PersWithJPA_jar_1.0-SNAPSHOTPU", null);
        
        /*Så Laver vi en EMF og en EM*/
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Christian_EXT-5_PersWithJPA_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        /*Så importere vi facaden, laver en instans af Project user.*/
        Facade f = new Facade();
        em.getTransaction().begin();
        //En måde at persistere på.
        ProjectUser proUsr = new ProjectUser("Christian", "Christian@email.com", new Date());
        //em.persist(proUsr);
        //System.out.println("Pro user er persisteret.");
        //En anden måde at persistere på.
        f.getAllUsers();
        
        em.getTransaction().commit();
        
        em.close();

        
    }
}
