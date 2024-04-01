class AuthenticationManager(timeToLive: Int) {

    private val pivot = timeToLive
    private val tokensTimeMap = hashMapOf<String, Pair<Int, Int>>()

    fun generate(tokenId: String, currentTime: Int) {
        tokensTimeMap[tokenId] = Pair(currentTime, currentTime + pivot)
    }

    fun renew(tokenId: String, currentTime: Int) {
        if (tokensTimeMap.containsKey(tokenId)) {
            var pair = tokensTimeMap[tokenId]!!
            if (currentTime < pair.second) {
                pair = Pair(pair.first, currentTime + pivot) 
                tokensTimeMap[tokenId] = pair
            }
        }
    }

    fun countUnexpiredTokens(currentTime: Int): Int {
        var cnt = 0
        tokensTimeMap.values.forEach { pair ->
            if (currentTime in pair.first until pair.second) {
                cnt++
            }
        }
        return cnt
    }
}


/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * var obj = AuthenticationManager(timeToLive)
 * obj.generate(tokenId,currentTime)
 * obj.renew(tokenId,currentTime)
 * var param_3 = obj.countUnexpiredTokens(currentTime)
 */