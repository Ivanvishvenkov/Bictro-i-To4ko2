package com.example.bustroito4ko

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.bustroito4ko.databinding.ActivityEditBinding
import layout.Cushat

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    private var indexImage = 0
    private var imageId = R.drawable.meal1
    private val imageIdList = listOf(
        R.drawable.meal1,
        R.drawable.meal2,
        R.drawable.meal3,
        R.drawable.meal4,
        R.drawable.meal5,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()
    }

    private fun initButtons() = with(binding){
        bNext.setOnClickListener {
            indexImage++
            if(indexImage > imageIdList.size - 1) indexImage = 0
            Log.d("MyLog", "Index: $indexImage")
            imageId = imageIdList[indexImage]
            imageView.setImageResource(imageId)
        }
        bDone.setOnClickListener {
            val cushat = Cushat(imageId, edTitle.text.toString(), edDesc.text.toString())
            val editIntent = Intent().apply {
                putExtra("cushat", cushat)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }
}