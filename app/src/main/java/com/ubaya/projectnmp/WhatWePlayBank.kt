package com.ubaya.projectnmp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable
import java.util.Dictionary

@Parcelize
data class Team(var idTeam: Int, var name: String) : Parcelable
@Parcelize
data class TeamMember(var idMember: Int, var name: String, var description: String) : Parcelable
@Parcelize
data class Achievement(var name: String, var year: Int, var team: String) : Parcelable
@Parcelize
data class Game(var idGame: Int, var name: String, var description: String) : Parcelable


