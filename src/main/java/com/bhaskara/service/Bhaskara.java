package com.bhaskara.service;

import java.util.ArrayList;
import java.util.List;

public class Bhaskara {
    public static List<Double> calculoRaizes(Double constante_a, Double constante_b, Double constante_c) {
        var raizes = new ArrayList<Double>();

        double delta = Math.pow(constante_b,2) - 4 * constante_a * constante_c;
        double x1 = (-constante_b + Math.sqrt(delta)) / (2 * constante_a);
        double x2 = (-constante_b - Math.sqrt(delta)) / (2 * constante_a);

        raizes.add(x2);
        raizes.add(x1);

        return raizes;
    }

    public static List<Double> calculoRaizes(BhaskaraCalcInputDTO bhaskaraCalcInputDTO) {

        Double constante_a = bhaskaraCalcInputDTO.parametroAToDouble();
        Double constante_b = bhaskaraCalcInputDTO.parametroBToDouble();
        Double constante_c = bhaskaraCalcInputDTO.parametroCToDouble();

        return calculoRaizes(constante_a,constante_b,constante_c);
    }
}
