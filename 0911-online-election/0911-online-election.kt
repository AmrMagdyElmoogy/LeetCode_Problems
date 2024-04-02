class TopVotedCandidate(persons: IntArray, times: IntArray) {
    private val leaders = TreeMap<Int, Int>()
    private val personVotes = hashMapOf<Int, Int>()
    private var maxVotes = 0
    private var leader = -1

    init {
        for (i in persons.indices) {
            val vote = personVotes.getOrDefault(persons[i], 0) + 1
            personVotes[persons[i]] = vote

            if (vote >= maxVotes) {
                maxVotes = vote
                leader = persons[i]
            }

            leaders[times[i]] = leader
        }
    }

    fun q(t: Int): Int {
        return leaders[leaders.floorKey(t)] ?: -1
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * var obj = TopVotedCandidate(persons, times)
 * var param_1 = obj.q(t)
 */