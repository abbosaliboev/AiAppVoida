package com.example.team_voida.Nav

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.team_voida.Basket.Basket
import com.example.team_voida.CreateAccount.CreateAccount
import com.example.team_voida.CreateAccount.CreateAccountNaming
import com.example.team_voida.Home.Home
import com.example.team_voida.Login.Login
import com.example.team_voida.R
import com.example.team_voida.SearchResult.SearchResult
import com.example.team_voida.Start.Guide
import com.example.team_voida.Start.Start

val navItemList = listOf(
    BottomNav(
        unSelected = R.drawable.bottom_home,
        selected = R.drawable.bottom_sel_home,
        notify = "홈 화면 이동 버튼"
    ),
    BottomNav(
        unSelected = R.drawable.bottom_heart,
        selected = R.drawable.bottom_sel_heart,
        notify = "찜 화면 이동 버튼"
    ),
    BottomNav(
        unSelected = R.drawable.bottom_categories,
        selected = R.drawable.bottom_sel_categories,
        notify = "카테고리 화면 이동 버튼"
    ),
    BottomNav(
        unSelected = R.drawable.bottom_cart,
        selected = R.drawable.bottom_sel_basket,
        notify = "장바구니 화면 이동 버튼"
    ),
    BottomNav(
        unSelected = R.drawable.bottom_profile,
        selected = R.drawable.bottom_sel_profile,
        notify = "계정 화면 이동 버튼"
    )
)
@Composable
fun HomeNav(){

    val navController = rememberNavController() // home nav
    val basketController = rememberNavController()
    var selectedIndex by remember { mutableStateOf(0) }
    val input = remember{ mutableStateOf("") }

    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = Color.LightGray
                    ),
                containerColor = Color.White
            ){
                navItemList.forEachIndexed { index, item ->
                    var tmpIndex = 0.dp
                    if(index == selectedIndex){
                        tmpIndex = 3.8.dp
                        if(index == 1){
                            tmpIndex = 4.dp
                        }
                    }

                    NavigationBarItem(
                        colors = NavigationBarItemColors(
                            selectedIndicatorColor = Color.Transparent,
                            selectedTextColor = Color.Transparent,
                            selectedIconColor = Color.Transparent,
                            unselectedIconColor = Color.Transparent,
                            unselectedTextColor = Color.Transparent,
                            disabledIconColor = Color.Transparent,
                            disabledTextColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .height(30.dp)
                            .offset(
                                y = tmpIndex
                            )
                        ,
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            if(index == selectedIndex){
                                Column {
                                    Image(
                                        modifier = Modifier
                                            .size(27.dp)
                                        ,
                                        painter = painterResource(item.selected),
                                        contentDescription = item.notify
                                    )
                                }
                            } else{
                                Image(
                                    modifier = Modifier
                                        .size(20.dp),
                                    painter = painterResource(item.unSelected),
                                    contentDescription = item.notify
                                )
                            }
                        }
                    )
                }
            }
        }
    ){ inner ->
        when(selectedIndex){
            0 -> NavHost(modifier = Modifier.padding(inner), navController = navController, startDestination = "home") {
                composable("home") {
                    Home(
                        navController = navController,
                        input = input
                    )
                }
                composable("searchResult") {
                    SearchResult(
                        navController = navController,
                        input = input,
                        productName = input.value
                    )
                }
            }

            // temporally set the page
            1 ->
                // NavHost(For heart)
                Basket()
            2 ->
                // NavHost(For Categories)
                Basket()
            3 ->
                // NavHost(For Basket)
                NavHost(modifier = Modifier.padding(inner), navController = basketController, startDestination = "basket"){
                    composable("basket"){
                        Basket()
                    }
                }
            4 ->
                // NavHost(For Profile)
                Basket()
        }
        // check git hub
    }
}