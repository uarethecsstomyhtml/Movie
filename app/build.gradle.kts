import com.android.build.gradle.BaseExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.navSafeArgs)
    id(BuildPlugins.project)
}

configure<BaseExtension> {

    android {
        (kotlinOptions as KotlinJvmOptions).apply {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }

    androidExtensions {
        isExperimental = true
    }

    dependencies {
        implementation(project(":movies"))
        implementation(project(":shop"))
        implementation(project(":hints"))
        implementation(project(":network"))
        implementation(project(":coins"))
        implementation(project(":sound-components"))

        androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.2.1")
        debugImplementation("androidx.test:rules:1.2.0")
        androidTestImplementation("org.robolectric:annotations:4.3.1")
    }
}
