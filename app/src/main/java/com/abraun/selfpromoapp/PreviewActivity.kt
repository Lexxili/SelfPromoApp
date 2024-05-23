package com.abraun.selfpromoapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abraun.selfpromoapp.databinding.ActivityPreviewBinding

class PreviewActivity : AppCompatActivity() {

    private lateinit var message: Message
    private lateinit var messagePreviewText: String
    private lateinit var binding: ActivityPreviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreviewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonSendMessage.setOnClickListener {

        }

        displayMessage()
        setupButton()

    }

    private fun displayMessage() {
        //        // get things from the intent
        //        val contactName: String? = intent.getStringExtra("Contact Name:") //for transmitting various data between the views
        //        val jobTitle: String? = intent.getStringExtra("Job Title:")

        //because of the use of android 24, getSerializableExtra is necessary
        message = intent.getSerializableExtra("Message") as Message // it is a cast

        messagePreviewText = """
                Hi ${message.contactName},

                My Name is ${message.myDisplayName} and I am a ${message.getFullJobDescr()}.

                I have a portfolio of apps to demonstrate my technical skills that I can show on request.

                I am able to start a new position ${message.getAvailability()}.

                Please get in touch if you have any suitable roles for me.

                Thanks and best regards.""".trimIndent()

        binding.textViewMessage.text = messagePreviewText
    }

    private fun setupButton() {
        binding.buttonSendMessage.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${message.contactNumber}") // this ensures that only sms apps respond
                putExtra("sms_body", messagePreviewText)
            }
            startActivity(intent)
        }
    }

}
