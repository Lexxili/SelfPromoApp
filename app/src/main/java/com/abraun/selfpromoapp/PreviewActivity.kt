package com.abraun.selfpromoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abraun.selfpromoapp.databinding.ActivityMainBinding
import com.abraun.selfpromoapp.databinding.ActivityPreviewBinding

class PreviewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPreviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreviewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

       binding.textViewMessage.text = "Manually text is setted"
    }

}
