package uz.gita.otabek.a41.domain

import android.content.SharedPreferences

class Repository private constructor() {

  companion object {
    private var instance: Repository? = null
    fun getInstance(): Repository {
      if (instance == null) {
        instance = Repository()
      }
      return instance!!
    }
  }

  private var sharedPreferences: SharedPreferences? = null

  fun setSharedPreferences1(sharedPreferences: SharedPreferences) {
    this.sharedPreferences = sharedPreferences
  }

  fun getSharedPreferences1(): SharedPreferences? {
    return sharedPreferences
  }
}