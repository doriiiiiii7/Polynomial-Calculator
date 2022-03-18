package model;

import java.util.Collections;
import java.util.regex.*;

public class Regex {
    private static final String polynomialPattern = "([+-]?(?:(?:\\d*x\\^\\d+)|(?:\\d*x)|(?:\\d+)))";

    public static Polinom getPolinom(String input){
        Pattern pattern = Pattern.compile(polynomialPattern);
        Matcher matcher = pattern.matcher(input);
        Polinom newPolinom = new Polinom();
        while (matcher.find()) {
            String group = matcher.group(1);
            Monom m = getMonom(group);
            newPolinom.getPolinom().add(m);
        }

        return newPolinom;
    }

    public static Monom getMonom(String input){
        int gradMonom = 0;
        double coeficientMonom = 0;
        if(input.indexOf('x') != -1){
            if(input.indexOf('x') == 0)
                coeficientMonom = 1;
            else{
                if(input.indexOf('x') == 1) {
                    if (input.startsWith("+"))
                        coeficientMonom = 1;
                    else if (input.startsWith("-"))
                        coeficientMonom = -1;
                    else
                        coeficientMonom = Double.parseDouble(input.substring(0, 1));
                }else
                    coeficientMonom = Double.parseDouble(input.substring(0, input.indexOf('x')));
            }
            if(input.indexOf('^') != -1){
                gradMonom = Integer.parseInt(input.substring(input.indexOf('^')+1));
            }
            else{
                gradMonom = 1;
            }
        }else
            coeficientMonom = Double.parseDouble(input);

        return new Monom(coeficientMonom, gradMonom);
    }
}
