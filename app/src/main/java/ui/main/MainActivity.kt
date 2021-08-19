package ui.main

import Pojo.Product_Model
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.graphics.drawable.RoundedBitmapDrawable
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ui.Profil.Profil
import com.bumptech.glide.request.RequestOptions

import com.bumptech.glide.Glide
import com.google.android.material.shape.RoundedCornerTreatment


class MainActivity : AppCompatActivity() {

    var ProductsViewModel:ProductsViewModel? = null

    var adapter:Adapter_Products? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bu_scroll_top = findViewById<FloatingActionButton>(R.id.bu_scroll_top)

        adapter = Adapter_Products(this)

        val rv = findViewById<RecyclerView>(R.id.rv_Products)

        val lm = GridLayoutManager(this, 2)

        rv.adapter = adapter

        ProductsViewModel = ProductsViewModel()

        rv.layoutManager = lm

        lm.isSmoothScrolling

        ProductsViewModel!!.start()

        ProductsViewModel!!.MutableLiveDataProduct.observe(this,
            object : Observer<List<Product_Model>> {
                override fun onChanged(t: List<Product_Model>?) {
                    adapter!!.setList(t as ArrayList<Product_Model>)
                }

            })


        val rv_categories = findViewById<RecyclerView>(R.id.rv_categories)

        val adapter_rv_categories = Adapter_categories(this, this,rv,rv_categories)

        val list_categories = arrayListOf<String>()

        val lm_rv_categories = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        rv_categories.adapter = adapter_rv_categories

        rv_categories.layoutManager = lm_rv_categories


        list_categories.add("All")
        list_categories.add("jewelery")
        list_categories.add("electronics")
        list_categories.add("men's clothing")
        list_categories.add("women's clothing")

        adapter_rv_categories.setList(list_categories)

        bu_scroll_top.setOnClickListener {
            rv.smoothScrollToPosition(0)
        }

        val bu_profil = findViewById<ImageView>(R.id.bu_profil)

        bu_profil.setOnClickListener {
            startActivity(Intent(this,Profil::class.java))
        }

    }

}