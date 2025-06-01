import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.craft_reciepts.CategoriesData
import com.example.craft_reciepts.ItemData
import com.example.craft_reciepts.R

class NavigationViewModel : ViewModel() {
    private val _navigationStack = mutableStateOf(listOf("Main"))
    val currentPath: String get() = _navigationStack.value.last()

    fun navigateTo(path: String) {
        _navigationStack.value = _navigationStack.value + path
    }

    fun navigateBack() {
        if (_navigationStack.value.size > 1) {
            _navigationStack.value = _navigationStack.value.dropLast(1)
        }
    }

    val categories = mapOf(
        "Main" to listOf(
            CategoriesData("Meat", R.drawable.ic_launcher_foreground),
            CategoriesData("Vegetables", R.drawable.ic_launcher_foreground),
            CategoriesData("Fruits", R.drawable.ic_launcher_foreground),
            CategoriesData("Fish", R.drawable.ic_launcher_foreground),
            CategoriesData("Dairy", R.drawable.ic_launcher_foreground),
            CategoriesData("Baked", R.drawable.ic_launcher_foreground),
            CategoriesData("Cooked", R.drawable.ic_launcher_foreground),
            CategoriesData("Craftable", R.drawable.ic_launcher_foreground),
            CategoriesData("Special", R.drawable.ic_launcher_foreground)
        ),

        "Meat" to listOf(
            CategoriesData("Beef", R.drawable.ic_launcher_foreground),
            CategoriesData("Chicken", R.drawable.ic_launcher_foreground),
            CategoriesData("Porkchop", R.drawable.ic_launcher_foreground),
            CategoriesData("Mutton", R.drawable.ic_launcher_foreground),
            CategoriesData("Rabbit", R.drawable.ic_launcher_foreground)
        ),

        "Vegetables" to listOf(
            CategoriesData("Carrot", R.drawable.ic_launcher_foreground),
            CategoriesData("Potato", R.drawable.ic_launcher_foreground),
            CategoriesData("Baked Potato", R.drawable.ic_launcher_foreground),
            CategoriesData("Poisonous Potato", R.drawable.ic_launcher_foreground),
            CategoriesData("Beetroot", R.drawable.ic_launcher_foreground)
        ),

        "Fruits" to listOf(
            CategoriesData("Apple", R.drawable.ic_launcher_foreground),
            CategoriesData("Golden Apple", R.drawable.ic_launcher_foreground),
            CategoriesData("Enchanted Golden Apple", R.drawable.ic_launcher_foreground),
            CategoriesData("Melon Slice", R.drawable.ic_launcher_foreground),
            CategoriesData("Sweet Berries", R.drawable.ic_launcher_foreground),
            CategoriesData("Glow Berries", R.drawable.ic_launcher_foreground),
            CategoriesData("Chorus Fruit", R.drawable.ic_launcher_foreground)
        ),

        "Fish" to listOf(
            CategoriesData("Raw Cod", R.drawable.ic_launcher_foreground),
            CategoriesData("Cooked Cod", R.drawable.ic_launcher_foreground),
            CategoriesData("Raw Salmon", R.drawable.ic_launcher_foreground),
            CategoriesData("Cooked Salmon", R.drawable.ic_launcher_foreground),
            CategoriesData("Tropical Fish", R.drawable.ic_launcher_foreground),
            CategoriesData("Pufferfish", R.drawable.ic_launcher_foreground)
        ),

        "Dairy" to listOf(
            CategoriesData("Milk Bucket", R.drawable.ic_launcher_foreground),
            CategoriesData("Egg", R.drawable.ic_launcher_foreground)
        ),

        "Baked" to listOf(
            CategoriesData("Bread", R.drawable.ic_launcher_foreground),
            CategoriesData("Cookie", R.drawable.ic_launcher_foreground),
            CategoriesData("Pumpkin Pie", R.drawable.ic_launcher_foreground)
        ),

        "Cooked" to listOf(
            CategoriesData("Cooked Beef", R.drawable.ic_launcher_foreground),
            CategoriesData("Cooked Chicken", R.drawable.ic_launcher_foreground),
            CategoriesData("Cooked Porkchop", R.drawable.ic_launcher_foreground),
            CategoriesData("Cooked Mutton", R.drawable.ic_launcher_foreground),
            CategoriesData("Cooked Rabbit", R.drawable.ic_launcher_foreground)
        ),

        "Craftable" to listOf(
            CategoriesData("Rabbit Stew", R.drawable.ic_launcher_foreground),
            CategoriesData("Beetroot Soup", R.drawable.ic_launcher_foreground),
            CategoriesData("Mushroom Stew", R.drawable.ic_launcher_foreground),
            CategoriesData("Suspicious Stew", R.drawable.ic_launcher_foreground),
            CategoriesData("Honey Bottle", R.drawable.ic_launcher_foreground)
        ),

        "Special" to listOf(
            CategoriesData("Dried Kelp", R.drawable.ic_launcher_foreground),
            CategoriesData("Rotten Flesh", R.drawable.ic_launcher_foreground),
            CategoriesData("Spider Eye", R.drawable.ic_launcher_foreground),
            CategoriesData("Fermented Spider Eye", R.drawable.ic_launcher_foreground),
            CategoriesData("Cake", R.drawable.ic_launcher_foreground)
        )
    )

