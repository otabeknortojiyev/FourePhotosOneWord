package uz.gita.otabek.a41.presentation.gameover

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.gita.otabek.a41.R
import uz.gita.otabek.a41.presentation.gameover.mvp.GameOverContracts
import uz.gita.otabek.a41.presentation.gameover.mvp.GameOverModel
import uz.gita.otabek.a41.presentation.gameover.mvp.GameOverPresenter
import uz.gita.otabek.a41.presentation.home.HomeActivity

class GameOverActivity : AppCompatActivity(), GameOverContracts.View {
    private lateinit var presenter: GameOverContracts.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)
        init()
    }

    private fun init() {
        presenter = GameOverPresenter(this, GameOverModel())
        presenter.startTimer()
    }

    override fun goToHomeActivity() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}