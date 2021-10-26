package htw.berlin.prog2.ha1;

/**
 * Eine Klasse, die das Verhalten des Online Taschenrechners imitiert, welcher auf
 * https://www.online-calculator.com/ aufgerufen werden kann (ohne die Memory-Funktionen)
 * und dessen Bildschirm bis zu zehn Ziffern plus einem Dezimaltrennzeichen darstellen kann.
 * Enthält mit Absicht noch diverse Bugs oder unvollständige Funktionen.
 */
public class Calculator {

    private String screen = "0";

    private double latestValue;

    private String latestOperation = "";

    private String number;

    private double endresult = 0;



    /**
     * @return den aktuellen Bildschirminhalt als String
     */
    public String readScreen() {
        return screen;
    }

    /**
     * Empfängt den Wert einer gedrückten Zifferntaste. Da man nur eine Taste auf einmal
     * drücken kann muss der Wert positiv und einstellig sein und zwischen -9 und 9 liegen.
     * Führt in jedem Fall dazu, dass die gerade gedrückte Ziffer auf dem Bildschirm angezeigt
     * oder rechts an die zuvor gedrückte Ziffer angehängt angezeigt wird.
     * ist die Variable endresult = 0, wird ihm der Wert des Latestvalue zugeordnet
     * die Mehtode pressEqualsKeyAutomation() wird aufgerufen
     * @param digit Die Ziffer, deren Taste gedrückt wurde
     *
     */
    public void pressDigitKey(int digit) {
        if(digit > 9 || digit < -9) throw new IllegalArgumentException();

        if(screen.equals("0") || latestValue == Double.parseDouble(screen)) screen = "";

        screen = screen + digit;
        number = screen;
        if(endresult == 0){
            endresult = latestValue;
        }
        pressEqualsKeyAutomation();
    }

    /**
     * Empfängt den Befehl der C- bzw. CE-Taste (Clear bzw. Clear Entry).
     * Einmaliges Drücken der Taste löscht die zuvor eingegebenen Ziffern auf dem Bildschirm
     * so dass "0" angezeigt wird, jedoch ohne zuvor zwischengespeicherte Werte zu löschen.
     * Wird daraufhin noch einmal die Taste gedrückt, dann werden auch zwischengespeicherte
     * Werte sowie der aktuelle Operationsmodus zurückgesetzt, so dass der Rechner wieder
     * im Ursprungszustand ist.
     */
    public void pressClearKey() {
        screen = "0";
        latestOperation = "";
        latestValue = 0.0;
        number = "";
        endresult = 0;


    }

    /**
     * Empfängt den Wert einer gedrückten binären Operationstaste, also eine der vier Operationen
     * Addition, Substraktion, Division, oder Multiplikation, welche zwei Operanden benötigen.
     * Beim ersten Drücken der Taste wird der Bildschirminhalt nicht verändert, sondern nur der
     * Rechner in den passenden Operationsmodus versetzt.
     * Beim zweiten Drücken nach Eingabe einer weiteren Zahl wird direkt des aktuelle Zwischenergebnis
     * auf dem Bildschirm angezeigt. Falls hierbei eine Division durch Null auftritt, wird "Error" angezeigt.
     * @param operation "+" für Addition, "-" für Substraktion, "x" für Multiplikation, "/" für Division
     */
    public void pressBinaryOperationKey(String operation)  {
        latestValue = Double.parseDouble(screen);
        latestOperation = operation;
    }

    /**
     * Empfängt den Wert einer gedrückten unären Operationstaste, also eine der drei Operationen
     * Quadratwurzel, Prozent, Inversion, welche nur einen Operanden benötigen.
     * Wenn aus einer negativen Zahl die Wurzel gezogen werden soll, wird direkt Error angezeigt
     * Beim Drücken der Taste wird direkt die Operation auf den aktuellen Zahlenwert angewendet und
     * der Bildschirminhalt mit dem Ergebnis aktualisiert.
     * wird versucht aus einer negativen Zahl eine Wurzel zu ziehen, wird auf dem Screen Error angezeigt
     * @param operation "√" für Quadratwurzel, "%" für Prozent, "1/x" für Inversion
     */
    public void pressUnaryOperationKey(String operation) {
        latestValue = Double.parseDouble(screen);
        latestOperation = operation;
        if(operation.equals("√") && latestValue <=0){
            screen = "ERROR";
        }
        else {
            var result = switch (operation) {
                case "√" -> Math.sqrt(Double.parseDouble(screen));
                case "%" -> Double.parseDouble(screen) / 100;
                case "1/x" -> 1 / Double.parseDouble(screen);
                default -> throw new IllegalArgumentException();
            };


            screen = Double.toString(result);
            if (screen.contains(".") && screen.length() > 11) screen = screen.substring(0, 10);
        }

    }

    /**
     * Empfängt den Befehl der gedrückten Dezimaltrennzeichentaste, im Englischen üblicherweise "."
     * Fügt beim ersten Mal Drücken dem aktuellen Bildschirminhalt das Trennzeichen auf der rechten
     * Seite hinzu und aktualisiert den Bildschirm. Daraufhin eingegebene Zahlen werden rechts vom
     * Trennzeichen angegeben und daher als Dezimalziffern interpretiert.
     * Beim zweimaligem Drücken, oder wenn bereits ein Trennzeichen angezeigt wird, passiert nichts.
     */
    public void pressDotKey() {
        if(!screen.endsWith(".")) screen = screen + ".";
    }

    /**
     * Empfängt den Befehl der gedrückten Vorzeichenumkehrstaste ("+/-").
     * Zeigt der Bildschirm einen positiven Wert an, so wird ein "-" links angehängt, der Bildschirm
     * aktualisiert und die Inhalt fortan als negativ interpretiert.
     * Zeigt der Bildschirm bereits einen negativen Wert mit führendem Minus an, dann wird dieses
     * entfernt und der Inhalt fortan als positiv interpretiert.
     */
    public void pressNegativeKey() {
        screen = screen.startsWith("-") ? screen.substring(1) : "-" + screen;
    }

    /**
     * Empfängt den Befehl der gedrückten "="-Taste.
     * zeigt das in pressEqualsKeyAutomation() errechente endergebnis auf dem Screen an
     * wenn das Ergebnis eine runde Zahl ist, wird das .0 abgeschnitten
     * ist ein Punkt enthalten, können 0 bis 10 Ziffern angezeigt werden
     */


    public void pressEqualsKey() {
        screen = Double.toString(endresult);
        if (screen.endsWith(".0")) screen = screen.substring(0, screen.length() - 2);
        if (screen.contains(".") && screen.length() > 11) screen = screen.substring(0, 10);

    }

    /**
     * Wurde Eingeführt um mehr als zwei Rechenoperationen ausführen zu können.
     * Wird ausgelöst wenn zuvor eine binäre Operationstaste gedrückt und zwei Operanden eingegeben werden, ansonsten passiert nichts
     * Ergebnis der Operation wird in endresult gespeichert. Falls hierbei eine Division durch Null auftritt, wird "Error" angezeigt.
     */

    public void pressEqualsKeyAutomation() {
        if (latestValue != 0.0 && number != "" && latestOperation != ""){
            var result = switch (latestOperation) {
                case "+" -> endresult + Double.parseDouble(number);
                case "-" -> endresult - Double.parseDouble(number);
                case "x" -> endresult * Double.parseDouble(number);
                case "/" -> endresult / Double.parseDouble(number);
                default -> throw new IllegalArgumentException();
            };
            endresult = result;
        }
    }
}
