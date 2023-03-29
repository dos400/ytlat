package uz.hamroev.ytlat.ui.test.data

data class TestData(
    val question: String,
    val a: String,
    val b: String,
    val c: String,
    val d: String,
    val correctAnswer: Int,
    var selectedAnswer: Int = -1
)
