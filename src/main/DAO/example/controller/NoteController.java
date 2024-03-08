package controller;

import DAO.model.entity.Notes;
import DAO.model.entity.Tags;
import DAO.service.NoteService;
import DAO.service.TagService;
import javafx.collections.ObservableList;

public class NoteController {
    private final NoteService noteService;
    private final TagService tagService;

    public NoteController(NoteService noteService, TagService tagService) {
        this.noteService = noteService;
        this.tagService = tagService;
    }

    // Interagera med "Notes"
    public ObservableList<Notes> getAllNotes() {
        return noteService.getAllNotes();
    }

    public void createNote(String title, String content) {
        noteService.createNote(title, content);
    }

    public void updateNote(Notes note) {
        noteService.updateNote(note);
    }

    public void deleteNote(Notes note) {
        noteService.deleteNote(note);
    }

    // Interagera med "Tags" metod
    public ObservableList<Tags> getAllTags() {
        return tagService.getAllTags();
    }

}
