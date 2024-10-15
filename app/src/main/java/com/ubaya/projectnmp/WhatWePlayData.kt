package com.ubaya.projectnmp

object WhatWePlayData {
    var whatWePlayDatas: Array<WhatWePlayBank> = arrayOf(
        WhatWePlayBank("Valorant", "Valorant is a FPS game",
            R.drawable.valorant, listOf(
                mapOf("achievement" to "Valorant is a FPS game", "year" to 2020),
                mapOf("achievement" to "Popular in esports", "year" to 2021),
                mapOf("achievement" to "Valorant is a competitive game", "year" to 2018),
                mapOf("achievement" to "Best game awards", "year" to 2019)
            ),
            mapOf(
                "Team A" to listOf(
                    TeamMember("Alice", "Duelist", R.drawable.doraemon),
                    TeamMember("Bob", "Smoker", R.drawable.ic_launcher_background),
                    TeamMember("Alice2", "Healer", R.drawable.doraemon),
                    TeamMember("Bob2", "Support", R.drawable.ic_launcher_background),
                ),
                "Team B" to listOf(
                    TeamMember("Aaron", "Duelist", R.drawable.doraemon),
                    TeamMember("Oakley", "Smoker", R.drawable.ic_launcher_background),
                    TeamMember("Stanley", "Healer", R.drawable.doraemon),
                    TeamMember("James", "Support", R.drawable.ic_launcher_background),
                ),
                "Team C" to listOf(
                    TeamMember("Darren", "Duelist", R.drawable.doraemon),
                    TeamMember("Edward", "Smoker", R.drawable.ic_launcher_background),
                    TeamMember("Randy", "Healer", R.drawable.doraemon),
                    TeamMember("Ryan", "Support", R.drawable.ic_launcher_background),
                ),
                "Team D" to listOf(
                    TeamMember("Luki", "Duelist", R.drawable.doraemon),
                    TeamMember("Matthew", "Smoker", R.drawable.ic_launcher_background),
                    TeamMember("Willy", "Healer", R.drawable.doraemon),
                    TeamMember("Budi", "Support", R.drawable.ic_launcher_background),
                ),
            )
        ),
        WhatWePlayBank("Mobile Legends", "Mobile legends is a MOBA game",
            R.drawable.mobilelegends, listOf(
                mapOf("achievement" to "Mobile legend is a MOBA game", "year" to 2020),
                mapOf("achievement" to "Popular in esports", "year" to 2021),
                mapOf("achievement" to "Mobile Legends is a competitive game", "year" to 2018),
                mapOf("achievement" to "Best game awards", "year" to 2019)
            ), mapOf(
                "Team A" to listOf(
                    TeamMember("Alice", "Duelist", R.drawable.doraemon),
                    TeamMember("Bob", "Smoker", R.drawable.ic_launcher_background),
                    TeamMember("Alice2", "Healer", R.drawable.doraemon),
                    TeamMember("Bob2", "Support", R.drawable.ic_launcher_background),
                ),
                "Team B" to listOf(
                    TeamMember("Aaron", "Duelist", R.drawable.doraemon),
                    TeamMember("Oakley", "Smoker", R.drawable.ic_launcher_background),
                    TeamMember("Stanley", "Healer", R.drawable.doraemon),
                    TeamMember("James", "Support", R.drawable.ic_launcher_background),
                ),
                "Team C" to listOf(
                    TeamMember("Darren", "Duelist", R.drawable.doraemon),
                    TeamMember("Edward", "Smoker", R.drawable.ic_launcher_background),
                    TeamMember("Randy", "Healer", R.drawable.doraemon),
                    TeamMember("Ryan", "Support", R.drawable.ic_launcher_background),
                ),
                "Team D" to listOf(
                    TeamMember("Luki", "Duelist", R.drawable.doraemon),
                    TeamMember("Matthew", "Smoker", R.drawable.ic_launcher_background),
                    TeamMember("Willy", "Healer", R.drawable.doraemon),
                    TeamMember("Budi", "Support", R.drawable.ic_launcher_background),
                ),
            )
        ),
        WhatWePlayBank("PUBG", "PUBG is a TPS game",
            R.drawable.pubg, listOf(
                mapOf("achievement" to "Valorant is a FPS game", "year" to 2020),
                mapOf("achievement" to "Popular in esports", "year" to 2021),
                mapOf("achievement" to "Valorant is a competitive game", "year" to 2018),
                mapOf("achievement" to "Best game awards", "year" to 2019)
            ), mapOf(
                "Team A" to listOf(
                    TeamMember("Alice", "Duelist", R.drawable.doraemon),
                    TeamMember("Bob", "Smoker", R.drawable.ic_launcher_background),
                    TeamMember("Alice2", "Healer", R.drawable.doraemon),
                    TeamMember("Bob2", "Support", R.drawable.ic_launcher_background),
                ),
                "Team B" to listOf(
                    TeamMember("Aaron", "Duelist", R.drawable.doraemon),
                    TeamMember("Oakley", "Smoker", R.drawable.ic_launcher_background),
                    TeamMember("Stanley", "Healer", R.drawable.doraemon),
                    TeamMember("James", "Support", R.drawable.ic_launcher_background),
                ),
                "Team C" to listOf(
                    TeamMember("Darren", "Duelist", R.drawable.doraemon),
                    TeamMember("Edward", "Smoker", R.drawable.ic_launcher_background),
                    TeamMember("Randy", "Healer", R.drawable.doraemon),
                    TeamMember("Ryan", "Support", R.drawable.ic_launcher_background),
                ),
                "Team D" to listOf(
                    TeamMember("Luki", "Duelist", R.drawable.doraemon),
                    TeamMember("Matthew", "Smoker", R.drawable.ic_launcher_background),
                    TeamMember("Willy", "Healer", R.drawable.doraemon),
                    TeamMember("Budi", "Support", R.drawable.ic_launcher_background),
                ),
            )
        )
    )
}