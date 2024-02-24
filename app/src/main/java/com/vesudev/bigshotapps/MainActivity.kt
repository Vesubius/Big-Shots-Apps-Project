package com.vesudev.bigshotapps

import android.content.ClipData.Item
import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vesudev.bigshotapps.ui.theme.BigShotAppsTheme
import androidx.compose.material3.ButtonColors as ButtonColors1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BigShotAppsTheme {
                PreviewMainScreen()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(
        //====================== BARRA SUPERIOR ========================================
        topBar = {

            TopAppBar(
                //Parametro de Top App Bar
                title = {

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "Big Shot App"
                    )

                },
                // Parametro de Top app bar
                colors = topAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
            )
        },

        //====================== CUERPO DE LA APP =================================
        content = { paddingValues -> ScreenBody(paddingValues) },

        //--------------------------Boton Flotante----------------------------
        floatingActionButton = {

            Button(onClick = { /*TODO*/ }){
                Text(text = "Subir foto")
            }

        },
        //---------------------- Posicion del boton Flotante ------------------
        floatingActionButtonPosition = FabPosition.End,

        //====================== BARRA INFERIOR ====================================
        bottomBar = {

            BottomAppBar(containerColor = (MaterialTheme.colorScheme.primary)) {


                Text(
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 22.sp,
                    textAlign = TextAlign.End,
                    text = "By VesuDev",
                    color = MaterialTheme.colorScheme.onSecondary
                )

            }

        })
}



@Composable
fun ScreenBody(padding: PaddingValues) {
    LazyColumn(

        modifier = Modifier
            .fillMaxSize()
            .padding(top = 62.dp)
            .padding(bottom = 80.dp)
    ) {


    }
}


@Preview
@Composable
fun PreviewMainScreen() {
    BigShotAppsTheme {
        MainScreen()
    }
}
