package model;

import java.util.Collections;

public class Operatii {
    public static Polinom adunaPolinoame(Polinom primulPolinom, Polinom alDoileaPolinom){
        Polinom rezultat = new Polinom();
        int i = 0, j = 0;
        int lungime1 = primulPolinom.getPolinom().size();
        int lungime2 = alDoileaPolinom.getPolinom().size();
        while(i < lungime1 && j < lungime2){
            if(primulPolinom.getPolinom().get(i).getGrad() > alDoileaPolinom.getPolinom().get(j).getGrad()){
                rezultat.getPolinom().add(primulPolinom.getPolinom().get(i));
                i++;
            }
            else if(primulPolinom.getPolinom().get(i).getGrad() < alDoileaPolinom.getPolinom().get(j).getGrad()) {
                rezultat.getPolinom().add(alDoileaPolinom.getPolinom().get(j));
                j++;
            }else {
                double coeficientNou = primulPolinom.getPolinom().get(i).getCoeficient() + alDoileaPolinom.getPolinom().get(j).getCoeficient();
                if(coeficientNou != 0) {
                    Monom m = new Monom(coeficientNou, primulPolinom.getPolinom().get(i).getGrad());
                    rezultat.getPolinom().add(m);
                }
                i++; j++;
            }
        }
        for(; i<lungime1; i++)
            if(primulPolinom.getPolinom().get(i).getCoeficient() != 0)
                rezultat.getPolinom().add(primulPolinom.getPolinom().get(i));

        for(; j<lungime2; j++)
            if(alDoileaPolinom.getPolinom().get(j).getCoeficient() != 0)
                rezultat.getPolinom().add(alDoileaPolinom.getPolinom().get(j));
        return rezultat;
    }

    public static Polinom scadePolinoame(Polinom primulPolinom, Polinom alDoileaPolinom){
        Polinom polinomNegat = new Polinom();
        for(Monom m: alDoileaPolinom.getPolinom()){
            polinomNegat.getPolinom().add(new Monom(-m.getCoeficient(),m.getGrad()));
        }
        return adunaPolinoame(primulPolinom, polinomNegat);
    }

    public static Polinom deriveazaPolinom(Polinom p){
        Polinom rezultat = new Polinom();
        for(Monom m: p.getPolinom()){
            if(m.getGrad() != 0)
                rezultat.getPolinom().add(new Monom(m.getGrad()*m.getCoeficient(), m.getGrad()-1));
        }
        return rezultat;
    }

    public static Polinom inmultestePolinoame(Polinom primulPolinom, Polinom alDoileaPolinom){
        Polinom polinomAux = new Polinom();
        Polinom rezultat = new Polinom();
        for(Monom m1: primulPolinom.getPolinom()){
            for(Monom m2: alDoileaPolinom.getPolinom()){
                if(m1.getCoeficient() != 0 && m2.getCoeficient() != 0)
                    polinomAux.getPolinom().add(new Monom(m1.getCoeficient()*m2.getCoeficient(), m1.getGrad()+m2.getGrad()));
            }
            rezultat = adunaPolinoame(rezultat, polinomAux);
            polinomAux.getPolinom().clear();
        }

        Collections.sort(rezultat.getPolinom());
        return rezultat;
    }

    public static Polinom integreazaPolinom(Polinom p){
        Polinom rezultat = new Polinom();
        for(Monom m: p.getPolinom()){
            rezultat.getPolinom().add(new Monom(m.getCoeficient()/(m.getGrad()+1), m.getGrad()+1));
        }
        return rezultat;
    }

    public static Polinom[] impartePolinoame(Polinom primulPolinom, Polinom alDoileaPolinom){
        Polinom[] rezultat = new Polinom[2];
        if(!alDoileaPolinom.getPolinom().isEmpty() && alDoileaPolinom.getPolinom().get(0).getCoeficient() != 0){
            Polinom cat = new Polinom();
            Polinom rest = primulPolinom;
            Polinom polinomAux = new Polinom();
            while(!rest.getPolinom().isEmpty() && rest.getLeadingPower() >= alDoileaPolinom.getLeadingPower()){
                double coeficientNou = (rest.getLeadingMonom().getCoeficient())/(alDoileaPolinom.getLeadingMonom().getCoeficient());
                int gradNou = rest.getLeadingMonom().getGrad() - alDoileaPolinom.getLeadingMonom().getGrad();
                Monom t = new Monom(coeficientNou, gradNou);
                polinomAux.getPolinom().add(t);
                cat.getPolinom().add(t);
                rest = scadePolinoame(rest, inmultestePolinoame(polinomAux, alDoileaPolinom));
                polinomAux.getPolinom().clear();
            }
            rezultat[0] = cat;
            rezultat[1] = rest;
            return rezultat;
        }
        else
            return null;
    }
}
