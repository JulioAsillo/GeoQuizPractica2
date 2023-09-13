package com.example.geoquizpractica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var position = 0

    lateinit var questions: ArrayList<Question>

    val btYes = findViewById<Button>(R.id.btYes)
    val btNo = findViewById<Button>(R.id.btNo)
    val btNext = findViewById<Button>(R.id.btNext)

    val tvSentence = findViewById<TextView>(R.id.tvSentence)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadQuestions()
        setupViews()
    }

    private fun loadQuestions() {
        questions = ArrayList()
        var question = Question("Es lima la capital de Chile?", false)
        questions.add(question)
    }

    private fun setupViews() {

        showSentence()

        btYes.setOnClickListener{
            if (questions[position].answer){
                Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
            }
        }

        btNo.setOnClickListener{
            if (!questions[position].answer){
                Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
            }
        }

        btNext.setOnClickListener{
            position++
            showSentence()
        }
    }

    private fun showSentence() {
        tvSentence.text = questions[position].sentence
    }

}


