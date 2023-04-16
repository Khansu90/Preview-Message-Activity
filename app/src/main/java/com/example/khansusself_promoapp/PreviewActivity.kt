package com.example.khansusself_promoapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_preview.*


class PreviewActivity : AppCompatActivity() {


  private lateinit var message : Message
    private lateinit var  messagePreviewText : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        previewMessage()
        setupClick()
    }

    private fun previewMessage() {
         message = intent.getSerializableExtra("Message") as Message
         messagePreviewText = """
                
                Hi,${message.contactName}!
                I am ${message.myDisplayName}.I am ${message.getYourFullJobTitle()}.I have a strong portfolio
                to demonstrate my technical skills on request.If you have a suitable job for me,please dont
                hesitate to inform me about it.I am able to start ${message.date()}.Thank you for wasting
                your precious time!
                
                Best regards!
                
                
                
                """".trimIndent()
        text_view_preview_message.text = messagePreviewText
    }private fun setupClick () {
        button_send_message.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto:${message.contactNumber}")  // This ensures only SMS apps respond
                putExtra("sms_body", messagePreviewText)
            }
            startActivity(intent)
        }
    }

}