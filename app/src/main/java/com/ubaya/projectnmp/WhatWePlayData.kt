package com.ubaya.projectnmp

object WhatWePlayData {
    var whatWePlayDatas: Array<WhatWePlayBank> = arrayOf(
        WhatWePlayBank("Valorant", "Valorant is a FPS game",
            R.drawable.valorant, listOf(
                Achievement("Valorant Championship", 2020, "Team A"),
                Achievement("Valorant Regional Finals", 2021, "Team B"),
                Achievement("Valorant World Cup", 2022, "Team C"),
                Achievement("Valorant Invitational", 2023, "Team D"),
                Achievement("Valorant Pro League", 2024, "Team E"),
            ),
            listOf(
                Team(
                "Team A", listOf(
                    TeamMember("Alice", "Duelist", R.drawable.doraemon),
                    TeamMember("Bob", "Smoker", R.drawable.ic_launcher_background),
                    TeamMember("Alice2", "Healer", R.drawable.doraemon),
                    TeamMember("Bob2", "Support", R.drawable.ic_launcher_background),
                )
                ),
                Team(
                "Team B", listOf(
                    TeamMember("Aaron", "Duelist", R.drawable.doraemon),
                    TeamMember("Oakley", "Smoker", R.drawable.ic_launcher_background),
                    TeamMember("Stanley", "Healer", R.drawable.doraemon),
                    TeamMember("James", "Support", R.drawable.ic_launcher_background),
                )
                ),
                Team(
                "Team C", listOf(
                    TeamMember("Darren", "Duelist", R.drawable.doraemon),
                    TeamMember("Edward", "Smoker", R.drawable.ic_launcher_background),
                    TeamMember("Randy", "Healer", R.drawable.doraemon),
                    TeamMember("Ryan", "Support", R.drawable.ic_launcher_background),
                )
                ),
                Team(
                "Team D", listOf(
                    TeamMember("Luki", "Duelist", R.drawable.doraemon),
                    TeamMember("Matthew", "Smoker", R.drawable.ic_launcher_background),
                    TeamMember("Willy", "Healer", R.drawable.doraemon),
                    TeamMember("Budi", "Support", R.drawable.ic_launcher_background),
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
                        TeamMember("Alice", "Duelist", R.drawable.doraemon),
                        TeamMember("Bob", "Smoker", R.drawable.ic_launcher_background),
                        TeamMember("Alice2", "Healer", R.drawable.doraemon),
                        TeamMember("Bob2", "Support", R.drawable.ic_launcher_background)
                    )
                ),
                Team(
                    "Team B", listOf(
                        TeamMember("Aaron", "Duelist", R.drawable.doraemon),
                        TeamMember("Oakley", "Smoker", R.drawable.ic_launcher_background),
                        TeamMember("Stanley", "Healer", R.drawable.doraemon),
                        TeamMember("James", "Support", R.drawable.ic_launcher_background)
                    )
                ),
                Team(
                    "Team C", listOf(
                        TeamMember("Darren", "Duelist", R.drawable.doraemon),
                        TeamMember("Edward", "Smoker", R.drawable.ic_launcher_background),
                        TeamMember("Randy", "Healer", R.drawable.doraemon),
                        TeamMember("Ryan", "Support", R.drawable.ic_launcher_background),
                    )
                ),
                Team(
                    "Team D", listOf(
                        TeamMember("Luki", "Duelist", R.drawable.doraemon),
                        TeamMember("Matthew", "Smoker", R.drawable.ic_launcher_background),
                        TeamMember("Willy", "Healer", R.drawable.doraemon),
                        TeamMember("Budi", "Support", R.drawable.ic_launcher_background)
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
                    TeamMember("Alice", "Duelist", R.drawable.doraemon),
                    TeamMember("Bob", "Smoker", R.drawable.ic_launcher_background),
                    TeamMember("Alice2", "Healer", R.drawable.doraemon),
                    TeamMember("Bob2", "Support", R.drawable.ic_launcher_background),
                )
                ),
                Team(
                "Team B", listOf(
                    TeamMember("Aaron", "Duelist", R.drawable.doraemon),
                    TeamMember("Oakley", "Smoker", R.drawable.ic_launcher_background),
                    TeamMember("Stanley", "Healer", R.drawable.doraemon),
                    TeamMember("James", "Support", R.drawable.ic_launcher_background),
                )
                ),
                Team(
                "Team C", listOf(
                    TeamMember("Darren", "Duelist", R.drawable.doraemon),
                    TeamMember("Edward", "Smoker", R.drawable.ic_launcher_background),
                    TeamMember("Randy", "Healer", R.drawable.doraemon),
                    TeamMember("Ryan", "Support", R.drawable.ic_launcher_background),
                )
                ),
                Team(
                "Team D", listOf(
                    TeamMember("Luki", "Duelist", R.drawable.doraemon),
                    TeamMember("Matthew", "Smoker", R.drawable.ic_launcher_background),
                    TeamMember("Willy", "Healer", R.drawable.doraemon),
                    TeamMember("Budi", "Support", R.drawable.ic_launcher_background),
                )
                )
            )
        )
    )
}