package com.zainpradana.bcads4.utils

import android.content.Context
import com.zainpradana.bcads4.utils.Const.NAMA_USER
import com.zainpradana.bcads4.utils.Const.PREF_NAME
import com.zainpradana.bcads4.utils.Const.STATUS_USER

class UserPreference (context: Context) {
    private val preference = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun setStatusUser(value: Boolean) {
        val editor = preference.edit()
        editor.putBoolean(STATUS_USER, value)
        editor.apply()
    }

    fun getStatusUser(): Boolean {
        return preference.getBoolean(STATUS_USER, false)
    }

    fun setNamaUser(value: String) {
        val editor = preference.edit()
        editor.putString(NAMA_USER, value)
        editor.apply()
    }

    fun getNamaUser(): String? {
        return preference.getString(NAMA_USER, "")
    }
}