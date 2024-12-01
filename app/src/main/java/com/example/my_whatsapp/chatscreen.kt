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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
fun chatScreen(
    navController: NavController,
    name: String?,
    profilePic: Int?
) {
    var moreoption by remember { mutableStateOf(false) }
    var insideoption by remember { mutableStateOf(false) }
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    profilePic?.let {
                        Image(
                            painter = painterResource(id = it), contentDescription = null,
                            modifier = Modifier.height(40.dp).width(40.dp)
                                .clip(RoundedCornerShape(50))
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = name ?: "no person exist",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W500
                        )
                    )
                }
            },
            navigationIcon = {
                IconButton(onClick = { navController.navigate("home") }) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.videocam),
                        contentDescription = null,
                        modifier = Modifier.height(25.dp).width(25.dp),
                        tint = Color.White
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.camera),
                        contentDescription = null,
                        modifier = Modifier.height(25.dp).width(25.dp),
                        tint = Color.White
                    )
                }
                Box {
                    IconButton(onClick = { moreoption = true }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = null,
                            modifier = Modifier.height(25.dp).width(25.dp),
                            tint = Color.White
                        )
                    }
                    DropdownMenu(expanded = moreoption, onDismissRequest = { moreoption = false }) {
                        DropdownMenuItem(text = { Text("view Contact") }, onClick = {})
                        DropdownMenuItem(text = { Text("Search") }, onClick = {})
                        DropdownMenuItem(text = { Text("add to list") }, onClick = {})
                        DropdownMenuItem(text = { Text("media,links and docs") }, onClick = {})
                        DropdownMenuItem(text = { Text("mute notifications") }, onClick = {})
                        DropdownMenuItem(text = { Text("disappearing messages") }, onClick = {})
                        DropdownMenuItem(text = { Text("wallpaper") }, onClick = {})
                        DropdownMenuItem(text = { Text("more") }, onClick = {})

                    }
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(Color.Black)
        )
    }) {
        Box(modifier = Modifier.fillMaxSize()) {
            profilePic?.let {
                Image(
                    painter = painterResource(id = it),
                    contentDescription = null,
                    modifier = Modifier.fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
            }
            Row(
                modifier = Modifier.fillMaxSize().padding(10.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("messages") },
                    leadingIcon = {
                        IconButton(onClick = {}) {
                            Icon(
                                painter = painterResource(id = R.drawable.emoji),
                                contentDescription = null,
                                tint = Color.DarkGray
                            )
                        }
                    },
                    trailingIcon = {
                        Row {
                            IconButton(onClick = {}) {
                                Icon(
                                    painter = painterResource(id = R.drawable.attach_file),
                                    contentDescription = null,
                                    tint = Color.DarkGray
                                )
                            }
                            IconButton(onClick = {}) {
                                Icon(
                                    painter = painterResource(id = R.drawable.currency_rupee),
                                    contentDescription = null,
                                    tint = Color.DarkGray
                                )
                            }
                            IconButton(onClick = {}) {
                                Icon(
                                    painter = painterResource(id = R.drawable.camera),
                                    contentDescription = null,
                                    tint = Color.DarkGray
                                )
                            }
                        }
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0xfff8f8f8),
                        unfocusedIndicatorColor = Color.Gray,
                        focusedIndicatorColor = Color.Gray
                    ),
                    modifier = Modifier.fillMaxWidth(0.85f).clip(shape = CircleShape)
                )
                IconButton(
                    onClick = {},
                    modifier = Modifier.height(51.dp).width(51.dp),
                    colors = IconButtonDefaults.iconButtonColors(containerColor = Color(0XFF47AD5D)),
                    ) {
                    Icon(
                        painter = painterResource(id = R.drawable.keyboard_voice),
                        contentDescription = null,
                        modifier = Modifier.height(37.dp).width(37.dp),
                        tint = Color.White
                    )
                }
            }
        }

    }
}

