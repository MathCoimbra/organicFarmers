package br.com.fiap.organicfarmers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding


abstract class ATViewHolder<M, B : ViewBinding>(
    bindingLaunch: (LayoutInflater, ViewGroup?, Boolean) -> ViewBinding,
    root: ViewGroup,
    val
    binding: B = bindingLaunch(LayoutInflater.from(root.context), root, false) as B
) : RecyclerView.ViewHolder(
    binding.root
) {

    abstract fun bind(item: M)

    fun onClickListener(item: M, callback: ((M) -> Unit)?) {
        binding.root.setOnClickListener {
            callback?.invoke(item)
        }
    }

}