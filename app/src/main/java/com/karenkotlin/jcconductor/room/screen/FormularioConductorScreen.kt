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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.karenkotlin.jcconductor.ui.theme.JCConductorTheme

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FormularioConductorPreview() {
    JCConductorTheme {
        FormularioConductorScreen()
    }
}

@Composable
fun FormularioConductorScreen() {
    Scaffold { innerPadding ->
        FormularioConductorContent(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun FormularioConductorContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(26.dp)
            .background(Color.White)
    ) {
        var nameValue by remember { mutableStateOf("") }
        var ciValue by remember { mutableStateOf("") }
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
                    Button(
                        onClick = { }
                    ){
                        Text(
                            text = "Registrar"
                        )
                    }
                    Button(
                        onClick = { }
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