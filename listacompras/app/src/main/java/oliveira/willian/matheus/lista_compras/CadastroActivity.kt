package oliveira.willian.matheus.lista_compras

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    val COD_IMAGE = 101
    var imageBitMap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

       // Definindo o ouvinte do botão
        btn_inserir.setOnClickListener {

//            Pegando o valor digitado pelo usuario
            val produto = txt_produto.text.toString()
            val qtd = txt_quantidade.text.toString()
            val valor = txt_valor.text.toString()

            // Verificando se o usuario digitou algum valor
            if (produto.isNotEmpty() && qtd.isNotEmpty() && valor.isNotEmpty()){

                val prod = Produto(produto, qtd.toInt(), valor.toDouble(), imageBitMap)

                produtosGlobal.add(prod)

                txt_produto.text.clear()
                txt_quantidade.text.clear()
                txt_valor.text.clear()

            } else {

                txt_produto.error = if (txt_produto.text.isEmpty()) "Preencha o nome do produto" else null
                txt_quantidade.error = if (txt_quantidade.text.isEmpty()) "Preencha a quantidade" else null
                txt_valor.error = if (txt_valor.text.isEmpty()) "Preencha o valor" else null
            }
        }

        img_foto_produto.setOnClickListener {
            abrirGaleria()
        }
    }

    fun abrirGaleria(){

        // Definindo a acção do conteudo
        val intent = Intent(Intent.ACTION_GET_CONTENT)

        // Definindo filtro para imagens
        intent.type = "image/*"

        // Inicializando a activity com resultado
        startActivityForResult(Intent.createChooser(intent, "Selecione uma imagem"), COD_IMAGE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == COD_IMAGE && resultCode == Activity.RESULT_OK){

            if (data != null){

                // Lendo a URI com a imagem
                val inputStream = contentResolver.openInputStream(data.getData()!!);

                // Tranformando o resultado em bitmap
                imageBitMap = BitmapFactory.decodeStream(inputStream)

                // Exibir a imagem no aplicativo
                img_foto_produto.setImageBitmap(imageBitMap)
            }
        }
    }
}