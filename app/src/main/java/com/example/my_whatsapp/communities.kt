package com.example.my_whatsapp

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun communities(navController: NavController) {
    var moreoption by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Communities") },
                actions = {
                    Row(modifier = Modifier.padding(5.dp))
                    {
                        IconButton(onClick = {}) {
                            Icon(
                                painter = painterResource(id = R.drawable.qr_code_scanner),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(30.dp)
                                    .width(30.dp)
                            )
                        }
                        IconButton(onClick = { navController.navigate("camera") }) {
                            Icon(
                                painter = painterResource(id = R.drawable.camera),
                                modifier = Modifier
                                    .height(30.dp)
                                    .width(30.dp),
                                contentDescription = null
                            )
                        }
                        IconButton(onClick = { moreoption = true }) {
                            Box {
                                Icon(
                                    imageVector = Icons.Default.MoreVert,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .height(30.dp)
                                        .width(30.dp)
                                )
                                DropdownMenu(
                                    expanded = moreoption,
                                    onDismissRequest = {},
                                    modifier = Modifier.padding(8.dp)
                                ) {
                                    DropdownMenuItem(text = { TextButton(onClick = {}) { Text("settings") } },
                                        onClick = { navController.navigate("settings") })
                                }

                            }
                        }

                    }
                }
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
                                Icon(
                                    painter = painterResource(id = R.drawable.chats),
                                    contentDescription = null
                                )
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
                            IconButton(onClick = { navController.navigate("communities") }) {
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
        Spacer(modifier = Modifier.height(70.dp))
        Row(modifier = Modifier.padding(10.dp)) {
            Box {
                Icon(
                    painter = painterResource(id = R.drawable.community),
                    contentDescription = null
                )

                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = null,
                    tint = Color.Green
                )
            }

            Text("new Community")
        }
    }
}
