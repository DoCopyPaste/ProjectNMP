package com.ubaya.projectnmp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.sql.Date

@Parcelize

data class Event(var game:String, var description:String, var schedule:java.util.Date, var title:String, var team:String, var imageId:Int) : Parcelable