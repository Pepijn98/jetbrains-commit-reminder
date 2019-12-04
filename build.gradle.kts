plugins {
    java
    id("org.jetbrains.intellij") version "0.4.14"
    kotlin("jvm") version "1.3.61"
}

group = "info.kurozeropb"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.github.kurozeropb:CoroutineTimer:1.0.0")
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version = "2019.3"
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    patchPluginXml {
        changeNotes("""
      Add change notes here.<br>
      <em>most HTML tags may be used</em>""")
    }
}