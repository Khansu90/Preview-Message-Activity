package com.example.khansusself_promoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_preview.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


          button_preview_message.setOnClickListener{
              clickListener()
          }
        val spinnerValues = arrayOf("Android Developer","Android Engineer")
        val spinnerAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,spinnerValues)
        spinner_item.adapter = spinnerAdapter
    }

    private fun clickListener() {
        val message = Message (edit_text_contact_name.text.toString(),edit_text_contact_number.text.toString(),edit_text_my_display_name.text.toString(),check_box_junior.isChecked, check_box_immediate_start.isChecked,spinner_item.selectedItem?.toString(),edit_text_start_date.text.toString())
        val myIntentActivity = Intent(this,PreviewActivity::class.java)
        myIntentActivity.putExtra("Message",message)
        startActivity(myIntentActivity)
    }
}