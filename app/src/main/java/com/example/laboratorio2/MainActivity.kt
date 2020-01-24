package com.example.laboratorio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var trophyImage: ImageView
    lateinit var textCount: TextView
    var count = 0
    var meta = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        trophyImage = findViewById(R.id.rewardImage)
        textCount = findViewById(R.id.countText)
    }

    // Reiniciando los valores
    fun restart(view: View) {
        this.textCount.setText("0")
        trophyImage.visibility = View.INVISIBLE
        trophyImage.setImageResource(R.drawable.trofeo_plata)
        this.count = 0
        this.meta = 10
    }

    // Funciones del boton que avanza 1
    fun addOne(view: View) {
        this.count++

        // Cuando deja presionado el boton
        pressButton.setOnLongClickListener(){
            Toast.makeText(this, "Faltan ${this.meta - count} para alcanzar la meta", LENGTH_SHORT).show()
            true
        }

        // No puede avanzar más de 20
        if(this.count < 21) {
            textCount.run { setText(count.toString()) }
        }

        // Cuando llegue a las metas correspondientes
        if(this.count == 10){
            trophyImage.visibility = View.VISIBLE
            Toast.makeText(this, "Felicidades Alcanzaste la Meta de 10", LENGTH_LONG).show()
            meta = 20
        }
        if(this.count == 20){
            trophyImage.setImageResource(R.drawable.trofeo)
            Toast.makeText(this, "Felicidades Alcanzaste la Meta, Reinicialo para Volver a Jugar", LENGTH_LONG).show()
        }
    }

}
