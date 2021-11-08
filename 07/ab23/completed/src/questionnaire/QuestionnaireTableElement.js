import React from 'react';

const textStyle = {
  verticalAlign: 'middle'
};

const QuestionnaireTableElement = ({ questionnaire }) => (
  <tr >
    <th scope="row" style={textStyle}>
      {questionnaire.id}
    </th>
    <td style={textStyle}>
      {questionnaire.title}
    </td>
    <td style={textStyle}>
      {questionnaire.description}
    </td>
  </tr>
)

export default QuestionnaireTableElement;
