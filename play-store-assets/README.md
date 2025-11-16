# Assets para Google Play Store

Este directorio contiene todos los assets necesarios para publicar la app en Google Play Store.

## 📁 Estructura

```
play-store-assets/
├── graphics/
│   ├── icon-512x512.png          ✅ CREADO (Ícono de alta resolución)
│   └── feature-graphic-1024x500.png  ✅ CREADO (Gráfico de características)
├── screenshots/
│   └── (Agrega tus capturas de pantalla aquí)
└── texts/
    └── TEXTOS_PLAY_STORE.md      ✅ CREADO (Todos los textos)
```

## ✅ Assets Completados

### 1. Ícono de alta resolución (512x512)
**Archivo:** `graphics/icon-512x512.png`
- ✅ Tamaño correcto: 512x512 px
- ✅ Formato: PNG 32-bit
- ✅ Listo para usar

### 2. Gráfico de características (1024x500)
**Archivo:** `graphics/feature-graphic-1024x500.png`
- ✅ Tamaño correcto: 1024x500 px
- ✅ Formato: PNG
- ✅ Fondo azul con logo centrado
- ✅ Listo para usar

### 3. Textos
**Archivo:** `texts/TEXTOS_PLAY_STORE.md`
- ✅ Título
- ✅ Descripción corta
- ✅ Descripción completa
- ✅ Notas de versión
- ✅ Palabras clave
- ✅ Todos los textos listos para copiar/pegar

## ⚠️ Pendiente: Capturas de Pantalla

Necesitas crear **mínimo 2 capturas de pantalla** de la app funcionando.

### Cómo crear capturas:

#### Opción A: En tu dispositivo Android
1. Instala la app en tu móvil
2. Abre la app
3. Toma screenshots (botón power + volumen abajo)
4. Transfiere las imágenes a tu PC
5. Guárdalas en `screenshots/`

#### Opción B: Emulador Android Studio
1. Abre Android Studio
2. Inicia un emulador
3. Instala la app: `adb install app/build/outputs/apk/debug/app-debug.apk`
4. Abre la app
5. Usa la cámara del emulador para capturar

### Requisitos de capturas:

- **Cantidad:** Mínimo 2, máximo 8
- **Tamaño:** Entre 320px y 3840px en el lado más largo
- **Proporción:** 16:9 o 9:16 (vertical u horizontal)
- **Formato:** JPG o PNG de 24-bit
- **Sin canal alfa** (sin transparencia)

### Sugerencias de capturas:

1. **Pantalla principal** con el logo y las primeras herramientas
2. **Sección "Escalas y calculadoras"** completa
3. **Sección "Genética"** o cualquier otra categoría
4. **Una herramienta abierta** en el navegador (opcional)

### Nombres sugeridos:

```
screenshots/
├── 01-main-screen.png         (Pantalla principal)
├── 02-escalas-calculadoras.png (Sección escalas)
├── 03-genetica.png            (Sección genética)
└── 04-neurologia.png          (Sección neurología)
```

## 📋 Checklist de Assets

Antes de subir a Play Store:

- [x] Ícono 512x512 ✅
- [x] Gráfico 1024x500 ✅
- [x] Textos completos ✅
- [ ] Mínimo 2 capturas de pantalla ⚠️ PENDIENTE
- [x] Política de privacidad (PRIVACY_POLICY.md) ✅

## 🎨 Personalización

Si quieres personalizar el gráfico de características:

```python
# Edita play-store-assets/graphics/feature-graphic-1024x500.png
# Puedes usar GIMP, Photoshop, o cualquier editor de imágenes
# Mantén el tamaño: 1024x500 px
```

## 📤 Cómo usar estos assets en Play Console

1. **Ícono:**
   - Play Console → Ficha de Play Store → "Ícono de la aplicación"
   - Sube `graphics/icon-512x512.png`

2. **Gráfico de características:**
   - Play Console → Ficha de Play Store → "Gráfico de características"
   - Sube `graphics/feature-graphic-1024x500.png`

3. **Capturas:**
   - Play Console → Ficha de Play Store → "Capturas de pantalla de teléfono"
   - Sube todas las capturas de `screenshots/`

4. **Textos:**
   - Abre `texts/TEXTOS_PLAY_STORE.md`
   - Copia y pega cada texto en el campo correspondiente

## ✨ Todo listo excepto...

Solo falta que **tomes las capturas de pantalla** de la app funcionando en tu dispositivo.

Una vez tengas las capturas, ¡estarás listo para publicar en Play Store!
