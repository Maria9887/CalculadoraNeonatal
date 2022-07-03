package org.nacho.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.nacho.myapp.domain.MenuOption;
import org.nacho.myapp.factory.FormulaFactory;
import org.nacho.myapp.utils.Constants;

public class MainActivity extends AppCompatActivity {

    MenuOption[] menuOptionArray = new MenuOption[3];
    MenuOption option = null;
    TextView quantityTxt = null;
    Spinner mySpinner = null;
    Button myButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantityTxt = findViewById(R.id.quantityTxt);
        myButton = findViewById(R.id.myButton);

        option = new MenuOption(Constants.CODE_FORMULA_1, "Formula 1");
        menuOptionArray[0] = option;
        option = new MenuOption(Constants.CODE_FORMULA_2, "Formula 2");
        menuOptionArray[1] = option;
        option = new MenuOption(Constants.CODE_FORMULA_3, "Formula 3");
        menuOptionArray[2] = option;

        mySpinner = findViewById(R.id.mySpinner);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, menuOptionArray);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(arrayAdapter);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer selectedOptionPosition = mySpinner.getSelectedItemPosition();
                Integer selectedOptionId = menuOptionArray[selectedOptionPosition].getId();

                if (quantityTxt.getText() == null || "".equalsIgnoreCase(quantityTxt.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please enter a valid quantity", Toast.LENGTH_LONG).show();
                    return;
                }
                Float quantityInputFloat = null;
                Integer quantityInputInteger = null;
                try {
                    quantityInputFloat = Float.valueOf(quantityTxt.getText().toString());
                    quantityInputInteger = Integer.valueOf(quantityTxt.getText().toString());
                } catch(Exception e) {
                    Toast.makeText(getApplicationContext(), "Please enter a numeric quantity", Toast.LENGTH_LONG).show();
                    return;
                }
                if (quantityInputFloat != null && quantityInputInteger != null) {
                    // Ejemplo de Patron de diseño Factory
                    Integer formulaResultInteger = FormulaFactory.getFormula(selectedOptionId, quantityInputInteger);
                    Float formulaResultFloat = FormulaFactory.getFormula(selectedOptionId, quantityInputFloat);
                    String msg = "Integer result of formula=" + formulaResultInteger + ", Float result of formula=" + formulaResultFloat;
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}