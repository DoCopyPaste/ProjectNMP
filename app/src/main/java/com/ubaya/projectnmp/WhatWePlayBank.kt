package com.ubaya.projectnmp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable
import java.util.Dictionary

@Parcelize
data class Team(var idTeam: Int, var name: String, var teamMember: List<TeamMember>) : Parcelable
@Parcelize
data class TeamMember(var idMember: Int, var name: String, var role: String, var imageId: Int) : Parcelable
@Parcelize
data class Achievement(var idAchievement: Int, var name: String, var year: Int, var team: String) : Parcelable
@Parcelize
data class Game(var idGame: Int, var name: String, var description: String) : Parcelable


