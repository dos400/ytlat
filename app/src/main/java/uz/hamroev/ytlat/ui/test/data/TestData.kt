package uz.hamroev.ytlat.ui.test.data

data class TestData(
    val question: String,
    var answers:ArrayList<Variant>,
    var selectedAnswer: Int = -1
)

typealias Variant = Pair<String, Boolean>
