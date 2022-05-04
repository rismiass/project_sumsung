package com.example.project.data

import com.example.project.R
import com.example.project.model.Advertisement

class DataAdvertisement {

    public fun loadList() : ArrayList<Advertisement> {
        return arrayListOf(Advertisement("Официант", "250 рублей/час", "Пятница, Воскресенье", R.drawable.waiter),
        Advertisement("Администратор", "350 рублей/час", "Вторник, Четверг", R.drawable.administrator),
        Advertisement("Няня", "200 рублей/час", "Понедельник, Среда", R.drawable.nunny),
            Advertisement("Няня", "200 рублей/час", "Понедельник, Среда", R.drawable.nunny),
            Advertisement("Няня", "200 рублей/час", "Понедельник, Среда", R.drawable.nunny),
            Advertisement("Няня", "200 рублей/час", "Понедельник, Среда", R.drawable.nunny),
            Advertisement("Няня", "200 рублей/час", "Понедельник, Среда", R.drawable.nunny),
            Advertisement("Няня", "200 рублей/час", "Понедельник, Среда", R.drawable.nunny),
            Advertisement("Няня", "200 рублей/час", "Понедельник, Среда", R.drawable.nunny),
            Advertisement("Няня", "200 рублей/час", "Понедельник, Среда", R.drawable.nunny),Advertisement("Няня", "200 рублей/час", "Понедельник, Среда", R.drawable.nunny),


        Advertisement("Промоутер", "150 рублей/час", "Среда, Суббота", R.drawable.promoter))
    }
}