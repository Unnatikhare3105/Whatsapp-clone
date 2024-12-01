package com.example.my_whatsapp

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
fun home(navController: NavController){
    val chat = chatlist().list;
    var moreoption by remember { mutableStateOf(false) }
    var isdialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text(
                    text = "Whatsapp",
                    style = TextStyle(fontSize = 31.sp, fontWeight = FontWeight.Bold),
                    color = Color(0xff47AD5D)
                )},
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
                        IconButton(onClick = {navController.navigate("camera")}) {
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
                                    onDismissRequest = { moreoption = false },
                                    modifier = Modifier.padding(8.dp)
                                ) {
                                    DropdownMenuItem(text = { TextButton(onClick = {}) { Text("new group") } },
                                        onClick = {moreoption = false})
                                    DropdownMenuItem(text = { TextButton(onClick = {}) { Text("new broadcast") } },
                                        onClick = {moreoption = false})
                                    DropdownMenuItem(text = { TextButton(onClick = {}) { Text("linked devices") } },
                                        onClick = {moreoption = false})
                                    DropdownMenuItem(text = { TextButton(onClick = {}) { Text("starred messages") } },
                                        onClick = {moreoption = false})
                                    DropdownMenuItem(text = { TextButton(onClick = {}) { Text("payments") } },
                                        onClick = {moreoption = false})
                                    DropdownMenuItem(text = { TextButton(onClick = {navController.navigate("settings")}) { Text("settings") } },
                                        onClick = {moreoption = false})
                                }

                            }
                        }

                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
        floatingActionButtonPosition = FabPosition.End,
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
                            IconButton(onClick = { navController.navigate("updates") }) {
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
        }
    ){
        Column(
            modifier = Modifier
                .padding(10.dp)
                .padding(top = 50.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Ask Meta AI And Search...") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth()
                    .border(
                        border = BorderStroke(0.5.dp, Color.Black.copy(0.3f)),
                        shape = CircleShape
                    )
            )

            Row(modifier = Modifier.fillMaxWidth()) {
                LazyColumn {
                    items(chat) { chats ->

                        Row(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
                            Image(
                                painter = painterResource(id = chats.images),
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .height(50.dp)
                                    .clip(RoundedCornerShape(50))
                                    .clickable { navController.navigate("profile/${chats.title}/${chats.images}") }
//                                    .clickable { isdialog = true }
                            )

                            /*
                            if (isdialog) {
                                AlertDialog(onDismissRequest = { isdialog = false },
                                    confirmButton = {},
                                    shape = RoundedCornerShape(0),
                                    text = {
                                        Box(modifier = Modifier.height(300.dp)
                                            .align(Alignment.CenterVertically))
                                        {
                                            Row(modifier = Modifier.fillMaxSize().
                                                background(Color.White),
                                                horizontalArrangement = Arrangement.Absolute.Left,
                                                verticalAlignment = Alignment.Top) {
                                                Icon(painter = painterResource(id = R.drawable.arrow_back), contentDescription = null)
                                                Text(text = chats.title, style = TextStyle(fontSize = 20.sp))
                                            }
                                            Image( painter = painterResource(id = chats.images),
                                                contentDescription = null,
                                                modifier = Modifier.fillParentMaxHeight()
                                                .clickable { navController.navigate("profile/${chats.title}/${chats.images}") },
                                                contentScale = ContentScale.Crop

                                            )
                                            Row(modifier = Modifier.fillMaxSize(),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                                verticalAlignment = Alignment.Bottom,
                                                content = {
                                                    IconButton(onClick = {},
                                                        colors = IconButtonDefaults.iconButtonColors(
                                                            containerColor = Color.Transparent
                                                        )) {
                                                        Icon(painter = painterResource(id = R.drawable.chats),
                                                            contentDescription = null,
                                                            tint = Color(0xff47AD5D))
                                                    }
                                                    IconButton(onClick = {}) {
                                                        Icon(painter = painterResource(id = R.drawable.phone),
                                                            contentDescription = null,
                                                            tint = Color(0xff47AD5D))
                                                    }
                                                    IconButton(onClick = {}) {
                                                        Icon(painter = painterResource(id = R.drawable.videocam),
                                                            contentDescription = null,
                                                            tint = Color(0xff47AD5D))
                                                    }
                                                    IconButton(onClick = {}) {
                                                        Icon(painter = painterResource(id = R.drawable.baseline_info_outline_24),
                                                            contentDescription = null,
                                                            tint = Color(0xff47AD5D))
                                                    }
                                                }
                                                )
                                        }
                                    }
                                    )
                            }

                             */

                            Spacer(modifier = Modifier.width(20.dp))
                            Column(modifier = Modifier.clickable { navController.navigate("chatscreen/${chats.title}/${chats.images}") }
                            ) {
                                Text(
                                    text = chats.title,
                                    style = TextStyle(fontSize = 25.sp)
                                )
                                Row(
                                    modifier = Modifier,
                                    verticalAlignment = Alignment.CenterVertically
                                ){
                                    Icon(
                                        painter = painterResource(id = R.drawable.check),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .width(30.dp),
                                        tint = Color.Gray
                                    )
                                    Text(
                                        text = chats.description,
                                        style = TextStyle(fontSize = 18.sp)
                                    )

                                }
                            }
                        }
                    }
                }

            }
        }
    }
}