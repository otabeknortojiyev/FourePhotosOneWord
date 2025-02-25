package uz.gita.otabek.a41.presentation.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import uz.gita.otabek.a41.R
import uz.gita.otabek.a41.domain.Repository
import uz.gita.otabek.a41.presentation.gameover.GameOverActivity
import uz.gita.otabek.a41.presentation.home.HomeActivity
import uz.gita.otabek.a41.presentation.main.mvp.MainContracts
import uz.gita.otabek.a41.presentation.main.mvp.MainModel
import uz.gita.otabek.a41.presentation.main.mvp.MainPresenter

class MainActivity : AppCompatActivity(), MainContracts.View {
  private val answerItems: ArrayList<Button> = ArrayList()
  private val variantItems: ArrayList<Button> = ArrayList()

  private lateinit var presenter: MainContracts.Presenter

  private val back: ImageView by lazy { findViewById(R.id.back) }
  private val score: AppCompatButton by lazy { findViewById(R.id.score) }
  private val level: AppCompatButton by lazy { findViewById(R.id.level) }

  private val iv1: ImageView by lazy { findViewById(R.id.iv1) }
  private val iv2: ImageView by lazy { findViewById(R.id.iv2) }
  private val iv3: ImageView by lazy { findViewById(R.id.iv3) }
  private val iv4: ImageView by lazy { findViewById(R.id.iv4) }

  private val rightAnswer: ImageView by lazy { findViewById(R.id.rightAnswer) }
  private val eraser: ImageView by lazy { findViewById(R.id.eraser) }

  private val btnAns1: AppCompatButton by lazy { findViewById(R.id.btn13) }
  private val btnAns2: AppCompatButton by lazy { findViewById(R.id.btn14) }
  private val btnAns3: AppCompatButton by lazy { findViewById(R.id.btn15) }
  private val btnAns4: AppCompatButton by lazy { findViewById(R.id.btn16) }
  private val btnAns5: AppCompatButton by lazy { findViewById(R.id.btn17) }
  private val btnAns6: AppCompatButton by lazy { findViewById(R.id.btn18) }
  private val btnAns7: AppCompatButton by lazy { findViewById(R.id.btn19) }
  private val btnAns8: AppCompatButton by lazy { findViewById(R.id.btn20) }
  private val btnAns9: AppCompatButton by lazy { findViewById(R.id.btn21) }
  private val btnAns10: AppCompatButton by lazy { findViewById(R.id.btn22) }
  private val btnAns11: AppCompatButton by lazy { findViewById(R.id.btn23) }

  private val btnVariant1: AppCompatButton by lazy { findViewById(R.id.btn7) }
  private val btnVariant2: AppCompatButton by lazy { findViewById(R.id.btn8) }
  private val btnVariant3: AppCompatButton by lazy { findViewById(R.id.btn9) }
  private val btnVariant4: AppCompatButton by lazy { findViewById(R.id.btn10) }
  private val btnVariant5: AppCompatButton by lazy { findViewById(R.id.btn11) }
  private val btnVariant6: AppCompatButton by lazy { findViewById(R.id.btn12) }
  private val btnVariant7: AppCompatButton by lazy { findViewById(R.id.btn1) }
  private val btnVariant8: AppCompatButton by lazy { findViewById(R.id.btn2) }
  private val btnVariant9: AppCompatButton by lazy { findViewById(R.id.btn3) }
  private val btnVariant10: AppCompatButton by lazy { findViewById(R.id.btn4) }
  private val btnVariant11: AppCompatButton by lazy { findViewById(R.id.btn5) }
  private val btnVariant12: AppCompatButton by lazy { findViewById(R.id.btn6) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    loadViews()

    presenter = MainPresenter(this, MainModel())
  }

