package com.example.team_voida.Payment

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.text
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.team_voida.Basket.BasketCartNum
import com.example.team_voida.Basket.BasketItemArrange
import com.example.team_voida.Basket.BasketProduct
import com.example.team_voida.Basket.ComposableLifecycle
import com.example.team_voida.Basket.basketSample
import com.example.team_voida.Categories.cateSports
import com.example.team_voida.Notification.Notification
import com.example.team_voida.ProductInfo.Loader
import com.example.team_voida.R
import com.example.team_voida.SearchResult.sampleSearchResult
import com.example.team_voida.Tools.LoaderSet
import com.example.team_voida.session
import com.example.team_voida.ui.theme.Selected
import com.example.team_voida.ui.theme.TextLittleDark
import com.example.team_voida.ui.theme.Unselected
import com.example.team_voida.ui.theme.WishButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

@Composable
fun Payment(
    navController: NavController,
    basketFlag: MutableState<Boolean>,
    homeNavFlag: MutableState<Boolean>,
    productFlag: MutableState<Boolean>,
    selectedIndex: MutableState<Int>,
    productID: MutableState<Int>,
    isItemWhichPart: MutableState<Int>,
    isPayOne: MutableState<Boolean>
){
    val scrollState = rememberScrollState()
    val tmpRegisteredPayMethod = remember { mutableListOf("신용카드", "모바일 페이", "계좌이체") }

    val paymentInfo:MutableState<PaymentInfo?> = remember { mutableStateOf<PaymentInfo?>(null) }
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
            homeNavFlag.value = true
            productFlag.value = false

            selectedIndex.value = 3
        } else if(event == Lifecycle.Event.ON_RESUME){
            Log.e("123","on_resume")
        }
    }


    runBlocking {
        val job = GlobalScope.launch {
            if(isPayOne.value){
                paymentInfo.value = PaymentServerOne(
                    action = when (isItemWhichPart.value) {
                        1 -> "/Popular"
                        2 -> "/BigSale"
                        3 -> "/TodaySale"
                        4 -> "/New"
                        else -> ""
                    },
                    session_id = session.sessionId.value,
                    product_id = productID.value
                )
            } else {
                paymentInfo.value = PaymentServerMultiple(
                    session_id = session.sessionId.value
                )
            }

        }
    }

    if(paymentInfo.value != null){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(scrollState)

        ){
            Notification("결제 화면입니다. 아래에 설정된 배송지, 연락처를 확인해주세요. 결제되는 상품들을 확인하시고 화면 우측 하단에 '결제하기' 버튼을 눌러주세요..")

            // Payment
            Text(
                modifier = Modifier
                    .padding(
                        start = 22.dp
                    ),
                textAlign = TextAlign.Center,
                text = "Payment",
                color = TextLittleDark,
                style = TextStyle(
                    fontSize = 25.sp,
                    fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                )
            )

            Spacer(Modifier.height(15.dp))

            PaymentAddress()
            Spacer(Modifier.height(7.dp))
            PaymentContact()
            Spacer(Modifier.height(15.dp))

            var num = 0
            paymentInfo.value!!.item.forEach { item ->
                num += item.number
            }
            PaymentNum(num)
            Spacer(Modifier.height(7.dp))
            PaymentRow(paymentInfo)
            Spacer(Modifier.height(15.dp))
            PaymentMethod()
            Spacer(Modifier.height(5.dp))
            PaymentMethodList(tmpRegisteredPayMethod)
            Spacer(Modifier.height(20.dp))
        }
    } else{
        LoaderSet()
    }

}

@Composable
fun PaymentAddress(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 10.dp,
                end = 10.dp
            )
            .clip(RoundedCornerShape(7.dp))
            .background(
                color = WishButton
            )

    ){
        Text(
            modifier = Modifier
                .padding(
                    start = 5.dp
                )
                .padding(
                    start = 13.dp,
                    top = 13.dp,
                    end = 13.dp
                )
            ,
            textAlign = TextAlign.Center,
            text = "배송 주소",
            color = TextLittleDark,
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            )
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                modifier = Modifier
                    .padding(
                        start = 5.dp
                    )
                    .padding(13.dp)
                    .fillMaxWidth()
                    .weight(8f)
                ,
                text = "서울특별시 서대문구 독립문로 129-1 가나다 아파트세상 203동 1104호",
                color = TextLittleDark,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                )
            )
            Button(
                onClick = {},
                modifier = Modifier
                    .size(30.dp)
                    .width(1.dp)
                    .offset(
                        x = -10.dp,
                        y = 20.dp
                    )
                ,
                colors = ButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Transparent,
                    disabledContentColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent
                ),
                contentPadding = PaddingValues(0.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.payment_edit),
                    contentDescription = "",
                    modifier = Modifier

                )
            }

        }
    }
}

@Composable
fun PaymentContact(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 10.dp,
                end = 10.dp
            )
            .clip(RoundedCornerShape(7.dp))
            .background(
                color = WishButton
            )

    ){
        Text(
            modifier = Modifier
                .padding(
                    start = 5.dp
                )
                .padding(
                    start = 13.dp,
                    top = 13.dp,
                    end = 13.dp
                )
            ,
            textAlign = TextAlign.Center,
            text = "연락처",
            color = TextLittleDark,
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            )
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                modifier = Modifier
                    .padding(
                        start = 5.dp
                    )
                    .padding(13.dp)
                    .fillMaxWidth()
                    .weight(8f)
                ,
                text = "010-1234-5678"+"\n"+"123456@gmail.com",
                color = TextLittleDark,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                )
            )
            Button(
                onClick = {},
                modifier = Modifier
                    .size(30.dp)
                    .width(1.dp)
                    .offset(
                        x = -10.dp,
                        y = 20.dp
                    )
                ,
                colors = ButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Transparent,
                    disabledContentColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent
                ),
                contentPadding = PaddingValues(0.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.payment_edit),
                    contentDescription = "",
                    modifier = Modifier

                )
            }

        }
    }
}


