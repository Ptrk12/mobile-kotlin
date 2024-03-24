package pl.wsei.pam.lab03

import android.widget.ImageButton
import pl.wsei.pam.lab01.R

data class Tile(val button: ImageButton, val tileResource: Int, val deckResource: Int) {
    init {
        button.setImageResource(deckResource)
    }
    private var _revealed: Boolean = false
    var revealed: Boolean
        get() {
            return _revealed
        }
        set(value){
            _revealed = value
            if(_revealed == true)
            {
                button.setImageResource(R.drawable.baseline_question_mark_24)
            }else{
                button.setImageResource(R.drawable.baseline_sentiment_satisfied_alt_24);
            }
        }
    fun removeOnClickListener(){
        button.setOnClickListener(null)
    }
}