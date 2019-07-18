package fr.urouen.controllers;

import fr.urouen.exceptions.HTMLEntryNotFoundException;
import fr.urouen.exceptions.XMLEntryNotFoundException;
import fr.urouen.models.Entry;
import fr.urouen.models.ResumeEntries;
import fr.urouen.models.ResumeEntry;
import fr.urouen.repository.DatabaseManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class RG19HTMLController {
    /**
     * Le gestionaire de la base de données
     */
    private final
    DatabaseManager manager;

    public RG19HTMLController(DatabaseManager manager) {
        this.manager = manager;
    }

    /**
     * Afficher la page d'accueil
     * @param model ModelAndView
     * @return ModelAndView
     */
    @GetMapping(path = "/", produces = "text/html")
    public ModelAndView getAcceuil(ModelAndView model) {
        model.setViewName("home");
        model.addObject("title", "Home - RG19");
        return model;
    }

    /**
     * Afficher la page aide
     * @param model ModelAndView
     * @return ModelAndView
     */
    @GetMapping(path = "help", produces = "text/html")
    public ModelAndView getHelp(ModelAndView model) {
        model.setViewName("help");
        model.addObject("title", "Help - RG19");
        model.addObject("page", "help");
        return model;
    }

    /**
     * Afficher les resumés des articles
     * @param model ModelAndView
     * @param query String : Selectionner Les resumés par catégories
     * @return ModelAndView
     */
    @GetMapping(path = "resume/html", produces = "text/html")
    public ModelAndView resume(ModelAndView model, @RequestParam(value = "query", required = false) String query) {
        List<Entry> entries;
        if (query == null) {
            entries = manager.getEntries();
        } else
            entries = manager.findByTerm(query);

        ResumeEntries resume = new ResumeEntries();
        for (Entry entry : entries) {
            resume.addResume(new ResumeEntry(entry));
        }
        model.setViewName("resume");
        //model.addObject("entry","entry");
        model.addObject("entries", resume);
        model.addObject("title", "Resume - RG19");
        model.addObject("page", "resume");
        return model;
    }

    /**
     * Afficher le détails d"un article
     * @param model ModelAndView
     * @param id int : l'identifiant de l"article
     * @return ModelAndView
     */
    @GetMapping(path = "resume/html/{id:\\d+}", produces = "text/html")
    public ModelAndView detail(ModelAndView model, @PathVariable("id") int id) {
        try {
            Entry entry = manager.getEntryById(id);
            model.setViewName("detail");
            model.addObject("entry", entry);
            return model;
        } catch (XMLEntryNotFoundException e) {
            throw new HTMLEntryNotFoundException();
        }
    }
}
