package edu.udb.appcoroutinedog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var dogApiClient: DogApiClient
    private lateinit var imageView: ImageView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dogApiClient = DogApiClient()
        imageView = findViewById(R.id.imageView)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            fetchRandomDogImage()
        }
    }

    private fun fetchRandomDogImage() {
        lifecycleScope.launch {
            val imageUrl = dogApiClient.getRandomDogImage()
            Glide.with(this@MainActivity)
                .load(imageUrl)
                .into(imageView)
        }
    }
}
