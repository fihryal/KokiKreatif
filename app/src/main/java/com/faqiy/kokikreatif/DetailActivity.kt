package com.faqiy.kokikreatif

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.faqiy.kokikreatif.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private var _binding : ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var data = intent.getParcelableExtra(EXTRA_DATA) as resep?

        binding.apply {
            detailNama.text = data?.nama
            detailBahan.text = data?.bahan
            detailResep.text = data?.resep
            data?.img?.let { Picasso.get().load(it).into(detailImage) }
        }

        binding.actionShare.setOnClickListener {
            val detailImage: ImageView = findViewById(R.id.detail_image)
            val share = Intent.createChooser(Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "https://developer.android.com/training/sharing/")

                // (Optional) Here we're setting the title of the content
                putExtra(Intent.EXTRA_TITLE, "Serep Mudah & Enak")

                // (Optional) Here we're passing a content URI to an image to be displayed
                data?.img?.let { Picasso.get().load(it).into(detailImage) }
                flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
            }, null)
            startActivity(share)


        }
    }

    companion object{
        const val EXTRA_DATA = "data"
    }
}