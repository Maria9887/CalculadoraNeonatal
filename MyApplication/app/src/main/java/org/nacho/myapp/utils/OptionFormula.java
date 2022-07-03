package org.nacho.myapp.utils;

public class OptionFormula {

    public static Float Formula1(Float quantity) {
        System.out.println("Float:Formula1");
        return quantity + 5f;
    }

    public static Integer Formula1(Integer quantity) {
        System.out.println("Integer:Formula1");
        return quantity + 5;
    }

    public static Float Formula2(Float quantity) {
        System.out.println("Float:Formula2");
        return quantity * 2f;
    }

    public static Integer Formula2(Integer quantity) {
        System.out.println("Integer:Formula2");
        return quantity * 2;
    }

    public static Float Formula3(Float quantity) {
        System.out.println("Float:Formula3");
        return quantity / 5f;
    }

    public static Integer Formula3(Integer quantity) {
        System.out.println("Integer:Formula3");
        return quantity / 5;
    }

}
