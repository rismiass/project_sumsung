package app.data

import app.model.dataclasses.ItemSettings

class DataSettingsMain {
    public  fun loadList(): ArrayList<ItemSettings> {
        return arrayListOf(
            ItemSettings("Фамилия", "Сапрыкин"),
            ItemSettings("Имя", "Константин"),
            ItemSettings("Отчество", "Дмитриевич"),
            ItemSettings("Электронная почта", "saprikostya@gmail.com"),
            ItemSettings("Номер телефона", "+7(981)590069")
        )

    }

}