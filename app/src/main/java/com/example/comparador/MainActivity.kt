package com.example.comparador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import com.example.comparador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]


        viewModel.firstText.observe(this, Observer { text ->
            binding.edFirstText.setText(text)
        })

        viewModel.secondText.observe(this, Observer { text ->
            binding.edSecondText.setText(text)
        })

        viewModel.comparisonResult.observe(this, Observer { result ->
            if (result) {
                binding.tvResult.text = getString(R.string.tv_true)
            } else {
                binding.tvResult.text = getString(R.string.tv_false)
            }
        })


        binding.btnCompare.setOnClickListener {
            viewModel.setFirstText(binding.edFirstText.text.toString())
            viewModel.setSecondText(binding.edSecondText.text.toString())
            viewModel.compareTexts()
        }
    }
}
