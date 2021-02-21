package com.example.unitcoverter;

public class Converter {
    public static float toCelcius(float fah) {
        return (fah - 32) * 5/9;
    }

    public static double toKG(float ibs) {
        return (ibs * 0.45359237);
    }

    public static double toKM(float miles){
        return  (miles * 1.60934);
    }
    public static double toMeter(float feet){
        return (feet * 0.3048);
    }

}
