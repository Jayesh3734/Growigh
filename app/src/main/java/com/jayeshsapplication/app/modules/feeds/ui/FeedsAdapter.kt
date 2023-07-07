package com.jayeshsapplication.app.modules.feeds.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jayeshsapplication.app.R
import com.jayeshsapplication.app.databinding.RowFeedsBinding
import com.jayeshsapplication.app.modules.feeds.data.model.FeedsRowModel

class FeedsAdapter(
  var list: List<FeedsRowModel>
) : RecyclerView.Adapter<FeedsAdapter.RowFeedsVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowFeedsVH {
    val view =
      LayoutInflater.from(parent.context).inflate(R.layout.row_feeds, parent, false)
    return RowFeedsVH(view)
  }

  override fun onBindViewHolder(holder: RowFeedsVH, position: Int) {
    val feedsRowModel = list[position]
    holder.binding.feedsRowModel = feedsRowModel

    Glide.with(holder.itemView)
      .load(feedsRowModel.imageUrl)
  }

  override fun getItemCount(): Int = list.size

  public fun updateData(newData: List<FeedsRowModel>) {
    list = newData
    notifyDataSetChanged()
  }

  fun setOnItemClickListener(clickListener: OnItemClickListener) {
    this.clickListener = clickListener
  }

  interface OnItemClickListener {
    fun onItemClick(
      view: View,
      position: Int,
      item: FeedsRowModel
    )
  }

  inner class RowFeedsVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowFeedsBinding = RowFeedsBinding.bind(itemView)
  }
}


