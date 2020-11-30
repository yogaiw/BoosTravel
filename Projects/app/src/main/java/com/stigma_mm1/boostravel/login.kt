package com.stigma_mm1.boostravel

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_login.*


class login : AppCompatActivity() {

    var valid: Boolean = true
    val fAuth: FirebaseAuth = FirebaseAuth.getInstance()
    val fStore: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            checkField(edtEmail)
            checkField(edtPassword)

            fAuth.signInWithEmailAndPassword(edtEmail.text.toString(), edtPassword.text.toString()).addOnSuccessListener(OnSuccessListener {
                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()
                val df: DocumentReference = fStore.collection("Users").document(it.user?.uid.toString())

                df.get().addOnSuccessListener(OnSuccessListener {
                    if(it.getString("isMitra") == "0") {
                        startActivity(Intent(this, home::class.java))
                    } else {
                        startActivity(Intent(this, mitra_home::class.java))
                    }
                })
            }).addOnFailureListener { OnFailureListener {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
            }}
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