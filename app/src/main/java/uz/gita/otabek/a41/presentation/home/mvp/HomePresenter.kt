package uz.gita.otabek.a41.presentation.home.mvp

import uz.gita.otabek.a41.domain.Repository
import uz.gita.otabek.a41.presentation.home.HomeActivity

class HomePresenter(private val view: HomeActivity, private val model: HomeContracts.Model) :
    HomeContracts.Presenter {
    private var images =
        model.getImage(Repository.getInstance().getSharedPreferences1()!!.getInt("level", 0))

    init {
        loadImages()
    }

    private fun loadImages() {
        val list = listOf(images.img1, images.img2, images.img3, images.img4)
        view.loadImg(list)
        if (Repository.getInstance().getSharedPreferences1()!!.getInt("level", 1) == 1) {
            view.setLevel(1)
        } else view.setLevel(
            Repository.getInstance().getSharedPreferences1()!!.getInt("level", 1) + 1
        )
        view.setMoney(Repository.getInstance().getSharedPreferences1()!!.getInt("money", 0))
    }

    override fun startGame() {
        view.goToMainActivity()
    }

    override fun leaderboard() {
        view.showInfo()
    }

    override fun settings() {
        view.showInfo()
    }

    override fun aboutApp() {
        view.showInfo()
    }

    override fun quit() {
        view.quitGame()
    }
}