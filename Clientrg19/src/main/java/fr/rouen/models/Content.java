package fr.rouen.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;


@XmlAccessorType(XmlAccessType.FIELD)
public class Content {
    @XmlAttribute(required = true)
    private String type;
    @XmlAttribute
    private String href;
    @XmlValue
    private String text;

    public Content() {
        this.type = null;
        this.href = null;
        this.text = null;
    }
    public Content(String type) {
        this.type = type;
        this.href = null;
        this.text = null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getData(){
        return href==null?text:href;
    }
}