@Composable
fun PaymentNum(
    cartNum: Int
){

    Row (
        modifier = Modifier
            .semantics(mergeDescendants = true) {
                text = AnnotatedString("현재 결제 목록에는 ${cartNum} 개의 상품이 존재합니다.")
            }
            .fillMaxWidth()
            .padding(20.dp),

        ) {
        Text(
            modifier = Modifier,

            textAlign = TextAlign.Center,
            text = "Items",
            color = TextLittleDark,
            style = TextStyle(
                fontSize = 25.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            )
        )
        Spacer(Modifier.width(7.dp))
        Text(
            modifier = Modifier
                .clip(shape = CircleShape)
                .background(
                    color = Selected
                )
                .width(30.dp)
                .height(30.dp)
                .offset(
                    y = 5.dp
                )
            ,
            textAlign = TextAlign.Center,
            text = cartNum.toString(),
            color = TextLittleDark,
            style = TextStyle(
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            )
        )
    }
}

@Composable
fun PaymentRow(
    paymentInfo: MutableState<PaymentInfo?>
){



    //
    paymentInfo.value?.item?.forEachIndexed { index, item ->
        Column {
            Row(
                modifier = Modifier
                    .padding(
                        start = 10.dp,
                        end = 10.dp
                    )
                ,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Box(){
                    AsyncImage(
                        model = if(item.img[0]=='\"'){item.img.substring(1,item.img.length-1)} else{item.img},
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(86.dp)
                            .shadow(
                                elevation = 5.dp,
                                shape = CircleShape
                            )
                            .clip(CircleShape)

                            .border(
                                width = 5.dp,
                                color = Color.White,
                                shape = CircleShape
                            )
                    )

                    Box(
                        modifier = Modifier
                            .offset(
                                x = 60.dp,
                                y = 11.dp
                            )
                    ){
                        Text(
                            modifier = Modifier
                                .clip(shape = CircleShape)
                                .background(
                                    color = Selected
                                )
                                .width(30.dp)
                                .height(30.dp)
                                .border(
                                    width = 3.dp,
                                    color = Color.White,
                                    shape = CircleShape
                                )
                                .offset(
                                    y = 5.dp
                                )
                            ,
                            textAlign = TextAlign.Center,
                            text = item.number.toString(),
                            color = TextLittleDark,
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                            )
                        )
                    }
                }
                Text(
                    modifier = Modifier
                        .padding(
                            start = 5.dp
                        )
                        .padding(13.dp)
                        .weight(7f)
                        .padding(top = 10.dp)
                    ,
                    text = item.name,
                    color = TextLittleDark,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                    )
                )

                val textPrice = DecimalFormat("#,###", DecimalFormatSymbols(Locale.US)).format(item.price)

                Text(
                    modifier = Modifier
                        .padding(
                            start = 5.dp
                        )
                        .padding(13.dp)
                        .weight(4f)
                        .padding(top = 17.dp)

                    ,
                    text = textPrice + "원",
                    color = TextLittleDark,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                    )
                )
            }
            Spacer(Modifier.height(5.dp))
        }
    }
}

@Composable
fun PaymentMethod(){
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 20.dp
            ),

        ) {
        Text(
            modifier = Modifier,

            textAlign = TextAlign.Center,
            text = "Payment Method",
            color = TextLittleDark,
            style = TextStyle(
                fontSize = 25.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            )
        )
        Button(
            onClick = {},
            modifier = Modifier
                .size(30.dp)
                .width(1.dp)
                .offset(
                    x = -10.dp,
                )
            ,
            colors = ButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Transparent,
                disabledContentColor = Color.Transparent,
                disabledContainerColor = Color.Transparent
            ),
            contentPadding = PaddingValues(0.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.payment_edit),
                contentDescription = "",
                modifier = Modifier

            )
        }
    }
}

@Composable
fun PaymentMethodList(
    tmpRegisteredPayMethod: MutableList<String>
){
    val scrollState = rememberScrollState()
    val selected = remember{ mutableStateOf(0) }
    Row(
        modifier = Modifier
            .horizontalScroll(scrollState)
            .padding(
                start = 20.dp
            )
    ){
        tmpRegisteredPayMethod.forEachIndexed { index, item ->
            Button(
                onClick = {
                    selected.value = index
                },
                colors = if(selected.value == index){
                    ButtonColors(
                        contentColor = Selected,
                        containerColor = Selected,
                        disabledContentColor = Selected,
                        disabledContainerColor = Selected
                    )
                } else {
                    ButtonColors(
                        containerColor = Unselected,
                        contentColor = Unselected,
                        disabledContainerColor = Unselected,
                        disabledContentColor = Unselected
                    )
                }
            ){
                Text(
                    modifier = Modifier,

                    textAlign = TextAlign.Center,
                    text = item,
                    color = TextLittleDark,
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                    )
                )
            }
            Spacer(Modifier.width(7.dp))
        }
    }
}