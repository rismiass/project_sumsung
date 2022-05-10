package com.example.project.data

import com.example.project.R
import com.example.project.model.Course

class DataCourse {

    public fun loadList() : ArrayList<Course> {
        return arrayListOf(
            Course("Профильная математика", "10 000 рублей", R.drawable.matematika),
            Course("Русский язык", "350 рублей/час", R.drawable.russian_language),
            Course("Английский язык", "500 рублей/час", R.drawable.english),
            Course("Дизайн", "2000 рублей/час", R.drawable.design),
            )
    }
}
