# toml
agp = "8.5.2"
kotlin = "1.9.0"
coreKtx = "1.15.0"
junit = "4.13.2"
junitVersion = "1.2.1"
espressoCore = "3.6.1"
lifecycleRuntimeKtx = "2.8.7"
activityCompose = "1.10.0"
composeBom = "2024.04.01"

roomRuntime = "2.6.1"
ksp = "1.9.0-1.0.13"
navigationCompose = "2.7.7"

# [libraries]
androidx-room-runtime = { group = "androidx.room", name = "room-runtime", version.ref = "roomRuntime" }
androidx-room-ktx = { group = "androidx.room", name = "room-ktx", version.ref = "roomRuntime" }
androidx-room-compiler = { group = "androidx.room", name = "room-compiler", version.ref = "roomRuntime" }

androidx-navigation-compose = { group = "androidx.navigation", name = "navigation-compose", version.ref = "navigationCompose" }

# plugins
kotlin-ksp = { id = "com.google.devtools.ksp", version.ref = "ksp" }



# build.gradle.kts
# plugins
alias(libs.plugins.kotlin.ksp)

# dependencies

implementation(libs.androidx.room.runtime)
implementation(libs.androidx.room.ktx)
ksp(libs.androidx.room.compiler)

implementation(libs.androidx.navigation.compose)