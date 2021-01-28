package com.stigma_mm1.boostravel.user_side

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.stigma_mm1.boostravel.R
import kotlinx.android.synthetic.main.activity_daftar_user.*
import kotlin.collections.HashMap

class DaftarUserActivity : AppCompatActivity() {

    var valid: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_user)

        val fAuth: FirebaseAuth = FirebaseAuth.getInstance()
        val fStore: FirebaseFirestore = FirebaseFirestore.getInstance()

        btnDaftar.setOnClickListener {
            val namaU = edtNama.text.toString()
            val emailU = edtEmail.text.toString()
            val hpU = edtNoHp.text.toString()
            val pwdU = edtPassword.text.toString()

            checkField(edtNama)
            checkField(edtEmail)
            checkField(edtNoHp)
            checkField(edtPassword)

            if (valid) {
                fAuth.createUserWithEmailAndPassword(emailU, pwdU).addOnSuccessListener(
                    OnSuccessListener {
                        Toast.makeText(this,"Berhasil Dibuat",Toast.LENGTH_SHORT).show()

                        val df: DocumentReference = fStore.collection("Users").document(FirebaseAuth.getInstance().uid!!)
                        val userMap: HashMap<String, String> = HashMap()

                        userMap.put("nama", namaU)
                        userMap.put("email", emailU)
                        userMap.put("hp", hpU)
                        userMap.put("isMitra", "0")

                        df.set(userMap)

                        startActivity(Intent(this, DashboardUserActivity::class.java))
                        finish()

                    }).addOnFailureListener(OnFailureListener {
                        Toast.makeText(this, "Pendaftaran Gagal", Toast.LENGTH_SHORT).show()
                })
            }
        }
    }

    private fun checkField(textField: EditText) {
        if(textField.getText().toString().isEmpty()) {
            textField.setError("Wajib Diisi")
            valid = false
        } else {
            valid = true
        }
    }
}
