package com.example.my_whatsapp

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun camera(navController: NavController){
    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "thoda ruko pehle sikhne doo please",
            style = TextStyle(fontSize = 30.sp)
        )
    }

    /*
    val context = LocalContext.current

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            if(isGranted){
                Toast.makeText(context, "Permisssion Granted", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context,"Permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    )

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview(),
        onResult = { bitmap ->
            if(bitmap != null){
                Toast.makeText(context, "image captured", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(context, "image captured failed", Toast.LENGTH_SHORT).show()
            }
        }
    )

    Box (modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
        ){
        Icon(
            painter = painterResource(id = R.drawable.camera),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
                .clickable {
                    cameraLauncher.launch()
                }
        )

    }

     */
}