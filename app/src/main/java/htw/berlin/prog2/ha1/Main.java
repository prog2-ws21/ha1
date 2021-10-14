package htw.berlin.prog2.ha1;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        //FIRST BUG with NaN

//       // calculator.pressNegativeKey();
//        calculator.pressBinaryOperationKey("/");
//        calculator.pressDigitKey(0);
//        calculator.pressEqualsKey();
//        calculator.pressBinaryOperationKey("+");
//        calculator.pressDigitKey(7);
//        calculator.pressEqualsKey();
//        System.out.println(calculator.readScreen());
//        calculator.pressEqualsKey();
//        System.out.println(calculator.readScreen());


//        Calculator calculator = new Calculator();
//        calculator.pressDigitKey(9);
//        // calculator.pressNegativeKey();
//        calculator.pressBinaryOperationKey("+");
//        calculator.pressDigitKey(0);
//        calculator.pressEqualsKey();
//        calculator.pressBinaryOperationKey("+");
//        calculator.pressDigitKey(7);
//        calculator.pressEqualsKey();
//        System.out.println(calculator.readScreen());
//        calculator.pressEqualsKey();
//        System.out.println(calculator.readScreen());


//        calculator.pressBinaryOperationKey("+");


//        calculator.pressDigitKey(7);
//        calculator.pressNegativeKey();
//        calculator.pressBinaryOperationKey("+");
//        calculator.pressDigitKey(7);
//        calculator.pressEqualsKey();
//        System.out.println(calculator.readScreen());

//TEST pressDigitKey latestValue== value of screen

        calculator.pressDigitKey(1);
        calculator.pressDigitKey(1);
        calculator.pressBinaryOperationKey("+");
        calculator.pressDigitKey(1);
        calculator.pressDigitKey(1);
        calculator.pressBinaryOperationKey("-");
         //calculator.pressEqualsKey();
        System.out.println(calculator.readScreen());

       // calculator.pressBinaryOperationKey("*");

//        System.out.println("latestValue ==>" + calculator.getLatestValue());
//        System.out.println("SCREEN ==>" + calculator.readScreen());

    }
}
