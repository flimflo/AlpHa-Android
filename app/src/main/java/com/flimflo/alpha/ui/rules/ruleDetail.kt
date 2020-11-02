package com.flimflo.alpha.ui.rules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.TextView
import com.flimflo.alpha.R
import kotlinx.android.synthetic.main.activity_rule_detail.*
import java.util.ArrayList

class ruleDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rule_detail)

        val bundle=intent.extras

        if(bundle != null) {
            val finalText =  getString(R.string.rule) + bundle.getInt(rulesConstants.ruleNumber.toString()).toString()
            tvRuleNumber.text =  finalText
            imRuleIcon.setImageResource(bundle.getInt(rulesConstants.ruleImage.toString()))
            tvRuleTitle.text = bundle.getString(rulesConstants.ruleTitle.toString())

            addDescriptions(bundle.getStringArrayList(rulesConstants.ruleDescription.toString()))
        }
    }

    fun addDescriptions(descriptionList: ArrayList<String>?) {

        var counter = 1

        if(descriptionList != null) {
            for(description in descriptionList) {

                val newDescription = TextView(this)
                val finalText = counter.toString() + ".- " + description
                newDescription.setText(finalText)
                newDescription.setTextSize(TypedValue.COMPLEX_UNIT_SP,18F)

                LLDescription.addView(newDescription)

                counter++
            }
        }
    }
}