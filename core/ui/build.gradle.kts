plugins {
    alias(libs.plugins.drinkwiz.android.library)
    alias(libs.plugins.drinkwiz.compose)
}

android {
    namespace = "${libs.versions.nameSpace}.core.ui"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}