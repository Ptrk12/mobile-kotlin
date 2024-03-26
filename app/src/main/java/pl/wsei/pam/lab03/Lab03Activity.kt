package pl.wsei.pam.lab03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import pl.wsei.pam.lab01.R
import java.util.Timer
import kotlin.concurrent.schedule

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


        runOnUiThread() {
            mBoardModel.setOnGameChangeListener { e ->
                run {
                    when (e.state) {
                        GameStates.Matching -> {
                            e.tiles.map { it.revealed = true };
                        }
                        GameStates.Match -> {
                            e.tiles.map { it.revealed = true };
                        }
                        GameStates.NoMatch -> {
                            e.tiles.map { it.revealed = true };
                            Timer().schedule(2000) {
                                e.tiles.map { it.revealed = false };
                            }
                        }
                        GameStates.Finished -> {
                            Toast.makeText(this, "Game finished", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }

    }
}
