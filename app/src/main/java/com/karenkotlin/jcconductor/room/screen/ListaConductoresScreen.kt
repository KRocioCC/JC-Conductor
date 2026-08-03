package com.karenkotlin.jcconductor.room.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.karenkotlin.jcconductor.room.entity.Conductor
import com.karenkotlin.jcconductor.room.navigation.AppScreens
import com.karenkotlin.jcconductor.ui.theme.JCConductorTheme

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ListaConductoresPreview(){
    JCConductorTheme     {
        ListaConductoresScreen(
            navController = rememberNavController()
        )
    }
}

@Composable
fun ListaConductoresScreen(
    navController: NavController
){
    Scaffold { innerPadding ->
        ListaConductoresContent(
            modifier = Modifier.padding(innerPadding),
            navController = navController

        )
    }
}

@Composable
fun ListaConductoresContent(
    modifier: Modifier = Modifier,
    navController: NavController


){
    var conductores by remember {
        mutableStateOf(emptyList<Conductor>())
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(26.dp)
            .background(Color.Cyan)
    ){
        //1
        Text(
            text = "Lista de Conductores",
            Modifier.padding(top = 16.dp, start = 16.dp)
        )
        LazyColumn(
            modifier = Modifier
                .weight(1f)
        ){
            items(conductores){
                    conductor ->
                ConductorCard(
                    nombre = conductor.nombre,
                    ci = conductor.ci
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
                Text(
                    text = "Salir"
                )
            }
            Button(
                onClick = {
                    navController.navigate(
                        AppScreens.FormularioConductorScreen.route
                    )
                }
            ){
                Text(
                    text = "Añadir"
                )
            }
        }
    }
}
@Composable
fun ConductorCard(
    nombre: String,
    ci: String
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
                text = nombre,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "CI: $ci"
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ){

                Button(
                    onClick = {}
                ){
                    Text("Editar")
                }

                Button(
                    onClick = {}
                ){
                    Text("Eliminar")
                }

            }
        }
    }
}