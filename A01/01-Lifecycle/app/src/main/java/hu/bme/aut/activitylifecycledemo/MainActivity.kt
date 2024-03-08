package hu.bme.aut.activitylifecycledemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import hu.bme.aut.activitylifecycledemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDetails.setOnClickListener {
            val intentDetails = Intent(this, DetailsActivity::class.java)
            intentDetails.putExtra("KEY_DATA", "MobWeb Data Demo Intent")
            startActivity(intentDetails)
        }

        Log.d("TAG_LIFE", "onCreate called")
    }

    override fun onStart() {
        super.onStart()
        Log.d("TAG_LIFE", "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG_LIFE", "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG_LIFE", "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG_LIFE", "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG_LIFE", "onDestroy called")
    }
}