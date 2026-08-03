package com.karenkotlin.jcconductor.room.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.karenkotlin.jcconductor.room.RoomApp
import com.karenkotlin.jcconductor.room.entity.Conductor
import com.karenkotlin.jcconductor.room.navigation.AppScreens
import com.karenkotlin.jcconductor.ui.theme.JCConductorTheme
import kotlinx.coroutines.launch
import com.karenkotlin.jcconductor.room.dao.ConductorDao
import androidx.lifecycle.viewmodel.compose.viewModel
import com.karenkotlin.jcconductor.room.viewmodel.ConductorViewModel

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FormularioConductorPreview() {
    JCConductorTheme {
        FormularioConductorScreen(
            navController = rememberNavController(),
            viewModel = ConductorViewModel()
        )
    }
}

@Composable
fun FormularioConductorScreen(
    navController: NavController,
    viewModel: ConductorViewModel = viewModel()
) {
    Scaffold { innerPadding ->
        FormularioConductorContent(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            viewModel = viewModel
        )
    }
}

@Composable
fun FormularioConductorContent(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: ConductorViewModel


) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(26.dp)
            .background(Color.White)
    ) {
        var nameValue by remember { mutableStateOf("") }
        var ciValue by remember { mutableStateOf("") }

        val scope = rememberCoroutineScope()
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
                    .background(Color.White)
            ) {
                Text(
                    text = "Registro de Usuario"
                )
                Text(
                    text = "Nombre:",
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                )

                OutlinedTextField(
                    value = nameValue,
                    onValueChange = {
                        nameValue = it
                    },
                    label = {
                        Text("Nombre")
                    }
                )
                Spacer(modifier = Modifier.padding(top = 20.dp))
                Text(
                    text = "CI:",
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                )

                OutlinedTextField(
                    value = ciValue,
                    onValueChange = {
                        ciValue = it
                    },
                    label = {
                        Text("Nombre")
                    }
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.End
                ){
                    Spacer(modifier = Modifier.padding(top = 20.dp))
                    Button(
                        onClick = {

                            val conductor = Conductor(
                                nombre = nameValue,
                                ci = ciValue
                            )

                            viewModel.addConductor(conductor)

                            navController.navigate(
                                AppScreens.ListaConductoresScreen.route
                            )

                        }
                    ){
                        Text("Registrar")
                    }
                    Button(
                        onClick = {
                            navController.navigate(
                                AppScreens.ListaConductoresScreen.route
                            )
                        }
                    ){
                        Text(
                            text = "Volver"
                        )
                    }
                }
            }
        }
    }
}