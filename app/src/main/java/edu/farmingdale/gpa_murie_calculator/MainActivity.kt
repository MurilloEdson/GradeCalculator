package edu.farmingdale.gpa_murie_calculator

import android.os.Bundle
import android.text.Layout
import android.text.TextUtils
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calc = findViewById<Button>(R.id.button)
        val grade1 = findViewById<EditText>(R.id.editTextText)
        val grade2 = findViewById<EditText>(R.id.editTextText2)
        val grade3 = findViewById<EditText>(R.id.editTextText3)
        val grade4 = findViewById<EditText>(R.id.editTextText4)
        val grade5 = findViewById<EditText>(R.id.editTextText5)
        var finalAns = findViewById<TextView>(R.id.textView6)
        var layout = findViewById<LinearLayout>(R.id.MainLayout)
        calc.setOnClickListener{
            var g1s = grade1.text.toString()
            var g2s  = grade2.text.toString()
            var g3s = grade3.text.toString()
            var g4s = grade4.text.toString()
            var g5s = grade5.text.toString()
            var anyEmpty = isEditTextEmpty(grade1) || isEditTextEmpty(grade2) || isEditTextEmpty(grade3) || isEditTextEmpty(grade4) || isEditTextEmpty(grade5)
            if(!anyEmpty){
                var g1 = g1s.toInt()
                var g2 = g2s.toInt()
                var g3 = g3s.toInt()
                var g4 = g4s.toInt()
                var g5 = g5s.toInt()
                var gpa = (g1 + g2 + g3 + g4 + g5)/5
                finalAns.setText("The GPA is: " + gpa)
                grade1.setText(""); grade2.setText("");grade3.setText("");grade4.setText("");grade5.setText("")
                if(gpa>100){
                    finalAns.setText("The GPA is: INVALID")
                    layout.setBackgroundResource(R.color.white)
                }else if(gpa>=80){
                    layout.setBackgroundResource(R.color.green)
                }else if (gpa>60){
                    layout.setBackgroundResource(R.color.yellow)
                }else if(gpa>0){
                    layout.setBackgroundResource(R.color.red)
                }else{
                    finalAns.setText("The GPA is: INVALID")
                    layout.setBackgroundResource(R.color.white)
                }
            }else{
                Toast.makeText(this,R.string.empty_grade_error,Toast.LENGTH_SHORT).show()
                if(TextUtils.isEmpty(g1s.toString())){
                    grade1.setError("Please fill in grade")
                }else if (TextUtils.isEmpty(g2s.toString())){
                    grade2.setError("Please fill in grade")
                }else if (TextUtils.isEmpty(g3s.toString())){
                    grade3.setError("Please fill in grade")
                }else if(TextUtils.isEmpty(g4s.toString())){
                    grade4.setError("Please fill in grade")
                }else{
                    grade5.setError("Please fill in grade")
                }


                finalAns.setText("The GPA is: ____")
            }

        }

    }
    fun isEditTextEmpty(editText: EditText): Boolean {
        val text = editText.text.toString().trim()
        return text.isEmpty()
    }
}