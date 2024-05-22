package com.abraun.selfpromoapp

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

    }

    private fun displayMessage() {
        //        // get things from the intent
        //        val contactName: String? = intent.getStringExtra("Contact Name:") //for transmitting various data between the views
        //        val jobTitle: String? = intent.getStringExtra("Job Title:")

        //todo fix outdated
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

    //todo init send button

}
