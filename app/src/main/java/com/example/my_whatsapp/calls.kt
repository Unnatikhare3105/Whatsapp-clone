package com.example.my_whatsapp

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.core.view.DragAndDropPermissionsCompat
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun calls(navController: NavController) {
    val chat = chatlist().list;
    var moreoption by remember { mutableStateOf(false) }
    Scaffold(topBar = {
            TopAppBar(
                title = {
                    Text("Calls",
                        style = TextStyle(
                            fontSize = 31.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                actions = {
                    Row(modifier = Modifier.padding(10.dp)) {
                        IconButton(onClick = {}) {
                            Icon(
                                painter = painterResource(id = R.drawable.qr_code_scanner),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(5.dp)
                                    .height(28.dp)
                                    .width(28.dp)
                            )
                        }
                        IconButton(onClick = {navController.navigate("camera")}){
                            Icon(
                                painter = painterResource(id = R.drawable.camera),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(5.dp)
                                    .height(28.dp)
                                    .width(28.dp)
                            )
                        }
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(5.dp)
                                    .height(28.dp)
                                    .width(28.dp)
                            )
                        }
                        Box {
                            IconButton(onClick = {moreoption = true}) {
                                Icon(
                                    imageVector = Icons.Default.MoreVert,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(5.dp)
                                        .height(28.dp)
                                        .width(28.dp)
                                )
                            }
                            DropdownMenu(expanded = moreoption, onDismissRequest = {moreoption = false}) {
                                DropdownMenuItem(text = { Text("clear call logs")},
                                    onClick = {})
                                DropdownMenuItem(text = { Text("settings")},
                                    onClick = {navController.navigate("settings")})
                            }
                        }
                    }
                },
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                contentColor = Color.Black,
                containerColor = Color.Transparent,
                content = {
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically){
                        Column(
                            modifier = Modifier.padding(5.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            IconButton(onClick = {navController.navigate("home")}) {
                                Icon(painter = painterResource(id = R.drawable.chats), contentDescription = null)
                            }
                            Text("Chats")

                        }
                        Column(
                            modifier = Modifier.padding(5.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            IconButton(onClick = {navController.navigate("updates")}) {
                                Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
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
                            IconButton(onClick = {navController.navigate("calls")}) {
                                Icon(imageVector = Icons.Default.Call, contentDescription = null)
                            }
                            Text("Calls")
                        }
                    }

                }
            )
        }) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn {
                items(chat) { chats ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier
                                .clickable { navController.navigate("chatscreen/${chats.title}/${chats.images}") },
                            verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = chats.images),
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .height(70.dp)
                                    .clip(RoundedCornerShape(50))
                            )
                            Spacer(modifier = Modifier.width(15.dp))
                            Text(
                                text = chats.title,
                                style = TextStyle(fontSize = 21.sp)
                            )
                        }
                        Row {
                            IconButton(onClick = {}) {
                                Icon(
                                    painter = painterResource(id = R.drawable.videocam),
                                    contentDescription = null
                                )
                            }
                            IconButton(onClick = {}) {
                                Icon(
                                    painter = painterResource(id = R.drawable.phone),
                                    contentDescription = null
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}