    val item = mapOf(
        // Meat
        "Beef" to ItemData("Raw beef dropped by cows. Restores 3 hunger points.", R.drawable.ic_launcher_background),
        "Chicken" to ItemData("Raw chicken dropped by chickens. Has 30% chance to give hunger effect. Restores 2 hunger points.", R.drawable.ic_launcher_background),
        "Porkchop" to ItemData("Raw pork dropped by pigs. Restores 3 hunger points.", R.drawable.ic_launcher_background),
        "Mutton" to ItemData("Raw mutton dropped by sheep. Restores 2 hunger points.", R.drawable.ic_launcher_background),
        "Rabbit" to ItemData("Raw rabbit meat dropped by rabbits. Restores 3 hunger points.", R.drawable.ic_launcher_background),

        // Vegetables
        "Carrot" to ItemData("Grown from carrot crops. Can be eaten or used to breed pigs. Restores 3 hunger points.", R.drawable.ic_launcher_background),
        "Potato" to ItemData("Grown from potato crops. Restores 1 hunger point.", R.drawable.ic_launcher_background),
        "Baked Potato" to ItemData("Cooked potato in a furnace. Restores 5 hunger points.", R.drawable.ic_launcher_background),
        "Poisonous Potato" to ItemData("Rare drop from potato crops. Has 60% chance to give poison effect. Restores 2 hunger points.", R.drawable.ic_launcher_background),
        "Beetroot" to ItemData("Grown from beetroot crops. Can be used to make soup. Restores 1 hunger point.", R.drawable.ic_launcher_background),

        // Fruits
        "Apple" to ItemData("Dropped from oak leaves. Restores 4 hunger points.", R.drawable.ic_launcher_background),
        "Golden Apple" to ItemData("Crafted with apple and gold ingots. Grants absorption and regeneration effects. Restores 4 hunger points.", R.drawable.ic_launcher_background),
        "Enchanted Golden Apple" to ItemData("Crafted with apple and gold blocks. Grants powerful regeneration, resistance, absorption, and fire resistance effects.", R.drawable.ic_launcher_background),
        "Melon Slice" to ItemData("Obtained from melon blocks. Restores 2 hunger points.", R.drawable.ic_launcher_background),
        "Sweet Berries" to ItemData("Grown on sweet berry bushes. Restores 2 hunger points.", R.drawable.ic_launcher_background),
        "Glow Berries" to ItemData("Found in lush caves. Provides light when eaten. Restores 2 hunger points.", R.drawable.ic_launcher_background),
        "Chorus Fruit" to ItemData("Dropped by chorus plants in the End. Teleports player when eaten. Restores 4 hunger points.", R.drawable.ic_launcher_background),

        // Fish
        "Raw Cod" to ItemData("Caught by fishing or dropped by guardians. Restores 2 hunger points.", R.drawable.ic_launcher_background),
        "Cooked Cod" to ItemData("Cooked raw cod in a furnace. Restores 5 hunger points.", R.drawable.ic_launcher_background),
        "Raw Salmon" to ItemData("Caught by fishing in cold biomes. Restores 2 hunger points.", R.drawable.ic_launcher_background),
        "Cooked Salmon" to ItemData("Cooked raw salmon in a furnace. Restores 6 hunger points.", R.drawable.ic_launcher_background),
        "Tropical Fish" to ItemData("Caught by fishing in warm oceans. Restores 1 hunger point.", R.drawable.ic_launcher_background),
        "Pufferfish" to ItemData("Caught by fishing. Gives hunger, nausea, and poison effects. Restores 1 hunger point.", R.drawable.ic_launcher_background),

        // Dairy
        "Milk Bucket" to ItemData("Obtained by milking cows. Removes all status effects.", R.drawable.ic_launcher_background),
        "Egg" to ItemData("Laid by chickens. Can be thrown or used in crafting. Restores 1 hunger point.", R.drawable.ic_launcher_background),

        // Baked
        "Bread" to ItemData("Crafted with wheat. Restores 5 hunger points.", R.drawable.ic_launcher_background),
        "Cookie" to ItemData("Crafted with wheat and cocoa beans. Restores 2 hunger points.", R.drawable.ic_launcher_background),
        "Pumpkin Pie" to ItemData("Crafted with pumpkin, sugar, and egg. Restores 8 hunger points.", R.drawable.ic_launcher_background),

        // Cooked Meats
        "Cooked Beef" to ItemData("Cooked beef in a furnace. Restores 8 hunger points.", R.drawable.ic_launcher_background),
        "Cooked Chicken" to ItemData("Cooked chicken in a furnace. Restores 6 hunger points.", R.drawable.ic_launcher_background),
        "Cooked Porkchop" to ItemData("Cooked porkchop in a furnace. Restores 8 hunger points.", R.drawable.ic_launcher_background),
        "Cooked Mutton" to ItemData("Cooked mutton in a furnace. Restores 6 hunger points.", R.drawable.ic_launcher_background),
        "Cooked Rabbit" to ItemData("Cooked rabbit in a furnace. Restores 5 hunger points.", R.drawable.ic_launcher_background),

        // Craftable
        "Rabbit Stew" to ItemData("Crafted with cooked rabbit, carrot, baked potato, mushroom, and bowl. Restores 10 hunger points.", R.drawable.ic_launcher_background),
        "Beetroot Soup" to ItemData("Crafted with 6 beetroots and bowl. Restores 6 hunger points.", R.drawable.ic_launcher_background),
        "Mushroom Stew" to ItemData("Crafted with red and brown mushrooms and bowl. Restores 6 hunger points.", R.drawable.ic_launcher_background),
        "Suspicious Stew" to ItemData("Crafted with bowl, red/brown mushroom, and any flower. Gives various effects.", R.drawable.ic_launcher_background),
        "Honey Bottle" to ItemData("Obtained from beehives. Removes poison effect. Restores 6 hunger points.", R.drawable.ic_launcher_background),

        // Special
        "Dried Kelp" to ItemData("Cooked kelp in furnace. Can be eaten quickly. Restores 1 hunger point.", R.drawable.ic_launcher_background),
        "Rotten Flesh" to ItemData("Dropped by zombies. Has 80% chance to give hunger effect. Restores 4 hunger points.", R.drawable.ic_launcher_background),
        "Spider Eye" to ItemData("Dropped by spiders. Gives poison effect. Restores 2 hunger points.", R.drawable.ic_launcher_background),
        "Fermented Spider Eye" to ItemData("Crafted with spider eye, sugar, and brown mushroom. Used for potions.", R.drawable.ic_launcher_background),
        "Cake" to ItemData("Crafted with wheat, sugar, milk, and egg. Placed block that can be eaten 7 times (1 slice = 2 hunger points).", R.drawable.ic_launcher_background)
    )
}