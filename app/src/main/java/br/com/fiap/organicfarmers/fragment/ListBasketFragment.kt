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
import br.com.fiap.organicfarmers.modal.Basket
import kotlinx.android.synthetic.main.fragment_list_basket.view.*
import kotlinx.android.synthetic.main.fragment_basket_item.view.*

class ListBasketFragment : Fragment {

    constructor() {}

    constructor(baskets: ArrayList<Basket>) {
        this.baskets = baskets
    }

    private lateinit var baskets: ArrayList<Basket>

    companion object {
        fun newInstance(baskets: ArrayList<Basket>) = ListBasketFragment(baskets)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_list_basket, container, false)
        val activity = activity as Context
        val recyclerView = view.recycler_view_basket
        recyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = ProductListAdapter()
        recyclerView.adapter
        return view
    }

    internal inner class ProductListAdapter : RecyclerView.Adapter<ViewHolder>() {

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) =
            ViewHolder(
                LayoutInflater.from(viewGroup.context).inflate(
                    R.layout.fragment_basket_item, viewGroup, false
                )
            )

        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
            viewHolder.bind(baskets[position])
        }

        override fun getItemCount(): Int {
            return baskets.size
        }
    }

    internal inner class ViewHolder constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(basket: Basket) {
            itemView.basket_name.text = basket.name
            itemView.basket_price.text = basket.price
        }
    }

}