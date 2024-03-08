package DAO;

import DAO.model.entity.Tags;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TagDAO {

    private final EntityManager entityManager;

    public TagDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Tags findById(Long id) {
        return entityManager.find(Tags.class, id);
    }

    public List<Tags> findAll() {
        return entityManager.createQuery("SELECT t FROM Tags t", Tags.class).getResultList();
    }

    public void save(Tags tag) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(tag);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void update(Tags tag) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(tag);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void delete(Tags tag) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(tag);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public ObservableList<Tags> getAllTags() {
        List<Tags> tagsList = findAll();
        return FXCollections.observableArrayList(tagsList);
    }

    public List<Tags> findByTagName(String name) {
        return entityManager.createQuery("SELECT t FROM Tags t WHERE t.name = :name", Tags.class)
                .setParameter("name", name)
                .getResultList();
    }
}