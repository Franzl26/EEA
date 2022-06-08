import Funktionen.ECGleichung;
import Funktionen.ECPunkt;

import java.util.ArrayList;
import java.util.Arrays;

import static Funktionen.Funktionen.*;

public class Main {
    public static void main(String[] args) {
        // test();
        // speedTest();
        // ecTest();
        // Uebung5.uebung5();
        // Uebung7.uebung7();
        Uebung8.uebung8();

        System.out.println("\n\n");
        ECGleichung gl = new ECGleichung(8,7,73);
        ECPunkt p1 = new ECPunkt(gl, 32,53);
        System.out.println(p1.isPrimitive(true));
        ArrayList<ECPunkt> l = gl.printAllElements();
        l.forEach(o -> {
            if (o.isPrimitive()) System.out.println("isPrimitive: " + o);
        });
        System.out.println(p1.mult(13*17));
    }

    public static void test() {
        System.out.println(euklidischerAlgorithmus(973, 301, true));
        System.out.println(Arrays.toString(erweiterterEuklidischerAlgorithmus(973, 301, true)));
        System.out.println(Arrays.toString(erweiterterEuklidischerAlgorithmus(67, 12, true)));
        System.out.println(inverseBerechnen(7, 12));
        System.out.println(inverseBerechnen(12, 67));
        System.out.println(faktorisieren(976));
    }

    public static void speedTest() {
        int anz = 10000;
        long modulus = 7 * anz / 2;
        long start = System.currentTimeMillis();
        for (int i = 1; i < anz; i++) modPow(2L, i, modulus);
        long mitte = System.currentTimeMillis();
        for (int i = 1; i < anz; i++) squareAndMultiply(2L, i, modulus);
        long ende = System.currentTimeMillis();
        System.out.println(mitte - start);
        System.out.println(ende - mitte);

    }

    public static void ecTest() {
        ECGleichung gl = new ECGleichung(2, 2, 17);
        ECPunkt p1 = new ECPunkt(gl, 5, 1);
        System.out.println(p1.isPrimitive(true));

        ECGleichung gl2 = new ECGleichung(1,0,23);

        ArrayList<ECPunkt> l = gl2.printAllElements();
        l.forEach(o -> {
            if (o.isPrimitive()) System.out.println("isPrimitive: " + o);
        });
        new ECPunkt(gl2, 9, 5).isPrimitive(true);
        System.out.println(gl2.add(1,5,11,10));
        System.out.println(gl2.verdoppeln(1,5));
    }
}
