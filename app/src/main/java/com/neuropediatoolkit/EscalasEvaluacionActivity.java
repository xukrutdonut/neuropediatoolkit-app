package com.neuropediatoolkit;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class EscalasEvaluacionActivity extends AppCompatActivity {

    private ListView escalasListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escalas_evaluacion);

        escalasListView = findViewById(R.id.escalasListView);

        List<String> escalas = getEscalasEvaluacion();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            android.R.layout.simple_list_item_1,
            escalas
        );
        escalasListView.setAdapter(adapter);
    }

    private List<String> getEscalasEvaluacion() {
        List<String> escalas = new ArrayList<>();
        
        escalas.add("ESCALA DE GLASGOW\n" +
                   "Apertura ocular: 4-1\n" +
                   "Respuesta verbal: 5-1\n" +
                   "Respuesta motora: 6-1\n" +
                   "Total: 15-3 puntos\n" +
                   "• Leve: 13-15\n" +
                   "• Moderado: 9-12\n" +
                   "• Grave: ≤8");
        
        escalas.add("ESCALA DE COMA DE GLASGOW PEDIÁTRICO\n" +
                   "Adaptada para < 4 años\n" +
                   "Apertura ocular: 4-1\n" +
                   "Respuesta verbal: 5-1 (adaptada)\n" +
                   "Respuesta motora: 6-1");
        
        escalas.add("APGAR\n" +
                   "Al 1 y 5 minutos de vida\n" +
                   "• Frecuencia cardíaca\n" +
                   "• Esfuerzo respiratorio\n" +
                   "• Tono muscular\n" +
                   "• Irritabilidad refleja\n" +
                   "• Color\n" +
                   "Cada ítem: 0-2 puntos");
        
        escalas.add("ESCALA DE DENVER II\n" +
                   "Evaluación del desarrollo:\n" +
                   "• Motor grueso\n" +
                   "• Motor fino adaptativo\n" +
                   "• Lenguaje\n" +
                   "• Personal-social\n" +
                   "Edad: 0-6 años");
        
        escalas.add("ESCALA DE BAYLEY\n" +
                   "Evaluación integral:\n" +
                   "• Desarrollo cognitivo\n" +
                   "• Desarrollo motor\n" +
                   "• Desarrollo del lenguaje\n" +
                   "Edad: 1-42 meses");
        
        escalas.add("CARS (Childhood Autism Rating Scale)\n" +
                   "Evaluación de autismo\n" +
                   "15 ítems\n" +
                   "Puntuación: 15-60\n" +
                   "• < 30: No autista\n" +
                   "• 30-36: Autismo leve-moderado\n" +
                   "• ≥ 37: Autismo grave");
        
        escalas.add("M-CHAT-R/F\n" +
                   "Detección precoz autismo\n" +
                   "20 preguntas\n" +
                   "Edad: 16-30 meses\n" +
                   "Screening de riesgo");
        
        escalas.add("CONNERS\n" +
                   "Evaluación TDAH\n" +
                   "Versiones:\n" +
                   "• Padres (48 ítems)\n" +
                   "• Profesores (28 ítems)\n" +
                   "Edad: 3-17 años");
        
        return escalas;
    }
}
