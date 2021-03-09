package oliveira.willian.matheus.lista_compras

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_adicionar.setOnClickListener {
            // Criando a Itent explícita
            val intent = Intent(this, CadastroActivity::class.java)

            // iniciando a atividade
            startActivity(intent)
        }

//        Implementação do adptador
        val produtoAdapter = ProdutoAdapter(this)

//        Definindo o adpatador na lista
        list_view_produtos.adapter = produtoAdapter

        list_view_produtos.setOnItemLongClickListener { adapterView: AdapterView<*>, view: View, position: Int, id: Long ->

//            Buscando o item clicado
            val item = produtoAdapter.getItem(position)

//            Removendo o item clicando na lista
            produtoAdapter.remove(item)

//            Retorno indicando que o click foi finalizado com sucesso
            true
        }
    }

    override fun onResume() {
        super.onResume()

        val adapter = list_view_produtos.adapter as ProdutoAdapter

        adapter.clear()
        adapter.addAll(produtosGlobal)

        val soma = produtosGlobal.sumByDouble { it.valor * it.quantidade }

        val f = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
        txt_total.text = "TOTAL: ${f.format(soma)}"
    }
}