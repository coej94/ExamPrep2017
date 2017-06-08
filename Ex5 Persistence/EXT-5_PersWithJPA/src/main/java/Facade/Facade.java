/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Project;
import entity.ProjectUser;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author christian
 */
public class Facade implements iFacade{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Christian_EXT-5_PersWithJPA_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();
    
    @Override
    public String findProjects(String name) {
        try{
            return em.createNativeQuery("SELECT * FROM Project WHERE name = 'ProjectY'").getSingleResult().toString();
            
        }finally{
            em.close();
        }
    }

    @Override
    public void getAllUsers() {
        List<ProjectUser> pul;
        Query query = em.createQuery("Select pu from ProjectUser pu");
         pul = (List<ProjectUser>)query.getResultList();
         for(ProjectUser pu : pul){
             System.out.print("ID: " + pu.getId() + ", Name: " + pu.getUsername());
         }
    }

    @Override
    public void getAllProjects() {
         List<Project> pl;
        Query query = em.createQuery("SELECT p FROM Project p");
        pl = (List<Project>)query.getResultList();
        for (Project p : pl) {
            System.out.println("Name: " + p.getName() + "Description: " + p.getDescription());
        }
    }

    @Override
    public void addUser(ProjectUser pu) {
        em.getTransaction().begin();
        em.persist(pu);
        em.getTransaction().commit();
        em.close();
    }
    
    @Override
    public void addProject(Project p){
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }
    
    @Override
    public void delete(Project p) {
        try {
            em.remove(p);
        } finally {
             em.close();
        }
        
    }
}
