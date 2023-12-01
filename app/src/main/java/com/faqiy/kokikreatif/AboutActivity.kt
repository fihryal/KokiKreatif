package com.faqiy.kokikreatif

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.faqiy.kokikreatif.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private var _binding : ActivityAboutBinding? = null
    private val binding get () = _binding as ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}