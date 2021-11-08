import Header from "./Header";
import Footer from "./Footer";
import QuestionnaireContainer from "./questionnaire/QuestionnaireContainer"

function App() {
  return (
      <div>
          <Header title={"Flashcard Client with React"} subtitle={"Version 1"}></Header>
          <QuestionnaireContainer />
          <Footer message={"The FHNW Team"}></Footer>
      </div>
  );
}

export default App;
