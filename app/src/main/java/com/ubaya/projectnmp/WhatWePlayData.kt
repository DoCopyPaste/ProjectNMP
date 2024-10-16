package com.ubaya.projectnmp

object WhatWePlayData {
    var whatWePlayDatas: Array<WhatWePlayBank> = arrayOf(
        WhatWePlayBank("Valorant", "Valorant is a FPS game",
            R.drawable.valorant, listOf(
                Achievement("Valorant Championship", 2020, "Team A"),
                Achievement("Valorant Regional Finals", 2021, "Team B"),
                Achievement("Valorant World Cup", 2022, "Team C"),
                Achievement("Valorant Invitational", 2022, "Team D"),
                Achievement("Valorant Pro League", 2024, "Team E"),
            ),
            listOf(
                Team(
                "Team A", listOf(
                    TeamMember("Alice", "Duelist", R.drawable.pp),
                    TeamMember("Bob", "Smoker", R.drawable.pp_1),
                    TeamMember("Alice2", "Healer", R.drawable.pp_2),
                    TeamMember("Bob2", "Support", R.drawable.pp_3),
                )
                ),
                Team(
                "Team B", listOf(
                    TeamMember("Aaron", "Duelist", R.drawable.pp),
                    TeamMember("Oakley", "Smoker", R.drawable.pp_2),
                    TeamMember("Stanley", "Healer", R.drawable.pp_3),
                    TeamMember("James", "Support", R.drawable.pp_1),
                )
                ),
                Team(
                "Team C", listOf(
                    TeamMember("Darren", "Duelist", R.drawable.pp_1),
                    TeamMember("Edward", "Smoker", R.drawable.pp),
                    TeamMember("Randy", "Healer", R.drawable.pp_2),
                    TeamMember("Ryan", "Support", R.drawable.pp_3),
                )
                ),
                Team(
                "Team D", listOf(
                    TeamMember("Luki", "Duelist", R.drawable.pp),
                    TeamMember("Matthew", "Smoker", R.drawable.pp_1),
                    TeamMember("Willy", "Healer", R.drawable.pp_3),
                    TeamMember("Budi", "Support", R.drawable.pp_2),
                )
                )
            )
        ),
        WhatWePlayBank("Mobile Legends", "Mobile legends is a MOBA game",
            R.drawable.mobilelegends, listOf(
                Achievement("Mobile Legends National Tournament", 2020, "Team A"),
                Achievement("Mobile Legends Southeast Asia Championship", 2021, "Team B"),
                Achievement("Mobile Legends World Series", 2021, "Team C"),
                Achievement("Mobile Legends Invitational", 2022, "Team D"),
                Achievement("Mobile Legends Pro League", 2022, "Team E"),
                ), listOf(
                Team(
                    "Team A", listOf(
                        TeamMember("Alice", "Duelist", R.drawable.pp),
                        TeamMember("Bob", "Smoker", R.drawable.pp_1),
                        TeamMember("Alice2", "Healer", R.drawable.pp_2),
                        TeamMember("Bob2", "Support", R.drawable.pp_3)
                    )
                ),
                Team(
                    "Team B", listOf(
                        TeamMember("Aaron", "Duelist", R.drawable.pp_1),
                        TeamMember("Oakley", "Smoker", R.drawable.pp),
                        TeamMember("Stanley", "Healer", R.drawable.pp_2),
                        TeamMember("James", "Support", R.drawable.pp_3)
                    )
                ),
                Team(
                    "Team C", listOf(
                        TeamMember("Darren", "Duelist", R.drawable.pp_3),
                        TeamMember("Edward", "Smoker", R.drawable.pp_2),
                        TeamMember("Randy", "Healer", R.drawable.pp_1),
                        TeamMember("Ryan", "Support", R.drawable.pp),
                    )
                ),
                Team(
                    "Team D", listOf(
                        TeamMember("Luki", "Duelist", R.drawable.pp_1),
                        TeamMember("Matthew", "Smoker", R.drawable.pp_2),
                        TeamMember("Willy", "Healer", R.drawable.pp),
                        TeamMember("Budi", "Support", R.drawable.pp_3)
                    )
                )
            )
        ),

        WhatWePlayBank("PUBG", "PUBG is a TPS game",
            R.drawable.pubg, listOf(
                Achievement("PUBG Global Championship", 2019, "Team A"),
                Achievement("PUBG Continental Series", 2020, "Team B"),
                Achievement("PUBG Invitational", 2020, "Team C"),
                Achievement("PUBG Masters", 2021, "Team D"),
                Achievement("PUBG Mobile World League", 2021, "Team E"),
                ), listOf(
                Team(
                "Team A", listOf(
                    TeamMember("Alice", "Duelist", R.drawable.pp_1),
                    TeamMember("Bob", "Smoker", R.drawable.pp),
                    TeamMember("Alice2", "Healer", R.drawable.pp_2),
                    TeamMember("Bob2", "Support", R.drawable.pp_3),
                )
                ),
                Team(
                "Team B", listOf(
                    TeamMember("Aaron", "Duelist", R.drawable.pp_1),
                    TeamMember("Oakley", "Smoker", R.drawable.pp),
                    TeamMember("Stanley", "Healer", R.drawable.pp_2),
                    TeamMember("James", "Support", R.drawable.pp_3),
                )
                ),
                Team(
                "Team C", listOf(
                    TeamMember("Darren", "Duelist", R.drawable.pp_1),
                    TeamMember("Edward", "Smoker", R.drawable.pp_2),
                    TeamMember("Randy", "Healer", R.drawable.pp_3),
                    TeamMember("Ryan", "Support", R.drawable.pp),
                )
                ),
                Team(
                "Team D", listOf(
                    TeamMember("Luki", "Duelist", R.drawable.pp_1),
                    TeamMember("Matthew", "Smoker", R.drawable.pp_3),
                    TeamMember("Willy", "Healer", R.drawable.pp_2),
                    TeamMember("Budi", "Support", R.drawable.pp),
                )
                )
            )
        )
    )
}