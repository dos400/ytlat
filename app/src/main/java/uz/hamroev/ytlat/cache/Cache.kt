package uz.hamroev.ytlat.cache

import android.content.Context
import android.content.SharedPreferences

object Cache {

    private const val NAME = "ytlat"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var language: String?
        get() = sharedPreferences.getString("language", "uz")
        set(value) = sharedPreferences.edit() {
            if (value != null) {
                it.putString("language", value)
            }
        }

    var position: Int?
        get() = sharedPreferences.getInt("position", 0)
        set(value) = sharedPreferences.edit() {
            if (value != null) {
                it.putInt("position", value)
            }
        }

    var filterName: String?
        get() = sharedPreferences.getString("filtername", "None")
        set(value) = sharedPreferences.edit() {
            if (value != null) {
                it.putString("filtername", value)
            }
        }

    var mavzuNumber: String?
        get() = sharedPreferences.getString("mavzunomi", "None")
        set(value) = sharedPreferences.edit() {
            if (value != null) {
                it.putString("mavzunomi", value)
            }
        }

    var pageName: String?
        get() = sharedPreferences.getString("pageName", "None")
        set(value) = sharedPreferences.edit() {
            if (value != null) {
                it.putString("pageName", value)
            }
        }


}

