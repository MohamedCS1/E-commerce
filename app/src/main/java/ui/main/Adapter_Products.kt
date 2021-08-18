package ui.main

import Pojo.Product_Model
import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ecommerce.R
import ui.DetailProducts.Detail_Product

class Adapter_Products(val context: Context):RecyclerView.Adapter<Adapter_Products.PrductViewHolder>() {

    private var arraylist = arrayListOf<Product_Model>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrductViewHolder {

        return PrductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_product,parent,false))

    }

    @SuppressLint("ResourceType")
    override fun onBindViewHolder(holder: PrductViewHolder, position: Int) {
//        holder.tv_id.text = arraylist[position].id.toString()
        holder.tv_title.text = arraylist[position].title.toString()
        holder.tv_price.text = arraylist[position].price.toString()
//        holder.tv_description.text = arraylist[position].description
//        holder.tv_category.text = arraylist[position].category

        holder.image_product.layoutParams.height = 300
        holder.image_product.layoutParams.width = 300

        val url = arraylist[position].image
        Glide.with(context).load(url).placeholder(R.drawable.placeholderimg).into(holder.image_product)

        holder.card_product.setOnClickListener {
            val intent = Intent(context,Detail_Product::class.java)
            intent.putExtra("title",arraylist[position].title)
            intent.putExtra("price",arraylist[position].price.toString())
            intent.putExtra("category" ,arraylist[position].category.toString())
            intent.putExtra("description" ,arraylist[position].description.toString())
            intent.putExtra("image_url",arraylist[position].image)
            context.startActivities(arrayOf(intent))
        }

        holder.bu_details.setOnClickListener{
            val intent = Intent(context,Detail_Product::class.java)
            intent.putExtra("title",arraylist[position].title)
            intent.putExtra("price",arraylist[position].price.toString())
            intent.putExtra("category" ,arraylist[position].category.toString())
            intent.putExtra("description" ,arraylist[position].description.toString())
            intent.putExtra("image_url",arraylist[position].image)
            context.startActivities(arrayOf(intent))
        }

    }

    override fun getItemCount(): Int {
        return arraylist.size
    }

    class PrductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val image_product = itemView.findViewById<ImageView>(R.id.image_product)
//        val tv_id = itemView.findViewById<TextView>(R.id.tv_id)
        val tv_title = itemView.findViewById<TextView>(R.id.tv_title)
        val tv_price = itemView.findViewById<TextView>(R.id.tv_price)
//        val tv_description = itemView.findViewById<TextView>(R.id.tv_description)
//        val tv_category = itemView.findViewById<TextView>(R.id.tv_category)
        val card_product = itemView.findViewById<CardView>(R.id.card_product)
        val bu_details = itemView.findViewById<Button>(R.id.bu_details)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(ArrayList:ArrayList<Product_Model>)
    {
        this.arraylist = ArrayList
        Log.d("res",arraylist.size.toString())
        notifyDataSetChanged()
    }

}
