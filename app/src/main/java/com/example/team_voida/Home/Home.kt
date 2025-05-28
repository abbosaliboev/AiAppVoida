package com.example.team_voida.Home

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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsEndWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.text
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.substring
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import coil3.imageLoader
import coil3.network.httpHeaders
import coil3.request.ImageRequest
import coil3.util.DebugLogger

import com.example.team_voida.Basket.ComposableLifecycle
import com.example.team_voida.Notification.Notification
import com.example.team_voida.R
import com.example.team_voida.SearchBar
import com.example.team_voida.ui.theme.TextLittleDark
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

@Composable
fun Home(
    navController: NavController,
    input: MutableState<String>,
    result: List<Popular>?,
    basketFlag: MutableState<Boolean>,
    homeNavFlag: MutableState<Boolean>,
    productFlag: MutableState<Boolean>,
    selectedIndex: MutableState<Int>
){
    val scrollState = rememberScrollState()
    Log.e("zxz",result.toString())
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
            selectedIndex.value = 0
            homeNavFlag.value = true
            basketFlag.value = false
            productFlag.value = false
            Log.e("123","on_start")
        } else if(event == Lifecycle.Event.ON_RESUME){
            Log.e("123","on_resume")
        }
    }

    // TODO
    // 임시로 result를 공통으로 사용


    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)

    ){
        Notification("홈 화면입니다. 실시간 인기 상품과 특가 상품을 만나볼 수 있습니다. 화면을 아래로 스크롤하여 다양한 이벤트 상품을 만나보세요!")
        HomeSearchBar(
            navController,
            input
        )
        HomePopularRanking(navController)
        HomeProducts(
            result = result
        )

        Notification("아래에 요즘 많이 담기는 특가 상품을 만나보세요!")
        HomeBar(
            navController = navController,
            title = "많이 담는 특가"
        )
        HomeProducts(
            result = result

        )

        Notification("아래에 오늘 하루만 진행하는 특가 이벤트 상품을 만나보세요!")
        HomeBar(
            navController = navController,
            title = "하루 특가"
        )
        HomeProducts(
            result = result

        )

        Notification("아래에 요즘 뜨고 있는 인기 신상품을 만나보세요!")
        HomeBar(
            navController = navController,
            title = "인기 신상품"
        )
        HomeProducts(
            result = result
        )
        Spacer(Modifier.height(45.dp))
    }
}

@Composable
fun HomeSearchBar(
    navController: NavController,
    input: MutableState<String>
){
    Row(
        modifier = Modifier

    ){
        Text(
            modifier = Modifier
                .offset(
                    x = 15.dp,
                    y = 5.dp
                ),
            textAlign = TextAlign.Center,
            text = "Shop",
            color = TextLittleDark,
            style = TextStyle(
                fontSize = 35.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            )
        )
        Spacer(Modifier.width(7.dp))
        SearchBar(
            navController = navController,
            resultInput = input
        )
    }
}

@Composable
fun HomePopularRanking(
    navController: NavController
){
    Column {
        HomeBar(
            navController = navController,
            title = "실시간 인기"
        )
    }
}


// Home Bar which represented repeatedly
@Composable
fun HomeBar(
    navController: NavController,
    title: String
){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            modifier = Modifier,
//                    .offset(
//                        x = 15.dp,
//                        y = 5.dp
//                    ),
            textAlign = TextAlign.Center,
            text = title,
            color = TextLittleDark,
            style = TextStyle(
                fontSize = 25.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            )
        )
        Row (
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .clickable {
                    navController.navigate("home")
                }
        ){
            Text(
                modifier = Modifier
                    .offset(
                        x = -10.dp,
                        y = 7.dp
                    ),

                textAlign = TextAlign.Center,
                text = "모두 보기",
                color = TextLittleDark,
                style = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                )
            )
            Icon(
                painter = painterResource(R.drawable.arrow_button),
                contentDescription = "모두 보기 버튼",
                tint = Color.Unspecified
            )
        }
    }
}



@Composable
fun HomeProducts(
    result: List<Popular>? = null
){

    var count: Int? = null
    val index = remember { mutableStateOf(2) }


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
                    HomeCard(
                        id = tmpResult1.id,
                        img = tmpResult1.image_url,
                        name = tmpResult1.name,
                        price = tmpResult1.price,
                        description = tmpResult1.description,
                        category = tmpResult1.category
                    )
                    HomeCard(
                        id = tmpResult2.id,
                        img = tmpResult2.image_url,
                        name = tmpResult2.name,
                        price = tmpResult2.price,
                        description = tmpResult2.description,
                        category = tmpResult2.category
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
                        index.value += 1
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
fun HomeCard(
    id: Int,
    img: String,
    description: String,
    name: String,
    price: Float,
    category: String
){
    val imageLoader = LocalContext.current.imageLoader.newBuilder()
        .logger(DebugLogger())
        .build()


    Box(
        modifier = Modifier
            // ScreenReader를 위해 텍스트를 한 묶음으로 처리
            .semantics(mergeDescendants = true){
                text = AnnotatedString(name + "상품 입니다." + "상품의 가격은" + price + "입니다.")
            }
            .width(180.dp)
            .padding(
                start = 10.dp,
                end = 10.dp,
            )
    ){
        Image(
            painter = painterResource(R.drawable.home_rec),
            contentDescription = "",
            modifier = Modifier.shadow(elevation = 15.dp, shape = RoundedCornerShape(15.dp))
        )
        Column (
            modifier = Modifier.fillMaxSize()
        ){

            Log.e("zzz",img)


            AsyncImage(
                imageLoader = imageLoader,
                modifier = Modifier
                    .offset(
                        y = 10.dp
                    )
                    .size(170.dp)
                    .clip(RoundedCornerShape(15.dp))
                ,
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data(
                        if(img[0]=='\"'){img.substring(1,img.length-1)} else{img}
                    )
                    .build(),
                contentDescription = name + "상품 이미지"
            )
            Log.e("after    ","${name} : ${img}")

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
                    text = name.substring(1,name.length-1),
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                    )
                )
    
                val textPrice = DecimalFormat("#,###", DecimalFormatSymbols(Locale.US)).format(price)
                Text(
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    text = textPrice + "원",
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

