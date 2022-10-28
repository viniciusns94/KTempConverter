package viniciuskotlin.com.ktempconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var celciusRadio: RadioButton
    lateinit var fahreinheitRadio: RadioButton
    lateinit var converterButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.activitymain_valortemp) as EditText

        celciusRadio = findViewById(R.id.activitymain_celciusradio) as RadioButton
        fahreinheitRadio = findViewById(R.id.activitymain_fahreinheitradio) as RadioButton

        converterButton = findViewById(R.id.activitymain_converterButton) as Button
        converterButton.setOnClickListener { converter(it) }
    }

    fun converter(view: View) {
        var temp: Double = editText.text.toString().toDouble()

        if (celciusRadio.isChecked) {
            temp = (temp - 32) * 5 / 9
        } else if (fahreinheitRadio.isChecked) {
            temp = temp * 9 / 5 + 32
        }

        editText.setText(temp.toString())
    }
}