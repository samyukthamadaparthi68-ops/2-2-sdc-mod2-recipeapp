package example.recipeapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class RecipeAdapter(private val recipeList: List<Recipe>) :
    RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.recipeImage)
        val name: TextView = itemView.findViewById(R.id.recipeName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe = recipeList[position]
        holder.name.text = recipe.title

        Glide.with(holder.itemView.context)
            .load(recipe.imageUrl)
            .into(holder.image)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, RecipeDetailActivity::class.java)
            intent.putExtra("name", recipe.title)
            intent.putExtra("image", recipe.imageUrl)
            intent.putExtra("ingredients", recipe.description)
            intent.putExtra("instructions", recipe.description)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = recipeList.size
}