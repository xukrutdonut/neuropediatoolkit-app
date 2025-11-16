# 🚀 Inicio Rápido - NeuropediaToolkit

## ¿Qué es esto?

Una aplicación Android completa con **6 herramientas neuropediátricas** listas para usar:
- 📏 Perímetro Cefálico
- 🧠 Índice Cefalométrico
- 👶 Desarrollo Psicomotor
- 📊 Curvas de Crecimiento / IMC
- 💊 Calculadora de Dosis
- 📋 Escalas de Evaluación

## ⚡ Compilar el APK en 2 pasos

```bash
# 1. Entrar a la carpeta
cd neuropediatoolkit-app

# 2. Ejecutar el script
./build-apk.sh
```

✅ El APK estará en: `app/build/outputs/apk/debug/app-debug.apk`

## 📱 Instalar en tu móvil

### Opción A: Con cable USB
```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

### Opción B: Sin cable
1. Copia el APK a tu teléfono
2. Ábrelo desde tus archivos
3. Activa "Instalar apps desconocidas" si te lo pide
4. ¡Listo!

## 📚 Documentación Completa

- **README.md** - Información general del proyecto
- **INSTALL.md** - Guía detallada de instalación y uso
- **RESUMEN.md** - Detalles técnicos completos

## ⚙️ Requisitos

- **Para compilar**: Android Studio o Java JDK 8+
- **Para instalar**: Android 5.0 o superior (cualquier móvil reciente)

## 🆘 Problemas Comunes

**"No tengo Android Studio"**
```bash
# Instala solo Java (más ligero)
# Luego ejecuta build-apk.sh
```

**"El script no funciona"**
```bash
chmod +x build-apk.sh
./gradlew assembleDebug
```

**"No puedo instalar el APK"**
- Ve a Ajustes → Seguridad → Activa "Orígenes desconocidos"

## ✨ ¡Eso es todo!

El proyecto está **100% completo y funcional**.

Cualquier duda, revisa **INSTALL.md** para más detalles.

---
**Creado para neuropediatras** 🩺👨‍⚕️👩‍⚕️
