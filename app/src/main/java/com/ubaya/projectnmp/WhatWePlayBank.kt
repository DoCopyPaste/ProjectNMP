package com.ubaya.projectnmp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable
import java.util.Dictionary

@Parcelize
data class Team(val name: String, val teamMember: List<TeamMember>):Parcelable
@Parcelize
data class TeamMember(val name: String, val role: String, val imageId: Int) : Parcelable
@Parcelize
data class Achievement(val name: String, val year: Int, val team: String) : Parcelable

data class WhatWePlayBank(var title:String, var description:String, var imageId:Int, var achievements:List<Achievement>, var teams:List<Team>) {

}