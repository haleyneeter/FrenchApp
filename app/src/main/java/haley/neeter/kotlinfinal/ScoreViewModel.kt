package haley.neeter.kotlinfinal


import androidx.lifecycle.ViewModel

class ScoreViewModel: ViewModel() {

    var score = 0

    fun scoreUp() {
        score++
    }
}