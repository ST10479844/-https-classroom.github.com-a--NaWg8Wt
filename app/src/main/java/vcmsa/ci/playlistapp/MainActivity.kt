package vcmsa.ci.playlistapp
//Student Number: ST10479844      Name: Seiuri Naidoo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
private val String.text: Any
    get() {
        TODO("Not yet implemented")
    }
class MainActivity : AppCompatActivity() {
    // These are array lists where we store each packing item's details
    val songTitles = arrayListOf<String>()         // Stores the names of items.
    val artistNames = arrayListOf<String>()       // Stores the category of each item.
    val ratings = arrayListOf<Int>()             // Stores the quantity of each item.
    val comments = arrayListOf<String>()        // Stores the comment of each item.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        // Linking UI elements
        // Input field for the song title
        val songTitleinput = findViewById<EditText>(R.id.songTitleinput)

        // Input field for category
        val artistNameinput = findViewById<EditText>(R.id.artistNameinput)

        // Input field for the song rating
        val ratingInput = findViewById<EditText>(R.id.ratingInput)

        // Optional Comment
        val commentInput = findViewById<EditText>(R.id.commentsInput)

        // Button to add items to list
        val addBtn = findViewById<Button>(R.id.btnAdd)

        // Button to view items on list
        val nextBtn = findViewById<Button>(R.id.btnNext)

        //Button to completely exit the app
        val exitBtn = findViewById<Button>(R.id.btnExit)



        // When the user clicks the "Input Item" button, this block of code will
        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            // Store the user input from each text box into a temporary variable
            val songTitleinput = songTitleinput.text.toString()
            val artistNameinput = artistNameinput.text.toString()
            val ratingInput = ratingInput.text.toString()
            val commentInput = commentInput.text.toString()


            // Validate input fields
            if (songTitleinput.isBlank() || artistNameinput.isBlank() || ratingInput.isBlank() || commentInput.isBlank()) {
                Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            val rating = ratingInput.toIntOrNull()
            if (rating == null || rating <= 0) {
                Toast.makeText(
                    this,
                    "Rating must be a number from 1 to 5!",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            // Add data to corresponding lists
            songTitles.add(songTitleinput)
            artistNames.add(artistNameinput)
            ratings.add(rating)
            comments.add(commentInput)

            //Tells the user that the item was added successfully
            Toast.makeText(this, "Item added successfully!", Toast.LENGTH_SHORT).show()

            // Clear input fields
            songTitleinput.text.clear()
            artistNameinput.text.clear()
            ratingInput.text.clear()
            commentInput.text.clear()
        }

        findViewById<Button>(R.id.btnNext).setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)

            // Convert quantities from Int to String
            val quantityStrings = ArrayList(ratings.map { it.toString() })

            // Attach all lists as extras
            intent.putStringArrayListExtra("Song Titles", songTitles)
            intent.putStringArrayListExtra("Artists Names", artistNames)
            intent.putStringArrayListExtra("rating Input", ratings)
            intent.putStringArrayListExtra("comments", comments)

            startActivity(intent)
        }

        findViewById<Button>(R.id.btnExit).setOnClickListener {
            finishAffinity()  // Close the app
        }
    }
}

private fun Any.clear() {}

private fun Intent.putStringArrayListExtra(s: String, ratings: java.util.ArrayList<Int>) {

}

