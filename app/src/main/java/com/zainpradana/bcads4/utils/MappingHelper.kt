package com.zainpradana.bcads4.utils

import android.database.Cursor
import com.zainpradana.bcads4.database.DatabaseContract
import com.zainpradana.bcads4.database.DatabaseContract.NoteColums.Companion.DESC
import com.zainpradana.bcads4.database.DatabaseContract.NoteColums.Companion.GENRE
import com.zainpradana.bcads4.database.DatabaseContract.NoteColums.Companion.POSTER
import com.zainpradana.bcads4.database.DatabaseContract.NoteColums.Companion.RATING
import com.zainpradana.bcads4.database.DatabaseContract.NoteColums.Companion.TITLE
import com.zainpradana.bcads4.database.DatabaseContract.NoteColums.Companion.TRAILER
import com.zainpradana.bcads4.database.DatabaseContract.NoteColums.Companion._ID
import com.zainpradana.bcads4.model.FilmModel

object MappingHelper {

    fun mapCursorToArrayList(notesCursor: Cursor?): ArrayList<FilmModel> {
        val noteList = ArrayList<FilmModel>()
        notesCursor?.apply {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(_ID))
                val title = getString(getColumnIndexOrThrow(TITLE))
                val desc = getString(getColumnIndexOrThrow(DESC))
                val genre = getString(getColumnIndexOrThrow(GENRE))
                val poster = getInt(getColumnIndexOrThrow(POSTER))
                val trailer = getInt(getColumnIndexOrThrow(TRAILER))
                val rate = getFloat(getColumnIndexOrThrow(RATING))
                noteList.add(FilmModel(id, title, desc, genre, poster, trailer, rate))
            }
        }
        return noteList
    }
}