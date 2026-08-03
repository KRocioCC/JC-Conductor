package com.karenkotlin.jcconductor.room.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.karenkotlin.jcconductor.room.entity.Conductor
import com.karenkotlin.jcconductor.room.navigation.AppScreens
import com.karenkotlin.jcconductor.room.viewmodel.ConductorViewModel
import com.karenkotlin.jcconductor.ui.theme.JCConductorTheme

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ListaConductoresPreview(){
    JCConductorTheme{
        ListaConductoresScreen(
            navController = rememberNavController()
        )
    }
}

@Composable
fun ListaConductoresScreen(
    navController: NavController,
    viewModel: ConductorViewModel = viewModel()
){
    Scaffold{ innerPadding ->
        ListaConductoresContent(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            viewModel = viewModel
        )
    }
}

@Composable
fun ListaConductoresContent(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: ConductorViewModel
){
    val conductores by viewModel.conductores.collectAsState(
        initial = emptyList()
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(26.dp)
            .background(Color.Cyan)
    ){

        Text(
            text = "Lista de Conductores",
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn(
            modifier = Modifier.weight(1f)
        ){
            items(conductores){ conductor ->
                ConductorCard(
                    conductor = conductor,
                    onDelete = {
                        viewModel.deleteConductor(conductor)
                    },
                    onEdit = {
                    }
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){

            Button(
                onClick = {}
            ){
                Text("Salir")
            }

            Button(
                onClick = {
                    navController.navigate(
                        AppScreens.FormularioConductorScreen.route
                    )
                }
            ){
                Text("Añadir")
            }

        }
    }
}

@Composable
fun ConductorCard(
    conductor: Conductor,
    onDelete: () -> Unit,
    onEdit: () -> Unit
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ){
        Column(
            modifier = Modifier.padding(16.dp)
        ){
            Text(
                text = conductor.nombre,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "CI: ${conductor.ci}"
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ){

                Button(
                    onClick = onEdit
                ){
                    Text("Editar")
                }

                Button(
                    onClick = onDelete
                ){
                    Text("Eliminar")
                }

            }
        }
    }
}