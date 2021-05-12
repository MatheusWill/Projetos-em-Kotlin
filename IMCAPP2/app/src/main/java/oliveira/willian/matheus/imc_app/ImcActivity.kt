package oliveira.willian.matheus.imc_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_imc.*

class ImcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        // val buttonCalcular: Button = findViewById(R.id.button_calcular_imc)
        // button_calcular_imc.setBackgroundColor(R.drawable.round_button)

        button_calcular_imc.setOnClickListener {

            if (edit_text_peso.text.isEmpty()) {
                edit_text_peso.error = "Digite seu peso!!"
            } else if (edit_text_altura.text.isEmpty()) {
                edit_text_altura.error = "Digite sua altura!!"
            } else {
                val intent = Intent(this, ResultadoImcActivity::class.java)

                intent.putExtra("peso", edit_text_peso.text.toString().toDouble())
                intent.putExtra("altura", edit_text_altura.text.toString().toDouble())

                startActivity(intent)
            }
        }

    }
}