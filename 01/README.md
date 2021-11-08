# Lektion 1: Einführung in das Modul "Web Frameworks"

## Einleitung

Die ersten beiden Wochen beinhalten eine Repetition der grundlegenden Konzepte, die in einer Java Webapplikation zum Einsatz kommen. Diese Konzepte wurden im Modul [Verteilte Systeme](https://www.fhnw.ch/de/studium/module/6007851) behandelt. Auch das Modul [Kommunikation in verteilten Anwendungen](https://www.fhnw.ch/de/studium/module/9076366) aus dem Studiengang iCompetence enthält Aspekte dieser Konzepte, jedoch werden diese nicht in der gleichen Ausführlichkeit behandelt.

Zu diesen Konzepten gehören:
* Servlet
* Filter
* Listener

## Ressourcen

Die Slides zu dieser Lektion sind auf [MS Teams](https://teams.microsoft.com/l/channel/19%3aGUtpEacwnFN-v0_PeG-fdUzDooai_4HhL8QwKr7hnRk1%40thread.tacv2/Allgemein?groupId=85012943-9402-4082-930e-4f0cc9356e0f&tenantId=9d1a5fc8-321e-4101-ae63-530730711ac2) abgelegt. Die Slides gibt es in 2 Versionen:

* eine druckbare Version unter Tab *Dateien* im Ordner `01`
* eine vertonte Version im gleichen Ordner.

Alle Arbeitsblätter finden sie ebenfalls auf [MS Teams](https://teams.microsoft.com/_#/school/files/Allgemein?threadId=19%3AGUtpEacwnFN-v0_PeG-fdUzDooai_4HhL8QwKr7hnRk1%40thread.tacv2&ctx=channel&context=01&rootfolder=%252Fteams%252Fwebfr_M365%252FFreigegebene%2520Dokumente%252FGeneral%252F01).

Der Quellcode eines Arbeitsblattes und auch die jeweiligen Lösungen werden über Gitlab bereitgestellt. Die elementaren Schritte im Umgang mit Git werden also vorausgesetzt.

## Theorie

### Ablauf Modul

Machen sie sich mit dem Modulinhalt vertraut. Orientieren sie sich an den Slides (siehe [Ressourcen](#ressourcen)).

### Servlet API

Folgende Komponenten im Kontext des _Servlet API_ müssen sie verstehen und erklären können. Jede dieser Komponenten übernimmt eine bestimmte Aufgabe während der Verarbeitung eines HTTP Requests. Die Zuordnung eines HTTP Requests in Form einer URL auf die entsprechenden Komponenten müssen sie aufzeigen können.

#### _Servlet_


> A servlet is a Java technology-based Web component, managed by a container, that
generates dynamic content. Like other Java technology-based components, servlets
are platform-independent Java classes that are compiled to platform-neutral byte
code that can be loaded dynamically into and run by a Java technology-enabled Web
server. Containers, sometimes called servlet engines, are Web server extensions that
provide servlet functionality. Servlets interact with Web clients via a
request/response paradigm implemented by the servlet container. 

--- from [JSR 369: JavaTM Servlet 4.0 Specification](https://jcp.org/en/jsr/detail?id=369)

Hier ein paar weitere Links aus dem Internet, die aus meiner Sicht nützlich und aktuell sind:
* Overview aus JSR 369: Die Spezifikation ist als [PDF](https://download.oracle.com/otndocs/jcp/servlet-4-final-eval-spec/index.html) verfügbar.
* [What are Servlets?](https://www.tutorialspoint.com/servlets/servlets_overview.htm) von [Javatpoint](https://www.javatpoint.com/)

#### _Servlet Container_ or _Servlet Engine_

> The servlet container is a part of a Web server or application server that provides the
network services over which requests and responses are sent, decodes MIME-based
requests, and formats MIME-based responses. A servlet container also contains and
manages servlets through their lifecycle.

--- from [JSR 369: JavaTM Servlet 4.0 Specification](https://jcp.org/en/jsr/detail?id=369)

Einen guten, kurzen Überblick zum _Servlet Container_ findet [hier](https://docs.oracle.com/cd/B14099_19/web.1012/b14017/overview.htm#i1001694).


#### Tomcat als _Web server_

> The Apache Tomcat software is an open source implementation of the Java Servlet, JavaServer Pages, Java Expression Language and Java WebSocket technologies. The Java Servlet, JavaServer Pages, Java Expression Language and Java WebSocket specifications are developed under the Java Community Process.

--- from [Apache Tomcat](https://tomcat.apache.org/index.html)



## Arbeitsblätter und Übungen
### AB1

In diesem Arbeitsblatt werden sie die Entwicklungsumgebung auf ihrem Computer aufsetzen, um Java Webapplikationen ohne Einsatz irgendwelcher Frameworks implementieren und ausführen zu können.

Bemerkungen:
* Das Arbeitsblatt finden sie auf MS Teams.
* Das Tool _Gradle_ werden wir als Wrapper innerhalb des entsprechenden Projektes zur Verfügung haben. Gradle muss nicht installiert werden!
* Bitte [Tomcat]() als eigenständige Applikation (Webserver) auf ihrem Computer installieren. Sie sollten für die Interaktion mit dem Tomcat keine IDE-Plugins verwenden!

### AB2

**Arbeiten sie in einem 2er-Team. Es macht mehr Spass!**

In diesem Arbeitsblatt wird die Komponente _Servlet_ repetiert. Das werden sie die einfache Java Webapplikation _flashcard-basic_ installieren und in ihrem Tomcat deployen. Sie sollten anschliessend verschiedene Fragen beantworten, die sich auf ihre Webapplikation in ihrem Tomcat beziehen.

Bemerkungen:
* Das Arbeitsblatt finden sie auf MS Teams.
* Bitte keine IDE-Plugins einsetzen.
* Senden sie mir ihre Antworten per Email, so dass ich ihnen ein Feddback geben kann.


### AB3

In diesem Arbeitsblatt erweitern sie die Komponente _BasicServlet_. Es ist das Ziel dieser Übung, dass sie mindestens einmal ganz direkt ein Servlet programmieren. Wir werden im Verlauf dieses Moduls *Spring  Boot* als Framework einsetzen. Dabei wird die Komponente *Servlet* immer mehr in der Hintergrund verschwinden, aber in jeder Spring Boot Applikation gleichwohl vorhanden sein. Das Servlet wird in jeder Java Webapplikation eine zentrale Rolle spielen - und deshalb ist es wichtig die Komponente Servlet zu verstehen.

Bemerkungen:
* Das Arbeitsblatt finden sie auf MS Teams.
* Die Lösung finden sie im Ordner `01/ab3/completed`.
