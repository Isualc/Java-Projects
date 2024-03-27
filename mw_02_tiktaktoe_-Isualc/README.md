[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/0OG2JTD9)
# TikTakToe-Codersbay

---
## Überblick

02_TikTakToe setzt das gleichnamige Spiel in Java Logik um. Es sollen 2 Spieler, X und O, gegeneinander, in einem 3x3 Felder großen Feld
auf der Konsole spielen können. Unser Programm folgt den Spielregeln des echten Spiels.

---
## Beurteilungsschema

|Beurteilung|Anforderungen|
| :- | :- |
|**Sehr Gut** |Grundlegende Teilaufgaben vollständig erfüllt **und** erweiterte Teilaufgaben vollständig erfüllt.|
|**Gut**|Grundlegende Teilaufgaben vollständig erfüllt **und** erweiterte Teilaufgaben überwiegend erfüllt.|
|**Befriedigend**|Grundlegende Teilaufgaben vollständig erfüllt **oder** grundlegende Teilaufgaben überwiegend erfüllt und zumindest Ansätze bei allen erweiterten Teilaufgaben.|
|**Genügend**|Grundlegende Teilaufgaben überwiegend erfüllt.|
|**Nicht genügend**|Grundlegende Teilaufgaben **nicht** überwiegend erfüllt.|
---

## Spezifikationen

- **Alle Ausgaben erfolgen über System.out**
- **Keinerlei Ausgaben erfolgen über System.err**
- **Halte dich an den StyleGuide**
- **Bitte befolge die Anweisungen zur Ausgabe _genau_, da die Test Cases selbst bei kleinen Fehlern (z.B. ein Leerzeichen zu viel oder zu wenig) fehlschlagen!**
- **Verwende die in den Lernzielen aufgezählten Konzepte, ansonsten werden bei der Bewertung Punkte abgezogen**

Diese Aufgabenstellung beinhaltet Platzhalter bei den Ausgabeformaten.

```In diesem Beispiel wird ein Wert eingelesen: ```
> nicht auf das Leerzeichen zwischen `:` und dem einzugebenden Wert vergessen!

```In diesem Beispiel wird folgender Wert ausgegeben: <ausgabewert>```

Ein Platzhalter ist immer mit `<>` gekennzeichnet und soll bei Eingaben oder Ausgaben nicht auf der Konsole ausgegeben werden.
Bei Ausgabewerten soll der jeweilige Wert, der dafür berechnet oder verarbeitet wurde, statt dem Platzhalter angezeigt werden.

---
## Hilfsmittel
### Erlaubt sind:
- Internet (Google, Foren, Teachin-Sites, …)
- Alte, selbstprogrammierte Projekte
- Trainer um Hilfe fragen :D
### Nicht erlaubt sind:
- Gruppenarbeit
- Plagiate (siehe StyleGuide)
- Von ChatGPT erstellter Code, es sei denn er erfüllt die Anforderungen von Plagiaten
---
## Lernziele
Es wurde eine Aufgabenstellung aus folgenden Kapiteln gewählt:

- Alles bisherige
- Java Array
- Java Mehrdimensionelle Arrays
- Java Switch
- Java Random
- Java Klassen
- Java Klassenmethoden
---
## Aufgabenstellung

### Einleitung

> Das Projekt hat ein Framework integriert, welches zum Durchführen der Aufgabenstellung verwendet werden kann und **soll**. 
> 
> Das **Löschen** einer der gegebenen Methoden oder Attribute wird automatisch als **Spezifikationsverstoß** geahndet!
> 
> Das **Hinzufügen** von Attributen, Methoden, Klassen, etc ist natürlich **erlaubt**.

Zum Beginn des Spiels soll die Willkommensnachricht ```Welcome to Tik-Tak-Codersbay!``` ausgegeben werden.

### Das Spielfeld
Wie bereits im Skript sollen auch für TikTakToe, Arrays zum Speichern des Spielfelds hergenommen werden. Dies
wird mithilfe eines 2D-Arrays der Größe 3x3 umgesetzt. Das Spielfeld soll zur Leserlichtkeit vor, und nach dem Spielersymbol
ein Leerzeichen vorweisen. Darum muss das Array auch vom Datentyp String sein.

Die Anzahl der Zeilen und Spalten des Spielfelds ```board``` sollen mithilfe von *Konstanten* definiert werden.

Das Spielfeld muss zu Beginn des Spiels an jeder Position mit 3 Leerzeichen initialisiert werden.
Verwende dafür die Methode ```initBoard()```.

Anschließend soll in ```printBoard()``` das Spielfeld, mitsamt aller Trennzeichen, ausgegeben werden.
- Die Trennzeichen für die Spalten sind: ```|```.
- Die Trennzeichen für die Zeilen sind: ```---+---+---```.
>Achte darauf, dass vor und nach dem Spielfeld ein ```\n``` steht damit die Ausgabe schöner aussieht.


Das leere Spielfeld sollte bereits nach diesem Schritt angezeigt werden können. Zum Testen ist hier ein Vergleich:
```
   |   |
---+---+---
   |   |
---+---+---
   |   |
```

