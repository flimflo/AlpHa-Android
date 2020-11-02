package com.flimflo.alpha.ui.rules

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.flimflo.alpha.R

class RulesAdapter(private val context: Context, private val rulesList: MutableList<Rule>) :
    RecyclerView.Adapter<RulesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rules_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = rulesList[position]
        val ruleImage = currentItem.image
        val ruleNumber = currentItem.ruleNumber
        holder.ruleImage.setImageResource(ruleImage!!)
        val finalText = context.getString(R.string.rule) + ruleNumber.toString()
        holder.ruleNumber.text = finalText
    }

    override fun getItemCount(): Int {
        return rulesList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ruleImage: ImageView
        var ruleNumber: TextView
        init {
            ruleImage = itemView.findViewById(R.id.ivRuleImage)
            ruleNumber = itemView.findViewById(R.id.tvRule)

            itemView.setOnClickListener {
                val position = adapterPosition
                val currentRule = rulesList[position]
                val intent = Intent(context, ruleDetail::class.java)
                intent.putExtra(rulesConstants.ruleNumber.toString(),currentRule.ruleNumber)
                intent.putExtra(rulesConstants.ruleImage.toString(),currentRule.image)
                intent.putExtra(rulesConstants.ruleTitle.toString(),currentRule.ruleTitle)
                intent.putStringArrayListExtra(rulesConstants.ruleDescription.toString(), ArrayList(currentRule.ruleDescription))
                context.startActivity(intent)
            }
        }
    }
}