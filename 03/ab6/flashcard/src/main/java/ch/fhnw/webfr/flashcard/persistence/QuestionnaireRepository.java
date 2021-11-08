package ch.fhnw.webfr.flashcard.persistence;

import java.util.ArrayList;
import java.util.List;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public interface QuestionnaireRepository extends MongoRepository<Questionnaire, String> {

    List<Questionnaire> findByTitle(String title);

//	@PostConstruct
//    public void initRepoWithTestData() {
//	    save(new Questionnaire("Test Questionnaire 1", "Lorem impsum"));
//	    save(new Questionnaire("Test Questionnaire 2", "Lorem impsum"));
//	    save(new Questionnaire("i1n Test funf", "Lorem impsum"));
//	    logger.debug("Testdata initialized");
//    }
}
