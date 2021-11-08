package ch.fhnw.webfr.flashcard.web;

import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public String findAll(Model model) {
		model.addAttribute("questionnaires", questionnaireRepository.findAll());
		return "questionnaires/list";
	}

	@GetMapping(value = "/{id}")
	public String findById(@PathVariable String id, Model model) {
		Optional<Questionnaire> optional = questionnaireRepository.findById(id);
		if (optional.isPresent()) {
			model.addAttribute("questionnaire", optional.get());
			return "questionnaires/show";
		} else {
			return "404";
		}
	}

	@GetMapping(params = "form")
	public String createForm(Model model) {
		model.addAttribute("questionnaire", new Questionnaire());
		return "questionnaires/create";
	}

	@PostMapping
	public String create(@Valid Questionnaire questionnaire, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			logger.debug("Binding error: " + bindingResult.getAllErrors());
			return "questionnaires/create";
		}
		questionnaireRepository.save(questionnaire);
		return "redirect:/questionnaires";
	}

	@DeleteMapping(value = "/{id}")
	public String delete(@PathVariable String id) {
		Optional<Questionnaire> optional = questionnaireRepository.findById(id);
		if (optional.isPresent()) {
			questionnaireRepository.deleteById(id);
			return "redirect:/questionnaires";
		} else {
			return "404";
		}
	}

}
