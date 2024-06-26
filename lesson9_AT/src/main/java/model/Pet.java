package model;

import java.util.List;

public class Pet {
    private List<String> photoUrls;

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setTags(List<TagsItem> tags) {
        this.tags = tags;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String name;
    private int id;
    private Category category;
    private List<TagsItem> tags;
    private String status;

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public List<TagsItem> getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }

    public Pet(String name, String status) {
        this.name = name;
        this.status = status;
    }
}