package oliveira.willian.matheus.imc_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_ncd.*

class NcdActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ncd)

        val arraySpinner = listOf<String>("Selecione", "Leve", "Moderada", "Intensa")
        val arrayAdapter = ArrayAdapter<String>(this, R.layout.spinner_dropdown_item, arraySpinner)
        spinner_tipo_atividade.adapter = arrayAdapter

    }
}

// ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, R.layout.spinner_item);
// adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
// spinner.setAdapter(adapter);