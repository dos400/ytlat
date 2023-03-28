package uz.hamroev.ytlat.app

import android.app.Application
import uz.hamroev.ytlat.cache.Cache

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Cache.init(this)
    }
}