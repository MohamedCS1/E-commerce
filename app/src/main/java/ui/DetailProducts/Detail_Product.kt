package ui.DetailProducts

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.core.graphics.drawable.toBitmap
import com.example.ecommerce.R

import com.bumptech.glide.Glide


class Detail_Product : AppCompatActivity() {

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)
        val tv_title = findViewById<TextView>(R.id.tv_d_title)
        val tv_price = findViewById<TextView>(R.id.tv_d_price)
        val tv_category = findViewById<TextView>(R.id.tv_d_category)
        val tv_description = findViewById<TextView>(R.id.tv_d_description)
        val image_view = findViewById<ImageView>(R.id.imageView_d)
        val bu_call = findViewById<Button>(R.id.bu_call)
        val bu_back = findViewById<ImageButton>(R.id.bu_back)
        val bu_save = findViewById<ImageView>(R.id.bu_save)

        val bundle = intent.extras

        val title = bundle!!.getString("title")
        val price = bundle.get("price")
        val category = bundle.get("category")
        val description = bundle.get("description")
        val image_url = bundle.get("image_url")

        tv_title.text = title.toString()
        tv_price.text = price.toString()
        tv_category.text = category.toString()
        tv_description.text = description.toString()

        Glide.with(this).load(image_url).placeholder(R.drawable.placeholderimg).into(image_view)

        bu_call.setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL, Uri.fromParts("tel","0552938510",null)))

        }

        bu_back.setOnClickListener {
            onBackPressed()
        }

        var bol:Boolean = true
        bu_save.setOnClickListener {

            if (bol)
            {
                bu_save.setImageDrawable(getDrawable(R.drawable.saved))
                Toast.makeText(this,"saved successfully!",Toast.LENGTH_SHORT).show()
                bol = false
            }
            else
            {
                bu_save.setImageDrawable(getDrawable(R.drawable.save))
                bol = true
                Toast.makeText(this,"Save has been cancelled",Toast.LENGTH_SHORT).show()

            }

        }
    }
}