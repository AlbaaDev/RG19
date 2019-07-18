package fr.rouen.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
    private String name;
    private String email;
    private String uri;

    public Person() {
        this.name = null;
        this.email = null;
        this.uri = null;
    }
    public Person(String name, String email, String uri) {
        this.name = name;
        this.email = email;
        this.uri = uri;
    }

    public Person(String name) {
        this.name = name;
        this.email = null;
        this.uri = null;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUri() {
        return uri;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
