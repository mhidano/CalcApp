package jp.techacademy.morikazu.hidano.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonPlus.setOnClickListener(this)
        buttonMinus.setOnClickListener(this)
        buttonTimes.setOnClickListener(this)
        buttonDivide.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        if (editText.text.toString() == "" || editText2.text.toString() == ""){
            Snackbar
                .make(v, "何か数値を入力してください", Snackbar.LENGTH_INDEFINITE)
                .setAction("閉じる"){}
                .show()
        } else{
            var Total: Double = 0.0
            val text = editText.text.toString().toDouble()
            val text2 = editText2.text.toString().toDouble()

            when (v.id) {
                R.id.buttonPlus -> Total = text.plus(text2)
                R.id.buttonMinus -> Total = text.minus(text2)
                R.id.buttonTimes -> Total = text.times(text2)
                R.id.buttonDivide -> Total = text.div(text2)
            }

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("VALUE", Total)

            startActivity(intent)
        }
    }
}