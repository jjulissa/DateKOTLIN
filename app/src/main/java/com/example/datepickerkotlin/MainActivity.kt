package com.example.datepickerkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.datepickerkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)
        binding.etDate.setOnClickListener {
            showDatePickerDialog()
        }

        binding.btnbienvenido.setOnClickListener {
            startActivity(Intent(this, Welcome ::class.java))
        }
    }

    private fun showDatePickerDialog() {

//  llamaremos a nuestra clase DatePickerFragment para que muestre el calendario.
        val datePicker = DatePickerFragment{day, month, year ->  onDateSelected(day,month, year) }
    datePicker.show(supportFragmentManager, "datePiker")

    }

    fun onDateSelected(day:Int, month:Int, year:Int) {
        binding.etDate.setText("Has seleccionado el dia $day del $month del $year")
    }

}