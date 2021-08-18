package ui.main

import Pojo.Product_Model
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.R
import kotlin.collections.ArrayList

class Adapter_categories(context: Context, val owner: LifecycleOwner, val rv:RecyclerView, val rv_categories:RecyclerView): RecyclerView.Adapter<Adapter_categories.ViewHolderCategories>() {

    private var arraylist = arrayListOf<String>()

    var raw_index = 0

    var ProductsViewModel:ProductsViewModel? = null

    val adapter = Adapter_Products(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCategories {

        return ViewHolderCategories(LayoutInflater.from(parent.context).inflate(R.layout.card_categories,parent,false))

    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolderCategories, @SuppressLint("RecyclerView") position: Int) {

        holder.tv_categories.text = arraylist[position]
        holder.card_categories.setOnClickListener(object :View.OnClickListener{
            @SuppressLint("NotifyDataSetChanged")
            override fun onClick(v: View?) {

                raw_index = position
                ProductsViewModel = ProductsViewModel()

                ProductsViewModel!!.start_by_categories(holder.tv_categories.text.toString())

                ProductsViewModel!!.MutableLiveDataProduct.observe(owner, object : Observer<List<Product_Model>>
                {
                    override fun onChanged(t: List<Product_Model>?) {

                        if (t!!.isEmpty())
                        {
                            ProductsViewModel!!.start()
                            rv.adapter = adapter
                            adapter.setList(t as ArrayList<Product_Model>)
                        }
                        else
                        {
                            rv.adapter = adapter
                            adapter.setList(t as ArrayList<Product_Model>)
                        }


                    }

                })
                notifyDataSetChanged()
            }

        })

        if (raw_index == position)
        {
            holder.card_categories.setCardBackgroundColor(Color.parseColor("#4cc844"))
            holder.tv_categories.setTextColor(Color.parseColor("#FFFFFF"))

            rv_categories.scrollToPosition(raw_index)


        }
        else
        {
            holder.card_categories.setCardBackgroundColor(Color.parseColor("#b0b5eb"))
            holder.tv_categories.setTextColor(Color.parseColor("#000000"))

        }

    }

    override fun getItemCount(): Int {
        return arraylist.size
    }


    class ViewHolderCategories(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val tv_categories = itemView.findViewById<TextView>(R.id.tv_categories)
        var card_categories = itemView.findViewById<CardView>(R.id.card_categories)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(ArrayList:ArrayList<String>)
    {
        this.arraylist = ArrayList
        notifyDataSetChanged()
    }
}