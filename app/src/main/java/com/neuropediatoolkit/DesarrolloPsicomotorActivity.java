package com.neuropediatoolkit;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class DesarrolloPsicomotorActivity extends AppCompatActivity {

    private ListView hitosListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desarrollo_psicomotor);

        hitosListView = findViewById(R.id.hitosListView);

        List<String> hitos = getHitosDesarrollo();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            android.R.layout.simple_list_item_1,
            hitos
        );
        hitosListView.setAdapter(adapter);
    }

    private List<String> getHitosDesarrollo() {
        List<String> hitos = new ArrayList<>();
        
        hitos.add("2 MESES\n• Sonrisa social\n• Sigue objetos con la mirada\n• Sostiene brevemente la cabeza");
        hitos.add("4 MESES\n• Control cefálico completo\n• Se lleva objetos a la boca\n• Ríe a carcajadas");
        hitos.add("6 MESES\n• Se sienta con apoyo\n• Pasa objetos de una mano a otra\n• Balbucea");
        hitos.add("9 MESES\n• Se sienta sin apoyo\n• Gateo\n• Pinza inferior\n• Dice 'papá' 'mamá' inespecífico");
        hitos.add("12 MESES\n• Camina con ayuda\n• Pinza superior\n• Dice 2-3 palabras\n• Entiende órdenes simples");
        hitos.add("18 MESES\n• Camina solo\n• Sube escaleras gateando\n• 10-20 palabras\n• Usa cuchara");
        hitos.add("2 AÑOS\n• Corre\n• Sube escaleras de pie\n• Frases de 2 palabras\n• Juego simbólico");
        hitos.add("3 AÑOS\n• Salta con ambos pies\n• Copia círculo\n• Frases de 3 palabras\n• Control de esfínteres");
        hitos.add("4 AÑOS\n• Salta en un pie\n• Copia cuadrado\n• Cuenta historias\n• Juega con otros niños");
        hitos.add("5 AÑOS\n• Salta alternando pies\n• Copia triángulo\n• Habla claramente\n• Se viste solo");
        
        return hitos;
    }
}
