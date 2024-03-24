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
    lateinit var mBoard: GridLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_lab03)

        val size = intent.getIntArrayExtra("size") ?: intArrayOf(3,3)

        var test: Int = R.id.lab03
        mBoard = findViewById(test)!!
        mBoard.columnCount = size[0]
        mBoard.rowCount = size[1]
        val mBoardModel = MemoryBoardView(mBoard, size[0], size[1])
    }
}
