package com.stigma_mm1.boostravel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class login : AppCompatActivity() {

    var valid: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            checkField(edtEmail)
            checkField(edtPassword)
        }

        daftarBtn.setOnClickListener {
            startActivity(Intent(this, daftar::class.java))

        }
    }

    fun checkField(textField: EditText) {
        if(textField.getText().toString().isEmpty()) {
            textField.setError("Wajib Diisi")
            valid = false
        } else {
            valid = true
        }
    }
}