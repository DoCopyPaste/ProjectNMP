package com.ubaya.projectnmp

import java.util.Date
import java.text.SimpleDateFormat
import java.util.Locale

object OurScheduleData {
    // Fungsi untuk parsing tanggal dan waktu dari string
    fun parseDate(dateString: String): java.sql.Date {
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US)  // Format tanggal dengan jam
        val utilDate = format.parse(dateString)  // Menghasilkan java.util.Date
        return java.sql.Date(utilDate.time)  // Konversi ke java.sql.Date
    }

    // Fungsi untuk memformat Date ke format yang diinginkan (contoh: "05 SEP")
    fun getFormattedDate(date: Date): String {
        //val targetFormat = SimpleDateFormat("dd MMMM yyyy", Locale.US)
        val targetFormat = SimpleDateFormat("dd MMM yyyy", Locale.US)
        val formattedDate = targetFormat.format(date)
        return formattedDate.substring(0, 6).uppercase()
    }

    // Fungsi untuk mengambil jam dalam format "hh:mm a" (12-hour format dengan AM/PM)
    fun getFormattedTime(date: Date): String {
        val timeFormat = SimpleDateFormat("hh:mm a", Locale.US)  // Format jam 12 dengan AM/PM
        return timeFormat.format(date)
    }
    var ourScheduleDatas: Array<OurScheduleBank> = arrayOf(
        OurScheduleBank(
            "Valorant",
            "This is a regional qualifier for valorant team A. The tense become more powerful then even, sit tight and bring your popcorn to watch an intense combat.",
            "Los Angeles, CA",
            parseDate("2024-09-05 10:00"),
            "Regional Qualifier",
            "Team A",
            R.drawable.valorant
        ),
        OurScheduleBank(
            "LOL",
            "This is a workshop for LOL team C. The tense become more powerful then even, sit tight and bring your popcorn to watch an intense combat.",
            "Los Angeles, CA",
            parseDate("2024-09-10 10:00"),
            "League of Legends Workshop 1",
            "Team C",
            R.drawable.lol
        ),
        OurScheduleBank(
            "COD",
            "This is a regional qualifier for COD team A. The tense become more powerful then even, sit tight and bring your popcorn to watch an intense combat.",
            "Los Angeles, CA",
            parseDate("2024-10-07 10:00"),
            "Call of Duty Championship",
            "Team A",
            R.drawable.cod
        ),
        OurScheduleBank(
            "Valorant",
            "This is a regional final for valorant team B. The tense become more powerful then even, sit tight and bring your popcorn to watch an intense combat.",
            "Los Angeles, CA",
            parseDate("2024-10-12 10:00"),
            "Regional Final",
            "Team B",
            R.drawable.valorant
        ),
        OurScheduleBank(
            "LOL",
            "This is a workshop for LOL team C. The tense become more powerful then even, sit tight and bring your popcorn to watch an intense combat.",
            "Los Angeles, CA",
            parseDate("2024-10-30 10:00"),
            "League of Legends Workshop 2",
            "Team C",
            R.drawable.lol
        ),
        OurScheduleBank(
            "Valorant",
            "This high-stakes event will bring together top teams from across the region, all competing for a chance to advance to the national finals. Expect intense gameplay, strategic plays, and thrilling moments as teams battle it out in one of the most popular first-person shooters.",
            "Los Angeles, CA",
            parseDate("2024-11-01 10:00"),
            "Valorant Championship",
            "Team C",
            R.drawable.valorant
        )
    )
}