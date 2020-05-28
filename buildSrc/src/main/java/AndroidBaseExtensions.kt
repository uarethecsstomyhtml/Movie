import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType


open class MoviePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.configureAndroid()
        project.configureDependencies()
    }
}

internal fun Project.configureAndroid() = this.extensions.getByType<BaseExtension>().run {
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

    useLibrary("android.test.runner")
    useLibrary("android.test.base")
    useLibrary("android.test.mock")

    buildTypes {
        getByName(BuildTypes.release) {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

        getByName(BuildTypes.debug) {
            isTestCoverageEnabled = true
        }
    }

    flavorDimensions(Dimensions.film)
    productFlavors {
        register(ProductFlavors.Free.name) {
            dimension = Dimensions.film
            resValue(ResValue.Type.string, ResValue.Name.appName, ProductFlavors.Free.En.appName)
            manifestPlaceholders =
                ProductFlavors.ManifestPlaceholders.appIcon(ProductFlavors.Free.En.appIcon)
            buildConfigField(
                ProductFlavors.BuildConfigField.Type.string,
                ProductFlavors.BuildConfigField.Name.database, ProductFlavors.Free.dbName
            )
        }
        register(ProductFlavors.Pro.name) {
            dimension = Dimensions.film
            resValue(ResValue.Type.string, ResValue.Name.appName, ProductFlavors.Pro.En.appName)
            manifestPlaceholders =
                ProductFlavors.ManifestPlaceholders.appIcon(ProductFlavors.Pro.En.appIcon)
            buildConfigField(
                ProductFlavors.BuildConfigField.Type.string,
                ProductFlavors.BuildConfigField.Name.database, ProductFlavors.Pro.dbName
            )
        }
    }

//    packagingOptions {
//        (this as KotlinJvmOptions).apply {
//            jvmTarget = JavaVersion.VERSION_1_8.toString()
//        }
//
//    }
//

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

internal fun Project.configureDependencies() = dependencies {
    add(ConfigurationName.implementation, Libraries.kotlin)
    add(ConfigurationName.implementation, Libraries.ktx)
    add(ConfigurationName.implementation, Libraries.multidex)

    add(ConfigurationName.implementation, Libraries.DI.koinAndroid)
    add(ConfigurationName.implementation, Libraries.DI.koinScope)
    add(ConfigurationName.implementation, Libraries.DI.koinViewModel)

    add(ConfigurationName.implementation, Libraries.Jetpack.navFragment)
    add(ConfigurationName.implementation, Libraries.Jetpack.archCore)
    add(ConfigurationName.implementation, Libraries.Jetpack.navUi)
    add(ConfigurationName.implementation, Libraries.Jetpack.room)
    add(ConfigurationName.kapt, Libraries.Jetpack.roomKapt)

    add(ConfigurationName.implementation, Libraries.Jetpack.roomCoroutines)

    add(ConfigurationName.implementation, Libraries.Image.glide)
    add(ConfigurationName.kapt, Libraries.Image.glideCompiler)

    add(ConfigurationName.implementation, Libraries.Logging.timber)

    add(ConfigurationName.implementation, Libraries.Network.retrofit)
    add(ConfigurationName.implementation, Libraries.Network.okHttp)
    add(ConfigurationName.implementation, Libraries.Network.gson)
    add(ConfigurationName.implementation, Libraries.Network.loggingInterceptor)

    add(ConfigurationName.implementation, Libraries.GooglePlayService.ads)
    add(ConfigurationName.implementation, Libraries.GooglePlayService.location)

    add(ConfigurationName.implementation, Libraries.Support.appCompat)
    add(ConfigurationName.implementation, Libraries.Support.constraintLayout)
    add(ConfigurationName.implementation, Libraries.Support.material)
    add(ConfigurationName.implementation, Libraries.Support.mediaPlayer2)
    add(ConfigurationName.implementation, Libraries.livedataKtx)

    add(ConfigurationName.androidTestImplementation, Libraries.Test.espresso)
    add(ConfigurationName.testImplementation, Libraries.Test.junit)
    add(ConfigurationName.testImplementation, Libraries.robolectric)
    add(ConfigurationName.testImplementation, Libraries.Test.koin)
    add(ConfigurationName.testImplementation, Libraries.Test.coroutines)

//    add(ConfigurationName.implementation , Libraries.fragment)
    add(ConfigurationName.debugImplementation, Libraries.fragmentTest)

//    add(ConfigurationName.debugImplementation, Libraries.Test.archCore)
    add(ConfigurationName.androidTestImplementation, Libraries.AndroidTest.mockito)
    add(ConfigurationName.testImplementation, Libraries.AndroidTest.mockito)
    add(ConfigurationName.androidTestImplementation, Libraries.AndroidTest.dexMakerMockito)
    add(ConfigurationName.androidTestImplementation, Libraries.AndroidTest.espressoContrib)
    //  add(ConfigurationName.androidTestImplementation, Libraries.AndroidTest.jUnit)
    add(ConfigurationName.androidTestImplementation, Libraries.AndroidTest.jUnitKtx)
    add(ConfigurationName.testImplementation, Libraries.AndroidTest.jUnitKtx)
    // add(ConfigurationName.debugImplementation, Libraries.AndroidTest.androidXCore)
    // add(ConfigurationName.debugImplementation, Libraries.AndroidTest.androidXCoreKtx)
}

