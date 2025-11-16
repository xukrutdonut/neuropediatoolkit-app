# Guía de Instalación y Uso - NeuropediaToolkit

## 📱 Instalación Rápida

### Opción 1: Instalación Directa del APK (Más Fácil)

Si ya tienes el archivo APK compilado:

1. **Transferir el APK a tu dispositivo Android:**
   - Envíalo por correo/WhatsApp/cable USB
   - O descárgalo directamente si está alojado online

2. **Habilitar instalación de fuentes desconocidas:**
   - Ve a **Ajustes** → **Seguridad**
   - Activa **"Orígenes desconocidos"** o **"Instalar apps desconocidas"**
   
3. **Instalar:**
   - Abre el archivo `app-debug.apk` desde tu gestor de archivos
   - Toca **"Instalar"**
   - Espera a que termine y toca **"Abrir"**

### Opción 2: Compilar desde el Código Fuente

#### Requisitos Previos

- **Sistema Operativo**: Windows, macOS o Linux
- **Android Studio**: Versión Arctic Fox (2020.3.1) o superior
- **JDK**: Java Development Kit 8 o superior
- **Espacio en disco**: Al menos 4 GB libres

#### Pasos para Compilar

1. **Descargar Android Studio:**
   - Ve a https://developer.android.com/studio
   - Descarga e instala Android Studio

2. **Abrir el proyecto:**
   ```bash
   # En terminal/consola
   cd neuropediatoolkit-app
   ```
   - O desde Android Studio: **File** → **Open** → Selecciona la carpeta

3. **Esperar sincronización de Gradle:**
   - Android Studio descargará las dependencias automáticamente
   - Esto puede tardar 5-10 minutos la primera vez

4. **Compilar el APK:**
   
   **Método A - Desde Android Studio:**
   - Ve a **Build** → **Build Bundle(s) / APK(s)** → **Build APK(s)**
   - Espera a que compile (aparecerá una notificación)
   - Haz clic en **"locate"** para ver el APK
   
   **Método B - Desde línea de comandos:**
   ```bash
   # En Linux/macOS
   ./gradlew assembleDebug
   
   # En Windows
   gradlew.bat assembleDebug
   ```
   
   **Método C - Script automático:**
   ```bash
   chmod +x build-apk.sh
   ./build-apk.sh
   ```

5. **Ubicación del APK:**
   ```
   app/build/outputs/apk/debug/app-debug.apk
   ```

#### Instalar en un dispositivo Android

**Con cable USB:**
```bash
# Activar "Depuración USB" en tu dispositivo
# Ajustes → Opciones de desarrollador → Depuración USB

# Instalar con ADB
adb install app/build/outputs/apk/debug/app-debug.apk
```

**Sin cable:**
- Copia el APK a tu dispositivo
- Ábrelo desde el gestor de archivos
- Instala normalmente

## 🚀 Guía de Uso

### 1. Calculadora de Perímetro Cefálico

**Para qué sirve:** Evalúa si el perímetro cefálico del niño está dentro de los rangos normales según su edad y sexo.

**Cómo usar:**
1. Ingresa la **edad** del niño (en meses, años o días)
2. Selecciona la **unidad de edad** (Meses/Años/Días)
3. Ingresa el **perímetro cefálico** en centímetros
4. Selecciona el **sexo** (Niño/Niña)
5. Toca **"Calcular"**

**Resultado:**
- Z-Score (desviaciones estándar)
- Clasificación: Normal, Microcefalia, Macrocefalia
- Interpretación clínica

### 2. Índice Cefalométrico y Braquicefálico

**Para qué sirve:** Detecta deformidades craneales como braquicefalia (cabeza ancha) o dolicocefalia (cabeza alargada).

**Cómo usar:**
1. Mide el **ancho craneal** (diámetro biparietal) con cinta métrica
2. Mide el **largo craneal** (diámetro anteroposterior)
3. Ingresa ambos valores en centímetros
4. Toca **"Calcular"**

**Resultado:**
- Índice cefálico calculado
- Clasificación: Normal (75-83), Braquicefalia (>83), Dolicocefalia (<75)
- Grado de severidad

### 3. Desarrollo Psicomotor

**Para qué sirve:** Consulta rápida de los hitos del desarrollo esperados por edad.

**Cómo usar:**
1. Abre la herramienta
2. Navega por la lista de hitos organizados por edad
3. Compara con el desarrollo del paciente

