package com.karenkotlin.jcconductor.room.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.karenkotlin.jcconductor.room.screen.FormularioConductorScreen
import com.karenkotlin.jcconductor.room.screen.ListaConductoresScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.ListaConductoresScreen.route
    ){
        composable(route = AppScreens.ListaConductoresScreen.route){
            ListaConductoresScreen(
                navController = navController
            )
        }
        composable(route = AppScreens.FormularioConductorScreen.route){
            FormularioConductorScreen(
                navController = navController
            )
        }
    }
}