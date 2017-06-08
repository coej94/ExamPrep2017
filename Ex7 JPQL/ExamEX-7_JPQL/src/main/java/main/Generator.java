/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author christian
 */
public class Generator {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Christian_ExamEX-7_JPQL_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        try{
            Facade f = new Facade();
            em.getTransaction().begin();
            Student s = new Student("Christian", "Jacobsen");           
            f.addStudent(s);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
}
