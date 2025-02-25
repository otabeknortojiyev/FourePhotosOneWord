package uz.gita.otabek.a41.data

import android.app.Application
import android.content.SharedPreferences
import uz.gita.otabek.a41.domain.Repository

class App : Application() {
  private var sharedPreferences: SharedPreferences? = null

  override fun onCreate() {
    super.onCreate()
    sharedPreferences = getSharedPreferences("app", MODE_PRIVATE)
    Repository.getInstance().setSharedPreferences1(sharedPreferences!!)
  }
}