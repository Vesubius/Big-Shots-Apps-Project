package com.vesudev.bigshotapps


import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.vesudev.bigshotapps.ui.theme.BigShotAppsTheme


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
    // Variable que controla de la imagen seleccionada
    var selectedImageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    //
    val singlePhotoPikerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri -> selectedImageUri = uri })

    Scaffold(
        //====================== BARRA SUPERIOR ========================================
        topBar = {
            TopAppBar(


                //Parametro de Top App Bar
                title = {

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = stringResource(id = R.string.app_name)
                    )

                },
                // Parametro de Top app bar
                colors = topAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
            )

        },

        //====================== CUERPO DE LA APP =================================
        content = { paddingValues -> ScreenBody(paddingValues, selectedImageUri) },

        //--------------------------Boton Flotante----------------------------
        floatingActionButton = {

            Button(onClick = {
                singlePhotoPikerLauncher.launch(
                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                )
            }) {
                Text(text = "Subir Foto")
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
fun ScreenBody(padding: PaddingValues, stateImage: Uri?) {


    Box(modifier = Modifier.fillMaxSize()) {
        // Imagen de fondo
        Image(
            painter = rememberImagePainter("https://i.pinimg.com/564x/ed/1a/36/ed1a36532ba9a37f71add3dc9d03743f.jpg"),
            contentDescription = "Fondo",
            modifier = Modifier.fillMaxSize()
        )
        //marco para las fotos subidaS
        Column(modifier = Modifier
            .height(400.dp)
            .fillMaxWidth()
            .padding(horizontal = 30.dp)) {
            // ======================== Contenido de la Pantalla ==========================
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),

                //Alineamiento vertical
                verticalArrangement = Arrangement.Bottom
            ) {
                //Item Imagen
                item {
                    AsyncImage(
                        model = stateImage,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth()
                    )
                }


            }
        }


    }

}


@Preview
@Composable
fun PreviewMainScreen() {
    BigShotAppsTheme {
        MainScreen()
    }
}
