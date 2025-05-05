package com.example.team_voida.Nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.team_voida.CreateAccount.CreateAccount
import com.example.team_voida.CreateAccount.CreateAccountNaming
import com.example.team_voida.Home.Home
import com.example.team_voida.Login.Login
import com.example.team_voida.Start.Guide
import com.example.team_voida.Start.Start

@Composable
fun HomeNav(){

    val navController = rememberNavController()

    // check git hub
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { Home(navController = navController) }
    }
}