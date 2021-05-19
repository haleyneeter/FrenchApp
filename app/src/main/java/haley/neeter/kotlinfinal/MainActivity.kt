package haley.neeter.kotlinfinal

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val title=findViewById<TextView>(R.id.title)
        val confirm=findViewById<TextView>(R.id.textConfirm)
        val play=findViewById<Button>(R.id.buttonPlay)
        val ER=findViewById<Button>(R.id.buttonER)
        val RE=findViewById<Button>(R.id.buttonRE)
        val IR=findViewById<Button>(R.id.buttonIR)
        var clicked:Int=0
        var clickedHard:Boolean=false
        val hard=findViewById<Button>(R.id.buttonHard)
    //    var textFrag:StartFrag= (supportFragmentManager.findFragmentById(R.id.fragment_view) as? StartFrag)!!
        IR.visibility = View.INVISIBLE
        ER.visibility = View.INVISIBLE
        RE.visibility = View.INVISIBLE
        hard.visibility=View.INVISIBLE


        play.setOnClickListener()
        {
            clicked++
            IR.visibility = View.VISIBLE
            ER.visibility = View.VISIBLE
            RE.visibility = View.VISIBLE
            hard.visibility = View.VISIBLE
            if(clicked>1)
            {
                val animation=AnimationUtils.loadAnimation(this,R.anim.bounce)
                title.startAnimation(animation)
            }

        }
        IR.setOnClickListener()
        {
            val verbType="IR"
            val intent = Intent(baseContext, GameScreen::class.java)
            intent.putExtra("verbType", verbType)
            startActivity(intent)
        }
        ER.setOnClickListener()
        {
            val verbType="ER"
            val intent = Intent(baseContext, GameScreen::class.java)
            intent.putExtra("verbType", verbType)
            startActivity(intent)
        }
        RE.setOnClickListener()
        {
            val verbType="RE"
            val intent = Intent(baseContext, GameScreen::class.java)
            intent.putExtra("verbType", verbType)
            startActivity(intent)
        }
        hard.setOnClickListener()
        {
            if(!clickedHard)
            {
                clickedHard=true
                confirm.text=("You sure? These verb are hard irregular present verbs? Click again to confirm")
                val animation = AnimationUtils.loadAnimation(this, R.anim.fade_out)
                confirm.startAnimation(animation)
                Handler().postDelayed({
                    confirm.visibility = View.GONE
                }, 7000)

            }

            else{
                val verbType="Hard"
                val intent = Intent(baseContext, GameScreen::class.java)
                intent.putExtra("verbType", verbType)
                startActivity(intent)

            }


        }



    }



}