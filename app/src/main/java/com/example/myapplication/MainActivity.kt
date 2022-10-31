package com.example.myapplication

import android.R.attr.x
import android.R.attr.y
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.btResult)
        val edtxt1: EditText = findViewById(R.id.ednum1)
        val edtxt2: EditText = findViewById(R.id.ednum2)
        val resultTV: TextView = findViewById(R.id.textResult)
        //global variable
        var flag : String = "sum"
        //here .. create a spinner items (options)
        val spinnerVal : Spinner = findViewById(R.id.spSelect)
        var options = arrayOf("sum","multiply","subtraction","divition","mod")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )
        button.setOnClickListener{ view ->
            //code here
            var x: Float= edtxt1.text.toString().toFloat();
            var y: Float = edtxt2.text.toString().toFloat();
            if(flag =="sum")
                resultTV.text = sum(x,y).toString();
            else if(flag=="multiply")
                resultTV.text = multiply(x,y).toString();
            else if(flag=="divition")
                resultTV.text = divition(x,y).toString();
            else if(flag=="subtraction")
                resultTV.text= subtraction(x,y).toString();
            else
                resultTV.text= mod(x,y).toString();

        }
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2) //p2 is the index of selected item
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}
public fun sum(a: Float, b: Float): Float {
    return a+b
}
public fun subtraction(a: Float, b: Float): Float {
    return a-b
}
public fun multiply(a: Float, b: Float): Float {
    return a*b
}
public fun divition(a: Float, b: Float): Float {
    return a/b
}
public fun mod(a: Float, b: Float): Float {
    var result = a% b
    if (result < 0) result += b
    return result.toFloat()

}