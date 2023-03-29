package uz.hamroev.ytlat.ui.test.data

import uz.hamroev.ytlat.R

object TestList {
    val a = R.id.a_answer_tv
    val b = R.id.b_answer_tv
    val c = R.id.c_answer_tv
    val d = R.id.d_answer_tv

    val list = listOf<TestData>(
        TestData("First question", "A", "B", "C", "D", a),
        TestData("Second question", "A", "B", "C", "D", a),
        TestData("Third question", "A", "B", "C", "D", a),
    )
}