plugins {
    `kotlin-dsl`
}

group = "${libs.versions.nameSpace}.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.tools.build.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    /**
     * Register convention plugins so they are available in the build scripts of the application
     */
    plugins {
        register("drinkwizAndroidApplication") {
            id = "drinkwiz.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("drinkwizAndroidLibrary") {
            id = "drinkwiz.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("drinkwizAndroidTest") {
            id = "drinkwiz.android.test"
            implementationClass = "AndroidTestConventionPlugin"
        }
        register("drinkwizCompose") {
            id = "drinkwiz.compose"
            implementationClass = "ComposeConventionPlugin"
        }
        register("drinkwizDynamic") {
            id = "drinkwiz.dynamic"
            implementationClass = "DynamicFeatureConventionPlugin"
        }
        register("drinkwizFlavors") {
            id = "drinkwiz.android.application.flavors"
            implementationClass = "AndroidApplicationFlavorsConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "drinkwiz.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "drinkwiz.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidHilt") {
            id = "drinkwiz.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
    }
}