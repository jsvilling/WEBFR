import React from "react";
import Header from "./Header";
import Footer from "./Footer";
import { Container } from "reactstrap";
import QuestionnaireContainer from "../questionnaire/QuestionnaireContainer";

export default class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      questionnaires: this.props.qs,
    };
  }
  render() {
    const msg =
      "Total of " + this.state.questionnaires.length + " questionnaires";
    return (
      <Container fluid>
        <Header title="Flashcard Client with React" subtitle="Version 1" />
        {/* <QuestionnaireContainer /> */}
        <QuestionnaireContainer questionnaires={this.state.questionnaires} />
        <Footer leftMessage="The FHNW Team" rightMessage={msg} />
      </Container>
    );
  }
}

App.defaultProps = {
  qs: [
    { id: 1, title: "Test Title 1", description: "Test Description 1" },
    { id: 2, title: "Test Title 2", description: "Test Description 2" },
    { id: 3, title: "Test Title 3", description: "Test Description 3" },
    { id: 4, title: "Test Title 4", description: "Test Description 4" },
    { id: 5, title: "Test Title 5", description: "Test Description 5" },
  ],
};
