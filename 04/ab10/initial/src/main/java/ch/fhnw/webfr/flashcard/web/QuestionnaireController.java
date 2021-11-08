package ch.fhnw.webfr.flashcard.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;
import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/questionnaires")
public class QuestionnaireController {
	private static final Log logger = LogFactory.getLog(QuestionnaireController.class);

	@Autowired
	private QuestionnaireRepository questionnaireRepository;

	@GetMapping
	public String findAll(Model model) {
	    model.addAttribute("questionnaires", questionnaireRepository.findAll());
	    return "questionnaires/list";
	}

	@GetMapping(value = "/{id}")
	public String findById(@PathVariable String id, Model model) {
        final Optional<Questionnaire> questionnaireOptional = questionnaireRepository.findById(id);
        if (questionnaireOptional.isPresent()) {
            model.addAttribute("questionnaire", questionnaireOptional.get());
            return "questionnaires/show";
        } else {
            throw new RuntimeException();
        }
    }
}
