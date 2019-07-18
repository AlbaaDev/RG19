package fr.urouen.controllers;

import fr.urouen.exceptions.XMLEntryNotFoundException;
import fr.urouen.models.Entry;
import fr.urouen.models.Feed;
import fr.urouen.models.ResumeEntries;
import fr.urouen.repository.DatabaseManager;
import fr.urouen.utils.XmlValidator;
import fr.urouen.views.XMLResponseDTO;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;
import java.util.List;

@RestController
public class RG19XMLController {

    final
    DatabaseManager manager;

    public RG19XMLController(DatabaseManager manager) {
        this.manager = manager;
    }

    @GetMapping(path = "resume/xml")
    public ResumeEntries resume(@RequestParam(value = "query",required = false) String query) {
        List<Entry> entries;
        if (query != null)
            entries = manager.findByTerm(query);
        else
            entries = manager.getEntries();
        return new ResumeEntries(entries);
    }

    @GetMapping("resume/xml/{id:\\d+}")
    public Entry resumeById(@PathVariable("id") int id){
        return manager.getEntryById(id);
    }
    @PostMapping("insert")
    public XMLResponseDTO insert(@RequestBody Feed feed){
        try {

            XmlValidator.Validate(feed);
            for (Entry entry : feed.getEntries()) {
                if (entry != null)
                    manager.addEntry(entry);
            }
            return new XMLResponseDTO("Les articles sont ajoutés avec succès");
        } catch (JAXBException e) {
            return new XMLResponseDTO("le flux envoyé n'est pas valide", 500);
        }
        catch (XMLEntryNotFoundException e){
            return new XMLResponseDTO(e.getMessage(),500);
        }
    }

    @DeleteMapping("delete/{id:\\d+}")
    public XMLResponseDTO deleteById(@PathVariable("id") int id){
       manager.deleteEntry(id);
        return new XMLResponseDTO("Article supprimé avec succès");
    }

    @PutMapping("update")
    public XMLResponseDTO updateById(@RequestBody Feed feed) {

        try {

            XmlValidator.Validate(feed);
            for (Entry entry : feed.getEntries()) {
                if (entry != null)
                    manager.updateEntry(entry);
            }
            return new XMLResponseDTO("Les articles sont ajoutés avec succès");
        } catch (JAXBException e) {
            return new XMLResponseDTO("le flux envoyé n'est pas valide", 500);
        }
        catch (XMLEntryNotFoundException e){
            return new XMLResponseDTO(e.getMessage(),500);
        }
    }

}
