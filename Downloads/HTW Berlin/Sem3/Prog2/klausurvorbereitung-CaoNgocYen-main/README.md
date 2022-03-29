# Klausur Angewandte Programmierung WS20/21

Die Klausur besteht aus zwei Teilen: einem praktischen und einem theoretischen Teil.
Sie haben insgesamt 90 Minuten Zeit für die Bearbeitung, massgeblich ist der Zeitstempel des entsprechenden Commits.
Sie müssen Ihre Abgabe auf mindestens vier Commits aufteilen (z.B. 1x für Antworten zum Code, 1x für Test-Code, 1x für allgemeine Antworten, 1x für Implementierungs-Code), ansonsten gibt es Punktabzug von bis zu 20 Punkten.
Es handelt sich um eine Open-Book-Klausur, Sie müssen jedoch nicht offensichtliche Quellen ausreichend kennzeichnen und dürfen keine fremde Leistung als Ihre eigene darstellen.

## Theoretischer Teil (60 Punkte)

Beantworten Sie die Fragen, die Sie in der Datei QUESTIONS.md finden. 
Die Fragen beziehen sich teilweise auf den Code in diesem Repository.
Schreiben Sie Ihre Antworten direkt in diese Datei unter die jeweilige Frage.
Wenn sinnvoll, schreiben Sie Freitext, jedoch höchstens drei Sätze pro Frage (in der Regel weniger).
Bei manchen Fragen ist eine Beantwortung als Auflistung sinnvoller, aber achten Sie hier darauf, dass es unmissverständlich ist, was Sie auflisten.
Reichen Sie das Ergebnis per Git Commit & Push ein. 
Sie können die Beantwortung über mehrere Commits verteilen und Ihre Antworten bis zum Ende der Bearbeitungszeit korrigieren.


## Praktischer Teil (60 Punkte)

Betrachten Sie die Klasse `Accounting` im Package `/service/accounting`, sowie das Interface `ReadOnlyInvoice`.
Implementieren Sie die zwei Methoden `createInvoice` und `calculateRevenue` so wie durch das entsprechende JavaDoc spezifiziert und erstellen Sie dafür eine Klasse `Invoice`, welche `ReadOnlyInvoice` implementiert (30 Punkte).
Erstellen Sie ausserdem für beide Methoden jeweils mindestens zwei automatische Testfälle, welche unterschiedliches Verhalten testen, also insgesamt mindestens vier (30 Punkte).
Es kann sinnvoll sein die Tests teilweise vor der Implementierung der zu testenden Methode zu erstellen (test-driven development), dies ist jedoch keine Muss.  