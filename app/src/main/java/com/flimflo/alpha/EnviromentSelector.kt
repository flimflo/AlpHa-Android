package com.flimflo.alpha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class EnviromentSelector : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviroment_selector)
    }

    fun SaturdatSelected(view: View) {
        goToMainScreen(EndpointEnviroment.SATURDAY)
    }
    fun SundaySelected(view: View) {
        goToMainScreen(EndpointEnviroment.SUNDAY)
    }

    private fun goToMainScreen(enviromentSelected: EndpointEnviroment) {
        Enviroment.setEnviroment(enviromentSelected)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}