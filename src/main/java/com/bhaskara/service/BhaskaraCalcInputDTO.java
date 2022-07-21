package com.bhaskara.service;

public class BhaskaraCalcInputDTO {
    String parametroA;
    String parametroB;
    String parametroC;

    public BhaskaraCalcInputDTO(String parametroA, String parametroB, String parametroC) {
        this.parametroA = parametroA;
        this.parametroB = parametroB;
        this.parametroC = parametroC;
    }

    public Double parametroAToDouble(){
        return Double.valueOf(parametroA);
    }

    public Double parametroBToDouble(){
        return Double.valueOf(parametroB);
    }

    public Double parametroCToDouble(){
        return Double.valueOf(parametroC);
    }

    public String getParametroA() {
        return parametroA;
    }

    public void setParametroA(String parametroA) {
        this.parametroA = parametroA;
    }

    public String getParametroB() {
        return parametroB;
    }

    public void setParametroB(String parametroB) {
        this.parametroB = parametroB;
    }

    public String getParametroC() {
        return parametroC;
    }

    public void setParametroC(String parametroC) {
        this.parametroC = parametroC;
    }
}

