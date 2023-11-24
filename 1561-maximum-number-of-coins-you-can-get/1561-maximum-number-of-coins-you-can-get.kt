class Solution {
    fun maxCoins(piles: IntArray): Int {
        piles.sort() 
        var result = 0
        var round = piles.size / 3
        var i = piles.size - 2
        while(round > 0)
        {
            result+= piles[i]
            round--
            i-=2
        }
        return result
    }
}