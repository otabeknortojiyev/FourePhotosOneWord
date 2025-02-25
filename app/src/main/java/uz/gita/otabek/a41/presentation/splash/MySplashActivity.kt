package uz.gita.otabek.a41.presentation.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import uz.gita.otabek.a41.R
import uz.gita.otabek.a41.presentation.home.HomeActivity

@SuppressLint("CustomSplashScreen")
class MySplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startTimer()
    }

    private fun startTimer() {

        val timer = object : CountDownTimer(2500, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                goToMainActivity()
            }
        }
        timer.start()
    }

    fun goToMainActivity() {
        startActivity(Intent(this@MySplashActivity, HomeActivity::class.java))
        finish()
    }

    override fun onBackPressed() {

    }
}