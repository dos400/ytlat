package uz.hamroev.ytlat.util

sealed class Resource {

    object Loading : Resource()

    data class Success<out T>(val data: T?) : Resource()

    data class Error<out T>(val message: T) : Resource()


}
