package com.gabrieldazzi.imclucas

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val tvPeso = findViewById<TextView>(R.id.tvPeso)
        val tvAltura = findViewById<TextView>(R.id.tvAltura)
        val tvResultadoFinal = findViewById<TextView>(R.id.tvResultadoFinal)

        val peso = intent.getDoubleExtra("peso", 0.0)
        val altura = intent.getDoubleExtra("altura", 0.0)
        val imc = intent.getDoubleExtra("imc", 0.0)
        val status = intent.getStringExtra("status")

        tvPeso.text = String.format("%.1f Kg", peso)
        tvAltura.text = String.format("%.1f m", altura)
        tvResultadoFinal.text = String.format("%.2f   %s", imc, status)
    }
}
