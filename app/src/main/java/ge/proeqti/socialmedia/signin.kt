package ge.proeqti.socialmedia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import ge.proeqti.socialmedia.databinding.ActivitySigninBinding

class signin : AppCompatActivity() {

    private lateinit var binding: ActivitySigninBinding
    private lateinit var fired: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fired = FirebaseAuth.getInstance()

        binding.alreadyreg.setOnClickListener { //is  shemtxveva roca daawveba already have an account
            val gadasvla = Intent(this, MainActivity::class.java)
            startActivity(gadasvla)
        }
        binding.button.setOnClickListener {

            val email = binding.emailEt.text.toString()
            val pass = binding.passET.text.toString()
            val repass = binding.repassET.text.toString()

    val email1=email.trim()
            val pass1=pass.trim()
            val repass1=repass.trim()

            if (email1.isNotEmpty() && pass1.isNotEmpty() && repass1.isNotEmpty()) {
                if (pass1 == repass1) {
                    fired.createUserWithEmailAndPassword(email1, pass1).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val gadasvla2 = Intent(this, MainActivity::class.java)
                            startActivity(gadasvla2)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "parolebi ar emtxveva", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(this, "carieli velebi an aravaliduri", Toast.LENGTH_SHORT).show()
            }
        }
    }

}