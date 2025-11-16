package com.neuropediatoolkit;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PerimetroCefalicaActivity extends AppCompatActivity {

    private EditText edadInput;
    private EditText perimetroInput;
    private RadioGroup sexoGroup;
    private Spinner edadUnidadSpinner;
    private TextView resultadoText;
    private Button calcularButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perimetro_cefalica);

        edadInput = findViewById(R.id.edadInput);
        perimetroInput = findViewById(R.id.perimetroInput);
        sexoGroup = findViewById(R.id.sexoGroup);
        edadUnidadSpinner = findViewById(R.id.edadUnidadSpinner);
        resultadoText = findViewById(R.id.resultadoText);
        calcularButton = findViewById(R.id.calcularButton);

        // Setup spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.edad_unidades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        edadUnidadSpinner.setAdapter(adapter);

        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularPercentil();
            }
        });
    }

    private void calcularPercentil() {
        try {
            double edad = Double.parseDouble(edadInput.getText().toString());
            double perimetro = Double.parseDouble(perimetroInput.getText().toString());
            
            int selectedId = sexoGroup.getCheckedRadioButtonId();
            if (selectedId == -1) {
                resultadoText.setText("Por favor selecciona el sexo");
                return;
            }
            
            RadioButton sexoButton = findViewById(selectedId);
            boolean esNino = sexoButton.getText().toString().equals("Niño");
            
            String unidad = edadUnidadSpinner.getSelectedItem().toString();
            
            // Convert edad to months
            if (unidad.equals("Años")) {
                edad = edad * 12;
            } else if (unidad.equals("Días")) {
                edad = edad / 30.0;
            }
            
            // Calculate Z-score and percentile (simplified calculation)
            String resultado = calcularZScoreYPercentil(edad, perimetro, esNino);
            resultadoText.setText(resultado);
            
        } catch (NumberFormatException e) {
            resultadoText.setText("Por favor ingresa valores numéricos válidos");
        }
    }

    private String calcularZScoreYPercentil(double edadMeses, double perimetro, boolean esNino) {
        // Datos simplificados basados en tablas OMS
        // En una app real, usarías las tablas completas de la OMS
        
        double media, desviacion;
        
        if (esNino) {
            // Aproximaciones para niños (ejemplo para 6 meses)
            media = 43.3;
            desviacion = 1.4;
        } else {
            // Aproximaciones para niñas
            media = 42.2;
            desviacion = 1.3;
        }
        
        double zScore = (perimetro - media) / desviacion;
        
        String clasificacion;
        if (zScore < -2) {
            clasificacion = "Microcefalia (< -2 DE)";
        } else if (zScore < -1) {
            clasificacion = "Normal bajo (-2 a -1 DE)";
        } else if (zScore <= 1) {
            clasificacion = "Normal (-1 a +1 DE)";
        } else if (zScore <= 2) {
            clasificacion = "Normal alto (+1 a +2 DE)";
        } else {
            clasificacion = "Macrocefalia (> +2 DE)";
        }
        
        return String.format("Perímetro Cefálico: %.1f cm\nZ-Score: %.2f DE\nClasificación: %s\n\nNota: Este es un cálculo aproximado. Consulta las tablas de la OMS para valores precisos.", 
                           perimetro, zScore, clasificacion);
    }
}
