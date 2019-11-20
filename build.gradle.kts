

buildscript {
    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath(BuildPlugins.androidGradlePlugin)
        classpath(BuildPlugins.kotlinGradlePlugin)
        classpath(BuildPlugins.navSafeArgsGradlePlugin)
    }
}



allprojects {
    repositories {
        google()
        jcenter()
        maven {
            setUrl("https://artifactory.appodeal.com/appodeal")
        }
    }
}

tasks.register(Tasks.clean, Delete::class) {
    delete(rootProject.buildDir)
}


