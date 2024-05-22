package com.abraun.selfpromoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.abraun.selfpromoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //binds the mainActivity to binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonPreview.setOnClickListener {
            onPreviewClicked()
        }

        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arrayOf("Android Developer", "Java Developer"))
        binding.spinnerJobTitle.adapter = spinnerAdapter
    }

    private fun onPreviewClicked() {

        //here we can use the binding, to extract the strings or whatever directly from the activity
        val message = Message(binding.editTextContactName.text.toString(),
            binding.editTextContactNumber.text.toString(),
            binding.editTextDisplayName.text.toString(),
            binding.checkBoxJunior.isChecked,
            binding.spinnerJobTitle.selectedItem?.toString(),
            binding.checkBoxImmediateStart.isChecked,
            binding.editTextStartDate.text.toString()
        )

        val previewActivityIntent = Intent(this, PreviewActivity::class.java)

        //put data in the intent, to use it later in another activity
        previewActivityIntent.putExtra("Message", message)
//      previewActivityIntent.putExtra("Contact Name:", binding.editTextContactName.text.toString() )
//      previewActivityIntent.putExtra("Job Title:", binding.spinnerJobTitle.selectedItem.toString())
        startActivity(previewActivityIntent)
    }
}