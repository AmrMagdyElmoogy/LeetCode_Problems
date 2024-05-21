class Solution {
      fun matchPlayersAndTrainers(players: IntArray, trainers: IntArray): Int {
        val sortedPlayers = players.sorted()
        val sortedTrainers = trainers.sorted()
        var result = 0
        var index = 0
        for (player in sortedPlayers) {
            var trainerCapacity = 0
            for (j in index..<sortedTrainers.size) {
                trainerCapacity += sortedTrainers[j]
                if (player <=  sortedTrainers[j] || player <= trainerCapacity) {
                    result++
                    index++
                    break
                }
                index++
            }
        }
        return result
    }
}