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
    val detailedInfo: String,
    val review: String
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
    detailedInfo = "붉게 영근 대추방울토마토는 대추처럼 살짝 길쭉한 생김새와 단단한 과육을 지녔는데요. 씹을수록 톡톡 터지는 과즙은 금세 입안을 싱그럽게 채워줍니다. 붉은 한 알에 풍부한 맛과 영양을 오롯이 품은 대추방울토마토를 신선하게 전해드릴게요. 평소 방울토마토를 간식, 샐러드, 주스 등으로 꾸준히 드시는 분이라면 손쉽게 담아가 보세요. 여러 가지 메뉴에 알맞게 활용하기 좋은 양이랍니다.",
    review = "방울토마토를 활용한 다양한 요리 레시피에 대한 리뷰입니다. 피자와 타코에서 방울토마토의 신선함이 돋보이며, 에어프라이어 치킨 가라아게와 함께 즐기는 방법도 소개되었습니다. 새송이 쉬림프 파스타는 버터와 마늘, 굴소스로 감칠맛을 낸다는데, 대추방울토마토로 감바스를 만든 후에는 바게트 곁들여 먹는 방법도 언급되어 있습니다. 방울토마토의 감칠맛과 신선함이 각 요리에 잘 어울린다는 평가가 지적되었고, 집에서 만든 음식의 건강함과 만족도도 높다는 점을 강조하고 있습니다."
)
