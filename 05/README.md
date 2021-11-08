# Lektion 5: Validierung, Error, Finalisierung

## Einleitung
In dieser Lektion wird die Spring MVC Appikation einerseits so abgeschlossen, dass die CRUD (Create-Read-Update-Delete) Operationen auf der Ressource Questionnaire ausgeführt werden können, andererseits wird die Applikation um ein paar wichtige Features erweitert wie:

* Validierung der Eingabefelder in einem Formular
* Error Handling

## Ressourcen
Die Slides zu dieser Lektion sind auf [MS Teams](https://teams.microsoft.com/l/channel/19%3aGUtpEacwnFN-v0_PeG-fdUzDooai_4HhL8QwKr7hnRk1%40thread.tacv2/Allgemein?groupId=85012943-9402-4082-930e-4f0cc9356e0f&tenantId=9d1a5fc8-321e-4101-ae63-530730711ac2) abgelegt. Die Slides gibt es in 2 Versionen:

* eine druckbare Version unter Tab *Dateien* im Ordner `05`
* eine vertonte Version im gleichen Ordner.

Hier ein paar Links aus dem Internet, die aus meiner Sicht nützlich und aktuell sind:
* Guide [Validating Form Input](https://spring.io/guides/gs/validating-form-input/)
* [Sending form data](https://developer.mozilla.org/en-US/docs/Learn/Forms/Sending_and_retrieving_form_data), z.B. Was geschieht mit den Formulardaten, falls die GET-Methode eingesetzt wird?

## Theorie
Sobald ein User Daten an eine Applikation senden kann, ist es wichtig diese Daten zu überprüfen, bevor sie in die Datenbank geschrieben werden. So kann die Konsistenz der Datenbank sichergestellt werden. Diese Validierung der Inputdaten ist eine nicht-funktionale Anforderung an die Applikation. Zur Validierung gehört auch ein entsprechendes Error-Handling. Die Error-Meldungen, die dem User gezeigt werden, müssen kontrolliert werden. Auf keinen Fall sollte der User einen Stack-Trace sehen!

Sie werden sie in dieser Lektion mit folgenden Fragen befassen müssen:

* In welchem Layer sollen die Input-Daten validiert werden?
* Wie werden Input-Daten innerhalb des HTTP Protokolls an den Server übermittelt?
* Wie unterstützt SpringMVC diese Input Validierung?
* Wie kann bei einem Browser-Reload vermieden werden, dass der letzte POST-Request noch einmal ausgeführt wird?
* Wie kann ein HTTP-PUT oder HTTP-DELETE im Browser ausgelöst werden, obwohl der Brower gemäss HTML5-Spezifikation nur HTTP-GET und POST unterstützen muss?

## Arbeitsblätter
**Arbeiten sie in einem 2er-Team. Es macht mehr Spass!**

### AB13
In diesem Arbeitsblatt befassen sie sich mit verschiedenen Möglichkeit der Input Validierung, die Spring bereitstellt. Machen sie sich Gedanken zu den Vor- bzw. Nachteile der einzelnen Ansätze.

### AB14
In diesem Arbeitsblatt werden sie die Read und Delete Operationen implementieren. Sie müssen neue Subviews erstellen und entsprechende Anpassungen z.B. im Page Controller vornehmen. Es ist wichtig, dass sie das Zusammenspiel zwischen der View Technologie `Thymeleaf` und der Server Applikation mit dem `Spring Framework` verstehen.

### AB15
Mit der Einführung der Validierung müssen sie sich auch Überlegungen zum Error-Handling machen. Was wollen sie in einem Fehlerfall dem User zeigen und wie?

### AB16
Mit diesem Arbeitsblatt vervollständigen sie die Appikation um die CRUD-Funktion `UPDATE`. Testen sie ausführlich.

Verstehen sie die Interaktionen zwischen:
* Browser und Server?
* Controller und Model?
* Model und View?
* View und Controller?