package ge.proeqti.socialmedia
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import ge.proeqti.socialmedia.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    lateinit var baind:ActivityMainBinding
    lateinit var fireb:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baind= ActivityMainBinding.inflate(layoutInflater)
        setContentView(baind.root)

        fireb = FirebaseAuth.getInstance()

        baind.notacnt.setOnClickListener {
            val gad=Intent(this,signin::class.java);
            startActivity(gad)
        }
        baind.button1.setOnClickListener {
            val email=baind.emailEt.text.toString()
            val pass=baind.passET.text.toString()

            if(email.isNotEmpty()&&pass.isNotEmpty())
            {
              val  email1=email.trim()
              val  pass1=pass.trim()
                fireb.signInWithEmailAndPassword(email1,pass1).addOnCompleteListener{

                    if(it.isSuccessful)
                    {
                        val gad=Intent(this,homepage::class.java)
                        startActivity(gad)
                    }
                    else{
                        Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()

                    }
                }

            }
            else
            {
                Toast.makeText(this," velebi aris carieli",Toast.LENGTH_SHORT).show()
            }
        }

    }
}
