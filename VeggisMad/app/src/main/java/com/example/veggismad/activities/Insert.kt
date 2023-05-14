package com.example.veggismad.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.veggismad.models.DeliveryModel
import com.example.veggismad.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Insert : AppCompatActivity() {

    private lateinit var name: EditText
    private lateinit var address: EditText
    private lateinit var email: EditText
    private lateinit var pNumber: EditText
    private lateinit var submitData: Button

    private lateinit var dbRef: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(R.layout.activity_insert)

        name = findViewById(R.id.insertName)
        address = findViewById(R.id.insertAddress)
        email = findViewById(R.id.insertEmail)
        pNumber = findViewById(R.id.insertNumber)
        submitData = findViewById(R.id.submit)

        dbRef = FirebaseDatabase.getInstance().getReference("DeliveryDetails")

        submitData.setOnClickListener{
            saveDeliveryData()
        }
    }

    private fun saveDeliveryData(){

        //getting values
        val nameADD = name.text.toString()
        val addressADD = address.text.toString()
        val emailADD = email.text.toString()
        val pNumberADD = pNumber.text.toString()

        if (nameADD.isEmpty()){
            name.error = "Please Enter your Name"
        }

        if (addressADD.isEmpty()){
            address.error = "Please Enter your Address"
        }

        if (emailADD.isEmpty()){
            email.error = "Please Enter your Email"
        }

        if (pNumberADD.isEmpty()){
            pNumber.error = "Please Enter your Phone number"
        }

        val deliveryAddressID = dbRef.push().key!!

        val delivery = DeliveryModel(deliveryAddressID, nameADD, addressADD, emailADD, pNumberADD)

        dbRef.child(deliveryAddressID).setValue(delivery)
            .addOnCompleteListener{
                Toast.makeText(this, "Insert successfully", Toast.LENGTH_LONG).show()

                name.text.clear()
                address.text.clear()
                email.text.clear()
                pNumber.text.clear()

            }.addOnFailureListener{ err ->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
            }



    }
}