package model;

public class Monom implements Comparable<Monom> {
    private double coeficient;
    private int grad;

    public Monom(double coeficient, int grad) {
        this.coeficient = coeficient;
        this.grad = grad;
    }

    public double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }

    public int getGrad() {
        return grad;
    }

    public String toString(){
        String s = "";
        String formatCoeficient = "" + ((coeficient == (int)coeficient) ? (int) coeficient : String.format("%.2f", coeficient));
        if(coeficient == 0 && grad == 0)
            return "0";
        else
            if(coeficient == 0)
                return s;

        if(grad == 0)
            return s + formatCoeficient;
        else
            if(coeficient == 1 || coeficient == -1)
                if(grad == 1)
                    return (coeficient == -1 ? "-":"") + "x";
                else
                    return (coeficient == -1 ? "-":"") + "x^" + grad;
            else
                if(grad == 1)
                    return s + formatCoeficient + "x";
                else
                    return s + formatCoeficient + "x^" + grad;
    }

    @Override
    public int compareTo(Monom o) {
        return  o.grad - this.grad;
    }
}
