# Guía para Publicar NeuropediaToolkit en Google Play Store

## 📋 Requisitos Previos

### 1. Cuenta de Google Play Console
- Costo: $25 USD (pago único de por vida)
- Registro en: https://play.google.com/console/signup
- Necesitas: Tarjeta de crédito/débito, cuenta de Google

### 2. Información Necesaria
- ✅ Nombre de la app: **NeuropediaToolkit**
- ✅ Categoría: **Medical** (Médica)
- ✅ Descripción corta y larga
- ✅ Capturas de pantalla (mínimo 2)
- ✅ Ícono de alta resolución (512x512)
- ✅ Gráfico de características (1024x500)
- ✅ APK/AAB firmado con certificado de producción

## 🔑 PASO 1: Crear Keystore para Firma de Producción

El APK actual es de DEBUG. Para Play Store necesitas uno FIRMADO.

```bash
cd /home/arkantu/docker/toolkit/neuropediatoolkit-app

# Crear keystore (guarda la contraseña en lugar seguro!)
keytool -genkey -v -keystore neuropediatoolkit-release.keystore \
  -alias neuropediatoolkit \
  -keyalg RSA \
  -keysize 2048 \
  -validity 10000

# Te preguntará:
# - Contraseña del keystore (¡GUÁRDALA!)
# - Nombre, Organización, Ciudad, País
# - Contraseña de la clave (puede ser la misma)
```

**⚠️ IMPORTANTE:** 
- Guarda el archivo `.keystore` en lugar seguro (¡NUNCA lo pierdas!)
- Guarda las contraseñas (sin ellas no podrás actualizar la app)
- NO subas el keystore a GitHub

## 🔐 PASO 2: Configurar Firma en Gradle

Crea el archivo `keystore.properties` (NO lo subas a Git):

```properties
storeFile=/ruta/completa/a/neuropediatoolkit-release.keystore
storePassword=TU_CONTRASEÑA_KEYSTORE
keyAlias=neuropediatoolkit
keyPassword=TU_CONTRASEÑA_KEY
```

## 📦 PASO 3: Generar APK/AAB de Producción

### Opción A: AAB (Recomendado por Google)
```bash
./gradlew bundleRelease
# Resultado: app/build/outputs/bundle/release/app-release.aab
```

### Opción B: APK (Universal)
```bash
./gradlew assembleRelease
# Resultado: app/build/outputs/apk/release/app-release.apk
```

**Nota:** Google Play prefiere AAB (Android App Bundle) porque optimiza el tamaño.

## 🎨 PASO 4: Crear Assets de Play Store

### A) Ícono de alta resolución (512x512 px)
- Formato: PNG de 32 bits con canal alfa
- Tamaño: Exactamente 512x512 píxeles
- Sin transparencia en bordes
- Ya tenemos: `logo_neuropediatoolkit.png` (necesita redimensionarse)

### B) Gráfico de características (1024x500 px)
- Formato: JPG o PNG de 24 bits
- Tamaño: Exactamente 1024x500 píxeles
- Promociona tu app visualmente

### C) Capturas de pantalla
- **Teléfono:** Mínimo 2, máximo 8
  - Tamaños: 320px-3840px en lado más largo
  - Proporción: 16:9 o 9:16
- **Tablet 7":** Opcional (2-8)
- **Tablet 10":** Opcional (2-8)

## 📝 PASO 5: Textos para Play Store

### Título (máximo 50 caracteres)
```
NeuropediaToolkit
```

### Descripción corta (máximo 80 caracteres)
```
28 herramientas esenciales para la consulta neuropediátrica
```

### Descripción completa (máximo 4000 caracteres)
```
NeuropediaToolkit es una aplicación Android que proporciona acceso rápido a 28 herramientas esenciales para la consulta neuropediátrica, organizadas en 8 categorías temáticas.

📊 ESCALAS Y CALCULADORAS
• Aplicación nutricional
• NIHSS-Ped
• PedCom
• Índice cefalométrico y braquicefálico
• Método de Weaver
• Test de Haizea-Llevant
• Calculadora de puntuaciones normalizadas

🧬 GENÉTICA
• Phenomyzer
• Decipher
• Rarechromo
• Varsome
• Gene Reviews

👤 DISMORFOLOGÍA
• Elements of morphology
• Atlas of syndromic morphology
• Atlas of human morphology
• Human phenotypes

🧠 ENFERMEDADES NEUROLÓGICAS
• Learning EEG
• Neuromuscular diseases
• Epilepsy Diagnosis
• Movement Disorder Genes
• Neurochecklists

🧪 METABÓLICAS
• Vademecum Metabolicum
• Treatable ID

🔬 NEURORRADIOLOGÍA
• MRI of the Neonatal Brain
• Radiopaedia

💊 MANEJO TERAPÉUTICO
• Treatabolome

📱 APLICACIONES MÓVILES
• Normscales
• Smart Optometry

✨ CARACTERÍSTICAS
✓ Acceso rápido a 28 herramientas especializadas
✓ Organización intuitiva por categorías
✓ Diseño profesional y limpio
✓ Enlaces directos a recursos web confiables
✓ Interfaz optimizada para uso clínico
✓ Compatible con Android 5.0+

Basado en el sitio web neuropediatoolkit.org, esta aplicación es una herramienta esencial para profesionales de neuropediatría, residentes y estudiantes.

⚠️ NOTA: Esta app proporciona enlaces a herramientas web. Se requiere conexión a Internet para acceder a las herramientas.

🔗 Sitio web oficial: https://neuropediatoolkit.org
```

