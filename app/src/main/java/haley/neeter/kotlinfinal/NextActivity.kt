package haley.neeter.kotlinfinal

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.after_game_screen)
        val conjNote=findViewById<TextView>(R.id.conjNote)
        val vNote=findViewById<TextView>(R.id.verbNote)
        val what=findViewById<Button>(R.id.buttonConj)
        val ER=findViewById<Button>(R.id.erButton)
        val RE=findViewById<Button>(R.id.reButton)
        val IR=findViewById<Button>(R.id.irButton)
        val irreg=findViewById<Button>(R.id.iregButton)
        val back=findViewById<Button>(R.id.buttonBack)

        what.setOnClickListener()
        {
            conjNote.text=(R.string.conjNote.toString())
        }
        ER.setOnClickListener()
        {

            vNote.text=(R.string.erNote.toString())
        }
        RE.setOnClickListener()
        {

            vNote.text=(R.string.reNote.toString())
        }
        IR.setOnClickListener()
        {

            vNote.text=(R.string.irNote.toString())
        }
        irreg.setOnClickListener()
        {

            vNote.text=(R.string.iregNote.toString())
        }
        back.setOnClickListener()
        {
            val intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent)
        }
    }



}