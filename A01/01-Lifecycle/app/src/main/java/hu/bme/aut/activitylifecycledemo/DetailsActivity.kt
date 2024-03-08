package hu.bme.aut.activitylifecycledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.bme.aut.activitylifecycledemo.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var data = intent.getStringExtra("KEY_DATA")

        binding.tvData.text = data
    }
}