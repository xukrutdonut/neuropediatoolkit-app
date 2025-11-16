#!/bin/bash
# Script para generar el keystore de producción

echo "╔═══════════════════════════════════════════════════════════════╗"
echo "║       GENERADOR DE KEYSTORE PARA GOOGLE PLAY STORE           ║"
echo "╚═══════════════════════════════════════════════════════════════╝"
echo ""
echo "Este script creará un keystore para firmar la app de producción."
echo ""
echo "⚠️  IMPORTANTE:"
echo "   - Guarda el archivo .keystore en lugar SEGURO"
echo "   - NUNCA pierdas este archivo ni las contraseñas"
echo "   - Sin ellos NO podrás actualizar la app en Play Store"
echo "   - Haz BACKUP del keystore"
echo ""
read -p "¿Continuar? (s/n): " continuar

if [ "$continuar" != "s" ]; then
    echo "Operación cancelada."
    exit 0
fi

KEYSTORE_PATH="neuropediatoolkit-release.keystore"

echo ""
echo "Generando keystore..."
echo ""

keytool -genkey -v \
    -keystore "$KEYSTORE_PATH" \
    -alias neuropediatoolkit \
    -keyalg RSA \
    -keysize 2048 \
    -validity 10000

if [ $? -eq 0 ]; then
    echo ""
    echo "✅ Keystore generado exitosamente: $KEYSTORE_PATH"
    echo ""
    echo "📝 PRÓXIMOS PASOS:"
    echo ""
    echo "1. Copia keystore.properties.template a keystore.properties"
    echo "   $ cp keystore.properties.template keystore.properties"
    echo ""
    echo "2. Edita keystore.properties con tus datos:"
    echo "   - storeFile: $(pwd)/$KEYSTORE_PATH"
    echo "   - storePassword: La contraseña que acabas de crear"
    echo "   - keyAlias: neuropediatoolkit"
    echo "   - keyPassword: La contraseña de la clave"
    echo ""
    echo "3. En app/build.gradle, descomenta las líneas de signingConfig"
    echo ""
    echo "4. Compila el APK/AAB de producción:"
    echo "   $ ./gradlew bundleRelease     # Para AAB (recomendado)"
    echo "   $ ./gradlew assembleRelease   # Para APK"
    echo ""
    echo "⚠️  GUARDA EL KEYSTORE EN LUGAR SEGURO (haz backup!)"
    echo ""
else
    echo "❌ Error al generar keystore"
    exit 1
fi
