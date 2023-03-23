package com.tfxsoftware.recyclelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.Serializable

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val editNumber: EditText = findViewById(R.id.editNumber)
        val editName: EditText = findViewById(R.id.editName)
        val registerButton: Button = findViewById(R.id.button)
        registerButton.setOnClickListener {
            try{
                var number = editNumber.text.toString()
                var name = editName.text.toString()
                var newContact = ContactEntry(name, number)
//                val intent = Intent(this, MainActivity::class.java)

                Intent().apply {
                    putExtra("contato", newContact)
                    setResult(RESULT_OK, this)
                }

                finish()

            }
            catch(e: Exception){
                Toast.makeText(this, "Favor preencha todos os campos", Toast.LENGTH_SHORT).show()
            }

        }
    }
}