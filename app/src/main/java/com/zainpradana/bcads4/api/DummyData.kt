package com.zainpradana.bcads4.api

import com.zainpradana.bcads4.R

object DummyData {

    var titleMovie = arrayOf(
        "A Rainy Day in New York",
        "Sonic the Hedgehod",
        "Ad Astra",
        "Avenger: Endgame"
    )

    var descMovie = arrayOf(
        "Two young people arrive in New York to spend a weekend, but once they arrive they're met with bad weather and a series of adventures.",
        "Mengisahkan petualangan Sonic saat ia belajar tentang kompleksitas kehidupan di bumi bersama manusia sahabat barunya, Tom Wachowski. Sonic dan Tom bersatu untuk menghentikan si jahat Dr. Robotnik yang ingin menangkap Sonic dan menggunakan kekuatan istimewanya untuk menguasai dunia.",
        "Seorang astronot melakukan perjalanan ke tepi luar tata surya untuk menemukan ayahnya dan mengungkap misteri yang mengancam kelangsungan hidup planet kita. Dia mengungkap rahasia yang menantang sifat keberadaan manusia dan tempat kita di kosmos.",
        "Terdampar di luar angkasa tanpa persediaan makanan dan minuman, Tony Stark berusaha mengirim pesan untuk Pepper Potts dimana persediaan oksigen mulai menipis. Sementara itu para Avengers yang tersisa harus menemukan cara untuk mengembalikan 50% mahluk di seluruh dunia yang telah dilenyapkan oleh Thanos."

    )

    var genreMovie = arrayOf(
        "Comedy, Romance",
        "Comedy, Action, Family",
        "Drama, Adventure, Mystery",
        "Action, Time Travel, Avengers"
    )

    var posterMovie = intArrayOf(
        R.drawable.ic_poster_a_rainy_day_in_new_york,
        R.drawable.ic_poster_sonic,
        R.drawable.ic_ad_astra,
        R.drawable.ic_avengers
    )

    var trailerMovie = intArrayOf(
        R.raw.video_a_rainy_day,
        R.raw.video_sonic,
        R.raw.video_sample,
        R.raw.video_sample
    )

    var ratingMovie = floatArrayOf(
        4.0F,
        3.0F,
        2.0F,
        5.0F
    )
}