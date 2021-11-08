import React from "react";
import QuestionnaireTable from "./QuestionnaireTable";

class QuestionnaireContainer extends React.Component {
  //   constructor(props) {
  //     super(props);
  //     this.state = {
  //       questionnaires: this.props.qs
  //     }
  //   }

  render() {
    return (
      <div>
        <h3>Questionnaires</h3>
        {/* <QuestionnaireTable
          questionnaires={this.state.questionnaires}
        /> */}
        <QuestionnaireTable questionnaires={this.props.questionnaires} />
      </div>
    );
  }
}

// QuestionnaireContainer.defaultProps = {
//   qs: [
//     { id: 1, title: "Test Title 1", description: "Test Description 1" },
//     { id: 2, title: "Test Title 2", description: "Test Description 2" },
//     { id: 3, title: "Test Title 3", description: "Test Description 3" },
//     { id: 4, title: "Test Title 4", description: "Test Description 4" },
//     { id: 5, title: "Test Title 5", description: "Test Description 5" },
//   ],
// };

export default QuestionnaireContainer;
