package ui.DetailProducts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.ecommerce.R

import android.widget.TextView
import com.bumptech.glide.Glide


class Detail_Product : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)
        val tv_title = findViewById<TextView>(R.id.tv_d_title)
        val tv_price = findViewById<TextView>(R.id.tv_d_price)
        val tv_category = findViewById<TextView>(R.id.tv_d_category)
        val tv_description = findViewById<TextView>(R.id.tv_d_description)
        val image_view = findViewById<ImageView>(R.id.imageView_d)
        val bu_call = findViewById<Button>(R.id.bu_call)

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

        }
    }
}