package example.recipeapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class RecipeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)

        val image = findViewById<ImageView>(R.id.detailImage)
        val name = findViewById<TextView>(R.id.detailName)
        val ingredients = findViewById<TextView>(R.id.detailIngredients)
        val instructions = findViewById<TextView>(R.id.detailInstructions)

        name.text = intent.getStringExtra("name")
        ingredients.text = "Ingredients: " + intent.getStringExtra("ingredients")
        instructions.text = "Instructions: " + intent.getStringExtra("instructions")

        Glide.with(this)
            .load(intent.getStringExtra("image"))
            .into(image)
    }
}