package ui.Profil

import Pojo.Product_Model
import android.graphics.drawable.Drawable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.R
import ui.main.Adapter_Products
import ui.main.ProductsViewModel
import com.bumptech.glide.Glide

import com.bumptech.glide.load.resource.bitmap.RoundedCorners

import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.RequestOptions

import android.R.attr.x





class Profil : AppCompatActivity() {

    var ProductsViewModel: ProductsViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        val image_profil = findViewById<ImageView>(R.id.image_profil)

//        CropImage.activity().setGuidelines(CropImageView.Guidelines.ON).start(this)

        val rv = findViewById<RecyclerView>(R.id.rv_saved)

        val adapter = Adapter_Products(this)

        val lm = GridLayoutManager(this, 2)

        rv.adapter = adapter

        rv.layoutManager = lm

        ProductsViewModel = ProductsViewModel()

        ProductsViewModel!!.start()

        lm.isSmoothScrolling

        ProductsViewModel!!.MutableLiveDataProduct.observe(this,
            object : Observer<List<Product_Model>> {
                override fun onChanged(t: List<Product_Model>?) {
                    adapter.setList(t as ArrayList<Product_Model>)
                }

            })

        val bu_back = findViewById<ImageView>(com.example.ecommerce.R.id.bu_back_profil)

        bu_back.setOnClickListener {
            onBackPressed()
        }

        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(50))
        Glide.with(this)
            .load(R.drawable.photo_profil)
            .apply(requestOptions)
            .into(image_profil)

    }
}