package com.example.lab8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab8.databinding.RecycleRowBinding

class CarAdapter(
    private val itemList:List<Pair<String,String?>>,
    private val onItemClick: (position:Int) -> Unit
    ):
    RecyclerView.Adapter<CarAdapter.CarHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarHolder {
        val itemBinding = RecycleRowBinding.inflate(LayoutInflater.from(parent.context))
        return CarHolder(itemBinding,onItemClick)
    }

    override fun onBindViewHolder(holder: CarHolder, position: Int) {
        val carData = itemList[position]
        holder.bind(carData.first , carData.second)
    }


    override fun getItemCount(): Int {
        return itemList.size
    }

    class CarHolder(private val itemBinding: RecycleRowBinding,
                     private val onItemClick: (position:Int) -> Unit):
        RecyclerView.ViewHolder(itemBinding.root){

            init{
                itemView.setOnClickListener{
                    onItemClick(adapterPosition)
                }
            }

            fun bind(carBrand: String , carBrandPhoto:String?){
                Glide.with(itemView)
                    .load(carBrandPhoto)
                    .centerCrop()
                    .placeholder(itemBinding.carView.drawable)
                    .into(itemBinding.carView)

                itemBinding.tvCarBrand.text = carBrand
            }
        }

}