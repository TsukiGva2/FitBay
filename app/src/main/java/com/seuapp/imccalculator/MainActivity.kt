package com.gabrieldazzi.imclucas

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etPeso = findViewById<EditText>(R.id.etPeso)
        val etAltura = findViewById<EditText>(R.id.etAltura)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnCalcular.setOnClickListener {
            val peso = etPeso.text.toString().toDoubleOrNull()
            val altura = etAltura.text.toString().toDoubleOrNull()

            if (peso != null && altura != null && altura > 0) {
                val imc = peso / (altura * altura)
                val status = when {
                    imc < 18.5 -> "Abaixo do peso"
                    imc < 24.9 -> "Peso normal"
                    imc < 29.9 -> "Sobrepeso"
                    imc < 34.9 -> "Obesidade Grau I"
                    imc < 39.9 -> "Obesidade Grau II"
                    else -> "Obesidade Grau III"
                }

                val resultado = String.format("IMC: %.2f\nStatus: %s", imc, status)
                tvResultado.text = resultado
            } else {
                Toast.makeText(this, "Insira valores válidos!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
