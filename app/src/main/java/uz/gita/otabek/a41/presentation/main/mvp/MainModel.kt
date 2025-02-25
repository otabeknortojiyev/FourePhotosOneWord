package uz.gita.otabek.a41.presentation.main.mvp

import uz.gita.otabek.a41.R
import uz.gita.otabek.a41.data.QuestionData
import kotlin.random.Random

class MainModel : MainContracts.Model {
    private val questions = arrayListOf(
        QuestionData(
            R.drawable.iv1_q1,
            R.drawable.iv2_q1,
            R.drawable.iv3_q1,
            R.drawable.iv4_q1,
            "природа",
            "природа".getRandomWords()
        ),
        QuestionData(
            R.drawable.iv1_q2,
            R.drawable.iv2_q2,
            R.drawable.iv3_q2,
            R.drawable.iv4_q2,
            "фрукты",
            "фрукты".getRandomWords()
        ),
        QuestionData(
            R.drawable.iv1_q3,
            R.drawable.iv2_q3,
            R.drawable.iv3_q3,
            R.drawable.iv4_q3,
            "оружие",
            "оружие".getRandomWords()
        ),
        QuestionData(
            R.drawable.iv1_q4,
            R.drawable.iv2_q4,
            R.drawable.iv3_q4,
            R.drawable.iv4_q4,
            "молоко",
            "молоко".getRandomWords()
        ),
        QuestionData(
            R.drawable.iv1_q5,
            R.drawable.iv2_q5,
            R.drawable.iv3_q5,
            R.drawable.iv4_q5,
            "джазз",
            "джазз".getRandomWords()
        ),
        QuestionData(
            R.drawable.iv1_q6,
            R.drawable.iv2_q6,
            R.drawable.iv3_q6,
            R.drawable.iv4_q6,
            "машина",
            "машина".getRandomWords()
        ),
        QuestionData(
            R.drawable.iv1_q7,
            R.drawable.iv2_q7,
            R.drawable.iv3_q7,
            R.drawable.iv4_q7,
            "доктор",
            "доктор".getRandomWords()
        ),
        QuestionData(
            R.drawable.iv1_q8,
            R.drawable.iv2_q8,
            R.drawable.iv3_q8,
            R.drawable.iv4_q8,
            "музыка",
            "музыка".getRandomWords()
        ),
        QuestionData(
            R.drawable.iv1_q9,
            R.drawable.iv2_q9,
            R.drawable.iv3_q9,
            R.drawable.iv4_q9,
            "хищник",
            "хищник".getRandomWords()
        ),
        QuestionData(
            R.drawable.iv1_q10,
            R.drawable.iv2_q10,
            R.drawable.iv3_q10,
            R.drawable.iv4_q10,
            "подарок",
            "подарок".getRandomWords()
        ),
        QuestionData(
            R.drawable.iv1_q11,
            R.drawable.iv2_q11,
            R.drawable.iv3_q11,
            R.drawable.iv4_q11,
            "волосы",
            "волосы".getRandomWords()
        ),
        QuestionData(
            R.drawable.iv1_q12,
            R.drawable.iv2_q12,
            R.drawable.iv3_q12,
            R.drawable.iv4_q12,
            "усталый",
            "усталый".getRandomWords()
        ),
        QuestionData(
            R.drawable.iv1_q13,
            R.drawable.iv2_q13,
            R.drawable.iv3_q13,
            R.drawable.iv4_q13,
            "счастливый",
            "счастливый".getRandomWords()
        ),
        QuestionData(
            R.drawable.iv1_q14,
            R.drawable.iv2_q14,
            R.drawable.iv3_q14,
            R.drawable.iv4_q14,
            "грустный",
            "грустный".getRandomWords()
        ),
        QuestionData(
            R.drawable.iv1_q15,
            R.drawable.iv2_q15,
            R.drawable.iv3_q15,
            R.drawable.iv4_q15,
            "летучаямышь",
            "летучаямышь".getRandomWords()
        ),
        QuestionData(
            R.drawable.iv1_q16,
            R.drawable.iv2_q16,
            R.drawable.iv3_q16,
            R.drawable.iv4_q16,
            "горы",
            "горы".getRandomWords()
        ),
        QuestionData(
            R.drawable.iv1_q17,
            R.drawable.iv2_q17,
            R.drawable.iv3_q17,
            R.drawable.iv4_q17,
            "мясо",
            "мясо".getRandomWords()
        ),
        QuestionData(
            R.drawable.iv1_q18,
            R.drawable.iv2_q18,
            R.drawable.iv3_q18,
            R.drawable.iv4_q18,
            "рыба",
            "рыба".getRandomWords()
        ),
        QuestionData(
            R.drawable.iv1_q19,
            R.drawable.iv2_q19,
            R.drawable.iv3_q19,
            R.drawable.iv4_q19,
            "цвета",
            "цвета".getRandomWords()
        ),
        QuestionData(
            R.drawable.iv1_q20,
            R.drawable.iv2_q20,
            R.drawable.iv3_q20,
            R.drawable.iv4_q20,
            "деньги",
            "деньги".getRandomWords()
        ),
        QuestionData(
            R.drawable.iv1_q21,
            R.drawable.iv2_q21,
            R.drawable.iv3_q21,
            R.drawable.iv4_q21,
            "динозавр",
            "динозавр".getRandomWords()
        ),
        QuestionData(
            R.drawable.iv1_q22,
            R.drawable.iv2_q22,
            R.drawable.iv3_q22,
            R.drawable.iv4_q22,
            "собака",
            "собака".getRandomWords()
        )
    )

    override fun getQuestion(index: Int): QuestionData {
        return questions[index]
    }

    override fun getQuestionCount(): Int {
        return questions.size
    }

    private fun String.getRandomWords(): String {
        val builder = StringBuilder()
        builder.append(this)
        val chars: Array<Char> = arrayOf(
            'а',
            'б',
            'в',
            'г',
            'д',
            'е',
            'ё',
            'ж',
            'з',
            'и',
            'й',
            'к',
            'л',
            'м',
            'н',
            'о',
            'п',
            'р',
            'с',
            'т',
            'у',
            'ф',
            'х',
            'ц',
            'ч',
            'ш',
            'щ',
            'э',
            'ю',
            'я'
        )

        for (i in 0 until (12 - this.length)) {
            var c = Random.nextInt(0, 30)
            while (this.contains(chars[c].toString())) {
                c = Random.nextInt(0, 30)
            }
            builder.append(chars[c].toString())
        }
        return builder.toList().shuffled().joinToString("")

    }
}