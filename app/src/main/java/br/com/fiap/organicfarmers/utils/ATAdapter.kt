package br.com.fiap.organicfarmers.utils

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

open class ATAdapter<V : ATViewHolder<M, B>, M, B : ViewBinding>(
    protected val viewHolder: (ViewGroup) -> V,
    private val onItemClick: ((M) -> Unit)? = null
) : RecyclerView.Adapter<V>() {

    var items: MutableList<M> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): V {
        return viewHolder(parent)
    }

    override fun onBindViewHolder(holder: V, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.onClickListener(item, onItemClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}