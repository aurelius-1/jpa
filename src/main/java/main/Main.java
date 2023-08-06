package main;

import entities.Employee;
import entities.Product;
import org.hibernate.jpa.HibernatePersistenceProvider;
import persistence.CustomPersistenceUnitInfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        //EntityManager
        //EntityManagerFactory

//        var emf =
//                /Persistence.createEntityManagerFactory("my-persistence-unit");

        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(), new HashMap());
        var em = emf.createEntityManager(); //represents the context - through it we operate the context

        //em.persist(); -> add an entity in the context
        //em.find();    -> finds by PK. Get from DB and add it to the context if it doesn't already exist
        //em.remove();  -> Marking entity for removal
        //em.merge();   -> merges an entity from outside the context to the context
        //em.refresh(); -> mirror the context from the database
        //em.detach();  -> take the entity out of the context

        try {
            em.getTransaction().begin();

            Employee e1 = em.find(Employee.class, 1);
            e1.setAddress("Sector 3");

            System.out.println("CFFFF" + e1);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
