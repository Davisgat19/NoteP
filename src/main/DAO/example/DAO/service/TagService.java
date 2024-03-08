package DAO.service;

import DAO.TagDAO;
import DAO.model.entity.Tags;
import javafx.collections.ObservableList;

public class TagService {

    private final TagDAO tagDAO;

    public TagService(TagDAO tagDAO) {
        this.tagDAO = tagDAO;
    }

    public ObservableList<Tags> getAllTags() {
        return tagDAO.getAllTags();
    }

    public void createTag(String tagName) {
        Tags tag = new Tags(tagName);
        tagDAO.save(tag);
    }

    public void updateTag(Tags tag) {
        tagDAO.update(tag);
    }

    public void deleteTag(Tags tag) {
        tagDAO.delete(tag);
    }
}
