import com.ptut.drinkwiz.DrinkWizBuildType

plugins {
    id("drinkwiz.android.application")
    id("drinkwiz.android.application.flavors")
    id("drinkwiz.android.application.compose")
    id("drinkwiz.android.hilt")
}

android {
    namespace = libs.versions.nameSpace.get()

    defaultConfig {
        applicationId = libs.versions.nameSpace.get()
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = DrinkWizBuildType.DEBUG.applicationIdSuffix
        }
        release {
            applicationIdSuffix = DrinkWizBuildType.RELEASE.applicationIdSuffix
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

fun String.toVersionCode(): Int {
    val version = this.split(".")
    return version[0].toInt() * 10000 + version[1].toInt() * 100 + version[2].toInt()
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}