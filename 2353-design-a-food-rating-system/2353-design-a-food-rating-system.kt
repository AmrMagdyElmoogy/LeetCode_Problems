data class Food(
    val food: String,
    val rating: Int,
) : Comparable<Food> {
    override fun compareTo(other: Food): Int {
    
        val ratingCompare = other.rating.compareTo(this.rating)

        if (ratingCompare != 0)
            return ratingCompare

        return this.food.compareTo(other.food)
    }
}

class FoodRatings(foods: Array<String>, cuisines: Array<String>, ratings: IntArray) {

    private val foodCuisinesMap = hashMapOf<String, Pair<String, Int>>()
    private val cuisinesHighestRatings = hashMapOf<String, PriorityQueue<Food>>()


    init {
        (0..foods.size - 1).forEach {
            foodCuisinesMap[foods[it]] = Pair(cuisines[it], ratings[it])
            setUpCuisinesDict(cuisines[it], foods[it], ratings[it])
        }
    }

    private fun setUpCuisinesDict(cuisine: String, food: String, rating: Int) {
        val queue = cuisinesHighestRatings.getOrPut(cuisine) { PriorityQueue() }
        queue.offer(Food(food, rating))
    }

    fun changeRating(food: String, newRating: Int) {
        foodCuisinesMap[food] = Pair(foodCuisinesMap[food]!!.first, newRating)
        setUpCuisinesDict(foodCuisinesMap[food]!!.first, food, newRating)

    }

    fun highestRated(cuisine: String): String {
        var highestRated = cuisinesHighestRatings[cuisine]!!.peek() 
        while(highestRated.rating != foodCuisinesMap[highestRated.food]!!.second){
            cuisinesHighestRatings[cuisine]!!.poll()
            highestRated = cuisinesHighestRatings[cuisine]!!.peek()  
        }
        return highestRated.food
    }

}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * var obj = FoodRatings(foods, cuisines, ratings)
 * obj.changeRating(food,newRating)
 * var param_2 = obj.highestRated(cuisine)
 */