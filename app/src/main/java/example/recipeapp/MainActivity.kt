
package example.recipeapp

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val webView = WebView(this)
        setContentView(webView)

        val recipeList = listOf(
            Recipe(
                "Penne Pasta",
                "Ingredients:\n\n" +
                        "• 200g Penne Pasta\n" +
                        "• 2 Tomatoes\n" +
                        "• 1 Onion\n" +
                        "• 2 Garlic cloves\n" +
                        "• 1 cup Tomato Sauce\n" +
                        "• 1 tsp Olive Oil\n" +
                        "• Salt to taste\n" +
                        "• Black Pepper\n" +
                        "• Cheese (optional)\n\n" +

                        "Preparation Steps:\n\n" +
                        "1. Boil water in a pan and add pasta with salt.\n" +
                        "2. Cook for 8-10 minutes until soft.\n" +
                        "3. Heat olive oil in another pan.\n" +
                        "4. Add chopped onion and garlic and sauté.\n" +
                        "5. Add tomatoes and tomato sauce.\n" +
                        "6. Add cooked pasta and mix well.\n" +
                        "7. Add salt and pepper for taste.\n" +
                        "8. Garnish with cheese and serve hot.",

                "https://img.freepik.com/free-photo/penne-pasta-tomato-sauce-with-chicken-tomatoes-wooden-table_2829-19744.jpg"
            )
        )

        val html = """
            <html>
            <body style="text-align:center;">
                <h2>${recipeList[0].title}</h2>
                <img src="${recipeList[0].imageUrl}" width="300"/>
                <p>${recipeList[0].description}</p>
            </body>
            </html>
        """

        webView.loadData(html, "text/html", "UTF-8")
    }
}
