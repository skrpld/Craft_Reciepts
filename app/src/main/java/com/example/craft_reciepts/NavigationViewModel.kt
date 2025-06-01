import androidx.lifecycle.ViewModel
import com.example.craft_reciepts.CategoriesData
import com.example.craft_reciepts.ItemData
import com.example.craft_reciepts.R

class NavigationViewModel : ViewModel() {
    var currentPath = "Main"

    val categories = mapOf(
        "Main" to listOf(
            CategoriesData("Meat", R.drawable.ic_launcher_foreground),
            CategoriesData("Vegetables", R.drawable.ic_launcher_foreground),
            CategoriesData("Cooked", R.drawable.ic_launcher_foreground),
            CategoriesData("Craftable", R.drawable.ic_launcher_foreground)
        ),

        "Meat" to listOf(
            CategoriesData("Beef", R.drawable.ic_launcher_foreground),
            CategoriesData("Chicken", R.drawable.ic_launcher_foreground),
            CategoriesData("Pork", R.drawable.ic_launcher_foreground)
        ),
        "Vegetables" to listOf(
            CategoriesData("Carrot", R.drawable.ic_launcher_foreground),
            CategoriesData("Potato", R.drawable.ic_launcher_foreground)
        )
    )

    val item = mapOf(
        "Beef" to ItemData("description of beef", R.drawable.ic_launcher_background)
    )
}