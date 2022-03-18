package model;

import java.util.ArrayList;

public class Polinom{
    private ArrayList<Monom> polinom = new ArrayList<>();

    public ArrayList<Monom> getPolinom() { return polinom; }

    public int getLeadingPower(){
        return polinom.get(0).getGrad();
    }

    public Monom getLeadingMonom(){
        return polinom.get(0);
    }

    public String toString(){
        if(polinom.size() == 0)
            return "0";
        else {
            String s = "" + polinom.get(0);
            int i = 1;
            String semn = "";
            while (i < polinom.size()) {
                semn = polinom.get(i).getCoeficient() < 0 ? " - " : " + ";
                if (semn.equals(" - "))
                    polinom.get(i).setCoeficient(-polinom.get(i).getCoeficient());
                s = s + semn + polinom.get(i);
                if (semn.equals(" - "))
                    polinom.get(i).setCoeficient(-polinom.get(i).getCoeficient());
                i++;
            }
            return s;
        }
    }
}
