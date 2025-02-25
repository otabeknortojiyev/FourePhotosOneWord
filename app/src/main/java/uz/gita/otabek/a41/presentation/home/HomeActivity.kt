package uz.gita.otabek.a41.presentation.home

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import uz.gita.otabek.a41.R
import uz.gita.otabek.a41.presentation.home.mvp.HomeContracts
import uz.gita.otabek.a41.presentation.home.mvp.HomeModel
import uz.gita.otabek.a41.presentation.home.mvp.HomePresenter
import uz.gita.otabek.a41.presentation.main.MainActivity

class HomeActivity : AppCompatActivity(), HomeContracts.View {
    private lateinit var presenter: HomeContracts.Presenter
    private lateinit var startGame: LinearLayout
    private lateinit var leaderboard: LinearLayout
    private lateinit var settings: LinearLayout
    private lateinit var aboutApp: LinearLayout
    private lateinit var quit: LinearLayout

    private lateinit var img1: ImageView
    private lateinit var img2: ImageView
    private lateinit var img3: ImageView
    private lateinit var img4: ImageView

    private lateinit var moneys: AppCompatButton
    private lateinit var levels: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        init()
        setActions()
    }

    private fun init() {
        startGame = findViewById(R.id.startGame)
        leaderboard = findViewById(R.id.results)
        settings = findViewById(R.id.settings)
        aboutApp = findViewById(R.id.about_app)
        quit = findViewById(R.id.quit)
        img1 = findViewById(R.id.iv1_2)
        img2 = findViewById(R.id.iv2_2)
        img3 = findViewById(R.id.iv3_2)
        img4 = findViewById(R.id.iv4_2)
        moneys = findViewById(R.id.score2)
        levels = findViewById(R.id.level2)

        presenter = HomePresenter(this, HomeModel())
    }

    private fun setActions() {
        startGame.setOnClickListener {
            presenter.startGame()
        }
        leaderboard.setOnClickListener {
            presenter.leaderboard()
        }
        settings.setOnClickListener {
            presenter.settings()
        }
        aboutApp.setOnClickListener {
            presenter.aboutApp()
        }
        quit.setOnClickListener {
            presenter.quit()
        }
    }

    override fun showInfo() {
        Toast.makeText(this, "Скоро будет!!!", Toast.LENGTH_SHORT).show()
    }

    override fun loadImg(list: List<Int>) {
        img1.setImageResource(list[0])
        img2.setImageResource(list[1])
        img3.setImageResource(list[2])
        img4.setImageResource(list[3])
    }

    override fun goToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun goToResultsActivity() {
        TODO("Not yet implemented")
    }

    override fun goToSettingsActivity() {
        TODO("Not yet implemented")
    }

    override fun goToAboutAppActivity() {
        TODO("Not yet implemented")
    }

    override fun quitGame() {
        finishAffinity()
    }

    override fun setLevel(level: Int) {
        levels.text = level.toString()
    }

    override fun setMoney(money: Int) {
        moneys.text = money.toString()
    }
}