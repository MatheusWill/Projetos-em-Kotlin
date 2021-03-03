package oliveira.willian.matheus.calculoaposentadoria

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.ArrayAdapter

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//      definindo o arquivo de layout
        setContentView(R.layout.activity_main)

//        acessando o Spinner(comboBox)
        val spn_sexo = findViewById<Spinner>(R.id.spn_sexo)

//        acessando a caixa de idade
        val txt_idade = findViewById<EditText>(R.id.txt_idade)

//        acessando o botão calcular
        val btn_calcular = findViewById<Button>(R.id.btn_calcular)

//        acessando o texto de resultados
        val txt_resultado = findViewById<TextView>(R.id.txt_resultado)

        spn_sexo.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listOf("", "masculino", "feminino"))

        btn_calcular.setOnClickListener {

//          captura o sexo selecionado
            val sexo = spn_sexo.selectedItem as String

//          captura a idade digitada
            val idade = txt_idade.text.toString().toInt()

//          variavel para guardar o resultado do calculo
            var resultado = 0

//          verificando o sexo da pessoa
            if (sexo == "masculino"){
                resultado = 65 - idade
            } else {
                resultado = 60 - idade
            }

//          atualizando a tela de acordo com o resultado do cálculo
            txt_resultado.text = "Faltam $resultado anos para você se aposentar."
        }

    }
}