plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdkVersion(30)

    defaultConfig {
        applicationId = "org.summerofbitcoin.wallet"
        minSdkVersion(23)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "v0.1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            debuggable(true)
        }
        getByName("release") {
            debuggable(false)
            // minifyEnabled(false)
            // shrinkResources(true)
            proguardFiles = mutableListOf(getDefaultProguardFile("proguard-android-optimize.txt"), file("proguard-rules.pro"))
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // basic android dependencies
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.5.20")
    implementation ("androidx.core:core-ktx:1.5.0")
    implementation ("androidx.appcompat:appcompat:1.3.0")
    implementation ("com.google.android.material:material:1.3.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.0.4")

    // tests
    testImplementation ("junit:junit:4.+")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
}