package com.example.todoapp.ui.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale


object Utils {

    fun formatDate(millis: Long?): String {
        if (millis == null) return ""

        val formatter = SimpleDateFormat(
            "dd/MM/yyyy",
            Locale.getDefault()
        )

        return formatter.format(Date(millis))
    }



    fun formatTime(
        hour: Int,
        minute: Int
    ): String {

        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
        }

        val formatter = SimpleDateFormat(
            "hh:mm a",
            Locale.getDefault()
        )

        return formatter.format(calendar.time)
    }
}
