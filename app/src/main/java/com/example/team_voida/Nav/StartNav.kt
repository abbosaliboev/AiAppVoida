package com.example.team_voida.Nav

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.team_voida.CreateAccount.CreateAccount
import com.example.team_voida.CreateAccount.CreateAccountNaming
import com.example.team_voida.Login.Login
import com.example.team_voida.Start.Guide
import com.example.team_voida.Start.Guide1
import com.example.team_voida.Start.Start

@Composable
fun StartNav(){

    val navController = rememberNavController()

    // check git hub
    NavHost(navController = navController, startDestination = "start") {
        composable("start") { Start(navController = navController) }
        composable("createAccount") { CreateAccount(navController = navController) }
        composable("login"){ Login(navController = navController) }
        composable("naming") { CreateAccountNaming(navController = navController) }
        composable("guide") { Guide(navController = navController) }
    }
}

