package com.ubaya.projectnmp

import java.io.Serializable
import java.util.Dictionary

data class TeamMember(val name: String, val role: String, val imageId: Int) : Serializable
data class WhatWePlayBank(var title:String, var description:String, var imageId:Int, var achievements:List<Map<String, Any>>, var teams:Map<String, List<TeamMember>>) {

}