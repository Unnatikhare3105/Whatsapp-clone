package com.example.my_whatsapp

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun updates(navController: NavController) {
    val chat = chatlist().list;
    var moreoption by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Updates") },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.qr_code_scanner),
                            contentDescription = "qr scan"
                        )
                    }
                    IconButton(onClick = {navController.navigate("camera")}) {
                        Icon(
                            painter = painterResource(id = R.drawable.camera),
                            contentDescription = "camera"
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "qr scan")
                    }
                    Box {
                        IconButton(onClick = { moreoption = true }) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "qr scan"
                            )
                        }
                        DropdownMenu(
                            expanded = moreoption,
                            onDismissRequest = { moreoption = false }) {
                            DropdownMenuItem(
                                text = { Text("status privacy") },
                                onClick = { moreoption = false })
                            DropdownMenuItem(
                                text = { Text("create channel") },
                                onClick = { moreoption = false })
                            DropdownMenuItem(
                                text = { Text("setting") },
                                onClick = { navController.navigate("settings") })
                        }

                    }
                }
            )
        },
        floatingActionButton = {
            IconButton(onClick = {navController.navigate("camera")}) {
                Icon(
                    painter = painterResource(id = R.drawable.camera),
                    contentDescription = "camera"
                )
            }
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                contentColor = Color.Black,
                containerColor = Color.Transparent,
                content = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.padding(5.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            IconButton(onClick = { navController.navigate("home") }) {
                                Icon(painter = painterResource(id = R.drawable.chats), contentDescription = null)
                            }
                            Text("Chats")

                        }
                        Column(
                            modifier = Modifier.padding(5.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            IconButton(onClick = { navController.navigate("updates") }) {
                                Icon(
                                    imageVector = Icons.Default.Favorite,
                                    contentDescription = null
                                )
                            }
                            Text("updates")
                        }
                        Column(
                            modifier = Modifier.padding(5.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            IconButton(onClick = {navController.navigate("communities")}) {
                                Icon(imageVector = Icons.Default.Person, contentDescription = null)
                            }
                            Text("Communities")

                        }
                        Column(
                            modifier = Modifier
                                .padding(5.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            IconButton(onClick = { navController.navigate("calls") }) {
                                Icon(imageVector = Icons.Default.Call, contentDescription = null)
                            }
                            Text("Calls")
                        }
                    }

                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            Text(
                "Status", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.W500)
            )
            Spacer(modifier = Modifier.height(30.dp))
            LazyRow() {

                items(chat) { chats ->
                    Column(modifier = Modifier.padding(10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = chats.images),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .height(60.dp)
                                .width(60.dp)
                                .clip(CircleShape)
//                                .border(border = BorderStroke(5.dp, Color.Green))
                        )

                        Text(chats.title)
                    }
                }

            }

        }
    }
}