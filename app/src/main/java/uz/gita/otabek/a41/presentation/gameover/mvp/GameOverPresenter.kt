package uz.gita.otabek.a41.presentation.gameover.mvp

import android.os.CountDownTimer
import uz.gita.otabek.a41.domain.Repository

class GameOverPresenter(
    private val view: GameOverContracts.View,
    private val model: GameOverContracts.Model
) : GameOverContracts.Presenter {
    override fun startTimer() {
        val timer = object : CountDownTimer(4000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                Repository.getInstance().getSharedPreferences1()!!.edit().putInt("level", 0).apply()
                view.goToHomeActivity()
            }
        }
        timer.start()
    }
}