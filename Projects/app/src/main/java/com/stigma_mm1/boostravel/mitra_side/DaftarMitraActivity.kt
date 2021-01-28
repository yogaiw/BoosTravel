package com.stigma_mm1.boostravel.mitra_side

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
import kotlinx.android.synthetic.main.activity_daftar_mitra.*

class DaftarMitraActivity : AppCompatActivity() {

    var valid: Boolean = true
    val fAuth: FirebaseAuth = FirebaseAuth.getInstance()
    val fStore: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_mitra)

        btnDaftar.setOnClickListener {
            val namaM = edtNama.text.toString()
            val emailM = edtEmail.text.toString()
            val hpM = edtNoHp.text.toString()
            val alamatM = edtAlamat.text.toString()
            val pwdM = edtPassword.text.toString()

            checkField(edtNama)
            checkField(edtEmail)
            checkField(edtNoHp)
            checkField(edtAlamat)
            checkField(edtPassword)

            if(valid) {
                fAuth.createUserWithEmailAndPassword(emailM, pwdM).addOnSuccessListener(OnSuccessListener {
                    Toast.makeText(this,"Berhasil Dibuat",Toast.LENGTH_SHORT).show()

                    val df: DocumentReference = fStore.collection("Users").document(FirebaseAuth.getInstance().uid!!)
                    val userMap: HashMap<String, String> = HashMap()

                    userMap.put("nama", namaM)
                    userMap.put("email", emailM)
                    userMap.put("hp", hpM)
                    userMap.put("alamat", alamatM)
                    userMap.put("isMitra", "1")

                    df.set(userMap)

                    startActivity(Intent(this, DashboardMitraActivity::class.java))
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