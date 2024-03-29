import kotlin.random.Random
class RandomizedSet() {
    val hashSet = hashSetOf<Int>()
    fun insert(`val`: Int): Boolean {
        return if (!hashSet.contains(`val`)) {
            hashSet.add(`val`)
            true
        } else {
            false
        }
    }

    fun remove(`val`: Int): Boolean {
        return if (hashSet.contains(`val`)) {
            hashSet.remove(`val`)
            true
        } else {
            false
        }
    }

    fun getRandom(): Int {
        val randomIndex = Random.nextInt(hashSet.size)
        return hashSet.elementAt(randomIndex)
    }
}
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */