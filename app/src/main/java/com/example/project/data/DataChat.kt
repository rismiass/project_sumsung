package com.example.project.data

import com.example.project.R
import com.example.project.model.Chat

class DataChat {

    public fun loadList() : ArrayList<Chat> {
        return arrayListOf(
            Chat("Mcdonalds", "Здравствуйте. Приглашаем вас...", R.drawable.mak),
            Chat("МТС", "Здравствуйте. Приглашаем вас...", R.drawable.mtc),
            Chat("Детский мир", "Здравствуйте. Приглашаем вас...", R.drawable.world)
        )
    }
}

