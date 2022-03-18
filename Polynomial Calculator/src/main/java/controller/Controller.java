package controller;
import model.Operatii;
import model.Polinom;
import model.Regex;
import view.DashboardView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class Controller {
    private final DashboardView dashboardView;

    public Controller(DashboardView dashboardView) {
        this.dashboardView = dashboardView;

        this.dashboardView.addListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstInput = dashboardView.getFirstInput();
                String secondInput = dashboardView.getSecondInput();
                if(verifyInput(firstInput, secondInput)) {
                    Polinom p1 = Regex.getPolinom(firstInput);
                    Polinom p2 = Regex.getPolinom(secondInput);
                    arrangeMonomials(p1, p2);
                    dashboardView.setResult("" + Operatii.adunaPolinoame(p1, p2));
                }
            }
        });

        this.dashboardView.subtractListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstInput = dashboardView.getFirstInput();
                String secondInput = dashboardView.getSecondInput();
                if(verifyInput(firstInput, secondInput)) {
                    Polinom p1 = Regex.getPolinom(firstInput);
                    Polinom p2 = Regex.getPolinom(secondInput);
                    arrangeMonomials(p1, p2);
                    dashboardView.setResult("" + Operatii.scadePolinoame(p1, p2));
                }
            }
        });

        this.dashboardView.multiplyListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstInput = dashboardView.getFirstInput();
                String secondInput = dashboardView.getSecondInput();
                if(verifyInput(firstInput, secondInput)) {
                    Polinom p1 = Regex.getPolinom(firstInput);
                    Polinom p2 = Regex.getPolinom(secondInput);
                    arrangeMonomials(p1, p2);
                    dashboardView.setResult("" + Operatii.inmultestePolinoame(p1, p2));
                }
            }
        });

        this.dashboardView.divideListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstInput = dashboardView.getFirstInput();
                String secondInput = dashboardView.getSecondInput();
                if(verifyInput(firstInput, secondInput)) {
                    Polinom p1 = Regex.getPolinom(firstInput);
                    Polinom p2 = Regex.getPolinom(secondInput);
                    arrangeMonomials(p1, p2);
                    if(p2.getLeadingMonom().getCoeficient() == 0) {
                        dashboardView.setResult("");
                        dashboardView.showError("Nu puteti imparti la 0!");
                    }
                    else {
                        Polinom[] rezultat = Operatii.impartePolinoame(p1, p2);
                        dashboardView.setResult("Cat: " + rezultat[0] + "  Rest: " + rezultat[1]);
                    }
                }
            }
        });

        this.dashboardView.clearListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboardView.setFirstInput("");
                dashboardView.setSecondInput("");
                dashboardView.setResult("");
            }
        });

        this.dashboardView.swapListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = dashboardView.getFirstInput();
                dashboardView.setFirstInput(dashboardView.getSecondInput());
                dashboardView.setSecondInput(s);
                dashboardView.setResult("");
            }
        });

        this.dashboardView.integrateListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstInput = dashboardView.getFirstInput();
                if(verifyInput(firstInput, "0")) {
                    Polinom p1 = Regex.getPolinom(firstInput);
                    arrangeMonomials(p1);
                    dashboardView.setResult("" + Operatii.integreazaPolinom(p1) + " + C");
                }
            }
        });

        this.dashboardView.differentiateListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstInput = dashboardView.getFirstInput();
                if(verifyInput(firstInput, "0")) {
                    Polinom p1 = Regex.getPolinom(firstInput);
                    arrangeMonomials(p1);
                    dashboardView.setResult("" + Operatii.deriveazaPolinom(p1));
                }
            }
        });

        this.dashboardView.helpListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String instructiuni = """
                             Introduceti polinaomele in casetele corespunzatoare sub forma:
                                                a(n)*x^n+a(n-1)*x^(n-1)+...+a(2)x^2+a(1)*x+a(0),
                                                unde a(n), a(n-1), ..., a(0) reprezinta coeficientii.
                             Dupa ce ati introdus polinoamele, apasati pe butonul corespunzator operatiei pe
                        care doriti sa o executati. In cazul operatiilor de derivare si integrare, primul polinom\s
                        va fi supus operatiei.
                             Butonul de SWAP inverseaza polinoamele intre ele
                             Butonul de CLEAR sterge datele de intrare si rezultatul.
                        """;
                dashboardView.showMessage(instructiuni);
            }
        });

    }

    public boolean verifyInput(String input1, String input2){
        Polinom p1 = Regex.getPolinom(input1);
        Polinom p2 = Regex.getPolinom(input2);
        String userInput1 = input1.replace(" ", "");
        String userInput2 = input2.replace(" ", "");

        if(!userInput1.equals(p1.toString().replace(" ", ""))) {
            dashboardView.showError("Input-ul nu respecta structura indicata!");
            return false;
        }else
            if(!userInput2.equals(p2.toString().replace(" ", ""))) {
                dashboardView.showError("Input-ul nu respecta structura indicata!");
                return false;
            }
            else
                return true;
    }

    public void arrangeMonomials(Polinom p1, Polinom p2){
        Collections.sort(p1.getPolinom());
        Collections.sort(p2.getPolinom());
    }
    public void arrangeMonomials(Polinom p1){
        Collections.sort(p1.getPolinom());
    }


}
