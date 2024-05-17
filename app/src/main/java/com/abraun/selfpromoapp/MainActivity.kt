package com.abraun.selfpromoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.abraun.selfpromoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.buttonPreview.setOnClickListener {
            onPreviewClicked()
        }

    }

    private fun onPreviewClicked() {
        val contactName = binding.editTextContactName.text.toString()
        val contactNumber = binding.editTextContactNumber.text.toString()
        val myDisplayName = binding.editTextDisplayName.text.toString()
        val includeJunior = binding.checkBoxJunior.isChecked
        val jobTitle = binding.spinnerJobTitle.selectedItem?.toString()
        val immediateStart = binding.checkBoxImmediateStart.isChecked
        val startDate = binding.editTextStartDate.text.toString()

        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        startActivity(previewActivityIntent)
    }
}