  private fun loadViews() {
    btnAns1.text = ""
    btnAns1.setOnClickListener { onAnswerClick(btnAns1) }
    answerItems.add(btnAns1)

    btnAns2.text = ""
    btnAns2.setOnClickListener { onAnswerClick(btnAns2) }
    answerItems.add(btnAns2)

    btnAns3.text = ""
    btnAns3.setOnClickListener { onAnswerClick(btnAns3) }
    answerItems.add(btnAns3)

    btnAns4.text = ""
    btnAns4.setOnClickListener { onAnswerClick(btnAns4) }
    answerItems.add(btnAns4)

    btnAns5.text = ""
    btnAns5.setOnClickListener { onAnswerClick(btnAns5) }
    answerItems.add(btnAns5)

    btnAns6.text = ""
    btnAns6.setOnClickListener { onAnswerClick(btnAns6) }
    answerItems.add(btnAns6)

    btnAns7.text = ""
    btnAns7.setOnClickListener { onAnswerClick(btnAns7) }
    answerItems.add(btnAns7)

    btnAns8.text = ""
    btnAns8.setOnClickListener { onAnswerClick(btnAns8) }
    answerItems.add(btnAns8)

    btnAns9.text = ""
    btnAns9.setOnClickListener { onAnswerClick(btnAns9) }
    answerItems.add(btnAns9)

    btnAns10.text = ""
    btnAns10.setOnClickListener { onAnswerClick(btnAns10) }
    answerItems.add(btnAns10)

    btnAns11.text = ""
    btnAns11.setOnClickListener { onAnswerClick(btnAns11) }
    answerItems.add(btnAns11)

    variantItems.add(btnVariant1)
    btnVariant1.setOnClickListener { onVariantClick(btnVariant1) }

    variantItems.add(btnVariant2)
    btnVariant2.setOnClickListener { onVariantClick(btnVariant2) }

    variantItems.add(btnVariant3)
    btnVariant3.setOnClickListener { onVariantClick(btnVariant3) }

    variantItems.add(btnVariant4)
    btnVariant4.setOnClickListener { onVariantClick(btnVariant4) }

    variantItems.add(btnVariant5)
    btnVariant5.setOnClickListener { onVariantClick(btnVariant5) }

    variantItems.add(btnVariant6)
    btnVariant6.setOnClickListener { onVariantClick(btnVariant6) }

    variantItems.add(btnVariant7)
    btnVariant7.setOnClickListener { onVariantClick(btnVariant7) }

    variantItems.add(btnVariant8)
    btnVariant8.setOnClickListener { onVariantClick(btnVariant8) }

    variantItems.add(btnVariant9)
    btnVariant9.setOnClickListener { onVariantClick(btnVariant9) }

    variantItems.add(btnVariant10)
    btnVariant10.setOnClickListener { onVariantClick(btnVariant10) }

    variantItems.add(btnVariant11)
    btnVariant11.setOnClickListener { onVariantClick(btnVariant11) }

    variantItems.add(btnVariant12)
    btnVariant12.setOnClickListener { onVariantClick(btnVariant12) }

    back.setOnClickListener { presenter.clickBack() }

    level.text = ""

    score.text = Repository.getInstance().getSharedPreferences1()!!.getInt("money", 0).toString()

  }

  private fun onVariantClick(button: Button) {
    val index = variantItems.indexOf(button)
    presenter.clickVariant(index, button.text.toString())
  }

  private fun onAnswerClick(button: Button) {
    val index = answerItems.indexOf(button)
    presenter.clickAnswer(index, button.text.toString())
  }

  override fun setVariant(variant: String) {
    variant.forEachIndexed { index, c ->
      val button = variantItems[index]
      button.text = c.toString()
      button.isVisible = true
    }
    rightAnswer.setOnClickListener {
      presenter.clickRightAnswer(score)
    }

    eraser.setOnClickListener { presenter.clickEraser(variantItems, score) }
  }

  override fun setAnswerSize(size: Int) {
    answerItems.forEachIndexed { index, button ->
      button.isVisible = index < size
    }
  }

  override fun setAnswer(index: Int, text: String) {
    answerItems[index].text = text
  }

  override fun showVariant(index: Int) {
    variantItems[index].isVisible = true
  }

  override fun hideVariant(index: Int) {
    variantItems[index].isInvisible = true
  }

  override fun removeAnswer(index: Int) {
    answerItems[index].text = ""
  }

  override fun setQuestions(resId1: Int, resId2: Int, resId3: Int, resId4: Int) {
    iv1.setImageResource(resId1)
    iv2.setImageResource(resId2)
    iv3.setImageResource(resId3)
    iv4.setImageResource(resId4)
  }


  override fun backToHomeActivity() {
    startActivity(Intent(this, HomeActivity::class.java))
    finish()
  }

  override fun clearAnswers() {
    answerItems.forEach {
      it.text = ""
    }
  }

  override fun goToGameOverActivity() {
    startActivity(Intent(this, GameOverActivity::class.java))
    finish()
  }

  override fun makeAllClickable() {
    answerItems.forEach {
      it.isClickable = true
    }
  }

  override fun makeUnClickable(index: Int) {
    answerItems[index].isClickable = false
  }

  override fun setLevel(level: Int) {
    this.level.text = level.toString()
  }

  override fun setScore(sc: Int) {
    val money = this.score.text.toString().toInt() + sc
    this.score.text = money.toString()
    val x = (score.text as String).toInt()
    Repository.getInstance().getSharedPreferences1()!!.edit().putInt("money", x).apply()
  }

  override fun onBackPressed() {
    presenter.clickBack()
  }

  override fun onDestroy() {
    val money = Repository.getInstance().getSharedPreferences1()!!.getInt("money", 0)
    Repository.getInstance().getSharedPreferences1()!!.edit().putInt("money", money).apply()
    super.onDestroy()
  }
}
