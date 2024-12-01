package com.example.my_whatsapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            home(navController)
        }

        composable(route = "updates") {
            updates(navController)
        }

        composable("communities") {
            communities(navController)
        }

        composable("calls") {
            calls(navController)
        }

        composable("camera") {
            camera(navController)
        }

        composable("settings") {
            setting(navController)
        }

        composable(route = "profile/{name}/{profilePic}",
                arguments = listOf(
                    navArgument("name"){type = NavType.StringType},
                    navArgument("profilePic"){type = NavType.IntType}
                )
        ){
            backStackEntry->
            val name = backStackEntry.arguments?.getString("name")
            val profilePic = backStackEntry.arguments?.getInt("profilePic")
            profile(navController, name , profilePic)
        }

        composable(route = "chatscreen/{name}/{profilePic}",
            arguments = listOf(
                navArgument("name"){type = NavType.StringType},
                navArgument("profilePic"){type = NavType.IntType}
            )){
            backStackEntry->
            val name = backStackEntry.arguments?.getString("name")
            val profilePic = backStackEntry.arguments?.getInt("profilePic")
            chatScreen(navController, name, profilePic)

        }
    }
}