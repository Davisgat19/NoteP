package controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseService {

    private static final String PERSISTENCE_UNIT_NAME = "default";

    private static EntityManagerFactory entityManagerFactory;

    // Metod för att starta EntityManagerFactory
    public static void initializeEntityManagerFactory() {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        } catch (Exception e) {
            System.err.println("Error initializing EntityManagerFactory: " + e.getMessage());
            throw new RuntimeException("Error initializing EntityManagerFactory", e);
        }
    }

    // Metod för att hämta EntityManager instance
    public static EntityManager getEntityManager() {
        if (entityManagerFactory == null) {
            initializeEntityManagerFactory(); // Initialize EntityManagerFactory if not already initialized
        }
        return entityManagerFactory.createEntityManager();
    }

    // stänger EntityManagerFactory när applikatiopn avslutas
    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
