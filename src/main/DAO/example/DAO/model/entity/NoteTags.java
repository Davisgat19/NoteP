package DAO.model.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "note_tags", schema = "notes_database", catalog = "")
@IdClass(NoteTagsPK.class)
public class NoteTags {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "note_id")
    private int noteId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "tag_id")
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
        NoteTags noteTags = (NoteTags) o;
        return noteId == noteTags.noteId && tagId == noteTags.tagId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(noteId, tagId);
    }
}
