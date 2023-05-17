package androiddeveloper.belajarandroiddasar

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {

    lateinit var computerImgView: ImageView
    lateinit var rockImgButton: ImageButton
    lateinit var paperImgButton: ImageButton
    lateinit var scissorsImgButton: ImageButton
    lateinit var resultImgView: ImageView

    private fun initComponents(){
        computerImgView = findViewById(R.id.computerImgView)
        rockImgButton = findViewById(R.id.rockImgButton)
        paperImgButton = findViewById(R.id.paperkImgButton)
        scissorsImgButton = findViewById(R.id.scissorsImgButton)
        resultImgView = findViewById(R.id.resultImgView)
    }

    private fun initListeners(){
        rockImgButton.setOnClickListener { startGame("ROCK") }
        paperImgButton.setOnClickListener { startGame("PAPER") }
        scissorsImgButton.setOnClickListener { startGame("SCISSORS") }
    }

    private fun startGame(option: String){
        val computerOption = Game.pickRandomOption()
        computerImgView.setImageResource(Game.pickDrawable(computerOption))

        when{
            Game.isDraw(option, computerOption) -> resultImgView.setImageResource(R.drawable.draw)
            Game.isWin(option, computerOption) -> resultImgView.setImageResource(R.drawable.win)
            else -> resultImgView.setImageResource(R.drawable.lose)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity)

        initComponents()
        initListeners()
    }
}