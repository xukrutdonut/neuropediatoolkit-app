# NeuropediaToolkit Android App

<p align="center">
  <img src="app/src/main/res/drawable/logo_neuropediatoolkit.png" alt="NeuropediaToolkit Logo" width="150"/>
</p>

<p align="center">
  <strong>Herramientas para la consulta neuropediátrica</strong>
</p>

<p align="center">
  <a href="https://neuropediatoolkit.org">Sitio Web Oficial</a> •
  <a href="#-descargar-apk">Descargar APK</a> •
  <a href="#-instalación">Instalación</a> •
  <a href="#-características">Características</a>
</p>

---

## 📱 Descripción

Aplicación Android que replica fielmente el sitio web [neuropediatoolkit.org](https://neuropediatoolkit.org), proporcionando acceso rápido a 28 herramientas esenciales para la consulta neuropediátrica.

La app está organizada en 8 secciones temáticas con imágenes originales del sitio web y diseño basado en el tema Twenty Nineteen de WordPress.

## 🎯 Características

✅ **28 herramientas** con enlaces directos al sitio web  
✅ **Organización por secciones** igual que el sitio original  
✅ **Imágenes/iconos** de cada herramienta descargados del sitio  
✅ **Logo oficial** de Neuropediatoolkit  
✅ **Diseño Twenty Nineteen** con colores del sitio web (#0073a8)  
✅ **Grid responsive** de 2 columnas  
✅ **Offline-ready** (la app funciona sin internet, pero los enlaces requieren conexión)  

## 📋 Herramientas Incluidas

### 📊 Escalas y calculadoras (7)
- Aplicación nutricional
- NIHSS-Ped
- PedCom
- Índice cefalométrico y braquicefálico
- Método de Weaver
- Test de Haizea-Llevant
- Calculadora de puntuaciones normalizadas

### 📱 Aplicaciones móviles (2)
- Normscales
- Smart Optometry

### 🧬 Genética (5)
- Phenomyzer
- Decipher
- Rarechromo
- Varsome
- Gene Reviews

### 👤 Dismorfología (4)
- Elements of morphology
- The atlas of syndromic morphology
- Atlas of human morphology
- Human phenotypes

### 🧠 Enfermedades neurológicas (5)
- Learning EEG
- Neuromuscular diseases
- Epilepsy Diagnosis
- Movement Disorder Genes
- Neurochecklists

### 🧪 Metabólicas (2)
- Vademecum Metabolicum
- Treatable ID

### 🔬 Neurorradiología (2)
- MRI of the Neonatal Brain
- Radiopaedia

### 💊 Manejo terapéutico (1)
- Treatabolome

## 📥 Descargar APK

**Última versión:** v3.0.0  
**Tamaño:** 8.7 MB  
**Compatible:** Android 5.0 (API 21) o superior

### Descarga directa:
👉 [**app-debug.apk**](app/build/outputs/apk/debug/app-debug.apk) ⬇️

O navega a: `app/build/outputs/apk/debug/app-debug.apk`

## 🚀 Instalación

### Método 1: Descarga directa en móvil
1. Descarga el archivo `app-debug.apk` desde este repositorio
2. Abre el archivo APK en tu dispositivo Android
3. Si es necesario, permite instalación de "Orígenes desconocidos"
4. Instala la aplicación

### Método 2: Instalación por ADB (Cable USB)
```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

### Método 3: Compilar desde código fuente
```bash
git clone https://github.com/TU_USUARIO/neuropediatoolkit-app.git
cd neuropediatoolkit-app
./gradlew assembleDebug
```

## 🛠️ Requisitos

- **Android:** 5.0 (Lollipop, API 21) o superior
- **Conexión a Internet:** Necesaria para acceder a las herramientas web
- **Permisos:** INTERNET

## 📸 Capturas de Pantalla

```
┌─────────────────────────┐
│    🔨 [Logo]            │
│  NeuropediaToolkit      │
│  Herramientas para...   │
├─────────────────────────┤
│ Escalas y calculadoras  │
│ ┌────┐ ┌────┐          │
│ │IMG │ │IMG │          │
│ │Nutr│ │NIHSS│          │
│ └────┘ └────┘          │
│ ... más herramientas    │
└─────────────────────────┘
```

## 🎨 Diseño y Estilo

- **Colores:** Tema Twenty Nineteen de WordPress
  - Primary: `#0073a8`
  - Texto: `#111111`
  - Texto secundario: `#767676`
- **Tipografía:** Sans-serif
- **Layout:** Grid de 2 columnas con CardView
- **Imágenes:** 80x80dp por herramienta

## 🔧 Tecnologías

- **Lenguaje:** Java
- **SDK:** Android API 21-34
- **Componentes:** RecyclerView, CardView, Material Design
- **Build:** Gradle 8.9

## 📂 Estructura del Proyecto

```
neuropediatoolkit-app/
├── app/
│   ├── src/main/
│   │   ├── java/com/neuropediatoolkit/
│   │   │   └── MainActivity.java
│   │   ├── res/
│   │   │   ├── drawable/
│   │   │   │   ├── logo_neuropediatoolkit.png
│   │   │   │   └── tool_*.png (28 imágenes)
│   │   │   ├── layout/
│   │   │   │   ├── activity_main.xml
│   │   │   │   └── item_tool.xml
│   │   │   └── values/
│   │   │       ├── colors.xml
│   │   │       ├── strings.xml
│   │   │       └── styles.xml
│   │   └── AndroidManifest.xml
│   └── build.gradle
├── build.gradle
├── settings.gradle
└── README.md
```

## 📝 Changelog

### v3.0.0 (2024-11-16)
- ✅ Descargadas 28 imágenes + logo del sitio web original
- ✅ Organización por 8 secciones temáticas
- ✅ Diseño Twenty Nineteen (#0073a8)
- ✅ Header con logo de Neuropediatoolkit
- ✅ Mejoras visuales en tarjetas

### v2.0.0
- Grid de 2 columnas con CardView
- 28 herramientas con enlaces web

### v1.0.0
- Versión inicial con calculadoras locales

## 🤝 Contribuir

Las contribuciones son bienvenidas. Para cambios importantes:

1. Fork este repositorio
2. Crea una rama para tu feature (`git checkout -b feature/NuevaHerramienta`)
3. Commit tus cambios (`git commit -am 'Agrega nueva herramienta'`)
4. Push a la rama (`git push origin feature/NuevaHerramienta`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto está basado en el sitio web [neuropediatoolkit.org](https://neuropediatoolkit.org) y es de uso educativo y clínico.

## 🔗 Enlaces

- **Sitio web oficial:** https://neuropediatoolkit.org
- **Documentación completa:** [CAMBIOS_v3.md](CAMBIOS_v3.md)
- **Guía de instalación:** [INSTALL.md](INSTALL.md)

## 👨‍⚕️ Créditos

Basado en el sitio web **Neuropediatoolkit** desarrollado para profesionales de neuropediatría.

---

<p align="center">
  Made with ❤️ for Neuropediatric Healthcare Professionals
</p>

<p align="center">
  <sub>Compatible con Android 5.0+</sub>
</p>
