# ====== KEEP KODE APLIKASI ======
# Jaga semua class di package kamu agar tidak dihapus/obfuscate
-keep class com.jempol.pamkelompok.** { *; }

# Pertahankan semua activity (terutama yang disebut di AndroidManifest)
-keep public class * extends android.app.Activity
-keep public class * extends androidx.appcompat.app.AppCompatActivity

# Jaga semua resource ID (R.id, R.layout, dll)
-keepclassmembers class **.R$* {
    public static <fields>;
}

# ====== LIBRARY GOOGLE PLAY & MAPS ======
# Untuk Google Play Services, Maps, Places, Location
-keep class com.google.android.gms.** { *; }
-dontwarn com.google.android.gms.**

# ====== FIREBASE AUTH ======
-keep class com.google.firebase.** { *; }
-dontwarn com.google.firebase.**

# ====== ANDROIDX / JETPACK ======
# Jaga semua class AndroidX penting
-keep class androidx.lifecycle.** { *; }
-keep class androidx.navigation.** { *; }
-keep class androidx.constraintlayout.** { *; }
-keep class androidx.appcompat.** { *; }
-keep class androidx.fragment.app.** { *; }

# View Binding / Data Binding
-keep class **.databinding.*Binding { *; }
-keep class **.viewbinding.* { *; }

# ====== LAINNYA UNTUK REFLECTION / XML ======
# Jaga semua constructor & method yang bisa dipanggil via refleksi
-keepclassmembers class * {
    public <init>(...);
}
-keepclassmembers class * {
    public void *(android.view.View);
}

# Jika kamu pakai anotasi (Lifecycle, Hilt, Firebase, dst)
-keepattributes *Annotation*

# Optional: jaga source file & line number info (debugging)
#-keepattributes SourceFile,LineNumberTable
