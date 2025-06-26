package com.cox.navigation3.data

data class FloorPlanState(
    val id: Int,
    val name: String,
    val price: Double,
    val description: String,
    val imageUrl: String
)

val floorPlans = listOf(
    FloorPlanState(
        id = 1,
        name = "Toyota Corolla Cross",
        price = 24999.99,
        description = "Compact SUV with excellent fuel efficiency and Toyota reliability. Perfect for urban driving.",
        imageUrl = "https://media.toyota.com.ar/5028b498-d731-4101-95de-00978d37ea8a.png"
    ),
    FloorPlanState(
        id = 2,
        name = "Ford F-150 Lightning",
        price = 54999.00,
        description = "All-electric pickup truck with impressive towing capacity and innovative features.",
        imageUrl = "https://www.vdm.ford.com/content/dam/na/ford/en_us/images/f150-lightning/2025/jellybeans/2025-f150-lightning-vhp-model-walk-plat.png"
    ),
    FloorPlanState(
        id = 3,
        name = "Honda CR-V Hybrid",
        price = 32999.50,
        description = "Spacious midsize SUV with hybrid efficiency and Honda's legendary durability.",
        imageUrl = "https://d2ivfcfbdvj3sm.cloudfront.net/7fc965ab77efe6e0fa62e4ca1ea7673bb6594453031e3d8e88cb10/stills_0640_png/MY2024/53528/53528_st0640_116.png"
    ),

    FloorPlanState(
        id = 5,
        name = "Tesla Model Y",
        price = 51999.00,
        description = "Premium electric crossover with cutting-edge technology and impressive range.",
        imageUrl = "https://www.pngarts.com/files/11/Tesla-PNG-Photo.png"
    ),
    FloorPlanState(
        id = 6,
        name = "BMW X5 xDrive40i",
        price = 65999.99,
        description = "Luxury SUV with sporty handling, premium interior, and advanced tech features.",
        imageUrl = "https://images.dealer.com/ddc/vehicles/2020/BMW/X5%20M/SUV/perspective/front-left/2020_24.png"
    ),
    FloorPlanState(
        id = 7,
        name = "Jeep Wrangler 4xe",
        price = 52999.50,
        description = "Iconic off-roader now with plug-in hybrid technology for eco-conscious adventurers.",
        imageUrl = "https://platform.cstatic-images.com/xxlarge/in/v2/stock_photos/178a092c-0d7b-4c99-8d61-fd8cd8f94027/8bfe4448-7490-4ffd-a69a-093ec25698ce.png"
    ),
    FloorPlanState(
        id = 4,
        name = "Chevrolet Silverado 2500HD",
        price = 45999.99,
        description = "Heavy-duty truck with exceptional payload capacity and towing performance.",
        imageUrl = "https://wompimages.ampify.care/fetchimage?siteId=7733&url=https%3A%2F%2Fwww.valleychevy.com%2Fwp-content%2Fuploads%2F2024%2F10%2FSilverado-2500-HD-2025-Black.png"
    )
)
