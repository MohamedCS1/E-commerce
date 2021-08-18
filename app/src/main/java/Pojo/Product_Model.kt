package Pojo

class Product_Model {

    var id: Int? = null
    var title: String? = null
    var price: Double? = null
    var description: String? = null
    var category: String? = null
    var image:String? = null

    constructor(id: Int, title: String, price: Double, description: String, category: String,image:String)
    {
        this.image = image
        this.id = id
        this.title = title
        this.price = price
        this.description = description
        this.category = category
    }

}