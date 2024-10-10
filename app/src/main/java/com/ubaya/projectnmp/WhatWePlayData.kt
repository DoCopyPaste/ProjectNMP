package com.ubaya.projectnmp

object WhatWePlayData {
    var whatWePlayDatas: Array<WhatWePlayBank> = arrayOf(
        WhatWePlayBank("Valorant", "Valorant is a FPS game",
            R.drawable.valorant, listOf(
                mapOf("achievement" to "Valorant is a FPS game", "year" to 2020),
                mapOf("achievement" to "Popular in esports", "year" to 2021),
                mapOf("achievement" to "Valorant is a competitive game", "year" to 2018),
                mapOf("achievement" to "Best game awards", "year" to 2019)
            )),
        WhatWePlayBank("Mobile Legends", "Mobile legends is a MOBA game",
            R.drawable.mobilelegends, listOf(
                mapOf("achievement" to "Mobile legend is a MOBA game", "year" to 2020),
                mapOf("achievement" to "Popular in esports", "year" to 2021),
                mapOf("achievement" to "Mobile Legends is a competitive game", "year" to 2018),
                mapOf("achievement" to "Best game awards", "year" to 2019)
                )),
        WhatWePlayBank("PUBG", "PUBG is a TPS game",
            R.drawable.pubg, listOf(
                mapOf("achievement" to "Valorant is a FPS game", "year" to 2020),
                mapOf("achievement" to "Popular in esports", "year" to 2021),
                mapOf("achievement" to "Valorant is a competitive game", "year" to 2018),
                mapOf("achievement" to "Best game awards", "year" to 2019)
                ))
    )
}