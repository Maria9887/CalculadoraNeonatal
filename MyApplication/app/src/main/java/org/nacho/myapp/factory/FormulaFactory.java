package org.nacho.myapp.factory;

import org.nacho.myapp.utils.Constants;
import org.nacho.myapp.utils.OptionFormula;

public class FormulaFactory {

    public static <T> T getFormula(int selectedOption, T inputQuantity) {
        T result = null;
        if (inputQuantity != null) {
            try {
                if (inputQuantity instanceof Integer) {
                    if (Constants.CODE_FORMULA_1.equals(selectedOption)) {
                        result = (T) OptionFormula.Formula1((Integer) inputQuantity);
                    }
                    if (Constants.CODE_FORMULA_2.equals(selectedOption)) {
                        result = (T) OptionFormula.Formula2((Integer) inputQuantity);
                    }
                    if (Constants.CODE_FORMULA_3.equals(selectedOption)) {
                        result = (T) OptionFormula.Formula3((Integer) inputQuantity);
                    }
                } else if(inputQuantity instanceof Float) {
                    if (Constants.CODE_FORMULA_1.equals(selectedOption)) {
                        result = (T) OptionFormula.Formula1((Float) inputQuantity);
                    }
                    if (Constants.CODE_FORMULA_2.equals(selectedOption)) {
                        result = (T) OptionFormula.Formula2((Float) inputQuantity);
                    }
                    if (Constants.CODE_FORMULA_3.equals(selectedOption)) {
                        result = (T) OptionFormula.Formula3((Float) inputQuantity);
                    }
                }
            } catch (NumberFormatException nfe) {
                // Cannot format number
            }
        }
        return result;
    }

}
