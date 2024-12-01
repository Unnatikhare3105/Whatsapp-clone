package com.example.my_whatsapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun setting(navController: NavController) {
    var setting = settinglist().list;
    LazyColumn {
        item {
            Row(
                modifier = Modifier.fillMaxWidth().padding(7.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically){
                    IconButton(onClick = { navController.navigate("home") }) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_back),
                            contentDescription = null
                        )
                    }
                    Text(text = "Settings", style = TextStyle(fontSize = 23.sp, fontWeight = FontWeight.W500))
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null,
                        modifier = Modifier.height(30.dp).width(30.dp))
                }
            }
            HorizontalDivider(thickness = 0.85.dp, color = Color.Gray)
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically){

                Image(painter = painterResource(id = R.drawable.khushi),
                    contentDescription = null,
                    modifier = Modifier.padding(7.dp).height(50.dp).width(50.dp)
                        .clip(CircleShape))

                Column {
                    Text("Unnati khare", style = TextStyle(fontSize = 20.sp,
                        fontWeight = FontWeight.W500))
                    Text("if u want to know more about me",
                        style = TextStyle(fontSize = 15.sp))
                }
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.qr_code_scanner),
                        contentDescription = null
                    )
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.AddCircle, contentDescription = null)
                }
            }
            HorizontalDivider(thickness = 0.5.dp, color = Color.Gray)
        }
        items(setting) { slist ->
            Row(
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = slist.Icon),
                    contentDescription = slist.title,
                    modifier = Modifier.padding(10.dp).height(27.dp).width(30.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(slist.title, style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.W400))
                    Spacer(modifier = Modifier.height(7.dp))
                    Text(slist.description, style = TextStyle(fontSize = 15.sp))
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }

    }

}

