import java.util.Arrays;

import static Funktionen.Funktionen.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(euklidischerAlgorithmus(973, 301, true));
        System.out.println(Arrays.toString(erweiterterEuklidischerAlgorithmus(973, 301, true)));
        System.out.println(Arrays.toString(erweiterterEuklidischerAlgorithmus(67, 12, true)));
        System.out.println(inverseBerechnen(7,12, true));
    }

}
