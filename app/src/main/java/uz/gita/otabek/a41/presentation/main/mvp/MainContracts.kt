package uz.gita.otabek.a41.presentation.main.mvp

import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import uz.gita.otabek.a41.data.QuestionData

interface MainContracts {
    interface Model {
        fun getQuestion(index: Int): QuestionData
        fun getQuestionCount(): Int
    }

    interface View {
        fun goToGameOverActivity()
        fun makeAllClickable()
        fun makeUnClickable(index: Int)
        fun setLevel(level: Int)
        fun setScore(score: Int)
        fun clearAnswers()
        fun backToHomeActivity()
        fun setVariant(variant: String)
        fun setAnswerSize(size: Int)
        fun setAnswer(index: Int, text: String)
        fun showVariant(index: Int)
        fun hideVariant(index: Int)
        fun removeAnswer(index: Int)
        fun setQuestions(resId1: Int, resId2: Int, resId3: Int, resId4: Int)
    }


    interface Presenter {
        fun clickRightAnswer(score: AppCompatButton)
        fun clickEraser(variants: ArrayList<Button>, score: AppCompatButton)
        fun clickBack()
        fun clickVariant(index: Int, text: String)
        fun clickAnswer(index: Int, text: String)
    }
}