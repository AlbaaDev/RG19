package fr.urouen.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Image {
    @XmlAttribute
    private String type;
    @XmlAttribute
    private String href;
    @XmlAttribute
    private String alt;
    @XmlAttribute
    private int length;

    public Image() {
        this.type = null;
        this.href = null;
        this.alt = null;
        this.length = 0;
    }
    public Image(String type, String href, String alt, int length) {
        this.type = type;
        this.href = href;
        this.alt = alt;
        this.length = length;
    }

    public String getHref() {
        return href;
    }

    public String getAlt() {
        return alt;
    }
}
