package com.neuropediatoolkit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class IndiceCefalometricoActivity extends AppCompatActivity {

    private EditText anchoInput;
    private EditText largoInput;
    private TextView resultadoText;
    private Button calcularButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indice_cefalometrico);

        anchoInput = findViewById(R.id.anchoInput);
        largoInput = findViewById(R.id.largoInput);
        resultadoText = findViewById(R.id.resultadoText);
        calcularButton = findViewById(R.id.calcularButton);

        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIndices();
            }
        });
    }

    private void calcularIndices() {
        try {
            double ancho = Double.parseDouble(anchoInput.getText().toString());
            double largo = Double.parseDouble(largoInput.getText().toString());

            // Índice Cefálico = (Ancho / Largo) × 100
            double indiceCefalico = (ancho / largo) * 100;

            String clasificacionCefalica;
            if (indiceCefalico < 75) {
                clasificacionCefalica = "Dolicocefalia (< 75)";
            } else if (indiceCefalico <= 83) {
                clasificacionCefalica = "Normal (75-83)";
            } else if (indiceCefalico <= 90) {
                clasificacionCefalica = "Braquicefalia leve (83-90)";
            } else if (indiceCefalico <= 100) {
                clasificacionCefalica = "Braquicefalia moderada (90-100)";
            } else {
                clasificacionCefalica = "Braquicefalia severa (> 100)";
            }

            String resultado = String.format(
                "Ancho craneal: %.1f cm\n" +
                "Largo craneal: %.1f cm\n\n" +
                "Índice Cefálico: %.2f\n" +
                "Clasificación: %s\n\n" +
                "Interpretación:\n" +
                "- Normal: 75-83\n" +
                "- Braquicefalia: > 83 (cabeza ancha)\n" +
                "- Dolicocefalia: < 75 (cabeza alargada)",
                ancho, largo, indiceCefalico, clasificacionCefalica
            );

            resultadoText.setText(resultado);

        } catch (NumberFormatException e) {
            resultadoText.setText("Por favor ingresa valores numéricos válidos");
        }
    }
}