## 🏷️ PASO 6: Categorización y Clasificación

### Categoría principal
**Medical (Médica)**

### Tipo de aplicación
**Aplicación** (no es un juego)

### Clasificación de contenido
Completa el cuestionario de Google:
- Contenido médico: Sí
- Para profesionales: Sí
- Edad recomendada: PEGI 3 / Everyone
- No contiene: Violencia, lenguaje adulto, contenido sexual

### Etiquetas (tags)
```
neuropediatría, pediatría, medicina, herramientas médicas, calculadoras médicas, escalas neurológicas, neurología pediátrica
```

## 📋 PASO 7: Información Legal

### Política de privacidad (REQUERIDA)
Crea una página web con:
- Qué datos recopilas (en este caso: ninguno)
- Cómo los usas
- Con quién los compartes
- Derechos del usuario

**Ejemplo simple (necesitas hosting):**
```
URL: https://tusitio.com/neuropediatoolkit/privacy-policy
```

### Declaraciones requeridas
- [ ] La app no recopila datos de usuarios
- [ ] La app accede a Internet solo para abrir enlaces
- [ ] Cumple con políticas de Google Play
- [ ] Es de uso médico/educativo profesional

## 🚀 PASO 8: Proceso de Subida

### En Google Play Console:

1. **Crear aplicación**
   - Nombre: NeuropediaToolkit
   - Idioma predeterminado: Español
   - Tipo: Aplicación
   - Gratuita/Paga: Gratuita

2. **Ficha de Play Store**
   - Título corto
   - Descripción completa
   - Ícono 512x512
   - Gráfico de características
   - Capturas de pantalla (mínimo 2)

3. **Clasificación de contenido**
   - Completa cuestionario
   - Categoría: Medical

4. **Precios y distribución**
   - Países: Seleccionar donde distribuir
   - Precio: Gratuita
   - Contiene anuncios: No
   - Dirigida a niños: No (es para profesionales)

5. **Subir APK/AAB**
   - Producción → Crear versión
   - Subir app-release.aab
   - Notas de la versión
   - Guardar → Revisar versión → Implementar

6. **Revisión**
   - Google revisará la app (puede tardar horas o días)
   - Te notificarán por email
   - Si es aprobada: ¡Publicada!

## ⏱️ TIEMPOS

- Revisión inicial: 1-7 días (usualmente 24-48h)
- Actualizaciones: 1-3 días
- Disponibilidad después de aprobación: 2-3 horas

## ✅ CHECKLIST FINAL

Antes de enviar a revisión:

- [ ] APK/AAB firmado con keystore de producción
- [ ] Keystore guardado en lugar seguro (backup!)
- [ ] Contraseñas guardadas
- [ ] Ícono 512x512 creado
- [ ] Gráfico 1024x500 creado
- [ ] Mínimo 2 capturas de pantalla
- [ ] Descripción completa escrita
- [ ] Política de privacidad publicada (URL)
- [ ] Categoría seleccionada: Medical
- [ ] Cuestionario de clasificación completado
- [ ] Países de distribución seleccionados
- [ ] Número de versión correcto (versionCode y versionName)

## 🔄 ACTUALIZACIONES FUTURAS

Para actualizar la app:

1. Aumenta `versionCode` y `versionName` en `app/build.gradle`
2. Compila nuevo AAB/APK con el MISMO keystore
3. Sube a Play Console → Producción → Nueva versión
4. Agrega notas de la versión
5. Implementar

## 💰 COSTOS

- Registro Play Console: $25 USD (una sola vez)
- Publicación de apps: Gratis
- Actualizaciones: Gratis
- Hosting para política de privacidad: Variable (puedes usar GitHub Pages gratis)

## 📞 SOPORTE

Si tienes problemas:
- Centro de ayuda: https://support.google.com/googleplay/android-developer
- Políticas: https://play.google.com/about/developer-content-policy/

---

**NOTA IMPORTANTE:** Esta guía es orientativa. Lee siempre las políticas actuales de Google Play antes de publicar.

**PRÓXIMOS PASOS:** Comienza con el PASO 1 (crear keystore) y avanza secuencialmente.
