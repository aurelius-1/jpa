package main;

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

        Product p = new Product();
        p.setId(104);
        p.setName("Prosecco");
//        p.setPrice(10.4);
//        p.setExpirationDate(LocalDate.now());

        try {
            em.getTransaction().begin();

            em.persist(p);//add the instance in the context -> not an INSERT query

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
