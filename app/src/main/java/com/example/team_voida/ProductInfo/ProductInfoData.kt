package com.example.team_voida.ProductInfo

data class ProductInfoData(
    val img: String,
    val name: String,
    val price: String,
    val discount: String,
    val eta: String,
    val seller: String,
    val pack: String,
    val additionalInfo : String?,
    val shortInfo: String,
    val intermediateInfo: String,
    val detailedInfo: String
)

val sampleProductInfoData = ProductInfoData(
    img = "https://product-image.kurly.com/hdims/resize/%5E%3E720x%3E936/cropcenter/720x936/quality/85/src/product/image/4436fdec-039d-4683-b8f3-7ebf677ad190.jpg",
    name = "[KF365] 대추방울토마토 750g",
    price = "6,990",
    discount = "58",
    eta = "23시 전 주문 시 수도권/충청 내일 아침 7시 전 도착",
    seller = "컬리",
    pack = "냉장(종이포장)",
    additionalInfo = null,
    shortInfo = "믿고 먹을 수 있는 상품을 합리적인 가격에",
    intermediateInfo = "붉게 영근 대추방울토마토는 대추처럼 살짝 길쭉한 생김새와 단단한 과육을 지녔는데요. 씹을수록 톡톡 터지는 과즙은 금세 입안을 싱그럽게 채워줍니다. 붉은 한 알에 풍부한 맛과 영양을 오롯이 품은 대추방울토마토를 신선하게 전해드릴게요. 평소 방울토마토를 간식, 샐러드, 주스 등으로 꾸준히 드시는 분이라면 손쉽게 담아가 보세요. 여러 가지 메뉴에 알맞게 활용하기 좋은 양이랍니다.",
    detailedInfo = "붉게 영근 대추방울토마토는 대추처럼 살짝 길쭉한 생김새와 단단한 과육을 지녔는데요. 씹을수록 톡톡 터지는 과즙은 금세 입안을 싱그럽게 채워줍니다. 붉은 한 알에 풍부한 맛과 영양을 오롯이 품은 대추방울토마토를 신선하게 전해드릴게요. 평소 방울토마토를 간식, 샐러드, 주스 등으로 꾸준히 드시는 분이라면 손쉽게 담아가 보세요. 여러 가지 메뉴에 알맞게 활용하기 좋은 양이랍니다."
)
