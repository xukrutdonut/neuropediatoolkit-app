package com.neuropediatoolkit;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout sectionsContainer;
    private List<Section> sections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sectionsContainer = findViewById(R.id.sectionsContainer);
        
        // Initialize sections
        initializeSections();
        
        // Create views for each section
        for (Section section : sections) {
            addSectionView(section);
        }
    }

    private void initializeSections() {
        sections = new ArrayList<>();
        
        // Escalas y calculadoras
        Section escalas = new Section("Escalas y calculadoras");
        escalas.addTool(new Tool("Aplicación nutricional", "https://www.seghnp.org/nutricional/", R.drawable.tool_01_nutricional));
        escalas.addTool(new Tool("NIHSS-Ped", "https://neuropediatoolkit.org/pednihss/", R.drawable.tool_02_nihss));
        escalas.addTool(new Tool("PedCom", "https://neuropediatoolkit.org/pedcom/", R.drawable.tool_03_pedcom));
        escalas.addTool(new Tool("Índice cefalométrico y braquicefálico", "https://neuropediatoolkit.org/calculadora-de-indice-cefalometrico-y-braquicefalico/", R.drawable.tool_04_cefalometrico));
        escalas.addTool(new Tool("Método de Weaver", "https://neuropediatoolkit.org/metodo-de-weaver/", R.drawable.tool_05_weaver));
        escalas.addTool(new Tool("Test de Haizea-Llevant", "http://46.202.131.191:32768/", R.drawable.tool_06_haizea));
        escalas.addTool(new Tool("Calculadora de puntuaciones normalizadas", "https://normapp.neuropedialab.org", R.drawable.tool_07_normalizadas));
        sections.add(escalas);
        
        // Aplicaciones móviles
        Section moviles = new Section("Aplicaciones móviles");
        moviles.addTool(new Tool("Normscales", "https://play.google.com/store/apps/details?id=b.piskernik.normscales", R.drawable.tool_08_normscales));
        moviles.addTool(new Tool("Smart Optometry", "https://play.google.com/store/apps/details?id=com.smartoptometry.smartoptometry.full&hl=es", R.drawable.tool_09_optometry));
        sections.add(moviles);
        
        // Genética
        Section genetica = new Section("Genética");
        genetica.addTool(new Tool("Phenomyzer", "https://compbio.charite.de/phenomizer/", R.drawable.tool_10_phenomyzer));
        genetica.addTool(new Tool("Decipher", "https://www.deciphergenomics.org/", R.drawable.tool_11_decipher));
        genetica.addTool(new Tool("Rarechromo", "https://rarechromo.org/", R.drawable.tool_12_rarechromo));
        genetica.addTool(new Tool("Varsome", "https://varsome.com/", R.drawable.tool_13_varsome));
        genetica.addTool(new Tool("Gene Reviews", "https://www.ncbi.nlm.nih.gov/books/NBK1116/", R.drawable.tool_14_genereviews));
        sections.add(genetica);
        
        // Dismorfología
        Section dismorfo = new Section("Dismorfología");
        dismorfo.addTool(new Tool("Elements of morphology", "https://elementsofmorphology.nih.gov/", R.drawable.tool_15_morphology));
        dismorfo.addTool(new Tool("The atlas of syndromic morphology", "https://syndrome-atlas.ca/", R.drawable.tool_16_syndromic));
        dismorfo.addTool(new Tool("Atlas of human morphology", "https://research.nhgri.nih.gov/atlas/index.shtml", R.drawable.tool_17_atlas));
        dismorfo.addTool(new Tool("Human phenotypes", "http://humanphenotypes.net/", R.drawable.tool_18_phenotypes));
        sections.add(dismorfo);
        
        // Enfermedades neurológicas
        Section neuro = new Section("Enfermedades neurológicas");
        neuro.addTool(new Tool("Learning EEG", "https://www.learningeeg.com/", R.drawable.tool_19_eeg));
        neuro.addTool(new Tool("Neuromuscular diseases", "https://neuromuscular.wustl.edu/", R.drawable.tool_20_neuromuscular));
        neuro.addTool(new Tool("Epilepsy Diagnosis", "https://www.epilepsydiagnosis.org/", R.drawable.tool_21_epilepsy));
        neuro.addTool(new Tool("Movement Disorder Genes", "https://www.mdsgene.org/", R.drawable.tool_22_movement));
        neuro.addTool(new Tool("Neurochecklists", "https://neurochecklists.com/", R.drawable.tool_23_neurochecklists));
        sections.add(neuro);
        
        // Metabólicas
        Section metabolicas = new Section("Metabólicas");
        metabolicas.addTool(new Tool("Vademecum Metabolicum", "http://www.vademetab.org/", R.drawable.tool_24_vademetab));
        metabolicas.addTool(new Tool("Treatable ID", "https://treatable-id.net", R.drawable.tool_25_treatable));
        sections.add(metabolicas);
        
        // Neurorradiología
        Section neuroimagen = new Section("Neurorradiología");
        neuroimagen.addTool(new Tool("MRI of the Neonatal Brain", "https://www.mrineonatalbrain.com/", R.drawable.tool_26_mri));
        neuroimagen.addTool(new Tool("Radiopaedia", "https://radiopaedia.org/", R.drawable.tool_27_radiopaedia));
        sections.add(neuroimagen);
        
        // Manejo terapéutico
        Section terapeutico = new Section("Manejo terapéutico");
        terapeutico.addTool(new Tool("Treatabolome", "https://treatabolome.org/#/", R.drawable.tool_28_treatabolome));
        sections.add(terapeutico);
    }

    private void addSectionView(Section section) {
        // Add section title
        TextView sectionTitle = new TextView(this);
        sectionTitle.setText(section.getName());
        sectionTitle.setTextSize(20);
        sectionTitle.setTextColor(0xFF111111);
        sectionTitle.setPadding(0, 32, 0, 16);
        LinearLayout.LayoutParams titleParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        sectionTitle.setLayoutParams(titleParams);
        sectionsContainer.addView(sectionTitle);
        
        // Add RecyclerView for tools
        RecyclerView recyclerView = new RecyclerView(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        
        ToolsAdapter adapter = new ToolsAdapter(section.getTools());
        recyclerView.setAdapter(adapter);
        
        LinearLayout.LayoutParams recyclerParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        recyclerView.setLayoutParams(recyclerParams);
        sectionsContainer.addView(recyclerView);
    }

    private void openUrl(String url) {
        // Abrir en WebView a pantalla completa
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }

    private static class Section {
        private String name;
        private List<Tool> tools;

        public Section(String name) {
            this.name = name;
            this.tools = new ArrayList<>();
        }

        public void addTool(Tool tool) {
            tools.add(tool);
        }

        public String getName() {
            return name;
        }

        public List<Tool> getTools() {
            return tools;
        }
    }

    private static class Tool {
        private String name;
        private String url;
        private int imageResId;

        public Tool(String name, String url, int imageResId) {
            this.name = name;
            this.url = url;
            this.imageResId = imageResId;
        }

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }

        public int getImageResId() {
            return imageResId;
        }
    }

    private class ToolsAdapter extends RecyclerView.Adapter<ToolsAdapter.ToolViewHolder> {
        private List<Tool> tools;

        public ToolsAdapter(List<Tool> tools) {
            this.tools = tools;
        }

        @NonNull
        @Override
        public ToolViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_tool, parent, false);
            return new ToolViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ToolViewHolder holder, int position) {
            Tool tool = tools.get(position);
            holder.toolName.setText(tool.getName());
            holder.toolImage.setImageResource(tool.getImageResId());
            holder.itemView.setOnClickListener(v -> openUrl(tool.getUrl()));
        }

        @Override
        public int getItemCount() {
            return tools.size();
        }

        class ToolViewHolder extends RecyclerView.ViewHolder {
            TextView toolName;
            ImageView toolImage;

            public ToolViewHolder(@NonNull View itemView) {
                super(itemView);
                toolName = itemView.findViewById(R.id.toolName);
                toolImage = itemView.findViewById(R.id.toolImage);
            }
        }
    }
}
