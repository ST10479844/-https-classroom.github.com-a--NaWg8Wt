package vcmsa.ci.playlistapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    //Declaring the screen elements
    private lateinit var displaySongstext: TextView
    private lateinit var displayAveragetext: TextView
    private lateinit var displayButton: Button
    private lateinit var calculateAveragebutton: Button
    private lateinit var mainMenubutton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)


        // Link variables to views
        displaySongstext = findViewById(R.id.displayTxt)
        displayAveragetext = findViewById(R.id.averageTxt)
        displayButton = findViewById(R.id.btnDisplay)
        calculateAveragebutton= findViewById(R.id.btnAverage)
        mainMenubutton = findViewById(R.id.btnBack)

        // Receive data from previous screen
        val songTitles = intent.getStringArrayListExtra("songTitles") ?: arrayListOf()
        val artistNames = intent.getStringArrayListExtra("artistNames") ?: arrayListOf()
        val ratings = intent.getStringArrayListExtra("ratings") ?: arrayListOf()
        val comments = intent.getStringArrayListExtra("comments") ?: arrayListOf()

        // Show all songs
        displayButton.setOnClickListener {
            val list = songTitles.indices.joinToString("\n") {
                "${songTitles[it]} (${artistNames[it]}) - ${ratings[it]}: ${comments[it]}"
            }
            displaySongstext.text = list.ifBlank { "No songs added!" }
        }

        // Show the average rating
        calculateAveragebutton.setOnClickListener {
            var totalRatingsum = 0.0
            var songCount = 0
            val filtered = songTitles.indices
                .filter { ratings[it].toIntOrNull() ?: 0 >= 2 }
                .forEach {
                    totalRatingsum += ratings[it].toIntOrNull() ?:
                            songCount ++
                }
            val averageRating = if (songCount > 0) {
                totalRatingsum/songCount
            } else {
                0.0
            }
            displayAveragetext.text = "Average Rating: ${String.format("%.2f", averageRating)}"
        }

        // Navigate back to main menu
        findViewById<Button>(R.id.btnBack).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        }
    }
