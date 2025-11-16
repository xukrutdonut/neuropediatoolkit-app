#!/bin/bash

echo "======================================"
echo "NeuropediaToolkit - Build Script"
echo "======================================"
echo ""

# Check if Java is installed
if ! command -v java &> /dev/null
then
    echo "❌ Error: Java no está instalado"
    echo "Por favor instala Java JDK 8 o superior"
    exit 1
fi

echo "✓ Java encontrado: $(java -version 2>&1 | head -n 1)"
echo ""

# Clean previous builds
echo "🧹 Limpiando builds anteriores..."
./gradlew clean

echo ""
echo "🔨 Compilando APK de debug..."
./gradlew assembleDebug

if [ $? -eq 0 ]; then
    echo ""
    echo "======================================"
    echo "✅ ¡Compilación exitosa!"
    echo "======================================"
    echo ""
    echo "El APK se encuentra en:"
    echo "📱 app/build/outputs/apk/debug/app-debug.apk"
    echo ""
    
    if [ -f "app/build/outputs/apk/debug/app-debug.apk" ]; then
        APK_SIZE=$(du -h app/build/outputs/apk/debug/app-debug.apk | cut -f1)
        echo "Tamaño del APK: $APK_SIZE"
        echo ""
        echo "Para instalar en tu dispositivo:"
        echo "  adb install app/build/outputs/apk/debug/app-debug.apk"
        echo ""
        echo "O transfiere el archivo a tu dispositivo Android"
        echo "y ábrelo para instalarlo."
    fi
else
    echo ""
    echo "======================================"
    echo "❌ Error en la compilación"
    echo "======================================"
    echo ""
    echo "Revisa los errores anteriores para más detalles."
    exit 1
fi
