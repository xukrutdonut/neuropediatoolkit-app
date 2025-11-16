package com.neuropediatoolkit;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CalculadoraDosisMedicamentosActivity extends AppCompatActivity {

    private EditText pesoInput;
    private Spinner medicamentoSpinner;
    private TextView resultadoText;
    private Button calcularButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_dosis);

        pesoInput = findViewById(R.id.pesoInput);
        medicamentoSpinner = findViewById(R.id.medicamentoSpinner);
        resultadoText = findViewById(R.id.resultadoText);
        calcularButton = findViewById(R.id.calcularButton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.medicamentos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        medicamentoSpinner.setAdapter(adapter);

        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularDosis();
            }
        });
    }

    private void calcularDosis() {
        try {
            double peso = Double.parseDouble(pesoInput.getText().toString());
            String medicamento = medicamentoSpinner.getSelectedItem().toString();

            String resultado = "";

            switch (medicamento) {
                case "Paracetamol":
                    double dosisParacetamol = peso * 15; // 15 mg/kg/dosis
                    resultado = String.format(
                        "Paracetamol\n\n" +
                        "Dosis: 15 mg/kg/dosis\n" +
                        "Peso: %.1f kg\n\n" +
                        "Dosis calculada: %.1f mg\n" +
                        "Cada 4-6 horas\n" +
                        "Máximo: 4 dosis/día\n" +
                        "Dosis máxima diaria: %.1f mg",
                        peso, dosisParacetamol, dosisParacetamol * 4
                    );
                    break;

                case "Ibuprofeno":
                    double dosisIbuprofeno = peso * 10; // 10 mg/kg/dosis
                    resultado = String.format(
                        "Ibuprofeno\n\n" +
                        "Dosis: 10 mg/kg/dosis\n" +
                        "Peso: %.1f kg\n\n" +
                        "Dosis calculada: %.1f mg\n" +
                        "Cada 6-8 horas\n" +
                        "Máximo: 40 mg/kg/día",
                        peso, dosisIbuprofeno
                    );
                    break;

                case "Amoxicilina":
                    double dosisAmoxicilina = peso * 40; // 40-50 mg/kg/día
                    resultado = String.format(
                        "Amoxicilina\n\n" +
                        "Dosis: 40-50 mg/kg/día\n" +
                        "Peso: %.1f kg\n\n" +
                        "Dosis total diaria: %.1f mg\n" +
                        "Dividir en 3 dosis\n" +
                        "Cada dosis: %.1f mg",
                        peso, dosisAmoxicilina, dosisAmoxicilina / 3
                    );
                    break;

                case "Ácido Valproico":
                    double dosisValproico = peso * 20; // 20-30 mg/kg/día inicial
                    resultado = String.format(
                        "Ácido Valproico\n\n" +
                        "Dosis inicial: 20-30 mg/kg/día\n" +
                        "Peso: %.1f kg\n\n" +
                        "Dosis calculada: %.1f mg/día\n" +
                        "Dividir en 2 dosis\n" +
                        "Cada dosis: %.1f mg\n\n" +
                        "NOTA: Requiere monitorización\n" +
                        "de niveles séricos",
                        peso, dosisValproico, dosisValproico / 2
                    );
                    break;

                case "Levetiracetam":
                    double dosisLevetiracetam = peso * 20; // 20 mg/kg/día inicial
                    resultado = String.format(
                        "Levetiracetam\n\n" +
                        "Dosis inicial: 20 mg/kg/día\n" +
                        "Peso: %.1f kg\n\n" +
                        "Dosis calculada: %.1f mg/día\n" +
                        "Dividir en 2 dosis\n" +
                        "Cada dosis: %.1f mg",
                        peso, dosisLevetiracetam, dosisLevetiracetam / 2
                    );
                    break;
            }

            resultadoText.setText(resultado + "\n\n⚠️ ADVERTENCIA: Este cálculo es orientativo.\nConsulte siempre con un médico antes de administrar.");

        } catch (NumberFormatException e) {
            resultadoText.setText("Por favor ingresa un peso válido");
        }
    }
}