**Incluye:**
- Motor grueso (caminar, correr, saltar)
- Motor fino (manipulación, pinza)
- Lenguaje (balbuceo, palabras, frases)
- Social (sonrisa, juego, interacción)

### 4. Curvas de Crecimiento / Calculadora de IMC

**Para qué sirve:** Calcula el Índice de Masa Corporal y clasifica el estado nutricional.

**Cómo usar:**
1. Ingresa la **edad** del niño
2. Ingresa el **peso** en kilogramos
3. Ingresa la **talla** en centímetros
4. Selecciona el **sexo**
5. Toca **"Calcular IMC"**

**Resultado:**
- IMC calculado
- Clasificación: Bajo peso, Normal, Sobrepeso, Obesidad
- Nota sobre percentiles pediátricos

### 5. Calculadora de Dosis de Medicamentos

**Para qué sirve:** Calcula dosis pediátricas de medicamentos comunes según el peso.

**Cómo usar:**
1. Ingresa el **peso** del paciente en kilogramos
2. Selecciona el **medicamento** del menú desplegable
3. Toca **"Calcular Dosis"**

**Medicamentos disponibles:**
- **Paracetamol**: 15 mg/kg/dosis (cada 4-6h)
- **Ibuprofeno**: 10 mg/kg/dosis (cada 6-8h)
- **Amoxicilina**: 40-50 mg/kg/día (dividido en 3 dosis)
- **Ácido Valproico**: 20-30 mg/kg/día (inicio)
- **Levetiracetam**: 20 mg/kg/día (inicio)

**⚠️ IMPORTANTE:**
- Estos son cálculos orientativos
- Siempre verifica con fuentes oficiales
- Considera contraindicaciones y ajustes individuales

### 6. Escalas de Evaluación

**Para qué sirve:** Referencia rápida de las escalas de evaluación neurológica y del desarrollo más utilizadas.

**Incluye:**
- **Glasgow**: Evaluación de nivel de conciencia
- **Glasgow Pediátrico**: Adaptado para menores de 4 años
- **APGAR**: Evaluación neonatal
- **Denver II**: Screening del desarrollo
- **Bayley**: Evaluación integral del desarrollo
- **CARS**: Detección de autismo
- **M-CHAT**: Screening precoz de autismo
- **Conners**: Evaluación de TDAH

## 💡 Consejos de Uso

1. **Mantén datos actualizados:** Pesa y mide al niño regularmente
2. **Usa todas las herramientas juntas:** Para una evaluación más completa
3. **Registra resultados:** Anota los valores para seguimiento
4. **Consulta con especialistas:** Ante cualquier hallazgo anormal

## ⚠️ Advertencias Médicas Importantes

- Esta app es una **herramienta de apoyo**, no un diagnóstico definitivo
- **NO reemplaza** la evaluación clínica profesional
- Los cálculos son **aproximados** y deben verificarse
- **Siempre consulta** las guías clínicas actualizadas
- Para medicamentos, **verifica dosis** en vademécum oficial
- Ante cualquier duda, **consulta con un especialista**

## 🔧 Solución de Problemas

### La app no instala
- Verifica que tienes habilitada la instalación de apps de fuentes desconocidas
- Asegúrate de tener espacio suficiente (al menos 50 MB)
- Intenta reiniciar el dispositivo

### La app se cierra inesperadamente
- Actualiza a la última versión de Android (si es posible)
- Limpia la caché: Ajustes → Apps → NeuropediaToolkit → Limpiar caché
- Reinstala la aplicación

### No puedo calcular / No aparecen resultados
- Verifica que ingresaste todos los datos requeridos
- Asegúrate de usar puntos (.) para decimales, no comas (,)
- Selecciona todas las opciones (sexo, unidades, etc.)

### El APK no compila
```bash
# Limpia el proyecto
./gradlew clean

# Verifica la versión de Java
java -version  # Debe ser 8 o superior

# Actualiza Gradle
./gradlew wrapper --gradle-version 8.0
```

## 📞 Soporte

Para más información sobre las herramientas clínicas, visita:
https://neuropediatoolkit.org/

## 📄 Licencia

Esta aplicación es de código abierto y está disponible para uso educativo y clínico.

---

**Versión**: 1.0  
**Última actualización**: 2024  
**Requisitos mínimos**: Android 5.0 (API 21) o superior
