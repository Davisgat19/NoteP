package controller;

import DAO.TagDAO;
import DAO.model.entity.Tags;

import java.util.List;

public class TagController {

    private final TagDAO tagDAO;

    public TagController(TagDAO tagDAO) {
        this.tagDAO = tagDAO;
    }

    public void createTag(String name) {
        Tags tag = new Tags(name);
        tagDAO.save(tag);
    }

    public Tags findTagById(Long id) {
        return tagDAO.findById(id);
    }

    public List<Tags> findAllTags() {
        return tagDAO.findAll();
    }

    public void updateTag(Long id, String newName) {
        Tags tag = tagDAO.findById(id);
        if (tag != null) {
            tag.setName(newName);
            tagDAO.update(tag);
        }
    }

    public void deleteTag(Long id) {
        Tags tag = tagDAO.findById(id);
        if (tag != null) {
            tagDAO.delete(tag);
        }
    }
}

