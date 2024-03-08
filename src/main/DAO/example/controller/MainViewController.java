package controller;

import DAO.NoteDAO;
import DAO.TagDAO;
import DAO.model.entity.Notes;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import java.util.List;

public class MainViewController {

    @FXML
    private ListView<Notes> noteListView;


    // Setter metod för NoteDAO injection
    public void setNoteDAO(NoteDAO noteDAO) {
    }

    public void setTagDAO(TagDAO tagDAO) {
    }

    // ladda data från databas

    private void loadData() {
        EntityManager entityManager = DatabaseService.getEntityManager();
        try {
            if (entityManager != null) { // Ej Null innan användning
                //  databas operationer med entityManager
                TypedQuery<Notes> query = entityManager.createQuery("SELECT n FROM Notes n", Notes.class);
                List<Notes> notes = query.getResultList();

                noteListView.getItems().addAll(notes);
            } else {
                System.err.println("Error: EntityManager is null.");
            }
        } finally {
            if (entityManager != null) {
                entityManager.close(); // stäng EntityManager
            }
        }
    }

    // Event Handlers?? Fler metoder??
}
