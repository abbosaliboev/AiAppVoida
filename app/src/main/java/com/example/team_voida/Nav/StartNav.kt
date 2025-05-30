package com.example.team_voida.Nav

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
fun StartNav(){

    val navController = rememberNavController()

    val email = remember { mutableStateOf("") }
    val pw = remember { mutableStateOf("") }
    val rePw = remember { mutableStateOf("") }
    val cell = remember { mutableStateOf("") }
    // check git hub
    NavHost(navController = navController, startDestination = "start") {
        composable("start") { Start(navController = navController) }
        composable("createAccount") {
            CreateAccount(
                email = email,
                pw  = pw,
                rePw = rePw,
                cell = cell,
                navController = navController
            )
        }
        composable("login"){ Login(navController = navController) }
        composable("naming") { CreateAccountNaming(
            email = email.value,
            pw = pw.value,
            cell = cell.value,
            navController = navController
        )
        }
        composable("guide") { Guide(navController = navController) }
        composable("home") { HomeNav() }
    }
}

