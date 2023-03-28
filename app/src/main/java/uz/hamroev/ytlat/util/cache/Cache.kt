package uz.hamroev.ytlat.util.cache

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

    var currency: String?
        get() = sharedPreferences.getString("currency", "usd")
        set(value) = sharedPreferences.edit() {
            if (value != null) {
                it.putString("currency", value)
            }
        }



}
