plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "com.dica.bookcatalog"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.dica.bookcatalog"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    // Если используешь Kotlin Compiler Extension для Compose, его версия должна быть совместима
    // composeOptions {
    //    kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get() // Убедись, что 'composeCompiler' есть в [versions] в libs.versions.toml
    // }
}

dependencies {

    // Core
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    implementation(libs.coil.compose) // Убедись, что 'coil-compose' определен в [libraries] и 'coil' в [versions] в libs.versions.toml

    // Тестирование
    testImplementation(libs.junit) // 'junit' из [libraries]
    androidTestImplementation(libs.androidx.junit) // 'androidx-junit' из [libraries]
    androidTestImplementation(libs.androidx.espresso.core) // 'androidx-espresso-core' из [libraries]
    androidTestImplementation(platform(libs.androidx.compose.bom)) // Используем тот же BOM
    androidTestImplementation(libs.androidx.ui.test.junit4) // 'androidx-ui-test-junit4' из [libraries]

    // Отладка Compose
    debugImplementation(libs.androidx.ui.tooling) // 'androidx-ui-tooling' из [libraries]
    debugImplementation(libs.androidx.ui.test.manifest) // 'androidx-ui-test-manifest' из [libraries]
}
