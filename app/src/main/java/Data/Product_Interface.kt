package Data

import Pojo.Product_Model
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Product_Interface {
    @GET("/products")
    fun get_Products():Call<List<Product_Model>>

    @GET("/products/category/{category}")
    fun get_Products_by_categories(@Path(value = "category") category: String):Call<List<Product_Model>>
}