package com.antique.suspend_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.antique.suspend_mvvm.databinding.ActivityMainBinding
import com.antique.suspend_mvvm.viewmodel.MainViewModel
import com.antique.suspend_mvvm.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel by lazy { ViewModelProvider(this, MainViewModelFactory()).get(MainViewModel::class.java)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initialize()
    }

    private fun initialize() {
        setupObservers()
        setupViewState()
    }

    private fun setupObservers() {
        viewModel.daily.asLiveData().observe(this) {
            Log.d("ApiStatusTest", it.toString())
            binding.resultView.text = it.toString()
        }
    }

    private fun setupViewState() {
        viewModel.load()
    }
}