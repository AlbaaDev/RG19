package fr.urouen.utils;

import fr.urouen.exceptions.XMLEntryNotFoundException;
import fr.urouen.models.Feed;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.util.ArrayList;
import java.util.List;

public class XmlValidator {

    private ClassLoader getLoader() {
        return getClass().getClassLoader();
    }

    public static void Validate(Feed feed) throws JAXBException, XMLEntryNotFoundException {
        try {
            List<String> validation = new ArrayList<>();
            JAXBContext context = JAXBContext.newInstance(Feed.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new StreamSource(new XmlValidator().getLoader().getResourceAsStream("rg19.xsd")));
            marshaller.setSchema(schema);

            marshaller.setEventHandler(event ->{
                if (event.getSeverity() == ValidationEvent.ERROR || event.getSeverity() == ValidationEvent.FATAL_ERROR) {
                    validation.add(event.getMessage());
                }
                return true;
            });
            marshaller.marshal(feed, System.out);
            if (!validation.isEmpty()){
                throw new XMLEntryNotFoundException(String.join("\n",validation));
            }
        } catch (SAXException e) {
            throw new XMLEntryNotFoundException(e.getMessage());
        }
    }
}
