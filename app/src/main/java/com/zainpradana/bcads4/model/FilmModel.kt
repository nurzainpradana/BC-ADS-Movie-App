package com.zainpradana.bcads4.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FilmModel(
    var id: Int ?= 0,
    var judul: String ?= "",
    var desc: String ?= "",
    var genre: String ?= "",
    var poster: Int ?= 0,
    var trailer: Int ?= 0,
    var rating: Float
) : Parcelable
