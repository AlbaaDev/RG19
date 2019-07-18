package fr.urouen.models;

import javax.xml.bind.annotation.*;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement(name = "entry", namespace = "http://univ.fr/rg19")
@XmlAccessorType(XmlAccessType.FIELD)
public class Entry {

    @XmlAttribute(name = "id")
    private Integer num;

    @XmlElement(name = "id")
    private String id;
    @XmlElement
    private String title;

    @XmlElement(name = "category")
    private List<Category> categories;
    @XmlElement
    private String published;
    @XmlElement
    private String updated;
    @XmlElement
    private Image image;
    @XmlElement
    private Content content;
    @XmlElement(name = "author")
    private List<Person> authors;
    @XmlElement(name = "contributor")
    private List<Person> contributors;

    public Entry() {
        this.num = null;
        this.id = null;
        this.title = null;
        this.categories =null;
        this.published = null;
        this.updated = null;
    }
    public Entry(int num,String id, String title, String published, List<Category> categories) {
        this.num = num;
        this.id = id;
        this.title = title;
        this.categories = categories;
        this.published = published;
        this.updated = null;
    }

    public Entry(int num, String id, String title,List<Category> categories, String updated) {
        this.num = num;
        this.id = id;
        this.title = title;
        this.categories = categories;
        this.published =null;
        this.updated = updated;
    }

    public List<String> getCategories() {
        List<String> cat = new LinkedList<>();
        if (categories != null)
        for (Category category : categories){
            cat.add(category.getTerm());
        }
        return cat;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublished() {
        return published;
    }


    public void setPublished(String published) {
        this.updated = null;
        this.published = published;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.published = null;
        this.updated = updated;
    }

    public String getDate(){
        return published == null ? updated : published;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public List<Person> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Person> authors) {
        this.authors = authors;
    }

    public List<Person> getContributors() {
        return contributors;
    }

    public void setContributors(List<Person> contributors) {
        this.contributors = contributors;
    }
}
