package uz.hamroev.ytlat.ui.test.data

import android.content.Context
import android.util.Log
import uz.hamroev.ytlat.R
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

object TestList {
    val a = R.id.a_answer_tv
    val b = R.id.b_answer_tv
    val c = R.id.c_answer_tv
    val d = R.id.d_answer_tv

    val list = arrayListOf<TestData>()

    fun loadQuestionsFromAssets(context: Context): List<TestData> {
        var reader:BufferedReader? = null;
        try {
            reader = BufferedReader(
                    InputStreamReader(context.assets.open("test_list.txt"), "UTF-8")
            );
            // do reading, usually loop until end of file reading
            val text = reader.readLines()
            text.forEachIndexed {index, str ->
                if (index % 8 == 0) {
                    list.add(TestData(str, "", "", "", "", 0))
                } else if (index % 8 == 2) {
                    if(str.startsWith("~")) {
                        list[index / 8].a = str.removePrefix("~")
                    } else if (str.startsWith("=")) {
                        list[index / 8].a = str.removePrefix("=")
                        list[index / 8].correctAnswer = a
                    }
                } else if (index % 8 == 3) {
                    if(str.startsWith("~")) {
                        list[index / 8].b = str.removePrefix("~")
                    } else if (str.startsWith("=")) {
                        list[index / 8].b = str.removePrefix("=")
                        list[index / 8].correctAnswer = b
                    }
                } else if (index % 8 == 4) {
                    if(str.startsWith("~")) {
                        list[index / 8].c = str.removePrefix("~")
                    } else if (str.startsWith("=")) {
                        list[index / 8].c = str.removePrefix("=")
                        list[index / 8].correctAnswer = c
                    }
                } else if (index % 8 == 5) {
                    if(str.startsWith("~")) {
                        list[index / 8].d = str.removePrefix("~")
                    } else if (str.startsWith("=")) {
                        list[index / 8].d = str.removePrefix("=")
                        list[index / 8].correctAnswer = d
                    }
                }
            }
        } catch (ex: IOException) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (ex:IOException) {
                    //log the exception
                }
            }
        }
        return list
    }
}