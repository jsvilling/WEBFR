package ch.fhnw.webfr.flashcard.web;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;
import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;

@Controller
@RequestMapping("/questionnaires")
public class QuestionnaireController {
	private static final Log logger = LogFactory.getLog(QuestionnaireController.class);

	@Autowired
	private QuestionnaireRepository questionnaireRepository;

	@GetMapping
	public String findAll(Model model) throws IOException {
		List<Questionnaire> questionnaires = questionnaireRepository.findAll();
		logger.debug("Found " + questionnaires.size() + " questionnaires");
		model.addAttribute("questionnaires", questionnaires);
		return "questionnaires/list";
	}

	@GetMapping(value = "/{id}")
	public String findById(@PathVariable String id, Model model) {
		Optional<Questionnaire> questionnaireOptional = questionnaireRepository.findById(id);
		if (questionnaireOptional.isPresent()) {
			logger.debug("Found questionnaire with id=" + id);
			model.addAttribute("questionnaire", questionnaireOptional.get());
			return "questionnaires/show";
		} else {
			logger.warn("Could not find questionnaire with id=" + id);
			return "error";
		}
    }
    
    @GetMapping(params = "form")
	public String createForm(Model model) {
		model.addAttribute("questionnaire", new Questionnaire());
		return "questionnaires/create";
	}

	@PostMapping
	public String create(Questionnaire questionnaire) {
		questionnaireRepository.save(questionnaire);
		return "redirect:/questionnaires";
	}

}
