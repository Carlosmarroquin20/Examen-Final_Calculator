package com.example.final_ema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var var1 = 0.0
    private var var2 = 0.0   //Variables para Operaciones
    private var OP = 0

    lateinit var TextView: TextView      //Variables de Tv Y Btn
    lateinit var BtnClear: Button
    lateinit var BtnDiv: Button
    lateinit var BtnMult: Button
    lateinit var BtnPlus: Button
    lateinit var BtnSubstract: Button
    lateinit var BtnEqual: Button
    lateinit var BtnDot: Button
    lateinit var BtnOne: Button
    lateinit var BtnTwo: Button
    lateinit var BtnThree: Button
    lateinit var BtnFour: Button
    lateinit var BtnFive: Button
    lateinit var BtnSix: Button
    lateinit var BtnSeven: Button
    lateinit var BtnEight: Button
    lateinit var BtnNine: Button
    lateinit var BtnZero: Button
    lateinit var BtnInf: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initEvents()     //Funcion que llamara a otra activity

        TextView = findViewById(R.id.TextView) //Se recogen Id de Tv y Btn
        BtnClear = findViewById(R.id.BtnClear)
        BtnDiv = findViewById(R.id.BtnDiv)
        BtnMult = findViewById(R.id.BtnMult)
        BtnPlus = findViewById(R.id.BtnPlus)
        BtnSubstract = findViewById(R.id.BtnSubtrac)
        BtnEqual = findViewById(R.id.BtnEqual)
        BtnDot = findViewById(R.id.BtnDot)
        BtnOne = findViewById(R.id.BtnOne)
        BtnTwo = findViewById(R.id.BtnTwo)
        BtnThree = findViewById(R.id.BtnThree)
        BtnFour = findViewById(R.id.BtnFour)
        BtnFive = findViewById(R.id.BtnFive)
        BtnSix = findViewById(R.id.BtnSix)
        BtnSeven = findViewById(R.id.BtnSeven)
        BtnEight = findViewById(R.id.BtnEight)
        BtnNine = findViewById(R.id.BtnNine)
        BtnZero = findViewById(R.id.BtnZero)
        BtnInf = findViewById(R.id.BtnInf)

        TextView.text = "0"
        OP = NoOperation

        BtnOne.setOnClickListener { NumberPress("1") }     //Asignacion de valores a cada boton por NumberPress
        BtnTwo.setOnClickListener { NumberPress("2") }
        BtnThree.setOnClickListener { NumberPress("3") }
        BtnFour.setOnClickListener { NumberPress("4") }
        BtnFive.setOnClickListener { NumberPress("5") }
        BtnSix.setOnClickListener { NumberPress("6") }
        BtnSeven.setOnClickListener { NumberPress("7") }
        BtnEight.setOnClickListener { NumberPress("8") }
        BtnNine.setOnClickListener { NumberPress("9") }
        BtnZero.setOnClickListener { NumberPress("0") }
        BtnDot.setOnClickListener { NumberPress(".") }

        BtnClear.setOnClickListener { cleanscreener() }        //Asigacion de funcion para limpiar

        BtnPlus.setOnClickListener { OpPress(Plus) }    //Asignar Valores para cuando se oprmime una Op
        BtnSubstract.setOnClickListener { OpPress(Substract) }
        BtnMult.setOnClickListener { OpPress(Mult) }
        BtnDiv.setOnClickListener { OpPress(Div) }

        BtnEqual.setOnClickListener { Answer() }        // Boton para llamar a la funcion ANSWER

    }

    private fun NumberPress(num: String) {                  //Funcion para verificar numero seleccionado y lo mostrara datos en TexView
        if (TextView.text == "0" && num != ".") {
            TextView.text = "$num"
        } else {
            TextView.text = "${TextView.text}$num"
        }

        if (OP == NoOperation) {
            var1 = TextView.text.toString().toDouble()
        } else {
            var2 = TextView.text.toString().toDouble()
        }
    }

    private fun OpPress(Operacion1: Int) {                       //Funcion para tomar el valor de la operacion presionada
        this.OP = Operacion1
        var1 = TextView.text.toString().toDouble()

        TextView.text = "0"
    }

    private fun Answer() {               //Funcion para evaluar resultado y dependiendo que operacion se elija se podra realizar desde una suma hasta una Division
        val result = when (OP) {
            Plus -> var1 + var2
            Substract -> var1 - var2
            Mult -> var1 * var2
            Div -> var1 / var2
            else -> 0
        }

        var1 = result as Double

        TextView.text = if ("$result".endsWith(".0")) {
            "$result".replace(".0", "")
        } else {
            "%.2f".format(result)
        }
    }

    private fun cleanscreener() {         //Funcion que reinicia los valores de 2 variables y Txv
        TextView.text = "0"
        var1 = 0.0
        var2 = 0.0
    }

    companion object {              //Las variables constantes
        const val Plus = 1
        const val Substract = 2
        const val Mult = 3
        const val Div = 4
        const val NoOperation = 0
    }

    fun initEvents() {                  // Funcion que permite transportarnos de una activity a otra
        val button = findViewById<Button>(R.id.BtnInf)
        button.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)
        }
    }
}