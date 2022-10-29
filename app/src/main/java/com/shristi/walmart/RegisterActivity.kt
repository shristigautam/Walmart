package com.shristi.walmart

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shristi.walmart.R
import com.shristi.walmart.model.UserAccount
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

//    companion object {
//        fun newInstance(context: Context): Intent {
//            return Intent(context, RegisterActivity::class.java)
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        register_button.setOnClickListener {
            val firstName = editTextFirstName.text.toString()
            val lastName = editTextLastName.text.toString()
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            if (firstName.isEmpty()) {
                editTextFirstName.error = "First Name is required"
                return@setOnClickListener
            }
            if (lastName.isEmpty()) {
                editTextLastName.error = "Last Name is required"
                return@setOnClickListener
            }
            if (email.isEmpty()) {
                editTextEmail.error = "Email is required"
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                editTextPassword.error = "Password is required"
                return@setOnClickListener
            }
            val user = UserAccount(firstName, lastName, email, password)
            val data = Intent()
            data.putExtra("user", user)
            setResult(RESULT_OK, data)
            finish()
        }
    }

    override fun onBackPressed() {
        setResult(RESULT_CANCELED)
        super.onBackPressed()
    }
}