package fr.urouen.models;

import javax.xml.bind.annotation.*;
import java.util.LinkedList;
import java.util.List;
@XmlRootElement(name = "feed", namespace = "http://univ.fr/rg19")
@XmlAccessorType(XmlAccessType.FIELD)
public class Feed{
   @XmlAttribute
    private String lang;
    @XmlElement
    private String title;
    @XmlElement
    private String pubDate;
    @XmlElement
    private String id;
    @XmlElement(name = "link")
    private List<Link> links;
    @XmlElement(name = "entry")
    private Entry[] entries;

    public Feed() {
       links = new LinkedList<>();
        entries = new Entry[10];
    }

    public Feed(String id, String title, String pubDate,String lang) {
        this.id = id;
        this.title = title;
        this.pubDate = pubDate;
        this.lang = lang;
        this.links = new LinkedList<>();
        this.entries = new Entry[10];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Entry[] getEntries() {
        return entries;
    }

    public void setEntries(Entry[] entries) {
        this.entries = entries;
    }
    public void  addEntry(Entry entry){
        entries[0] = entry;
    }
    public List<Link> getLinks() {
        return links;
    }
    public void addLink(Link link){
        links.add(link);
    }
    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
