package com.tfxsoftware.recyclelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import org.json.JSONObject
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
                Toast.makeText(this, connectDb().toString(), Toast.LENGTH_SHORT).show()
                addContact(newContact)
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



    private fun connectDb(): StorageReference{
        val storage = FirebaseStorage.getInstance()
        return storage.reference
    }

    private fun addContact(contact: ContactEntry){
        val fileRef = connectDb().child(contact.name + ".json")
        val json = JSONObject()
        json.put("name", contact.name)
        json.put("number", contact.number)
        val bytes = json.toString().toByteArray()
        fileRef.putBytes(bytes)

    }
}