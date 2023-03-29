@file:Suppress("DEPRECATION")

package com.example.assignmentrecyclerview1
import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.text.SimpleDateFormat
import java.util.*


   class MainActivity : AppCompatActivity() {
    private lateinit var dateAndTimeEditText: EditText
    private lateinit var dateAndTimeImageView: ImageView
    private lateinit var menButton: Button
    private lateinit var womenButton: Button
    private lateinit var vectorImageView: ImageView
    private lateinit var name: EditText
    private lateinit var email: EditText
    private lateinit var gender: EditText
    private lateinit var dob: EditText
    private lateinit var btechPassoutYear: EditText
    private lateinit var saveButton: Button
    private lateinit var dateandtime : EditText

    @SuppressLint("SetTextI18n", "CutPasteId")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        name = findViewById(R.id.name_edittext)
        email = findViewById(R.id.email_edittext)
        dateandtime = findViewById(R.id.dateandtime_edittext)
        dob = findViewById(R.id.DOB_edittext)
        btechPassoutYear = findViewById(R.id.btechpassout_edittext)
        saveButton = findViewById(R.id.saveButton)
        saveButton = findViewById(R.id.saveButton)
        saveButton.setOnClickListener {
            processInsert(
                name.text.toString(),
                email.text.toString(),
                getSelectedGender(),
                dob.text.toString(),
                dateandtime.text.toString(),
                btechPassoutYear.text.toString()
            )
            startActivity(Intent(applicationContext, Fetchdata::class.java))


        }

        val menButton = findViewById<Button>(R.id.maleButton)
        val womenButton = findViewById<Button>(R.id.femaleButton)
        vectorImageView = findViewById(R.id.vector_image_view)
        menButton.setOnClickListener {
            vectorImageView.setImageResource(R.drawable.ic_male)
            menButton.setBackgroundResource(R.color.Bluewhale)
            menButton.setTextColor(ContextCompat.getColor(this, R.color.white))
            womenButton.setBackgroundResource(R.color.mythirdcolor)
            womenButton.setTextColor(ContextCompat.getColor(this, R.color.black))
        }
        womenButton.setOnClickListener {
            vectorImageView.setImageResource(R.drawable.women)
            menButton.setBackgroundResource(R.color.mythirdcolor)
            menButton.setTextColor(ContextCompat.getColor(this, R.color.black))
            womenButton.setBackgroundResource(R.color.Bluewhale)
            womenButton.setTextColor(ContextCompat.getColor(this, R.color.white))
        }
        val rating1ImageView: ImageView = findViewById(R.id.rating1_imageview)
        val rating2ImageView: ImageView = findViewById(R.id.rating2_imageview)
        val rating3ImageView: ImageView = findViewById(R.id.rating3_imageview)
        val rating4ImageView: ImageView = findViewById(R.id.rating4_imageview)
        val rating5ImageView: ImageView = findViewById(R.id.rating5_imageview)
        val emptyCircleDrawable = ContextCompat.getDrawable(this, R.drawable.empty_circle)
        val filledCircleDrawable = ContextCompat.getDrawable(this, R.drawable.filled_circle)
        fun setRating(rating: Int) {
            rating1ImageView.setImageDrawable(emptyCircleDrawable)
            rating2ImageView.setImageDrawable(emptyCircleDrawable)
            rating3ImageView.setImageDrawable(emptyCircleDrawable)
            rating4ImageView.setImageDrawable(emptyCircleDrawable)
            rating5ImageView.setImageDrawable(emptyCircleDrawable)
            when (rating) {
                1 -> rating1ImageView.setImageDrawable(filledCircleDrawable)
                2 -> rating2ImageView.setImageDrawable(filledCircleDrawable)
                3 -> rating3ImageView.setImageDrawable(filledCircleDrawable)
                4 -> rating4ImageView.setImageDrawable(filledCircleDrawable)
                5 -> rating5ImageView.setImageDrawable(filledCircleDrawable)
            }
        }

        rating1ImageView.setOnClickListener {
            setRating(1)
        }

        rating2ImageView.setOnClickListener {
            setRating(2)
        }

        rating3ImageView.setOnClickListener {
            setRating(3)
        }

        rating4ImageView.setOnClickListener {
            setRating(4)
        }
        rating5ImageView.setOnClickListener {
            setRating(5)
        }
        val ratingValue = 3.4
        val star1 = findViewById<ImageView>(R.id.star1)
        val star2 = findViewById<ImageView>(R.id.star2)
        val star3 = findViewById<ImageView>(R.id.star3)
        val star4 = findViewById<ImageView>(R.id.star4)
        val star5 = findViewById<ImageView>(R.id.star5)
        val filledStars = ratingValue.toInt()
        star1.setImageResource(if (filledStars >= 1) R.drawable.ic_star_filled else R.drawable.ic_star_empty)
        star2.setImageResource(if (filledStars >= 2) R.drawable.ic_star_filled else R.drawable.ic_star_empty)
        star3.setImageResource(if (filledStars >= 3) R.drawable.ic_star_filled else R.drawable.ic_star_empty)
        star4.setImageResource(if (filledStars >= 5) R.drawable.ic_star_filled else R.drawable.ic_star_empty)
        star5.setImageResource(if (filledStars >= 5) R.drawable.ic_star_filled else R.drawable.ic_star_empty)
        star1.setOnClickListener {
            star1.setImageResource(R.drawable.ic_star_filled)
            star2.setImageResource(R.drawable.ic_star_empty)
            star3.setImageResource(R.drawable.ic_star_empty)
            star4.setImageResource(R.drawable.ic_star_empty)
            star5.setImageResource(R.drawable.ic_star_empty)
        }
        star2.setOnClickListener {
            star1.setImageResource(R.drawable.ic_star_filled)
            star2.setImageResource(R.drawable.ic_star_filled)
            star3.setImageResource(R.drawable.ic_star_empty)
            star4.setImageResource(R.drawable.ic_star_empty)
            star5.setImageResource(R.drawable.ic_star_empty)
        }
        star3.setOnClickListener {
            star1.setImageResource(R.drawable.ic_star_filled)
            star2.setImageResource(R.drawable.ic_star_filled)
            star3.setImageResource(R.drawable.ic_star_filled)
            star4.setImageResource(R.drawable.ic_star_empty)
            star5.setImageResource(R.drawable.ic_star_empty)
        }
        star4.setOnClickListener {
            star1.setImageResource(R.drawable.ic_star_filled)
            star2.setImageResource(R.drawable.ic_star_filled)
            star3.setImageResource(R.drawable.ic_star_filled)
            star4.setImageResource(R.drawable.ic_star_filled)
            star5.setImageResource(R.drawable.ic_star_empty)
        }
        star5.setOnClickListener {
            star1.setImageResource(R.drawable.ic_star_filled)
            star2.setImageResource(R.drawable.ic_star_filled)
            star3.setImageResource(R.drawable.ic_star_filled)
            star4.setImageResource(R.drawable.ic_star_filled)
            star5.setImageResource(R.drawable.ic_star_filled)
        }
        dateAndTimeEditText = findViewById(R.id.dateandtime_edittext)
        dateAndTimeImageView = findViewById(R.id.dateandtimeImageView)
        dateAndTimeImageView.setOnClickListener {
            showDateTimePicker()
        }
        val dobEditText = findViewById<EditText>(R.id.DOB_edittext)
        val calendarImageView = findViewById<ImageView>(R.id.calendarImageView)
        calendarImageView.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this, { _, year, month, dayOfMonth ->
                val formattedDate = "%02d-%02d-%d".format(dayOfMonth, month + 1, year)
                dobEditText.setText(formattedDate)
            }, year, month, dayOfMonth)

            datePickerDialog.show()
        }

        val btechPassoutYearEditText = findViewById<EditText>(R.id.btechpassout_edittext)

        btechPassoutYearEditText.setOnClickListener {
            showYearPicker(btechPassoutYearEditText)
        }

    }

    private fun processInsert(name: String, email: String, gender: String, dob: String, btechpassoutyear: String,dateandtime: String) {
        val res = DbManager(this).addRecord(name, gender, dob, dateandtime, email, btechpassoutyear)

        Toast.makeText(this, res, Toast.LENGTH_SHORT).show()


    }

    private fun getSelectedGender(): String {
        return when {
            menButton.isSelected -> "Male"
            womenButton.isSelected -> "female"
            else -> ""
        }

    }

    private fun getRating(): Int {
        var rating = 0
        val star1 = findViewById<ImageView>(R.id.star1)
        val star2 = findViewById<ImageView>(R.id.star2)
        val star3 = findViewById<ImageView>(R.id.star3)
        val star4 = findViewById<ImageView>(R.id.star4)
        val star5 = findViewById<ImageView>(R.id.star5)

        if (star1.isSelected) {
            rating = 1
        } else if (star2.isSelected) {
            rating = 2
        } else if (star3.isSelected) {
            rating = 3
        } else if (star4.isSelected) {
            rating = 4
        } else if (star5.isSelected) {
            rating = 5
        }
        return rating

    }


    @RequiresApi(Build.VERSION_CODES.N)
    private fun showDateTimePicker() {
        val currentDateAndTime = Calendar.getInstance()
        val currentYear = currentDateAndTime.get(Calendar.YEAR)
        val currentMonth = currentDateAndTime.get(Calendar.MONTH)
        val currentDayOfMonth = currentDateAndTime.get(Calendar.DAY_OF_MONTH)
        val currentHour = currentDateAndTime.get(Calendar.HOUR_OF_DAY)
        val currentMinute = currentDateAndTime.get(Calendar.MINUTE)
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                val timePickerDialog = TimePickerDialog(
                    this,
                    { _, hourOfDay, minute ->
                        val selectedDateTime = Calendar.getInstance()
                        selectedDateTime.set(year, month, dayOfMonth, hourOfDay, minute)
                        val dateTimeFormat =
                            SimpleDateFormat("dd-MM-yyyy | HH:mm", Locale.getDefault())
                        dateAndTimeEditText.setText(dateTimeFormat.format(selectedDateTime.time))
                    },
                    currentHour,
                    currentMinute,
                    true
                )
                timePickerDialog.show()
            },
            currentYear,
            currentMonth,
            currentDayOfMonth
        )
        datePickerDialog.show()
    }

    private fun showYearPicker(editText: EditText) {
        val yearMenu = PopupMenu(this, editText)
        yearMenu.menuInflater.inflate(R.menu.year_menu, yearMenu.menu)
        yearMenu.setOnMenuItemClickListener { menuItem ->
            editText.setText(menuItem.title)

            true
        }
        yearMenu.show()
    }



}