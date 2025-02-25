package uz.gita.otabek.a41.presentation.gameover.mvp

interface GameOverContracts {
    interface Model {

    }

    interface View {
        fun goToHomeActivity()
    }

    interface Presenter {
        fun startTimer()
    }
}