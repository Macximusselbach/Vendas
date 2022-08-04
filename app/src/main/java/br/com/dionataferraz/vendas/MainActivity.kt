package br.com.dionataferraz.vendas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    private lateinit var btOk: Button
    private lateinit var btClear: Button
    private lateinit var etName: EditText
    private lateinit var tvAnswer: TextView
    private lateinit var ivBackground: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()
        initializeBtOkListener()
        initializeBtClearListener()
        initializeGlide()
    }

    private fun initializeViews() {
        btOk = findViewById(R.id.bt_ok)
        btClear = findViewById(R.id.bt_clear)
        etName = findViewById(R.id.et_name)
        tvAnswer = findViewById(R.id.tv_answer)
        ivBackground = findViewById(R.id.iv_background)
    }

    private fun initializeBtOkListener() {
        btOk.setOnClickListener {
            if (!etName.text.isNullOrBlank()) {
                tvAnswer.text = getString(R.string.hello, etName.text)
                tvAnswer.visibility = View.VISIBLE
            }
        }
    }

    private fun initializeBtClearListener() {
        btClear.setOnClickListener {
            tvAnswer.text = ""
            etName.text.clear()
            tvAnswer.visibility = View.GONE
        }
    }

    private fun initializeGlide(){
        Glide
            .with(this)
            .load("https://static.wikia.nocookie.net/liga-da-zueira-oficial/images/d/da/Goku_render_1_alt_1_by_ssjrose890_ddujowl-fullview.png/revision/latest/scale-to-width-down/1000?cb=20200806022458&path-prefix=pt-br")
            .into(ivBackground);
    }
}