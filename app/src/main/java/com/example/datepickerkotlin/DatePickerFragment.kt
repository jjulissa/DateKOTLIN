package com.example.datepickerkotlin

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*

// Class ‘DatePickerFragment’ is not abstract and
// does not implement abstract member public abstract
// fun onDateSet(view: DatePicker!, year: Int, month: Int,
// dayOfMonth: Int): Unit defined in
// android.app.DatePickerDialog.OnDateSetListener
class DatePickerFragment (val listener: (day:Int, month:Int, year:Int)

// DialogFragment: Se trata de la clase padre que tiene
// todo el código para poder mostrar los datePicker
-> Unit): DialogFragment(),

// DatePickerDialog.OnDateSetListener: Añadir esto hará
// que podamos implementar una función
// para saber cuando el usuario ha seleccionado
// una fecha y que valores ha seleccionado.
DatePickerDialog.OnDateSetListener {

//  Esta función se llamará cuando el usuario seleccione una fecha y nos devolverá los datos seleccionados.
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        listener(dayOfMonth, month, year)

    }

// Esta función será la encargada de iniciar y mostrar el datePicker.
// Para crear un datePicker, la función necesitará la fecha de inicio
// (separada por día, mes y año), el contexto, y un listener
// como el que hemos implementado para saber
// cuando el usuario ha seleccionado una fecha.
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

//  Lo primero que he hecho ha sido crear un Calendar,
//  esta clase nos permite acceder a los datos de hoy
//  de una forma sencilla. A través del objeto Calendar,
//  puedo llamar a la función get(), y pedirle el año,
//  el mes y el día del mes.
    val c = Calendar.getInstance()
        val day = c.get(Calendar.DAY_OF_MONTH)
        val month = c.get(Calendar.MONTH)
        val year = c.get(Calendar.YEAR)

//  datePicker: le estoy pasando el contexto, que para ello tengo que hacer activity as Context, le estoy pasando el listener, que como lo tengo implementado en la clase solo tengo que poner this y termino añadiendo el año, el mes y el día.
    val picker = DatePickerDialog(activity as Context, R.style.DatePickerTheme, this, year, month, day)

//   minDate: Fechas anteriores
        picker.datePicker.minDate = c.timeInMillis

//  Lo que hemos hecho ha sido poner de fecha mínima hoy,
//  luego hemos sumado dos meses al mes del calendario y
//  le decimos que se lo ponga a la fecha máxima.
        c.add(Calendar.MONTH, +2)

//  datePicker nos da la posibilidad de añadir
//  una fecha mínima y otra máxima.

//  maxDate: Permite añadir la fecha máxima
        picker.datePicker.maxDate = c.timeInMillis
        return picker


    }
}

//  Nuestro objeto picker, es una instancia de un DatePickerDialog(),
//  cada una de estas instancias tiene un atributo dentro
//  que es el propio picker. Para acceder a él tendremos
//  que llamar a datePicker dentro de nuestro objeto picker.

//          val picker = DatePickerDialog(activity as Context, R.style.DatePickerTheme, this, year, month, day)
//        picker.datePicker