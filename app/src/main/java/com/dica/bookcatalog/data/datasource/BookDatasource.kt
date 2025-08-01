package com.dica.bookcatalog.data.datasource

import com.dica.bookcatalog.data.model.Book

object BookDatasource {

    private val allBooksInternal = listOf(
        Book(
            id = "1",
            title = "1984",
            author = "Джордж Оруэлл",
            description = "Антиутопический роман о тоталитарном обществе и контроле над личностью. Книга исследует темы пропаганды, надзора и индивидуальной свободы.",
            category = "Антиутопия",
            coverImageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/1984first.jpg/220px-1984first.jpg",
            yearPublished = 1949,
            pageCount = 328,
            rating = 4.5f
        ),
        Book(
            id = "2",
            title = "Мастер и Маргарита",
            author = "Михаил Булгаков",
            description = "Сатирический роман о визите дьявола в Москву 1930-х годов. Переплетает библейские мотивы с советской реальностью.",
            category = "Классика",
            coverImageUrl = "https://upload.wikimedia.org/wikipedia/ru/thumb/8/89/%D0%9C%D0%B0%D1%81%D1%82%D0%B5%D1%80_%D0%B8_%D0%9C%D0%B0%D1%80%D0%B3%D0%B0%D1%80%D0%B8%D1%82%D0%B0_-_%D0%BF%D0%B5%D1%80%D0%B2%D0%BE%D0%B5_%D0%B8%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5.jpg/242px-%D0%9C%D0%B0%D1%81%D1%82%D0%B5%D1%80_%D0%B8_%D0%9C%D0%B0%D1%80%D0%B3%D0%B0%D1%80%D0%B8%D1%82%D0%B0_-_%D0%BF%D0%B5%D1%80%D0%B2%D0%BE%D0%B5_%D0%B8%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5.jpg",
            yearPublished = 1967,
            pageCount = 480,
            rating = 4.8f
        ),
        Book(
            id = "3",
            title = "Гарри Поттер и философский камень",
            author = "Дж. К. Роулинг",
            description = "Первая книга о мальчике-волшебнике Гарри Поттере, который узнает о своем магическом происхождении и отправляется в школу Хогвартс.",
            category = "Фэнтези",
            coverImageUrl = "https://upload.wikimedia.org/wikipedia/ru/thumb/c/c5/Harry_Potter_and_the_Philosopher%27s_Stone_%E2%80%93_original_Bloomsbury_UK_front_cover.jpg/230px-Harry_Potter_and_the_Philosopher%27s_Stone_%E2%80%93_original_Bloomsbury_UK_front_cover.jpg",
            yearPublished = 1997,
            pageCount = 223,
            rating = 4.9f
        ),
        Book(
            id = "4",
            title = "Преступление и наказание",
            author = "Федор Достоевский",
            description = "Психологический роман о студенте Родконе Раскольникове, который совершает убийство старухи-процентщицы и пытается оправдать свой поступок.",
            category = "Классика",
            coverImageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/49/Dostoevsky_Prestuplenie_i_nakazanie_1870_vol_1.jpg/220px-Dostoevsky_Prestuplenie_i_nakazanie_1870_vol_1.jpg", // Другая обложка
            yearPublished = 1866,
            pageCount = 671,
            rating = 4.6f
        ),
        Book(
            id = "5",
            title = "Алхимик",
            author = "Пауло Коэльо",
            description = "Притча о пастухе Сантьяго, который отправляется на поиски сокровищ, спрятанных у египетских пирамид, и находит свою Судьбу.",
            category = "Приключения",
            coverImageUrl = "https://upload.wikimedia.org/wikipedia/ru/thumb/c/c0/CoelhoAlchemist.jpg/231px-CoelhoAlchemist.jpg",
            yearPublished = 1988,
            pageCount = 163,
            rating = 4.3f
        ),
        Book(
            id = "6",
            title = "Код да Винчи",
            author = "Дэн Браун",
            description = "Интеллектуальный детективный триллер, в котором гарвардский профессор Роберт Лэнгдон расследует убийство в Лувре и раскрывает древний заговор.",
            category = "Детектив",
            coverImageUrl = "https://upload.wikimedia.org/wikipedia/ru/thumb/6/65/DaVinciCode.jpg/235px-DaVinciCode.jpg",
            yearPublished = 2003,
            pageCount = 454,
            rating = 4.2f
        ),
        Book(
            id = "7",
            title = "Властелин колец: Братство Кольца",
            author = "Дж. Р. Р. Толкин",
            description = "Начало эпической саги о Средиземье, где хоббит Фродо Бэггинс наследует Кольцо Всевластия и отправляется в опасное путешествие, чтобы уничтожить его.",
            category = "Фэнтези",
            coverImageUrl = "https://upload.wikimedia.org/wikipedia/ru/thumb/0/0e/The_Fellowship_of_the_Ring_cover.jpg/230px-The_Fellowship_of_the_Ring_cover.jpg",
            yearPublished = 1954,
            pageCount = 423,
            rating = 4.9f
        )
    )
}