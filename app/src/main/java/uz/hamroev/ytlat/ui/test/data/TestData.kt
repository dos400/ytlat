package uz.hamroev.ytlat.ui.test.data

data class TestData(
    val question: String,
    var a: String,
    var b: String,
    var c: String,
    var d: String,
    var correctAnswer: Int,
    var selectedAnswer: Int = -1
)
