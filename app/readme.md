# toml
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