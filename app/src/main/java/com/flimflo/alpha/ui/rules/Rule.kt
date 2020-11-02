package com.flimflo.alpha.ui.rules

class Rule {
    var image:Int? = null
    var ruleNumber:Int? = null
    var ruleTitle:String? = null
    var ruleDescription:MutableList<String>? = null

    constructor(ruleNumber:Int,ruleTitle:String,image:Int,ruleDescription:MutableList<String>,) {
        this.image = image
        this.ruleNumber = ruleNumber
        this.ruleTitle = ruleTitle
        this.ruleDescription = ruleDescription
    }
}