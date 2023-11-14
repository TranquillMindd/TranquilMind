//classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21"

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-android")
//    id ("androidx.navigation.safeargs.kotlin")
//    id ("com.google.gms.google-services")
//    id ("kotlin-android-extensions")
}

android {
    namespace = "com.example.tranquilmind"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.tranquilmind"
        minSdk = 23
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    //classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.5")
   // apply plugin: 'com.google.gms.google-services'
//    implementation ("com.google.firebase:firebase-database-ktx:20.0.2")
    //apply plugin : "kotlin-android"
    //apply plugin : "kotlin-android-extensions"
    //classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
    //classpath ("com.android.tools.build:gradle:4.1.0")
    implementation ("com.google.android.gms:play-services-auth:20.3.0")
    var nav_version = ("2.3.5")
    implementation ("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation ("androidx.navigation:navigation-ui-ktx:$nav_version")

    var lottieVersion = "4.2.0"
    implementation ("com.airbnb.android:lottie:$lottieVersion")
    implementation ("androidx.core:core-ktx:1.3.2")
    implementation ("androidx.appcompat:appcompat:1.2.0")
    implementation ("com.google.android.material:material:1.3.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation ("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation ("androidx.navigation:navigation-ui-ktx:2.3.5")
    testImplementation ("junit:junit:4.+")
    androidTestImplementation ("androidx.test.ext:junit:1.1.2")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.3.0")
//    implementation ("com.google.firebase:firebase-auth-ktx:21.0.1")
    implementation ("com.squareup.picasso:picasso:2.71828")
    implementation(platform("com.google.firebase:firebase-bom:28.2.1"))
    implementation ("com.android.support:multidex:1.0.3")
//
//    implementation ("com.google.firebase:firebase-storage:16.0.1")
//    implementation ("com.google.firebase:firebase-database:16.0.1")
//    implementation ("com.google.firebase:firebase-core:16.0.0")
//    implementation ("com.google.firebase:firebase-auth:16.0.2")
    implementation ("com.xwray:groupie:2.1.0")
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    implementation ("androidx.recyclerview:recyclerview:1.0.0")
}