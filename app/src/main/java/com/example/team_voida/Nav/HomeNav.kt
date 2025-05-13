package com.example.team_voida.Nav

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.team_voida.Basket.Basket
import com.example.team_voida.Basket.BasketPaymentButton
import com.example.team_voida.Categories.Categories
import com.example.team_voida.CreateAccount.CreateAccount
import com.example.team_voida.CreateAccount.CreateAccountNaming
import com.example.team_voida.Home.Home
import com.example.team_voida.Home.HomePopularCall
import com.example.team_voida.Home.Popular
import com.example.team_voida.Login.Login
import com.example.team_voida.Payment.Payment
import com.example.team_voida.ProductInfo.ProductInfo
import com.example.team_voida.ProductInfo.ProductInfoBottomBar
import com.example.team_voida.ProductInfo.sampleProductInfoData
import com.example.team_voida.R
import com.example.team_voida.SearchResult.SearchResult
import com.example.team_voida.Start.Guide
import com.example.team_voida.Start.Start
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

val navItemList = listOf(
    BottomNav(
        unSelected = R.drawable.bottom_home,
        selected = R.drawable.bottom_sel_home,
        notify = "홈 화면 이동 버튼"
    ),
    BottomNav(
        unSelected = R.drawable.bottom_categories,
        selected = R.drawable.bottom_sel_categories,
        notify = "카테고리 화면 이동 버튼"
    ),
    BottomNav(
        unSelected = R.drawable.bottom_zoom,
        selected = R.drawable.bottom_zoom,
        notify = "화면 확대 기능"
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
@SuppressLint("RememberReturnType")
@Composable
fun HomeNav(){

    val navController = rememberNavController() // home nav
    val basketController = rememberNavController()
    var selectedIndex by remember { mutableStateOf(0) }
    val basketFlag = remember { mutableStateOf(false) }
    val homeNavFlag = remember { mutableStateOf(true)}
    val productFlag = remember{ mutableStateOf(false) }
    val dynamicTotalPrice = remember { mutableStateOf("") }

    var scale by remember { mutableStateOf(1f) }
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }

    val minScale = 1f
    val maxScale = 4f

    // Remember the initial offset
    var initialOffset by remember { mutableStateOf(Offset(0f, 0f)) }

    // Coefficient for slowing down movement
    val slowMovement = 0.5f

    val scrollState = rememberScrollState()

    // Lens(zoom) variable
    val interactionSource = remember{ MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    var result: List<Popular>? = null

    runBlocking {
        val job = GlobalScope.launch {
            result = HomePopularCall()
        }
    }
    Thread.sleep(1500L)


    val input = remember{ mutableStateOf("") }

    Scaffold(
        bottomBar = {
            Column {
                if(basketFlag.value){
                    BasketPaymentButton(
                        dynamicTotalPrice.value,
                        navController
                    )
                }
                if(productFlag.value){
                    ProductInfoBottomBar(sampleProductInfoData.price)
                }
                if(homeNavFlag.value){
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
                                        y = if(index != 2) tmpIndex
                                         else 0.dp
                                    )
                                ,
                                selected = selectedIndex == index,
                                onClick = {
                                    selectedIndex = index
                                    if(selectedIndex == 0) navController.navigate("home")
                                    else if(selectedIndex ==1) navController.navigate("categories")
                                    else if(selectedIndex ==2){
                                        when(scale){
                                            1f -> scale = 2f
                                            2f -> scale = 3f
                                            3f -> scale = 4f
                                            else -> {
                                                scale = 1f
                                                offsetX = 0f
                                                offsetY = 0f
                                            }
                                        }
                                    }
                                    else if(selectedIndex == 3) navController.navigate("basket")
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
                                                .size(
                                                    if(index == 2){
                                                        27.dp
                                                    } else {
                                                        20.dp
                                                    }
                                                ),
                                            painter = painterResource(item.unSelected),
                                            contentDescription = item.notify
                                        )
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    ){ inner ->
        NavHost(
            modifier = Modifier
                .padding(inner)
                .fillMaxSize()
                .pointerInput(Unit){
                    detectTransformGestures{_, pan, _, _ ->

                        val newScale = scale
                        scale = newScale.coerceIn(minScale, maxScale)

                        // Calculate new offsets based on zoom and pan
                        val centerX = size.width / 2
                        val centerY = size.height / 2
                        val offsetXChange = (centerX - offsetX) * (newScale / scale - 1)
                        val offsetYChange = (centerY - offsetY) * (newScale / scale - 1)

                        // Calculate min and max offsets
                        val maxOffsetX = (size.width / 2) * (scale - 1)
                        val minOffsetX = -maxOffsetX
                        val maxOffsetY = (size.height / 2) * (scale - 1)
                        val minOffsetY = -maxOffsetY

                        // Update offsets while ensuring they stay within bounds
                        if (scale <= maxScale) {
                            offsetX = (offsetX + pan.x * scale * slowMovement + offsetXChange)
                                .coerceIn(minOffsetX, maxOffsetX)
                            offsetY = (offsetY + pan.y * scale * slowMovement + offsetYChange)
                                .coerceIn(minOffsetY, maxOffsetY)
                        }

                        // Store initial offset on pan
                        if (pan != Offset(0f, 0f) && initialOffset == Offset(0f, 0f)) {
                            initialOffset = Offset(offsetX, offsetY)
                        }
                    }
                }
                .pointerInput(Unit) {
                    detectTapGestures(
                        onDoubleTap = {
                            // Reset scale and offset on double tap
                            if (scale != 1f) {
                                scale = 1f
                                offsetX = initialOffset.x
                                offsetY = initialOffset.y
                            } else {
                                scale = 2f
                            }
                        }
                    )
                }
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    translationX = offsetX
                    translationY = offsetY
                }

            ,
            navController = navController,
            startDestination = "home"
        ) {
            composable("home") {
                Home(
                    navController = navController,
                    input = input,
                    result = result
                )
            }
            composable("searchResult") {
                SearchResult(
                    navController = navController,
                    input = input,
                    productName = input.value
                )
            }
            composable("basket") {
                Basket(
                    dynamicTotalPrice,
                    basketFlag,
                    navController
                )
            }
            composable("productInfo"){
                ProductInfo(
                    productInfoData = sampleProductInfoData,
                    navController = navController,
                    productFlag = productFlag,
                    homeNavFlag = homeNavFlag
                )
            }
            composable("categories"){
                Categories(
                    navController = navController,
                    homeNavFlag = homeNavFlag
                )
            }

            composable("payment"){
                Payment(
                    navController = navController,
                    basketFlag = basketFlag
                )
            }
        }
    }
}