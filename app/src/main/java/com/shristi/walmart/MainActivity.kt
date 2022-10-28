package com.shristi.walmart

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton.setOnClickListener {
            if (versionEditText.text.isEmpty()) {
                versionEditText.error = "Android Version cannot be empty!"
                return@setOnClickListener
            }
            if (codeEditText.text.isEmpty()) {
                codeEditText.error = "Android Code Name cannot be empty!"
                return@setOnClickListener
            }

            //Create a new table row
            val tableRow = TableRow(applicationContext)
            tableRow.setPadding(18)
            tableRow.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.lightpink))


            // Set new table row layout parameters.
            val layoutParams = TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(0, 24, 0, 0)
            tableRow.layoutParams = layoutParams

            val versionTextView = TextView(applicationContext)
            versionTextView.text = versionEditText.text.toString()
            versionTextView.gravity = Gravity.CENTER_HORIZONTAL
            versionTextView.setTextColor(Color.parseColor("#000000"))
            versionTextView.textSize = 16f
            // add values into row by calling addView()
            tableRow.addView(versionTextView)

            val codeTextView = TextView(applicationContext)
            codeTextView.text = codeEditText.text.toString()
            codeTextView.gravity = Gravity.CENTER_HORIZONTAL
            versionTextView.setTextColor(Color.parseColor("#000000"))
            versionTextView.textSize = 16f
            tableRow.addView(codeTextView)

            // Finally add the created row row into layout
            tableLayout.addView(tableRow, layoutParams)

            versionEditText.text.clear()
            codeEditText.text.clear()
            codeEditText.clearFocus()
        }
    }
}