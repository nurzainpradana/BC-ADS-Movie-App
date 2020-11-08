package com.zainpradana.bcads4.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.zainpradana.bcads4.database.DatabaseContract.NoteColums.*
import com.zainpradana.bcads4.database.DatabaseContract.NoteColums.Companion.DESC
import com.zainpradana.bcads4.database.DatabaseContract.NoteColums.Companion.GENRE
import com.zainpradana.bcads4.database.DatabaseContract.NoteColums.Companion.POSTER
import com.zainpradana.bcads4.database.DatabaseContract.NoteColums.Companion.RATING
import com.zainpradana.bcads4.database.DatabaseContract.NoteColums.Companion.TABLE_NAME
import com.zainpradana.bcads4.database.DatabaseContract.NoteColums.Companion.TITLE
import com.zainpradana.bcads4.database.DatabaseContract.NoteColums.Companion.TRAILER
import com.zainpradana.bcads4.database.DatabaseContract.NoteColums.Companion._ID

internal class DatabaseHelper (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "dbmovie_apps"
        private const val DATABASE_VERSION = 1
        private val SQL_CREATE_TABLE_NOTE = "CREATE TABLE $TABLE_NAME" +
                "( ${_ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " ${TITLE} TEXT NOT NULL, " +
                " ${DESC} TEXT NOT NULL, " +
                " ${GENRE} TEXT NOT NULL, " +
                " ${POSTER} TEXT NOT NULL, " +
                " ${TRAILER} TEXT NOT NULL, " +
                " ${RATING} TEXT NOT NULL)"
    }

    override fun onCreate(p0: SQLiteDatabase) {
        p0.execSQL(SQL_CREATE_TABLE_NOTE)
    }

    override fun onUpgrade(p0: SQLiteDatabase, p1: Int, p2: Int) {
        p0.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(p0)
    }
}