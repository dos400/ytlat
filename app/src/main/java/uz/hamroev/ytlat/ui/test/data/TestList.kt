package uz.hamroev.ytlat.ui.test.data

import android.content.Context
import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
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

    fun loadQuestionsFromAssets(context: Context): Flow<List<TestData>> {
        list.clear()
        return flow {
            var reader: BufferedReader? = null;
            try {
                reader = BufferedReader(
                    InputStreamReader(context.assets.open("test_list.txt"), "UTF-8")
                );
                // do reading, usually loop until end of file reading
                val text = reader.readLines()
                text.forEachIndexed { index, str ->
                    if (index % 8 == 0) {
                        list.add(TestData(str, arrayListOf()))
                    } else if (index % 8 == 2) {
                        if (str.startsWith("~")) {
                            list[index / 8].answers.add(Variant(str.removePrefix("~"), false))
                        } else if (str.startsWith("=")) {
                            list[index / 8].answers.add(Variant(str.removePrefix("="), true))
                        }
                    } else if (index % 8 == 3) {
                        if (str.startsWith("~")) {
                            list[index / 8].answers.add(Variant(str.removePrefix("~"), false))
                        } else if (str.startsWith("=")) {
                            list[index / 8].answers.add(Variant(str.removePrefix("="), true))
                        }
                    } else if (index % 8 == 4) {
                        if (str.startsWith("~")) {
                            list[index / 8].answers.add(Variant(str.removePrefix("~"), false))
                        } else if (str.startsWith("=")) {
                            list[index / 8].answers.add(Variant(str.removePrefix("="), true))
                        }
                    } else if (index % 8 == 5) {
                        if (str.startsWith("~")) {
                            list[index / 8].answers.add(Variant(str.removePrefix("~"), false))
                        } else if (str.startsWith("=")) {
                            list[index / 8].answers.add(Variant(str.removePrefix("="), true))
                        }
                    }
                }
            } catch (ex: IOException) {
                //log the exception
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (ex: IOException) {
                        //log the exception
                    }
                }
            }
            emit(list)
        }
    }
}