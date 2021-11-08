import React from "react";
import QuestionnaireTableElement from "./QuestionnaireTableElement";
import {Table} from "reactstrap";

const QuestionnaireTable = ({ questionnaires }) => (
    <Table hover>
        <tbody>
        {
            questionnaires.map(questionnaire =>
                <QuestionnaireTableElement
                    key={questionnaire.id}
                    questionnaire={questionnaire}
                />
            )
        }
        </tbody>
    </Table>
)

export default QuestionnaireTable
