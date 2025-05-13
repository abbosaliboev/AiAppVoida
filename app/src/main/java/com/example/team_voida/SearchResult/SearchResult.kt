package com.example.team_voida.SearchResult

import android.app.appsearch.SearchResult
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.text
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.team_voida.Basket.ComposableLifecycle
import com.example.team_voida.Home.HomeSearchBar
import com.example.team_voida.Home.Popular
import com.example.team_voida.Nav.navItemList
import com.example.team_voida.Notification.Notification
import com.example.team_voida.R



@Composable
fun SearchResult(
    navController: NavController,
    input: MutableState<String>,
    productName: String,
    basketFlag: MutableState<Boolean>,
    homeNavFlag: MutableState<Boolean>,
    productFlag: MutableState<Boolean>
){

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
            homeNavFlag.value =true
            basketFlag.value = false
            productFlag.value = false
        } else if(event == Lifecycle.Event.ON_RESUME){
            Log.e("123","on_resume")
        }
    }
    val scrollState = rememberScrollState()
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)

    ) {
        Notification(productName + " 검색결과 입니다. 아래에 검색된 상품들을 만나보세요.")
        HomeSearchBar(
            navController,
            input
        )

        SearchProducts(
            sampleSearchResult.toList(),
            navController
        )
        Spacer(Modifier.height(30.dp))
    }
}

@Composable
fun SearchProducts(
    result: List<Popular>? = null,
    navController: NavController
){

    var count: Int? = null

    // represent {index * 2} items
    val index = remember { mutableStateOf(5) }


    //Todo, control the time optimally...
    // 분명 sleep with time 이 아닌
    // wait로 처리하는 로직이 있을 거 같음.


    if(result != null){
        count = result!!.size
    }

    Column {
        for(i in 1..index.value){
            val realIndex = i-1
            Row (
                modifier = Modifier
                    .padding(10.dp)
            ){
                if(count != null && index.value <= count){

                    val tmpResult1 = result!![realIndex*2]
                    val tmpResult2 = result!![realIndex*2+1]
                    SearchCard(
                        img = tmpResult1.img,
                        rank = tmpResult1.rank,
                        name = tmpResult1.name,
                        price = tmpResult1.price,
                        discount = tmpResult1.discount,
                        navController = navController
                    )
                    SearchCard(
                        img = tmpResult2.img,
                        rank = tmpResult2.rank,
                        name = tmpResult2.name,
                        price = tmpResult2.price,
                        discount = tmpResult2.discount,
                        navController = navController
                    )
                }
            }
        }
        Spacer(Modifier.height(10.dp))
        Row (
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable {
                    // index 값을 증가시켜, 해당 값에 따라 추가 아이템들이 나타나도록 구현
                    if(count != null && index.value*2 < count){
                        index.value += 5
                    }
                }
        ){
            Image(
                modifier = Modifier
                    .size(10.dp)
                    .offset(
                        y = 3.dp
                    ),
                painter = painterResource(R.drawable.arrow_down),
                contentDescription = ""
            )
            Spacer(Modifier.width(3.dp))
            Text(
                text = "상품 더보기",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                )
            )
        }
    }
}

@Composable
fun SearchCard(
    img: String,
    rank: String,
    name: String,
    price: String,
    discount: String,
    navController: NavController
){

    Box(
        modifier = Modifier
            // screen reader를 위해 텍스트를 한 묶음으로 처리
            .semantics(mergeDescendants = true){
                text = AnnotatedString(name + "상품 입니다." + discount + "할인되어 가격은" + price + "입니다.")
            }
            /////////////////////////
            .width(180.dp)
            .padding(
                start = 10.dp,
                end = 10.dp,
            )
            .clickable {navController.navigate("productInfo")}
    ){
        Image(
            painter = painterResource(R.drawable.home_rec),
            contentDescription = "",
            modifier = Modifier.shadow(elevation = 15.dp, shape = RoundedCornerShape(15.dp))
        )
        Column (
            modifier = Modifier.fillMaxSize()
        ){

            Image(
                modifier = Modifier
                    .offset(
                        y = 10.dp
                    )
                    .size(170.dp)
                    .clip(RoundedCornerShape(15.dp))
                ,
                painter = rememberAsyncImagePainter(img),
                contentDescription = name + "상품 이미지"
            )
            Column (
                modifier = Modifier.offset(
                    x = 12.dp,
                    y = 14.dp
                )
            ){
                Text(
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.width(140.dp),
                    text = name,
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                    )
                )
                Text(
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    text = price,
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                    )
                )
            }
        }
    }
}