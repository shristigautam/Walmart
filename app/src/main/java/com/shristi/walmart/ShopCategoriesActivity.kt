package com.shristi.walmart
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.shristi.walmart.R
import kotlinx.android.synthetic.main.activity_shop_categories.*

class ShoppingCategoryActivity : AppCompatActivity() {

    private val electronicProductList = arrayListOf(
        Product(
            itemId = "1",
            title = "Samsung Galaxy Ao3",
            price = 172.0,
            color = "Black",
            desc = "The Galaxy A03s smart phone has the 5,000mAh power you can rely on to be prepared for whatever you get into; And 7.75W charging gives you pick-me-up capacity when you need it. It was designed with processing speed in mind;\n" +
                    "Its reliable processing power makes downloading, streaming, and sharing a breeze. As one of our most affordable A Series phones, Galaxy A03s is both simple and durable; And its side-mounted finger sensor adds a personal touch to security.",
            image = R.drawable.samsungo3
        ),
        Product(
            itemId = "2",
            title = "Apple iPhone 12",
            price = 800.0,
            color = "White",
            desc = "Apple iPhone 12 is the latest smartphone from Apple. It has a 6.1-inch display, 4GB RAM, 64GB storage, and a 2815mAh battery. It has a 12MP + 12MP + 12MP triple rear camera and a 12MP front camera. It runs on iOS 14 and is powered by a 2815mAh battery.",
            image = R.drawable.iphone12
        ),
        Product(
            itemId = "3",
            title = "Samsung Galaxy S22 Ultra",
            price = 1049.0,
            color = "Black",
            desc = "The Galaxy S22 Ultra is slim and bold, with a polished frame that surrounds the extruded shape for elegant symmetry. And the linear camera, accented by mirrored lens rings, seems to float in place. Eject the S Pen from the bottom of the phone to write, sketch or control your phone. With the massive pixel sensors and shape-shifting pixels, this phone has Samsung's advanced Pro-grade Camera, packing the power of a professional's kit in one handheld device.",
            image = R.drawable.samsung22
        ),
        Product(
            itemId = "4",
            title = "Google Pixel 5",
            price = 700.0,
            color = "Black",
            desc = "Google Pixel 5 is the latest smartphone from Google. It has a 6.0-inch display, 8GB RAM, 128GB storage, and a 4080mAh battery. It has a 12.2MP + 16MP + 12.2MP triple rear camera and a 8MP front camera. It runs on Android 11 and is powered by a 4080mAh battery.",
            image = R.drawable.pixel5
        ),
        Product(
            itemId = "5",
            title = "OnePlus 8T",
            price = 600.0,
            color = "Black",
            desc = "OnePlus 8T is the latest smartphone from OnePlus. It has a 6.55-inch display, 12GB RAM, 256GB storage, and a 4500mAh battery. It has a 48MP + 16MP + 5MP triple rear camera and a 16MP front camera. It runs on Android 11 and is powered by a 4500mAh battery.",
            image = R.drawable.oneplus8t
        ),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_categories)
        val userName = intent.getStringExtra("email")
        textViewWelcome.text = "Welcome $userName"
        setListener()
    }

    fun setListener() {
        imageViewElec.setOnClickListener {
            Toast.makeText(this, "You have chosen Electronics.", Toast.LENGTH_LONG).show()
            startActivity(
                ProductActivity.newInstance(
                    this,
                    productList = electronicProductList
                )
            )
        }
        imageViewCloth.setOnClickListener {
            Toast.makeText(this, "You have chosen Clothing.", Toast.LENGTH_LONG).show()
        }
        imageViewBeauty.setOnClickListener {
            Toast.makeText(this, "You have chosen Beauty.", Toast.LENGTH_LONG).show()
        }
        imageViewFood.setOnClickListener {
            Toast.makeText(this, "You have chosen Food.", Toast.LENGTH_LONG).show()
        }
    }
}