### Hauptprogramm (100 Punkte)
In der Main Klasse und main Methode werden alle Programmabläufe gesteuert. 
Erzeuge für den Anfang ein Objekt der Klasse TikTakToe mit dem Namen ```game```. 
Mithilfe von diesem Objekt kannst du auf dein Spiefeld und alle anderen wichtigen Methoden der Klasse TiKTakToe in der Klasse
Main zugreifen.

#### Einlesen der Benutzereingaben

Befülle die beiden Methoden ```getRow()``` und ```getColumn()```. Mittels einem Scanner soll vom Benutzer die Zeile und
Spalte eingelesen werden, in die der Spieler seine Figur platzieren möchte.

```Row: ```

```Column: ```

> Die gültigen Eingaben hängen hierbei von der Spielfeldgröße ab.
> Achte darauf, dass der Benutzer bei einem 3x3 großen Feld zahlen zwischen 1 und 3 eingeben kann, aber der Index im Array
> zwischen 0 und 2 liegt! Es muss also überprüft werden ob es sich beim Input um eine Ganzzahl in den gegebenen Grenzen handelt.
> 
> Überlege dir außerdem wie du verhinderst, dass ein Buchstabe oder ein Wort dein Programm zum Absturz bringt und implementiere eine 
> geeignete Lösung. (Tipp: Verwende Strings für den Input, TypeCasting und try/catch)

Bei einer Falscheingabe wird die Fehlermeldung:

```Invalid Input! Please enter a valid integer for the row you want to select!``` 

beziehungsweise

```Invalid Input! Please enter a valid integer for the column you want to select!``` 

ausgegeben und der jeweilige Input wird erneut abgefragt. Ansonsten wird der eingegebene Integer von der Methode zurückgegeben.

#### Durchführen des Spielzugs

Verwende die Methode ```setPosition(int r, int c, String player)``` um den Spielzug eines Spielers zu setzen.
Die Übergabeparameter beinhalten die Informationen:
- ```r``` ... Index der Reihe (row)
- ```c``` ... Index der Spalte (column)
- ```player``` ... Spielfigur als String (``` X ``` oder ``` O ```)
  - Vergiss nicht vor und nach dem X oder O ein Leerzeichen zu speichern. Du kannst auch Konstanten dafür verwenden.


> Achtung! Wenn das gewählte Feld bereits von einem Spieler belegt wird, muss die Fehlermeldung: 
> 
> ```Error: Position is already taken! Please choose a different field.```
> ausgegeben werden. Beim Spielerwechsel können außerdem später Probleme an dieser Stelle auftreten. Behalte das im Hinterkopf :) .

#### Spielerwechsel

Wird der Spielzug erfolgreich durchgeführt soll der Spieler mittels ```getNextPlayer(String player)``` gewechselt werden.
Dies darf natürlich nur passieren, wenn der Spielzug vorher erfolgreich war, da ansonsten für den nächsten Zyklus ein Spieler übersprungen wird.

#### Spielende

Nach jedem Spielzug soll überprüft werden, ob das Spiel bereits vorüber ist. Dazu soll die Methode
```isGameOver()``` implementiert werden.

Überprüfe ob in einer Zeile, Spalte oder Diagonale alle Felder identisch sind und mach das für das ganze Spielfeld.
Eine Win-Condition wäre:

```!board[0][0].equals(“---“) && board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2])```

Übersetzt bedeutet das:
Board[0][0] ist nicht der Standardstring und stimmt mit dem 2 überein und der zweite mit dem 3.

> ```---``` ist der Platzhalte für die 3 Leerzeichen, da dies in diesem Dokument nicht anders anzeigbar ist.
---

#### Bonus (20 Punkte)
Erweitere dein Programm um eine Abfrage direkt nach der Willkommensnachricht, damit die Spielfeldgröße vom Benutzer bestimmt werden kann.

```How big should the board be? (min. 3):```

Gültige Eingaben sind dabei ganze Zahlen größer gleich 3.
Bei einer Falscheingabe wird die Meldung:
    
```Invalid Input! Please enter a valid integer for the board size! (min. 3)```

Passe die Methode ```isGameOver()``` so an, dass sie bei einer beliebigen Größe trotzdem funktioniert.


### Beispielausgabe
```
Welcome to Tik-Tak-Codersbay!

   |   |   
---+---+---
   |   |   
---+---+---
   |   |   

Row: 1
Column: 2

   |   |   
---+---+---
   |   | X 
---+---+---
   |   |   

Row: RRR
Invalid Input! Please enter a valid integer for the row you want to select!
Row: 345
Invalid Input! Please enter a valid integer for the row you want to select!
Row: 1
Column: 2
Error: Position is already taken! Please choose a different field.

   |   |   
---+---+---
   |   | X 
---+---+---
   |   |   

Row: 1
Column: 1

   |   |   
---+---+---
   | O | X 
---+---+---
   |   |   

Row: 2
Column: 2

   |   |   
---+---+---
   | O | X 
---+---+---
   |   | X 

Row: 1
Column: 0

   |   |   
---+---+---
 O | O | X 
---+---+---
   |   | X 

Row: 0
Column: 2

   |   | X 
---+---+---
 O | O | X 
---+---+---
   |   | X 

 X  wins!

Process finished with exit code 0

```
