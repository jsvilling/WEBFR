# Lesson 7: React Komponenten
In dieser Lektion werden die React Komponenten vertieft behandelt. Ein wichtiges Thema ist die Unterscheidung einer React Komponente in:
- Class Component
- Functional Component

Sie sollen in dieser Lektion lernen:
- Wie muss man eine Functional Component implementieren?
- Wie kann man eine Applikation in React Komponenten (Class oder Functional) aufteilen (=> Decomposition)?

## Einleitung
Die Möglichkeit in JavaScript funktional zu programmieren, hat das React Team bewogen dieses Programmierparadigma besser zu unterstützen. Deshalb sind die *Functional Component* entstanden. 

## Ressourcen
Die Slides zu dieser Lektion sind auf [MS Teams](https://teams.microsoft.com/l/channel/19%3aGUtpEacwnFN-v0_PeG-fdUzDooai_4HhL8QwKr7hnRk1%40thread.tacv2/Allgemein?groupId=85012943-9402-4082-930e-4f0cc9356e0f&tenantId=9d1a5fc8-321e-4101-ae63-530730711ac2) abgelegt. Die Slides gibt es in 2 Versionen:

* eine druckbare Version unter Tab *Dateien* im Ordner `07`
* eine vertonte Version im gleichen Ordner.

## Theorie
Der funktionale Ansatz führt zu React Komponenten, die einfacher zu lesen, zu debuggen und zu testen sind. Eine solche Komponente erhält Properties als Input und wird JSX als Output zurückgeben. Eine *Functional Component* kann aber keine Zustands- oder Lebenszyklusmethoden enthalten - dann braucht es die *Class Component*.

Einen guten Vergleich dieser beiden Komponenten finden sie im Blog [React Functional Components VS Class Components](https://medium.com/wesionary-team/react-functional-components-vs-class-components-86a2d2821a22).

## Arbeitsblätter und Übungen
**Arbeiten sie in einem 2er-Team. Es macht mehr Spass!**

### AB21 
Mit diesem Arbeitsblatt erfolgt der Start zur React-Applikation `flashcard-react`. Diese erste Version wird noch ohne Anbindung an den `flashcard-server` implementiert. Die Daten für die `Questionnaire` Entitäten sind simuliert.

### AB22
Sie erstellen eine weitere Version von `flashcard-react`. Wichtig in diesem Arbeitsblatt ist der Umgang Listen - und die Notwendigkeit des **Keys** zu verstehen!

In der Dokumentation von [React](https://reactjs.org/) findet man zu diesem Thema ein entsprechendes Kapitel [Lists and Keys](https://reactjs.org/docs/lists-and-keys.html).

### AB23
In einer React Applikation ist es wichtig zu überlegen, in welcher Komponente ein `State` verwaltet wird.

Im Kapitel [Lifting State Up](https://reactjs.org/docs/lifting-state-up.html) findet man eine ausführliche Beschreibung.