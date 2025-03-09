package ca.cal.tp2;

import ca.cal.tp2.repository.CDRepository;
import ca.cal.tp2.repository.DVDRepository;
import ca.cal.tp2.repository.DocumentRepository;
import ca.cal.tp2.repository.LivreRepository;
import ca.cal.tp2.service.PreposeService;
import ca.cal.tp2.utils.TcpServer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        // Votre script qui utilise votre API ici

        TcpServer.startTcpServer();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate2.ex1");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();




        em.getTransaction().commit();
        em.close();
        emf.close();




        Thread.currentThread().join();

    }
}
