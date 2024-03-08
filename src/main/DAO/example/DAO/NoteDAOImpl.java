package DAO;

import DAO.model.entity.Notes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import jakarta.persistence.EntityManager;
import java.util.List;

public class NoteDAOImpl extends NoteDAO {

    public NoteDAOImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public ObservableList<Notes> findAll() {
        return null;
    }

    @Override
    public ObservableList<Notes> getAllNotes() {
        List<Notes> notesList = entityManager.createQuery("SELECT n FROM Notes n", Notes.class).getResultList();
        return FXCollections.observableArrayList(notesList);
    }
}