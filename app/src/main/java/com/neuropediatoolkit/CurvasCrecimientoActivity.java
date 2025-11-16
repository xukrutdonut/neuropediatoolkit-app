package com.neuropediatoolkit;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CurvasCrecimientoActivity extends AppCompatActivity {

    private EditText edadInput;
    private EditText pesoInput;
    private EditText tallaInput;
    private RadioGroup sexoGroup;
    private Spinner edadUnidadSpinner;
    private TextView resultadoText;
    private Button calcularButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curvas_crecimiento);

        edadInput = findViewById(R.id.edadInput);
        pesoInput = findViewById(R.id.pesoInput);
        tallaInput = findViewById(R.id.tallaInput);
        sexoGroup = findViewById(R.id.sexoGroup);
        edadUnidadSpinner = findViewById(R.id.edadUnidadSpinner);
        resultadoText = findViewById(R.id.resultadoText);
        calcularButton = findViewById(R.id.calcularButton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.edad_unidades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        edadUnidadSpinner.setAdapter(adapter);

        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
            }
        });
    }

    private void calcularIMC() {
        try {
            double peso = Double.parseDouble(pesoInput.getText().toString());
            double talla = Double.parseDouble(tallaInput.getText().toString());
            
            // IMC = peso (kg) / talla² (m²)
            double tallaMts = talla / 100.0;
            double imc = peso / (tallaMts * tallaMts);

            String clasificacion;
            if (imc < 18.5) {
                clasificacion = "Bajo peso";
            } else if (imc < 25) {
                clasificacion = "Peso normal";
            } else if (imc < 30) {
                clasificacion = "Sobrepeso";
            } else {
                clasificacion = "Obesidad";
            }

            String resultado = String.format(
                "Peso: %.2f kg\n" +
                "Talla: %.1f cm\n\n" +
                "IMC: %.2f kg/m²\n" +
                "Clasificación: %s\n\n" +
                "Nota: Esta es una clasificación general.\n" +
                "Para niños, consulte las tablas de percentiles\n" +
                "de la OMS según edad y sexo.",
                peso, talla, imc, clasificacion
            );

            resultadoText.setText(resultado);

        } catch (NumberFormatException e) {
            resultadoText.setText("Por favor ingresa valores numéricos válidos");
        }
    }
}
