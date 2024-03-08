package DAO;

import DAO.model.entity.Notes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public abstract class NoteDAO {
    protected final EntityManager entityManager;

    public NoteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public abstract ObservableList<Notes> getAllNotes();

    public Notes findById(Long id) {
        return entityManager.find(Notes.class, id);
    }

    public List<Notes> findAll() {
        return entityManager.createQuery("SELECT n FROM Notes n", Notes.class).getResultList();
    }

    public void save(Notes note) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(note);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void update(Notes note) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(note);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void delete(Notes note) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(note);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
}
