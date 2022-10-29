package com.shristi.walmart

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.shristi.walmart.model.UserAccount
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var userList: ArrayList<UserAccount> = arrayListOf<UserAccount>(
        UserAccount("Shristi", "Gautam", "shristigautam@miu.edu", "Shristi123"),
        UserAccount("Renuka", "Mohanraj", "rmohanraj@miu.edu", "Rm123"),
        UserAccount("Computer", "Careers", "computercareers@miu.edu", "Cc123"),
        UserAccount("Ram", "Bahadur", "rbahadur@gmail.com", "Rb123"),
        UserAccount("Sita", "Kumari", "skumari@gmail.com", "Sk123"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var email: String = editTextEmail.text.toString().trim()
        var userAccount: UserAccount? = userList.find { s -> s.userEmail == email }

        signInButton.setOnClickListener {
            //removing whitespace and getting email and password
            var email: String = editTextEmail.text.toString().trim()
            var password: String = editTextPassword.text.toString().trim()
            println(email)
            println(password)
            if (email.isNullOrEmpty()) {
                editTextEmail.error = "Please enter a valid email!"
            } else
                if (password.isNullOrEmpty()) {
                    editTextPassword.error = "Please enter a valid password!"
                }

            if (!verifyUser(email, password)) {
                Toast.makeText(this, "User does not exist.", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, ShoppingCategoryActivity::class.java)
                intent.putExtra("email", email)
                startActivity(intent);
            }

        }



        textViewForgot.setOnClickListener {
            if (email.isNullOrEmpty()) {
                editTextEmail.error = "Invalid email !"
                return@setOnClickListener
            }
            //Email
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                type = "*/*"    //"text/plain"
                data = Uri.parse("mailto:shristigautam@miu.edu")
                putExtra(Intent.EXTRA_SUBJECT, "Here is your password!")
                putExtra(Intent.EXTRA_TEXT, "Your password is :" + userAccount?.password)
            }
            startActivity(intent)
        }



        val resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val data = result.data
                    val user = data?.getSerializableExtra("user") as UserAccount
                    if (userAccount != null) userList.add(user)
                    Toast.makeText(
                        this,
                        "User account created successfully!",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(this, "Error creating user!", Toast.LENGTH_LONG).show()
                }
            }

        createUserButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
//            startActivity(intent);
            resultLauncher.launch(intent)
        }


    }

    fun verifyUser(email: String, password: String): Boolean {
        return userList.contains(UserAccount("", "", email, password))
    }
}