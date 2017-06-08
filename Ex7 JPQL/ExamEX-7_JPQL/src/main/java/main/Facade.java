/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author christian
 */
public class Facade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Christian_ExamEX-7_JPQL_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    public List<Student> findAll() {
        try {
            return em.createNamedQuery("Student.findAll").getResultList();
            //return (List) em.createQuery("SELECT s FROM Student s");
        } finally {
            em.close();
        }
    }

    public List<Student> findByFirstname(String name) {
        Student s = new Student();
        try {                            //Hvis man vil lave metoden uafhængig.
            //return em.createNamedQuery("Student.findByFirstname").setParameter("firstname", name).getResultList();
            return em.createNamedQuery("Student.findByFirstname").setParameter("firstname", "Jan").getResultList();

        } finally {
            em.close();
        }
    }
    //Hvis man vil lave metoden uafhængig, uanset navnet

    public List<Student> findByLastname(/*String name*/) {
        Student s = new Student();
        try {
            //Hvis man vil lave metoden uafhængig, uanset navnet
            //return em.createNamedQuery("Student.findByLastname").setParameter("lastname", name).getResultList();
            return em.createNamedQuery("Student.findByLastname").setParameter("lastname", "Olsen").getResultList();
        } finally {
            em.close();
        }
    }

    public Long findSPCountForSpecificID(int id) {
        try {
//            List<Studypoint> spList = em.createNamedQuery("Studypoint.findSumByStudentId").setParameter("studentId", id).getResultList();
//            int result = 0;
//            for (Studypoint sp : spList) {
//                result += sp.getScore();
//            }
//            return result;
            Query q = em.createQuery("SELECT SUM(s.score) FROM Studypoint s WHERE s.studentId.id = :id ");
            q.setParameter("id", id);
            return (Long) q.getSingleResult();
        } finally {
            em.close();
        }
    }

    public int sumOfStudyPoints() {
        return (Integer) em.createQuery("SELECT SUM(s.score) FROM Studypoint s").getSingleResult();
    }

    public int findSPCount() {
        try {
            return em.createQuery("SELECT COUNT(s.score) FROM Studypoint s").getFirstResult();
        } finally {
            em.close();
        }
    }

    public void addStudent(Student s) {
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
    }
}
