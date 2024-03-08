package DAO.service;

import DAO.NoteDAO;
import DAO.model.entity.Notes;
import javafx.collections.ObservableList;

public class NoteService {

    private final NoteDAO noteDAO;

    public NoteService(NoteDAO noteDAO) {
        this.noteDAO = noteDAO;
    }

    public ObservableList<Notes> getAllNotes() {
        return noteDAO.getAllNotes();
    }

    public void createNote(String title, String content) {
        Notes note = new Notes();
        note.setTitle(title);
        note.setContent(content);
        noteDAO.save(note);
    }

    public void updateNote(Notes note) {
        noteDAO.update(note);
    }

    public void deleteNote(Notes note) {
        noteDAO.delete(note);
    }
}
