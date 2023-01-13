package br.com.kotlinappgasolinaalcool

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcularPreco(view: View){

        //recuperar valores digitados
        //primeiro modo
//        val precoAlcool = findViewById<EditText>(R.id.edit_alcool)
        //segundo modo e mais utilizado
        val precoAlcool = edit_alcool.text.toString()
        val precoGasolina = edit_gasolina.text.toString()

        val validarCamposPreenchidos = validarCampos(precoAlcool, precoGasolina)
        if (validarCamposPreenchidos){

            calcularPrecos(precoAlcool, precoGasolina)

        }else{
            text_resultado.text = "Preencha os preços primeiro!"
        }
    }

    fun calcularPrecos(valorAlcool:String , valorGasolina:String){

        val alcool = valorAlcool.toDouble();
        val gasolina = valorGasolina.toDouble()
        val res = alcool / gasolina
        if (res >= 0.72){
            text_resultado.text = "Gasolina!"
        }else{
            text_resultado.text = "Alcool!"
        }

    }

    private fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean {

        var camposValidados: Boolean = true
        if (precoAlcool == null || precoAlcool.equals("")){
            camposValidados = false
        }else if (precoGasolina == null || precoGasolina.equals("")){
            camposValidados = false
        }
        return camposValidados
    }
}