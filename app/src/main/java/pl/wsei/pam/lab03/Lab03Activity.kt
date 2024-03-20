package pl.wsei.pam.lab03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.LinearLayout
import pl.wsei.pam.lab01.R

public class Lab03Activity : AppCompatActivity() {
    lateinit var mBoard: GridLayout;
    override fun onCreate(savedInstanceState: Bundle?) {
        val size = intent.getIntArrayExtra("size") ?: intArrayOf(3,3)

        var test: Int = R.id.lab03
        mBoard = findViewById(test)!!;
        mBoard.columnCount = size[0];
        mBoard.rowCount = size[1];
        for (i in 0..size[1]){
            for(j in 0..size[0]){
                val btn = ImageButton(this).also {
                    it.tag = "${i}x${j}"
                    val layoutParams = GridLayout.LayoutParams()
                    it.setImageResource(R.drawable.baseline_sentiment_satisfied_alt_24)
                    layoutParams.width = 0
                    layoutParams.height = 0
                    layoutParams.setGravity(Gravity.CENTER)
                    layoutParams.columnSpec = GridLayout.spec(j, 1, 1f)
                    layoutParams.rowSpec = GridLayout.spec(i, 1, 1f)
                    it.layoutParams = layoutParams
                    mBoard.addView(it)
                }
            }
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab03)
    }
}