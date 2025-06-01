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
            CategoriesData("Meat", R.drawable.beef),
            CategoriesData("Vegetables", R.drawable.carrot),
            CategoriesData("Fruits", R.drawable.apple),
            CategoriesData("Fish", R.drawable.tropical_fish),
            CategoriesData("Dairy", R.drawable.milk_bucket),
            CategoriesData("Baked", R.drawable.bread),
            CategoriesData("Cooked", R.drawable.steak),
            CategoriesData("Craftable", R.drawable.beetroot_soup),
            CategoriesData("Special", R.drawable.dried_kelp)
        ),
        "Meat" to listOf(
            CategoriesData("Beef", R.drawable.beef),
            CategoriesData("Chicken", R.drawable.chicken),
            CategoriesData("Porkchop", R.drawable.porkchop),
            CategoriesData("Mutton", R.drawable.mutton),
            CategoriesData("Rabbit", R.drawable.rabbit)
        ),
        "Vegetables" to listOf(
            CategoriesData("Carrot", R.drawable.carrot),
            CategoriesData("Potato", R.drawable.potato),
            CategoriesData("Baked Potato", R.drawable.baked_potato),
            CategoriesData("Poisonous Potato", R.drawable.poisonous_potato),
            CategoriesData("Beetroot", R.drawable.beetroot)
        ),
        "Fruits" to listOf(
            CategoriesData("Apple", R.drawable.apple),
            CategoriesData("Golden Apple", R.drawable.golden_apple),
            CategoriesData("Enchanted Golden Apple", R.drawable.enchanted_golden_apple),
            CategoriesData("Melon Slice", R.drawable.melon_slice),
            CategoriesData("Sweet Berries", R.drawable.sweet_berries),
            CategoriesData("Glow Berries", R.drawable.glow_berries),
            CategoriesData("Chorus Fruit", R.drawable.chorus_fruit)
        ),
        "Fish" to listOf(
            CategoriesData("Raw Cod", R.drawable.raw_cod),
            CategoriesData("Cooked Cod", R.drawable.cooked_cod),
            CategoriesData("Raw Salmon", R.drawable.raw_salmon),
            CategoriesData("Cooked Salmon", R.drawable.cooked_salmon),
            CategoriesData("Tropical Fish", R.drawable.tropical_fish),
            CategoriesData("Pufferfish", R.drawable.pufferfish)
        ),
        "Dairy" to listOf(
            CategoriesData("Milk Bucket", R.drawable.milk_bucket),
            CategoriesData("Egg", R.drawable.egg)
        ),
        "Baked" to listOf(
            CategoriesData("Bread", R.drawable.bread),
            CategoriesData("Cookie", R.drawable.cookie),
            CategoriesData("Pumpkin Pie", R.drawable.pumpkin_pie)
        ),
        "Cooked" to listOf(
            CategoriesData("Steak", R.drawable.steak),
            CategoriesData("Cooked Chicken", R.drawable.cooked_chicken),
            CategoriesData("Cooked Porkchop", R.drawable.cooked_porkchop),
            CategoriesData("Cooked Mutton", R.drawable.cooked_mutton),
            CategoriesData("Cooked Rabbit", R.drawable.cooked_rabbit)
        ),
        "Craftable" to listOf(
            CategoriesData("Rabbit Stew", R.drawable.rabbit_stew),
            CategoriesData("Beetroot Soup", R.drawable.beetroot_soup),
            CategoriesData("Mushroom Stew", R.drawable.mushroom_stew),
            CategoriesData("Suspicious Stew", R.drawable.suspicious_stew),
            CategoriesData("Honey Bottle", R.drawable.honey_bottle)
        ),
        "Special" to listOf(
            CategoriesData("Dried Kelp", R.drawable.dried_kelp),
            CategoriesData("Rotten Flesh", R.drawable.rotten_flesh),
            CategoriesData("Spider Eye", R.drawable.spider_eye),
            CategoriesData("Fermented Spider Eye", R.drawable.fermented_spider_eye),
            CategoriesData("Cake", R.drawable.cake)
        )
    )

    val item = mapOf(
        // Meat
        "Beef" to ItemData("Raw beef dropped by cows. Restores 3 hunger points.", R.drawable.beef),
        "Chicken" to ItemData("Raw chicken dropped by chickens. Has 30% chance to give hunger effect. Restores 2 hunger points.", R.drawable.chicken),
        "Porkchop" to ItemData("Raw pork dropped by pigs. Restores 3 hunger points.", R.drawable.porkchop),
        "Mutton" to ItemData("Raw mutton dropped by sheep. Restores 2 hunger points.", R.drawable.mutton),
        "Rabbit" to ItemData("Raw rabbit meat dropped by rabbits. Restores 3 hunger points.", R.drawable.rabbit),
        // Vegetables
        "Carrot" to ItemData("Grown from carrot crops. Can be eaten or used to breed pigs. Restores 3 hunger points.", R.drawable.carrot),
        "Potato" to ItemData("Grown from potato crops. Restores 1 hunger point.", R.drawable.potato),
        "Baked Potato" to ItemData("Cooked potato in a furnace. Restores 5 hunger points.", R.drawable.baked_potato),
        "Poisonous Potato" to ItemData("Rare drop from potato crops. Has 60% chance to give poison effect. Restores 2 hunger points.", R.drawable.poisonous_potato),
        "Beetroot" to ItemData("Grown from beetroot crops. Can be used to make soup. Restores 1 hunger point.", R.drawable.beetroot),
        // Fruits
        "Apple" to ItemData("Dropped from oak leaves. Restores 4 hunger points.", R.drawable.apple),
        "Golden Apple" to ItemData("Crafted with apple and gold ingots. Grants absorption and regeneration effects. Restores 4 hunger points.", R.drawable.golden_apple),
        "Enchanted Golden Apple" to ItemData("Crafted with apple and gold blocks. Grants powerful regeneration, resistance, absorption, and fire resistance effects.", R.drawable.enchanted_golden_apple),
        "Melon Slice" to ItemData("Obtained from melon blocks. Restores 2 hunger points.", R.drawable.melon_slice),
        "Sweet Berries" to ItemData("Grown on sweet berry bushes. Restores 2 hunger points.", R.drawable.sweet_berries),
        "Glow Berries" to ItemData("Found in lush caves. Provides light when eaten. Restores 2 hunger points.", R.drawable.glow_berries),
        "Chorus Fruit" to ItemData("Dropped by chorus plants in the End. Teleports player when eaten. Restores 4 hunger points.", R.drawable.chorus_fruit),
        // Fish
        "Raw Cod" to ItemData("Caught by fishing or dropped by guardians. Restores 2 hunger points.", R.drawable.raw_cod),
        "Cooked Cod" to ItemData("Cooked raw cod in a furnace. Restores 5 hunger points.", R.drawable.cooked_cod),
        "Raw Salmon" to ItemData("Caught by fishing in cold biomes. Restores 2 hunger points.", R.drawable.raw_salmon),
        "Cooked Salmon" to ItemData("Cooked raw salmon in a furnace. Restores 6 hunger points.", R.drawable.cooked_salmon),
        "Tropical Fish" to ItemData("Caught by fishing in warm oceans. Restores 1 hunger point.", R.drawable.tropical_fish),
        "Pufferfish" to ItemData("Caught by fishing. Gives hunger, nausea, and poison effects. Restores 1 hunger point.", R.drawable.pufferfish),
        // Dairy
        "Milk Bucket" to ItemData("Obtained by milking cows. Removes all status effects.", R.drawable.milk_bucket),
        "Egg" to ItemData("Laid by chickens. Can be thrown or used in crafting. Restores 1 hunger point.", R.drawable.egg),
        // Baked
        "Bread" to ItemData("Crafted with wheat. Restores 5 hunger points.", R.drawable.bread),
        "Cookie" to ItemData("Crafted with wheat and cocoa beans. Restores 2 hunger points.", R.drawable.cookie),
        "Pumpkin Pie" to ItemData("Crafted with pumpkin, sugar, and egg. Restores 8 hunger points.", R.drawable.pumpkin_pie),
        // Cooked Meats
        "Steak" to ItemData("Cooked beef in a furnace. Restores 8 hunger points.", R.drawable.steak),
        "Cooked Chicken" to ItemData("Cooked chicken in a furnace. Restores 6 hunger points.", R.drawable.cooked_chicken),
        "Cooked Porkchop" to ItemData("Cooked porkchop in a furnace. Restores 8 hunger points.", R.drawable.cooked_porkchop),
        "Cooked Mutton" to ItemData("Cooked mutton in a furnace. Restores 6 hunger points.", R.drawable.cooked_mutton),
        "Cooked Rabbit" to ItemData("Cooked rabbit in a furnace. Restores 5 hunger points.", R.drawable.cooked_rabbit),
        // Craftable
        "Rabbit Stew" to ItemData("Crafted with cooked rabbit, carrot, baked potato, mushroom, and bowl. Restores 10 hunger points.", R.drawable.rabbit_stew),
        "Beetroot Soup" to ItemData("Crafted with 6 beetroots and bowl. Restores 6 hunger points.", R.drawable.beetroot_soup),
        "Mushroom Stew" to ItemData("Crafted with red and brown mushrooms and bowl. Restores 6 hunger points.", R.drawable.mushroom_stew),
        "Suspicious Stew" to ItemData("Crafted with bowl, red/brown mushroom, and any flower. Gives various effects.", R.drawable.suspicious_stew),
        "Honey Bottle" to ItemData("Obtained from beehives. Removes poison effect. Restores 6 hunger points.", R.drawable.honey_bottle),
        // Special
        "Dried Kelp" to ItemData("Cooked kelp in furnace. Can be eaten quickly. Restores 1 hunger point.", R.drawable.dried_kelp),
        "Rotten Flesh" to ItemData("Dropped by zombies. Has 80% chance to give hunger effect. Restores 4 hunger points.", R.drawable.rotten_flesh),
        "Spider Eye" to ItemData("Dropped by spiders. Gives poison effect. Restores 2 hunger points.", R.drawable.spider_eye),
        "Fermented Spider Eye" to ItemData("Crafted with spider eye, sugar, and brown mushroom. Used for potions.", R.drawable.fermented_spider_eye),
        "Cake" to ItemData("Crafted with wheat, sugar, milk, and egg. Placed block that can be eaten 7 times (1 slice = 2 hunger points).", R.drawable.cake)
    )
}