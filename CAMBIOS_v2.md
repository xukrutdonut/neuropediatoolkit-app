# Cambios Realizados - NeuropediaToolkit App

## 📱 Resumen de Cambios

Se ha modificado la aplicación para replicar exactamente el menú del sitio web https://neuropediatoolkit.org/

### ✅ Cambios Implementados

#### 1. **Diseño de Menú en Cuadrícula**
- **Antes**: Lista vertical simple
- **Después**: Grid de 2 columnas con tarjetas (CardView)
- **Estilo**: Cuadrados con bordes redondeados y sombra

#### 2. **28 Herramientas del Sitio Web Original**
Se han agregado todas las herramientas/enlaces del sitio web original:

**Escalas y calculadoras:**
1. Aplicación nutricional → https://www.seghnp.org/nutricional/
2. NIHSS-Ped → https://neuropediatoolkit.org/pednihss/
3. PedCom → https://neuropediatoolkit.org/pedcom/
4. Índice cefalométrico y braquicefálico → https://neuropediatoolkit.org/calculadora-de-indice-cefalometrico-y-braquicefalico/
5. Método de Weaver → https://neuropediatoolkit.org/metodo-de-weaver/
6. Test de Haizea-Llevant → http://46.202.131.191:32768/
7. Calculadora de puntuaciones normalizadas → https://normapp.neuropedialab.org
8. Normscales → https://play.google.com/store/apps/details?id=b.piskernik.normscales
9. Smart Optometry → https://play.google.com/store/apps/details?id=com.smartoptometry.smartoptometry.full&hl=es

**Genética y fenotipos:**
10. Phenomyzer → https://compbio.charite.de/phenomizer/
11. Decipher → https://www.deciphergenomics.org/
12. Rarecrhomo → https://rarechromo.org/
13. Varsome → https://varsome.com/
14. Gene Reviews → https://www.ncbi.nlm.nih.gov/books/NBK1116/
15. Elements of morphology → https://elementsofmorphology.nih.gov/
16. The atlas of syndromic morphology → https://syndrome-atlas.ca/
17. Atlas of human morphology in diverse populations → https://research.nhgri.nih.gov/atlas/index.shtml
18. Human phenotypes → http://humanphenotypes.net/

**Neurología:**
19. Learning EEG → https://www.learningeeg.com/
20. Neuromuscular diseases Washington → https://neuromuscular.wustl.edu/
21. Epilepsy Diagnosis → https://www.epilepsydiagnosis.org/
22. Movement Disorder Genes → https://www.mdsgene.org/
23. Neurochecklists → https://neurochecklists.com/

**Metabolismo y tratamientos:**
24. Vademecum Metabolicum → http://www.vademetab.org/
25. Treatable ID → https://treatable-id.net
26. Treatabolome → https://treatabolome.org/#/

**Neuroimagen:**
27. MRI of the Neonatal Brain → https://www.mrineonatalbrain.com/
28. Radiopaedia → https://radiopaedia.org/

#### 3. **Funcionalidad de Enlaces Web**
- Al tocar cada cuadrado, se abre el navegador web del móvil con el enlace correspondiente
- Se agregó el permiso de INTERNET en AndroidManifest.xml

#### 4. **Cambios en Archivos**

**MainActivity.java:**
- Cambió de ListView a RecyclerView con GridLayoutManager
- Implementado adaptador personalizado (ToolsAdapter)
- Los enlaces ahora abren URLs en el navegador en lugar de actividades internas
- Clase Tool ahora guarda URL en lugar de Class

**activity_main.xml:**
- Cambió de LinearLayout simple a ScrollView con LinearLayout interno
- Reemplazó ListView por RecyclerView
- Agregado título de sección "Escalas y calculadoras"
- Color del título cambiado a #0073a8 (el mismo del sitio web)

**item_tool.xml (nuevo archivo):**
- Layout para cada elemento del grid
- CardView con bordes redondeados (8dp)
- Elevación de 4dp para efecto de sombra
- TextView centrado para el nombre de la herramienta
- Altura mínima de 120dp
- Efecto ripple al tocar (selectableItemBackground)

**AndroidManifest.xml:**
- Agregado permiso `<uses-permission android:name="android.permission.INTERNET" />`

## 📦 Archivos Modificados

```
app/src/main/AndroidManifest.xml          [MODIFICADO] - Permiso de Internet
app/src/main/java/com/neuropediatoolkit/MainActivity.java  [MODIFICADO] - Grid + URLs
app/src/main/res/layout/activity_main.xml [MODIFICADO] - RecyclerView
app/src/main/res/layout/item_tool.xml     [NUEVO] - Layout de tarjeta
```

## 🎨 Diseño Visual

- **Color principal**: #0073a8 (azul del sitio web original)
- **Fondo**: #F5F5F5 (gris claro)
- **Tarjetas**: Blanco (#FFFFFF) con sombra
- **Grid**: 2 columnas
- **Espaciado**: 8dp entre tarjetas
- **Bordes**: Redondeados (8dp)

## 🚀 Cómo Instalar

### Opción 1: Transferir APK al móvil
```bash
# El APK está en:
app/build/outputs/apk/debug/app-debug.apk

# Por USB:
adb install app/build/outputs/apk/debug/app-debug.apk

# O copia el archivo al móvil y ábrelo desde el gestor de archivos
```

### Opción 2: Recompilar
```bash
cd /home/arkantu/docker/toolkit/neuropediatoolkit-app
./gradlew assembleDebug
```

## ✨ Funcionalidad

1. **Al abrir la app**: Verás el menú principal con 28 cuadrados en formato grid (2 columnas)
2. **Al tocar cualquier cuadrado**: Se abre el navegador del móvil con el enlace correspondiente
3. **Scroll**: Puedes desplazarte verticalmente para ver todas las herramientas
4. **Navegación**: Usa el botón "Atrás" del móvil para volver a la app desde el navegador

## 📱 Compatibilidad

- **Requiere**: Android 5.0 (API 21) o superior
- **Requiere**: Conexión a Internet para acceder a las herramientas web
- **Tamaño APK**: ~6.4 MB

## ⚠️ Notas Importantes

1. **Las herramientas son enlaces web**: No son calculadoras locales, abren páginas web
2. **Requiere Internet**: La mayoría de enlaces necesitan conexión a Internet
3. **Calculadoras locales antiguas**: Las actividades Java originales (PerimetroCefalicaActivity, etc.) siguen en el código pero no son accesibles desde el menú principal. Si las necesitas, puedes agregarlas como elementos adicionales en la lista de herramientas.

## 🔧 Para Agregar Más Herramientas

En `MainActivity.java`, dentro del método `initializeTools()`, agrega:

```java
toolsList.add(new Tool("Nombre de la herramienta", "https://url-de-la-herramienta.com"));
```

---

**Versión**: 2.0.0  
**Fecha**: Noviembre 2024  
**Estado**: ✅ COMPILADO Y LISTO PARA INSTALAR
