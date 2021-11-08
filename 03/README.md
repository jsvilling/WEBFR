# Lektion 3: "Controller" Design Pattern

## Einleitung
In dieser Lektion starten wir mit der Implementierung einer Java Webapplikation auf Basis von [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc). 

## Ressourcen
Die Slides zu dieser Lektion sind auf [MS Teams](https://teams.microsoft.com/_#/school/files/Allgemein?threadId=19%3AGUtpEacwnFN-v0_PeG-fdUzDooai_4HhL8QwKr7hnRk1%40thread.tacv2&ctx=channel&context=03&rootfolder=%252Fteams%252Fwebfr_M365%252FFreigegebene%2520Dokumente%252FGeneral%252F03) abgelegt. Die Slides gibt es in 2 Versionen:

* eine druckbare Version unter Tab *Dateien* im Ordner `03`
* eine vertonte Version im gleichen Ordner.

Alle Arbeitsblätter finden sie ebenfalls auf [MS Teams](https://teams.microsoft.com/_#/school/files/Allgemein?threadId=19%3AGUtpEacwnFN-v0_PeG-fdUzDooai_4HhL8QwKr7hnRk1%40thread.tacv2&ctx=channel&context=03&rootfolder=%252Fteams%252Fwebfr_M365%252FFreigegebene%2520Dokumente%252FGeneral%252F03).

Der Quellcode eines Arbeitsblattes und auch die jeweiligen Lösungen werden über Gitlab bereitgestellt.

Hier ein paar Links aus dem Internet, die aus meiner Sicht nützlich und aktuell sind:
* [Reference Documentation Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc)

## Theorie
Mit dieser Lektion wird das [Spring Framework](https://spring.io/projects/spring-framework) mit [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc) und [Spring Boot](https://spring.io/projects/spring-boot) eingeführt. Diese Technologien werden für den Rest des Moduls unsere Basis bilden, um _Java Web Applications_ und _Java Web Services_ schnell und effizient implementieren zu können. Es ist deshalb wichtig, dass ihr euch mit diesen Technologien vertraut macht. Sie basieren auf dem _Servlet API_ und nutzen die Basiskomponenten _Servlet_, _Filter_, _Listener_ - und natürlich werden beakasnnte Design Patterns eingesetzt.

Hier ein paar Links zu den verschiedenen Design Patterns auf der Website von [Martin Fowler](https://www.thoughtworks.com/de/profiles/martin-fowler):

* [Model View Controller](https://martinfowler.com/eaaCatalog/modelViewController.html)
* [Front Controller](https://martinfowler.com/eaaCatalog/frontController.html)
* [Page Controller](https://martinfowler.com/eaaCatalog/pageController.html)

Wichtig ist, dass sie diese Patterns zu den Komponenten von [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc) zuordnen können und dass sie die Funktionsweise von Spring verstehen und erklären können.

* Welche Rolle spielt das [DispatcherServlet](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-servlet)? Wann wird es gestartet? Wie wird es gestartet?
* Welches sind die Page Controller? Wie und warum werden sie gestartet?
* Ist ein Page Controller bei Spring MVC ein Servlet?
* Wieviele Servlets gibt es in einer Spring MVC Applikation
* Was ist der Endpoint für einen HTTP Request bei einer Spring MVC Applikation?
* Welche Rollen spielen in einer Spring MVC Applikation:
    * Web Server?
    * Servlet Container?
    * Spring Container?

## Arbeitsblätter
**Arbeiten sie in einem 2er-Team. Es macht mehr Spass!**

### AB6

Mit diesem Arbeitsblatt starten sie mit der Implementierung einer neuen Java Webapplikation, die SpringMVC nutzt. Sie lernen, wie man die Implementation einer Spring Webapplikation mit Hilfe vom [spring initializr](https://start.spring.io/) und [Spring Boot](https://spring.io/projects/spring-boot) beginnt.

Zusätzlich müssen sie die Datenbank MongoDB installieren.

Nutzen sie die verschiedenen Teilaufgaben, um sich mit Spring vertraut zu machen.

### AB7
Mit diesem Arbeitsblatt werden sie die Funktionalität des `BasicServlet` in die neue Klasse `QuestionnaoreController` überführen - und den ersten _PageController_ implementieren.

Aufgabe 1 und 2 beschreibt eine schrittweise Integration der In-Memory Datenbank aus den Lektion 1 und 2 in die neue Applikation. Noch bleibt die MongoDB ungenutzt! Wichtig ist, dass `QuestionnaireRepository` mit der Annotation `Component` zu einem Spring Bean wird und mit Dependency Injection von anderen Spring Beans genutzt werden kann.

In der Aufgabe 4 und 5 wird der Page Controller implementiert und getestet. Es ist wichtig, dass sie diese erste SpringMVC und das Zusammenspiel der Komponenten gut verstehen. Der Front Controller, bzw. das `DispatcherServlet` und der Page Controller spielen eine entscheidende Rolle in einer solchen Java Webapplikation.

### AB8
Aufgaben 1 bis 3 beschreiben eine schrittweise Integration der MongoDB in die Applikation. Die Entität `Questionnaire` wird über entsprechende Annotation zu einer Mongo-Entität. Diese Entität wird vom `QuestionnaireRepository` genutzt, um die Datenbank auszulesen und mit entsprechenden Entitäten zu beschreiben. Das Spring Bean `QuestionnaireRepository` wird im Vergleich zu AB5 komplett neu, dank Spring aber sehr einfach.

Testen ist wichtig.

### AB9
Sie erweitern die Applikation das AB6 um den zusätzlichen Page Controller `HelloWorldController`. 