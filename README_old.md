# NeuropediaToolkit - Aplicación Android

Aplicación Android para herramientas de consulta neuropediátrica basada en https://neuropediatoolkit.org/

## Características

La aplicación incluye las siguientes herramientas:

### 1. **Calculadora de Perímetro Cefálico**
- Calcula percentiles y z-scores del perímetro cefálico
- Basado en tablas de la OMS
- Identifica microcefalia, macrocefalia y normalidad
- Diferenciación por sexo y edad

### 2. **Índice Cefalométrico y Braquicefálico**
- Calcula el índice cefálico a partir del ancho y largo craneal
- Diagnóstico de braquicefalia y dolicocefalia
- Clasificación según severidad

### 3. **Desarrollo Psicomotor**
- Hitos del desarrollo por edades (2 meses a 5 años)
- Desarrollo motor grueso, fino, lenguaje y social
- Referencia rápida para evaluación pediátrica

### 4. **Curvas de Crecimiento / IMC**
- Calculadora de Índice de Masa Corporal (IMC)
- Clasificación de peso (bajo peso, normal, sobrepeso, obesidad)
- Datos de peso y talla

### 5. **Calculadora de Dosis de Medicamentos**
- Cálculo de dosis pediátricas según peso
- Medicamentos incluidos:
  - Paracetamol
  - Ibuprofeno
  - Amoxicilina
  - Ácido Valproico
  - Levetiracetam
- Información de frecuencia y dosis máxima

### 6. **Escalas de Evaluación**
- Escala de Glasgow (adulto y pediátrico)
- APGAR
- Escala de Denver II
- Escala de Bayley
- CARS (Childhood Autism Rating Scale)
- M-CHAT-R/F
- Conners (TDAH)

## Requisitos de Compilación

- Android Studio Arctic Fox o superior
- Android SDK 21 o superior (Android 5.0+)
- Gradle 8.0+
- JDK 8 o superior

## Instalación y Compilación

### Opción 1: Usando Android Studio

1. Abre Android Studio
2. Selecciona "Open an Existing Project"
3. Navega a la carpeta `neuropediatoolkit-app`
4. Espera a que Gradle sincronice el proyecto
5. Conecta un dispositivo Android o inicia un emulador
6. Haz clic en "Run" (▶️) o presiona Shift+F10

### Opción 2: Compilación por línea de comandos

```bash
cd neuropediatoolkit-app

# Para compilar el APK de debug
./gradlew assembleDebug

# El APK se generará en:
# app/build/outputs/apk/debug/app-debug.apk

# Para compilar el APK de release (requiere firma)
./gradlew assembleRelease
```

### Opción 3: Usando el script de compilación

```bash
cd neuropediatoolkit-app
chmod +x build-apk.sh
./build-apk.sh
```

## Instalación del APK

Una vez compilado el APK, puedes instalarlo en tu dispositivo:

```bash
# Usando adb (Android Debug Bridge)
adb install app/build/outputs/apk/debug/app-debug.apk
```

O simplemente transfiere el archivo APK a tu dispositivo Android e instálalo desde el administrador de archivos.

## Uso

1. Abre la aplicación NeuropediaToolkit
2. Verás un menú con todas las herramientas disponibles
3. Toca cualquier herramienta para acceder a ella
4. Ingresa los datos solicitados
5. Presiona "Calcular" para obtener los resultados

## Advertencias Importantes

⚠️ **IMPORTANTE**: Esta aplicación es una herramienta de apoyo clínico y educativa. 

- Los cálculos son aproximados y deben ser verificados con tablas oficiales
- NO reemplaza el juicio clínico profesional
- Siempre consulte las guías clínicas actualizadas
- Para prescripción de medicamentos, verifique las dosis con fuentes oficiales
- En caso de duda, consulte con un especialista en neuropediatría

## Estructura del Proyecto

```
neuropediatoolkit-app/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/neuropediatoolkit/
│   │       │   ├── MainActivity.java
│   │       │   ├── PerimetroCefalicaActivity.java
│   │       │   ├── IndiceCefalometricoActivity.java
│   │       │   ├── DesarrolloPsicomotorActivity.java
│   │       │   ├── CurvasCrecimientoActivity.java
│   │       │   ├── CalculadoraDosisMedicamentosActivity.java
│   │       │   └── EscalasEvaluacionActivity.java
│   │       ├── res/
│   │       │   ├── layout/
│   │       │   ├── values/
│   │       │   └── mipmap/
│   │       └── AndroidManifest.xml
│   └── build.gradle
├── build.gradle
├── settings.gradle
└── README.md
```

## Tecnologías Utilizadas

- **Lenguaje**: Java
- **SDK**: Android SDK (minSdk 21, targetSdk 34)
- **UI**: Material Design Components
- **Build System**: Gradle

## Próximas Mejoras

- [ ] Integrar tablas completas de la OMS para percentiles
- [ ] Añadir gráficos de curvas de crecimiento
- [ ] Soporte para múltiples idiomas
- [ ] Modo oscuro
- [ ] Historial de cálculos
- [ ] Exportar resultados a PDF
- [ ] Más escalas de evaluación neurológica
- [ ] Calculadoras de scores (PSOM, NIHSS pediátrico, etc.)

## Licencia

Este proyecto es de código abierto y está disponible para uso educativo y clínico.

## Créditos

Basado en el trabajo de https://neuropediatoolkit.org/

## Contacto y Contribuciones

Para reportar errores, sugerencias o contribuciones, por favor contacta con el equipo de desarrollo.

---

**Versión**: 1.0  
**Última actualización**: 2024
