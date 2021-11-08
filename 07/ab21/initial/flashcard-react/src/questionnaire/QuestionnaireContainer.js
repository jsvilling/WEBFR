import React, {useState} from "react";
import QuestionnaireTable from "./QuestionnaireTable";

const QuestionnaireContainer = () => {
    const [questionnaires] = useState(qs);

    return (
        <QuestionnaireTable questionnaires={questionnaires}></QuestionnaireTable>
    );
}

const qs =  [
        { id: 1, title: "Test Title 1", description: "Test Description 1" },
        { id: 2, title: "Test Title 2", description: "Test Description 2" },
        { id: 3, title: "Test Title 3", description: "Test Description 3" },
        { id: 4, title: "Test Title 4", description: "Test Description 4" },
        { id: 5, title: "Test Title 5", description: "Test Description 5" },
      ]

export default QuestionnaireContainer;
