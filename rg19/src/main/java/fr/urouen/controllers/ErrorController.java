package fr.urouen.controllers;

import fr.urouen.exceptions.HTMLEntryNotFoundException;
import fr.urouen.exceptions.XMLEntryNotFoundException;
import fr.urouen.views.XMLResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@RestControllerAdvice
public class ErrorController {
    /**
     * Captuer les erreurs et retouner une reponse XML
     * @param are XMLEntryNotFoundException
     * @return XMLResponseDTO
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(XMLEntryNotFoundException.class)
    public XMLResponseDTO notFoundResponse(XMLEntryNotFoundException are){

        return new XMLResponseDTO(are.getMessage(),404);
    }

    /**
     * Captuer les erreurs et retouner la page 404
     * @param model ModelAndVie
     * @return ModelAndVie
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(HTMLEntryNotFoundException.class)
    public ModelAndView notFoundResponse(ModelAndView model){
        model.setViewName("error");
        return model;
    }
}
