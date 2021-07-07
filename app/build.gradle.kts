plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdkVersion(30)

    buildFeatures {
        viewBinding = true
    }

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
    // basic android dependencies (task 1)
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.5.20")
    implementation ("androidx.core:core-ktx:1.5.0")
    implementation ("androidx.appcompat:appcompat:1.3.0")
    implementation ("com.google.android.material:material:1.3.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.0.4")

    // tests (task 1)
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")

    // navigation (task 3)
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")

    // toolbar (task 3)
    implementation("androidx.appcompat:appcompat:1.0.0")

    // bitcoindevkit (task 5)
    implementation("org.bitcoindevkit.bdkjni:bdk-jni-debug:0.2.1-dev")

    // qr codes (task 6)
    implementation("androidmads.library.qrgenearator:QRGenearator:1.0.4")
    implementation("com.google.zxing:core:3.4.1")
}
