package br.com.fiap.organicfarmers.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.organicfarmers.R
import br.com.fiap.organicfarmers.modal.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_list_product_category.view.*
import kotlinx.android.synthetic.main.fragment_product_item.view.*


class ListProductCategoryFragment : Fragment {

    constructor() {}

    constructor(products: ArrayList<Product>, category: String) {
        this.products = products
        this.category = category
    }

    private lateinit var products: ArrayList<Product>
    private lateinit var category: String


    companion object {
        fun newInstance(products: ArrayList<Product>, category: String) =
            ListProductCategoryFragment(products, category)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_list_product_category, container, false)
        val activity = activity as Context
        val recyclerView = view.recycler_view_products
        recyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = ProductListAdapter()
        recyclerView.adapter

        view.product_category.text = this.category
        return view
    }

    internal inner class ProductListAdapter : RecyclerView.Adapter<ViewHolder>() {

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) =
            ViewHolder(
                LayoutInflater.from(viewGroup.context).inflate(
                    R.layout.fragment_product_item, viewGroup, false
                )
            )

        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
            viewHolder.bind(products[position])
        }

        override fun getItemCount(): Int {
            return products.size
        }
    }

    internal inner class ViewHolder constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(product: Product) {
            itemView.product_name.text = product.name
            itemView.product_the_amount.text = product.theAmount
            itemView.product_price.text = product.price

            Picasso.get()
                .load(product.urlImg)
                .into(itemView.product_img)

        }

    }

}