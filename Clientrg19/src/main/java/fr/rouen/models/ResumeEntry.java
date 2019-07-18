package fr.rouen.models;

import javax.xml.bind.annotation.*;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement(name = "resume", namespace = "http://univ.fr/rg19")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResumeEntry {
    @XmlAttribute(name = "id", required = true)
    private Integer num;
    private String id;
    private String date;
    private String title;
    @XmlElement(name = "categorie")
    private List<String> categories;

    public ResumeEntry() {
        num = null;
        id = "";
        date = "";
        title = "";
        categories = new LinkedList<>();
    }

    public ResumeEntry(Entry entry) {
        this.num = entry.getNum();
        this.id = entry.getId();
        this.date = entry.getPublished() != null ? entry.getPublished() : entry.getUpdated();
        this.title = entry.getTitle();
        this.categories = entry.getCategories();

    }

    public int getNum() {
        return num;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getCategories() {
        return categories;
    }
}
