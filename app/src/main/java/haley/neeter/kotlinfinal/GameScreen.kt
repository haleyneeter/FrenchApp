package haley.neeter.kotlinfinal

import android.app.Notification
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.ViewModelProvider
import java.util.*
import haley.neeter.kotlinfinal.Notificaton.Companion.CHANNEL_ID


class GameScreen : AppCompatActivity() {
    lateinit var verbE: VerbER
    lateinit var verbI: VerbIR
    lateinit var verbR:VerbRE
    lateinit var verbH:IrregularVerb
    private val notificationManager: NotificationManagerCompat? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)
        val sessionId = intent.getStringExtra("verbType")
        var viewModel: ScoreViewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)
        val start=findViewById<Button>(R.id.buttonStart)
        val check=findViewById<Button>(R.id.buttonCheck)
        val next=findViewById<Button>(R.id.buttonNext)
        val newScreen=findViewById<Button>(R.id.buttonCont)
        val backScreen=findViewById<Button>(R.id.buttonBack)

        val list=makeListofIR()
        val listRE= makeListofRE()
        val listER= makeListofER()
        newScreen.visibility= View.INVISIBLE
        backScreen.visibility= View.INVISIBLE
        check.visibility = View.INVISIBLE
        next.visibility = View.INVISIBLE
        val user1 = findViewById<EditText>(R.id.input1)
        val user2 = findViewById<EditText>(R.id.input2)
        val user3 = findViewById<EditText>(R.id.input3)
        val user4 = findViewById<EditText>(R.id.input4)
        val user5 = findViewById<EditText>(R.id.input5)
        val user6 = findViewById<EditText>(R.id.input6)
        val title=findViewById<TextView>(R.id.verbName)
        val ani1= AnimationUtils.loadAnimation(this,R.anim.rotate_clock)
        val ani2=AnimationUtils.loadAnimation(this,R.anim.rotate_anti_clock)

       // var score:Int=0
        val scoreText=findViewById<TextView>(R.id.score)
        val timeText=findViewById<TextView>(R.id.time)
        val hint=findViewById<TextView>(R.id.note)
        start.setOnClickListener()
        {
            check.visibility = View.VISIBLE
            start.visibility = View.INVISIBLE
            if(sessionId=="IR")
            {
                verbI= getRandomIR(list)
                title.text = (verbI.infinitive + ": " + verbI.meaning)
            }
            if(sessionId=="ER")
            {
                verbE= getRandomER(listER)
                title.text = (verbE.infinitive + ": " + verbE.meaning)

            }
            if(sessionId=="RE")
            {
                verbR= getRandomRE(listRE)
                title.text = (verbR.infinitive + ": " + verbR.meaning)

            }
            if(sessionId=="Hard")
            {
                verbH= getRandomVerbIrreg()
                title.text = (verbH.infinitive + ": " + verbH.meaning)

            }



            val timer = object: CountDownTimer(100000, 1000)
            {
                override fun onTick(millisUntilFinished: Long) {
                    val number=millisUntilFinished/1000
                    timeText.text = """$number"""
                }
                @RequiresApi(Build.VERSION_CODES.O)
                override fun onFinish() {
                    if(viewModel.score>5)
                    {
                        sendOnChannel()
                    }

                    hint.text=("Game Over, Please either click the left button to return back to title screen, or the right button to learn more")
                    check.visibility = View.INVISIBLE
                    start.visibility = View.INVISIBLE
                    next.visibility = View.INVISIBLE
                    newScreen.visibility = View.VISIBLE
                    backScreen.visibility = View.VISIBLE
                    Thread.sleep(10000)
                    newScreen.startAnimation(ani1)
                    backScreen.startAnimation(ani2)


                }
            }
            timer.start()
        }
        backScreen.setOnClickListener()
        {
            val intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent)
        }
        newScreen.setOnClickListener()
        {
            val intent = Intent(baseContext, NextActivity::class.java)
            startActivity(intent)
        }
        check.setOnClickListener()
        {
            var isCorrect =0
            val text1: String = user1.text.toString()
            val text2: String = user2.text.toString()
            val text3: String = user3.text.toString()
            val text4: String = user4.text.toString()
            val text5: String = user5.text.toString()
            val text6: String = user6.text.toString()
            if(sessionId=="IR") {
                 isCorrect = checkItIR(text1, text2, text3, text4, text5, text6)

            }
            if(sessionId=="ER") {
                 isCorrect = checkIt(text1, text2, text3, text4, text5, text6)

            }
            if(sessionId=="RE")
            {
                isCorrect = checkItRE(text1, text2, text3, text4, text5, text6)
            }
            if(sessionId=="Hard")
            {
                isCorrect=checkItIrreg(text1, text2, text3, text4, text5, text6)

            }


            if (isCorrect==6) {
                hint.text=("Correct, click next to get a new verb")
                viewModel.scoreUp()
                scoreText.text = viewModel.score.toString()
                next.visibility=View.VISIBLE
                check.visibility=View.INVISIBLE
                user1.text.clear()
                user2.text.clear()
                user3.text.clear()
                user4.text.clear()
                user5.text.clear()
                user6.text.clear()
            } else {
                val missing:Int=6-isCorrect
                hint.text=("Try again $missing items are incorrect ")
                check.visibility = View.VISIBLE
            }


        }
        next.setOnClickListener()
        {
            check.visibility=View.VISIBLE
            when (sessionId) {
                "IR" -> {
                    verbI= getRandomIR(list)
                    title.text = (verbI.infinitive + ": " + verbI.meaning)
                }
                "ER" -> {
                    verbE= getRandomER(listER)
                    title.text = (verbE.infinitive + ": " + verbE.meaning)

                }
                "RE" -> {
                    verbR= getRandomRE(listRE)
                    title.text = (verbR.infinitive + ": " + verbR.meaning)
                }
                "Hard" -> {
                    verbH= getRandomVerbIrreg()
                    title.text = (verbH.infinitive + ": " + verbH.meaning)
                }
            }



        }



    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun sendOnChannel() {

        val notification: Notification = Notification.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_announcement_24)
            .setContentTitle("Great Job!")
            .setContentText("Try another verb type to test your skills out!")
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .build()
        notificationManager!!.notify(1, notification)
    }
    private fun checkIt(text1:String, text2:String, text3:String, text4:String, text5:String, text6:String):Int
    {
        var number=0
        if(text1 == verbE.getFS())
        {
            number++
        }
        if(text2 == verbE.getSS())
        {
            number++
        }
        if(text3 == verbE.getTS())
        {
            number++
        }
        if(text4 == verbE.getFP())
        {
            number++
        }
        if(text5 == verbE.getSP() )
        {
            number++
        }
        if(text6 == verbE.getTP() )
        {
            number++
        }


        return number

    }
    private fun checkItIR(text1:String, text2:String, text3:String, text4:String, text5:String, text6:String):Int
    {
        var number =0
        if(text1 == verbI.getFS())
        {
            number++
        }
        if(text2 == verbI.getSS())
        {
            number++
        }
        if(text3 == verbI.getTS())
        {
            number++
        }
        if(text4 == verbI.getFP())
        {
            number++
        }
        if(text5 == verbI.getSP() )
        {
            number++
        }
        if(text6 == verbI.getTP() )
        {
            number++
        }

        return number

    }
    private fun checkItRE(text1:String, text2:String, text3:String, text4:String, text5:String, text6:String):Int
    {
        var number =0
        if(text1 == verbR.getFS())
        {
            number++
        }
        if(text2 == verbR.getSS())
        {
            number++
        }
        if(text3 == verbR.getTS())
        {
            number++
        }
        if(text4 == verbR.getFP())
        {
            number++
        }
        if(text5 == verbR.getSP() )
        {
            number++
        }
        if(text6 == verbR.getTP() )
        {
            number++
        }

        return number

    }
    private fun checkItIrreg(text1:String, text2:String, text3:String, text4:String, text5:String, text6:String):Int
    {
        var number =0
        if(text1 == verbH.FS)
        {
            number++
        }
        if(text2 == verbH.SS)
        {
            number++
        }
        if(text3 == verbH.TS)
        {
            number++
        }
        if(text4 == verbH.FP)
        {
            number++
        }
        if(text5 == verbH.SP )
        {
            number++
        }
        if(text6 == verbH.TP)
        {
            number++
        }

        return number

    }


    private  fun getRandomER(list:ArrayList<VerbER>):VerbER{
        val rand = Random()
        return list[rand.nextInt(list.size)]
    }
    private  fun getRandomIR(list:ArrayList<VerbIR>):VerbIR{
        val rand = Random()
        return list[rand.nextInt(list.size)]
    }
    private  fun getRandomRE(list:ArrayList<VerbRE>):VerbRE{
        val rand = Random()
        return list[rand.nextInt(list.size)]
    }
    private fun getRandomVerbIrreg(): IrregularVerb {
        val random = Random()
        return IrregularVerb.values()[random.nextInt(IrregularVerb.values().size)]
    }
}