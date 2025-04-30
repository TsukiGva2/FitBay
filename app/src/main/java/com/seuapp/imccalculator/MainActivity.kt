package com.gabrieldazzi.imclucas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etPeso: EditText
    private lateinit var etAltura: EditText
    private lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPeso = findViewById(R.id.etPeso)
        etAltura = findViewById(R.id.etAltura)
        btnCalcular = findViewById(R.id.btnCalcular)

        btnCalcular.setOnClickListener {
            calcularIMC()
        }
    }

    private fun calcularIMC() {
        val pesoStr = etPeso.text.toString()
        val alturaStr = etAltura.text.toString()

        val peso = pesoStr.toDoubleOrNull()
        val altura = alturaStr.toDoubleOrNull()

        if (peso != null && altura != null && altura > 0) {
            val imc = peso / (altura * altura)
            val status = when {
                imc < 18.5 -> "Abaixo do peso"
                imc < 24.9 -> "Peso ideal"
                imc < 29.9 -> "Sobrepeso"
                imc < 39.9 -> "Obesidade"
                else -> "Obesidade grave"
            }

            val intent = Intent(this, ResultadoActivity::class.java).apply {
                putExtra("peso", peso)
                putExtra("altura", altura)
                putExtra("imc", imc)
                putExtra("status", status)
            }
            startActivity(intent)
        } else {
            Toast.makeText(this, "Insira valores válidos para peso e altura", Toast.LENGTH_SHORT).show()
        }
    }
}
