package uz.gita.otabek.a41.presentation.main.mvp

import android.view.View
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import uz.gita.otabek.a41.domain.Repository

class MainPresenter(
    private val view: MainContracts.View, private val model: MainContracts.Model
) : MainContracts.Presenter {

    private val count = model.getQuestionCount()
    private var currentPosition =
        Repository.getInstance().getSharedPreferences1()!!.getInt("level", 0)
    private var question = model.getQuestion(currentPosition)

    private var answer: Array<String> = Array(question.answer.length, { "" })
    private var variant: Array<String> = Array(12, { "" })

    init {
        loadQuestion()
    }

    private fun loadQuestion() {
        view.setVariant(question.variant)
        view.setAnswerSize(question.answer.length)
        view.setQuestions(question.img1, question.img2, question.img3, question.img4)
        view.setLevel(currentPosition + 1)
    }

    override fun clickVariant(index: Int, text: String) {
        val answerIndex = findEmptyAnswer()
        if (answerIndex == -1) return

        view.hideVariant(index)
        answer[answerIndex] = text
        view.setAnswer(answerIndex, text)
        variant[index] = text

        if (isWin() && currentPosition < count - 1) {
            currentPosition++
            question = model.getQuestion(currentPosition)
            answer = Array(question.answer.length, { "" })
            variant = Array(12, { "" })
            loadQuestion()
            view.clearAnswers()
            view.setScore(10)
            view.makeAllClickable()
            Repository.getInstance().getSharedPreferences1()!!.edit()
                .putInt("level", currentPosition)
                .apply()
            val money = Repository.getInstance().getSharedPreferences1()!!.getInt("money", 0)
            Repository.getInstance().getSharedPreferences1()!!.edit().putInt("money", money).apply()
        } else if (isWin() && currentPosition == count - 1) {
            view.goToGameOverActivity()
        }
    }

    private fun isWin(): Boolean {
        val builder = StringBuilder()
        answer.forEach {
            builder.append(it)

        }
        if (builder.toString() == question.answer) return true
        return false
    }

    override fun clickAnswer(index: Int, text: String) {
        view.removeAnswer(index)
        answer[index] = ""
        val hiddenIndex = findHiddenVariant(text)
        view.showVariant(hiddenIndex)
        variant[hiddenIndex] = ""
    }

    private fun findHiddenVariant(text: String): Int {
        variant.forEachIndexed { index, s ->
            if (text == s) return index
        }
        return -1
    }

    private fun findEmptyAnswer(): Int {
        answer.forEachIndexed { index, s ->
            if (s.isEmpty()) {
                return index
            }
        }
        return -1
    }

    override fun clickBack() {
        Repository.getInstance().getSharedPreferences1()!!.edit().putInt("level", currentPosition)
            .apply()
        val money = Repository.getInstance().getSharedPreferences1()!!.getInt("money", 0)
        Repository.getInstance().getSharedPreferences1()!!.edit().putInt("money", money).apply()
        view.backToHomeActivity()
    }

    override fun clickRightAnswer(score: AppCompatButton) {
        if (score.text.toString().toInt() >= 50) {
            answer.forEachIndexed { index, s ->
                if (s.isEmpty()) {
                    view.setAnswer(index, question.answer[index].toString())
                    answer[index] = question.answer[index].toString()
                    view.makeUnClickable(index)
                    view.hideVariant(question.variant.indexOf(question.answer[index].toString()))
                    if (isWin()) {
                        currentPosition++
                        question = model.getQuestion(currentPosition)
                        answer = Array(question.answer.length, { "" })
                        variant = Array(12, { "" })
                        loadQuestion()
                        view.clearAnswers()
                        view.setScore(10)
                        view.makeAllClickable()
                    } else {
                        view.setScore(-50)
                    }
                    val money =
                        Repository.getInstance().getSharedPreferences1()!!.getInt("money", 0)
                    Repository.getInstance().getSharedPreferences1()!!.edit().putInt("money", money)
                        .apply()
                    return
                }
            }
        }
    }

    override fun clickEraser(variants: ArrayList<Button>, score: AppCompatButton) {
        if (score.text.toString().toInt() >= 10) {
            variants.forEachIndexed { index, button ->
                if (button.visibility == View.VISIBLE && !question.answer.contains(button.text)) {
                    view.setScore(-10)
                    variant[index] = button.text.toString()
                    view.hideVariant(index)
                    val money =
                        Repository.getInstance().getSharedPreferences1()!!.getInt("money", 0)
                    Repository.getInstance().getSharedPreferences1()!!.edit().putInt("money", money)
                        .apply()
                    return
                }
            }
        }
    }
}