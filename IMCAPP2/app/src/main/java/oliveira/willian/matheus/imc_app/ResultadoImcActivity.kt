package oliveira.willian.matheus.imc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado_imc.*

class ResultadoImcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_imc)

        val peso = intent.getDoubleExtra("peso", 0.0)
        val altura = intent.getDoubleExtra("altura", 0.0)

        val imc = calcularImc(peso, altura)
        val resultados = obterStatus(imc)
        val dicas = getDica()

        text_view_resultado_imc.text = String.format("%.1f", imc)
        text_view_status_imc.text = resultados[0]
        text_view_dica_status.text = resultados[1]
        text_view_titulo_dica.text = dicas[0]
        text_view_dica.text = dicas[1]

    }
}