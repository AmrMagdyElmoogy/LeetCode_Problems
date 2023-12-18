class Solution {
    fun maxScore(cardPoints: IntArray, k: Int): Int {
        var left = 0
        val size = cardPoints.size 
        val sum = cardPoints.sum()
        val windowSize = size - k 
        var windowSum = 0
        var minSum = Integer.MAX_VALUE
        for(i in 0 until size){
            windowSum+= cardPoints[i]
            if(i - left + 1 == windowSize)
            {
                minSum = minOf(minSum,windowSum)
            }
            else if(i-left+1 > windowSize) {
                windowSum-= cardPoints[left]
                left++
                minSum = minOf(minSum,windowSum)
            }
        } 
       return sum-minSum
    }
}