package fr.urouen.views;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response",namespace = "http://univ.fr/rg19")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLResponseDTO {
    private String message;
    private int code;

    public XMLResponseDTO(String message) {
        this.message = message;
        this.code = 200;
    }

    public XMLResponseDTO(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public XMLResponseDTO() {
        this.message="L'article demandé n'existe pas";
    }
}
