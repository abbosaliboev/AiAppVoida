package com.example.team_voida.Payment

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import com.example.team_voida.Basket.BasketCartNum
import com.example.team_voida.Basket.BasketItemArrange
import com.example.team_voida.Basket.ComposableLifecycle
import com.example.team_voida.Basket.basketSample
import com.example.team_voida.Notification.Notification

@Composable
fun Payment(
    navController: NavController,
    basketFlag: MutableState<Boolean>
){
    val scrollState = rememberScrollState()

    ComposableLifecycle { source, event ->
        if (event == Lifecycle.Event.ON_PAUSE) {
            Log.e("123","on_pause")
        } else if(event == Lifecycle.Event.ON_STOP){
            Log.e("123","on_stop")
        } else if(event == Lifecycle.Event.ON_DESTROY){
            Log.e("123","on_destroy")
        } else if(event == Lifecycle.Event.ON_CREATE){
            Log.e("123","on_create")
        } else if(event == Lifecycle.Event.ON_START){
            Log.e("123","on_start")
            basketFlag.value = true
        } else if(event == Lifecycle.Event.ON_RESUME){
            Log.e("123","on_resume")
            basketFlag.value = true
        }
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)

    ){
        Notification("결제 화면입니다. 아래에 설정된 배송지, 연락처를 확인해주세요. 결제되는 상품들을 확인하시고 화면 우측 하단에 '결제하기' 버튼을 눌러주세요..")
    }
}