package com.karenkotlin.jcconductor.room.navigation

sealed class AppScreens(val route: String) {
    object ListaConductoresScreen : AppScreens("lista_screen")
    object FormularioConductorScreen : AppScreens("formulario_screen")
}