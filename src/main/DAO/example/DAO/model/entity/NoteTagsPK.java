package DAO.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class NoteTagsPK implements Serializable {
    @Column(name = "note_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noteId;
    @Column(name = "tag_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tagId;

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteTagsPK that = (NoteTagsPK) o;
        return noteId == that.noteId && tagId == that.tagId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(noteId, tagId);
    }
}
