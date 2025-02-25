package uz.gita.otabek.a41.presentation.home.mvp

import uz.gita.otabek.a41.data.ImageData

interface HomeContracts {
    interface Model {
        fun getImage(index: Int): ImageData
    }

    interface View {
        fun showInfo()
        fun loadImg(list: List<Int>)
        fun goToMainActivity()
        fun goToResultsActivity()
        fun goToSettingsActivity()
        fun goToAboutAppActivity()
        fun quitGame()
        fun setLevel(level: Int)
        fun setMoney(money: Int)
    }

    interface Presenter {
        fun startGame()
        fun leaderboard()
        fun settings()
        fun aboutApp()
        fun quit()

    }
}