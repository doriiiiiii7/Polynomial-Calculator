import model.Monom;
import model.Operatii;
import model.Polinom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperatiiTest {
    @Test
    public void additionTest(){
        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();
        p1.getPolinom().add(new Monom(1, 2));
        p1.getPolinom().add(new Monom(1, 1));
        p1.getPolinom().add(new Monom(3, 0));
        // p1 = x^2 + x + 3
        p2.getPolinom().add(new Monom(5, 1));
        p2.getPolinom().add(new Monom(6, 0));
        // p2 = 5x + 6
        assertTrue(Operatii.adunaPolinoame(p1, p2).toString().equals("x^2 + 6x + 9"), "Unsuccessful test!");
    }

    @Test
    public void subtractionTest(){
        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();
        p1.getPolinom().add(new Monom(1, 2));
        p1.getPolinom().add(new Monom(1, 1));
        p1.getPolinom().add(new Monom(3, 0));
        // p1 = x^2 + x + 3
        p2.getPolinom().add(new Monom(5, 1));
        p2.getPolinom().add(new Monom(6, 0));
        // p2 = 5x + 6
        assertTrue(Operatii.scadePolinoame(p1, p2).toString().equals("x^2 - 4x - 3"), "Unsuccessful test!");
    }

    @Test
    public void multiplicationTest(){
        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();
        p1.getPolinom().add(new Monom(1, 2));
        p1.getPolinom().add(new Monom(1, 1));
        p1.getPolinom().add(new Monom(3, 0));
        // p1 = x^2 + x + 3
        p2.getPolinom().add(new Monom(5, 1));
        p2.getPolinom().add(new Monom(6, 0));
        // p2 = 5x + 6
        assertTrue(Operatii.inmultestePolinoame(p1, p2).toString().equals("5x^3 + 11x^2 + 21x + 18"), "Unsuccessful test!");
    }

    @Test
    public void divisionTest(){
        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();
        p1.getPolinom().add(new Monom(1, 2));
        p1.getPolinom().add(new Monom(1, 1));
        p1.getPolinom().add(new Monom(3, 0));
        // p1 = x^2 + x + 3
        p2.getPolinom().add(new Monom(5, 1));
        p2.getPolinom().add(new Monom(6, 0));
        // p2 = 5x + 6

        Polinom[] rezultat = Operatii.impartePolinoame(p1, p2);
        assertTrue(rezultat[0].toString().equals("0,20x - 0,04"), "Unsuccessful test!");
        assertTrue(rezultat[1].toString().equals("3,24"), "Unsuccessful test!");
    }

    @Test
    public void diferentiationTest(){
        Polinom p1 = new Polinom();
        p1.getPolinom().add(new Monom(1, 2));
        p1.getPolinom().add(new Monom(1, 1));
        p1.getPolinom().add(new Monom(3, 0));
        // p1 = x^2 + x + 3

        assertTrue(Operatii.deriveazaPolinom(p1).toString().equals("2x + 1"), "Unsuccessful test!");
    }

    @Test
    public void integrationTest(){
        Polinom p1 = new Polinom();
        p1.getPolinom().add(new Monom(1, 2));
        p1.getPolinom().add(new Monom(1, 1));
        p1.getPolinom().add(new Monom(3, 0));
        // p1 = x^2 + x + 3

        assertTrue(Operatii.integreazaPolinom(p1).toString().equals("0,33x^3 + 0,50x^2 + 3x"), "Unsuccessful test!");
    }
}
