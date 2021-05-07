package oliveira.willian.matheus.imc_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ** Clique no card IMC
        card_imc.setOnClickListener {

            val abrirImcActivity = Intent(this, ImcActivity::class.java)
            startActivity(abrirImcActivity)
        }

        card_ncd.setOnClickListener {

            val abrirNcdActivity = Intent(this, NcdActivity::class.java)
            startActivity(abrirNcdActivity)
        }
    }
}