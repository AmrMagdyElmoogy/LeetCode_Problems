class TopVotedCandidate(persons: IntArray, times: IntArray) {
    private val leaderMap = TreeMap<Int, Int>() 
    private val personVotes = mutableMapOf<Int, Int>() 
    private var currentLeader = -1 
    
    init {
        var maxVotes = 0 
        var leader = -1 
        
    
        for (i in persons.indices) {
      
            val votes = personVotes.getOrDefault(persons[i], 0) + 1
            personVotes[persons[i]] = votes
            
            if (votes >= maxVotes) {
                maxVotes = votes
                leader = persons[i]
            }
     
            leaderMap[times[i]] = leader
        }
    }
    
    fun q(t: Int): Int {
        val time = leaderMap.floorKey(t)
        return leaderMap[time] ?: -1 
    }
}
/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * var obj = TopVotedCandidate(persons, times)
 * var param_1 = obj.q(t)
 */