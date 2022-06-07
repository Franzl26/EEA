import Funktionen.ECGleichung;
import Funktionen.ECPunkt;

public class Uebung8 {
    public static void uebung8() {
        // aufgabe2();
        aufgabe3();
        aufgabe4();
        aufgabe5();
        aufgabe6();
        aufgabe7();
        aufgabeZ1();
        aufgabeZ2();
    }

    public static void aufgabe2() {
        System.out.println("Aufgabe 2:");
        ECGleichung gleichung = new ECGleichung(2, 2, 17);
        ECPunkt p1 = new ECPunkt(gleichung, 2, 7);
        ECPunkt p2 = new ECPunkt(gleichung,5,2);
        System.out.println("a) (2, 7) + (5, 2) = " + p1.add(p2));
        ECPunkt p3 = new ECPunkt(gleichung,3,6);
        System.out.println("a) (3, 6) * 2 = " + (new ECPunkt(gleichung, 3,6).verdoppeln()));
    }

    public static void aufgabe3() {
    }

    public static void aufgabe4() {
    }

    public static void aufgabe5() {
    }

    public static void aufgabe6() {
    }

    public static void aufgabe7() {
    }

    public static void aufgabeZ1() {
    }

    public static void aufgabeZ2() {
    }
}
