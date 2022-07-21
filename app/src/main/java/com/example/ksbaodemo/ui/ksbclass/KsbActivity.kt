package com.example.ksbaodemo.ui.ksbclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.ksbaodemo.R
import com.example.ksbaodemo.databinding.ActivityKsbBinding
import com.example.ksbaodemo.extensions.viewBinding

class KsbActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityKsbBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.apply {
            setTitle(R.string.ks_class)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}