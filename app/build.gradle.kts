import com.android.build.gradle.BaseExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.navSafeArgs)
}

configure<BaseExtension> {
    buildToolsVersion(Versions.androidBuildToolsVersion)
    compileSdkVersion(AndroidSdk.compile)

    defaultConfig {
        applicationId = Release.appId
        versionCode = Release.versionCode
        versionName = Release.versionName

        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)

        testInstrumentationRunner = AndroidSdk.testInstrumentationRunner

        javaCompileOptions {
            annotationProcessorOptions {
                includeCompileClasspath = false
            }
        }
        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    android {
        (kotlinOptions as KotlinJvmOptions).apply {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }

    buildTypes {
        getByName(BuildTypes.release) {
            isMinifyEnabled  = false
            consumerProguardFiles("proguard-rules.pro")
        }
    }

    flavorDimensions(Dimensions.film)
    productFlavors {
        register(ProductFlavors.Free.name) {
            setDimension(Dimensions.film)
            resValue(ResValue.Type.string, ResValue.Name.appName, ProductFlavors.Free.En.appName)
            manifestPlaceholders = ProductFlavors.ManifestPlaceholders.appIcon(ProductFlavors.Free.En.appIcon)
            buildConfigField(ProductFlavors.BuildConfigField.Type.string,
                ProductFlavors.BuildConfigField.Name.database, ProductFlavors.Free.dbName)
        }
        register(ProductFlavors.Pro.name) {
            setDimension(Dimensions.film)
            resValue(ResValue.Type.string, ResValue.Name.appName, ProductFlavors.Pro.En.appName)
            manifestPlaceholders = ProductFlavors.ManifestPlaceholders.appIcon(ProductFlavors.Pro.En.appIcon)
            buildConfigField(ProductFlavors.BuildConfigField.Type.string,
                ProductFlavors.BuildConfigField.Name.database, ProductFlavors.Pro.dbName)
        }
    }

    androidExtensions {
        isExperimental = true
    }



    dependencies {
//        configurations {
//            all {
//                exclude(group = "com.google.guava", module = "listenablefuture")
//            }
//        }
        implementation(Libraries.kotlin)
        implementation(Libraries.ktx)

        implementation(Libraries.multidex)

        implementation(Libraries.DI.koinAndroid)
        implementation(Libraries.DI.koinScope)
        implementation(Libraries.DI.koinViewModel)

        implementation(Libraries.Jetpack.navFragment)
        implementation(Libraries.Jetpack.navUi)
        implementation(Libraries.Jetpack.room)
        kapt(Libraries.Jetpack.roomKapt)
        implementation(Libraries.Jetpack.roomCoroutines)

        implementation(Libraries.Image.glide)
        kapt(Libraries.Image.glideCompiler)

        implementation(Libraries.Logging.timber)

        implementation(Libraries.Network.retrofit)
        implementation(Libraries.Network.okHttp)
        implementation(Libraries.Network.gson)
        implementation(Libraries.Network.loggingInterceptor)

        implementation(Libraries.GooglePlayService.ads)
        implementation(Libraries.GooglePlayService.location)

   //     implementation(Libraries.Ads.appodeal)

        implementation(Libraries.Support.appCompat)
        implementation(Libraries.Support.constraintLayout)
        implementation(Libraries.Support.material)
        implementation(Libraries.Support.mediaPlayer2)

        testImplementation(Libraries.Test.espresso)
        testImplementation(Libraries.Test.junit)
        testImplementation(Libraries.Test.koin)
    }
}
