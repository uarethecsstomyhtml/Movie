
object BuildPlugins {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val ktlintGradlePlugin = "org.jlleitschuh.gradle.ktlint"
    const val navSafeArgsGradlePlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.Jetpack.nav}"

    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"
    const val navSafeArgs = "androidx.navigation.safeargs.kotlin"
    const val project = "com.arman.guessmoviebymusic"
}

object ConfigurationName {
    const val kapt = "kapt"
    const val implementation = "implementation"
    const val debugImplementation = "debugImplementation"
    const val testImplementation = "testImplementation"
    const val androidTestImplementation = "androidTestImplementation"
}

object Tasks {
    const val clean = "clean"
}

object BuildTypes {
    const val debug = "debug"
    const val release = "release"
}

object Dimensions {
    const val anime = "anime"
    const val film = "movie"
}

object ResValue {
    object Type {
        const val string = "string"
    }
    object Name {
        const val appName = "app_name"
    }
}



object ProductFlavors {
    object Free {
        const val name = "free"
        const val dbName = "\"MovieDebug.db\""
        object En {
            const val appName = "Guess Movie by Soundtrack - Test"
            const val appIcon = "@mipmap/ic_launcher"
        }
    }

    object Pro {
        const val name = "pro"
        const val dbName = "Movie.db"
        object En {
            const val appName = "Guess Movie by Soundtrack"
            const val appIcon = "@mipmap/ic_launcher"
        }
    }

    object ManifestPlaceholders {
        const val appIconKey = "appIcon"

        fun appIcon(appIcon: String) = mapOf(appIconKey to appIcon)
    }

    object BuildConfigField {
        object Type {
            const val string = "String"
        }
        object Name {
            const val database = "DATABASE_NAME"
        }
    }

}


object AndroidSdk {
    const val compile = 29
    const val min = 21
    const val target = 29
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Release {
    const val appId = "com.arman.guessmoviebymusic"
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Versions {
    const val gradle = "3.5.2"
    const val androidBuildToolsVersion = "29.0.2"

    const val kotlin = "1.3.50"
    const val ktx = "1.1.0"
    const val multidex = "2.0.1"
    const val ktlint = "0.34.2"
    const val ktlintPlugin = "9.1.0"

    object Jetpack {
        const val nav = "2.1.0"
        const val room = "2.2.1"
    }

    object DI {
        const val koin = "2.0.1"
    }
    object Support {
        const val appCompat = "1.1.0"
        const val constraintLayout = "1.1.3"
        const val material = "1.0.0"
        const val media2 = "1.0.1"
    }

    object Image {
        const val glide = "4.9.0"
    }

    object Logging {
        const val timber = "4.7.1"
    }

    object Network {
        const val retrofit = "2.7.0"
        const val okHttp = "4.2.2"
        const val gson = "2.3.0"
        const val loggingInterceptor = "4.2.1"
    }

    object GooglePlayService {
        const val ads = "18.3.0"
        const val location = "17.0.0"
    }

    object Test {
        const val junit = "4.12"
        const val espresso = "3.1.0"
        const val koin = "2.0.1"
        const val mockito = "3.2.4"
        const val dexMakerVersion = "2.25.1"
        const val archTesting = "2.0.0"
        const val androidXTestExtKotlinRunner = "1.1.0"
        const val androidXTestCore = "1.2.0"
        const val fragment = "1.2.0"
    }
}

object Libraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    const val ktx = "androidx.core:core-ktx:${Versions.ktx}"

    const val multidex = "androidx.multidex:multidex:${Versions.multidex}"

    const val fragment = "androidx.fragment:fragment:${Versions.Test.fragment}"
    const val fragmentTest = "androidx.fragment:fragment-testing:${Versions.Test.fragment}"

    const val livedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"
    const val robolectric = "org.robolectric:robolectric:4.3.1"


    object Jetpack {
        const val navFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.Jetpack.nav}"
        const val archCore = "androidx.arch.core:core-common:${Versions.Jetpack.nav}"
        const val navUi = "androidx.navigation:navigation-ui-ktx:${Versions.Jetpack.nav}"
        const val room = "androidx.room:room-runtime:${Versions.Jetpack.room}"
        const val roomKapt = "androidx.room:room-compiler:${Versions.Jetpack.room}"
        const val roomCoroutines = "androidx.room:room-ktx:${Versions.Jetpack.room}"
    }

    object DI {
        const val koinAndroid = "org.koin:koin-android:${Versions.DI.koin}"
        const val koinScope = "org.koin:koin-androidx-scope:${Versions.DI.koin}"
        const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.DI.koin}"
    }

    object Image {
        const val glide = "com.github.bumptech.glide:glide:${Versions.Image.glide}"
        const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.Image.glide}"
    }

    object Logging {
        const val timber = "com.jakewharton.timber:timber:${Versions.Logging.timber}"
    }

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.Network.retrofit}"
        const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.Network.okHttp}"
        const val gson = "com.squareup.retrofit2:converter-gson:${Versions.Network.gson}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.Network.loggingInterceptor}"
    }

    object GooglePlayService {
        const val ads = "com.google.android.gms:play-services-ads:${Versions.GooglePlayService.ads}"
        const val location = "com.google.android.gms:play-services-location:${Versions.GooglePlayService.location}"
    }

    object Support {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.Support.appCompat}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.Support.constraintLayout}"
        const val material = "com.google.android.material:material:${Versions.Support.material}"
        const val mediaPlayer2 = "androidx.media2:media2-player:${Versions.Support.media2}"
    }

    object Test {
        const val junit = "junit:junit:${Versions.Test.junit}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.Test.espresso}"
        const val koin = "org.koin:koin-test:${Versions.Test.koin}"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.3"
        //  const val archCore = "androidx.arch.core:core-testing:${Versions.Test.archTesting}"
    }

    object AndroidTest {
        const val mockito = "org.mockito:mockito-core:${Versions.Test.mockito}"
        const val dexMakerMockito =
            "com.linkedin.dexmaker:dexmaker-mockito:${Versions.Test.dexMakerVersion}"
        const val espressoContrib =
            "androidx.test.espresso:espresso-contrib:${Versions.Test.espresso}"
        const val jUnitKtx =
            "androidx.test.ext:junit-ktx:${Versions.Test.androidXTestExtKotlinRunner}"
        const val androidXCoreKtx = "androidx.test:core-ktx:${Versions.Test.androidXTestCore}"
    }
}

