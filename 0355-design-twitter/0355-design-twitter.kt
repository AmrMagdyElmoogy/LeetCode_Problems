class Twitter() {
    private val followers = hashMapOf<Int, MutableSet<Int>>()
    private val tweets = hashMapOf<Int, MutableList<Tweet>>()
    private var timeStamp = 0

    data class Tweet(val id: Int, val time: Int) : Comparable<Tweet> {
        override fun compareTo(other: Tweet): Int {
            return other.time.compareTo(this.time)
        }
    }

    fun postTweet(userId: Int, tweetId: Int) {
        val tweet = tweets.getOrDefault(userId, mutableListOf())
        tweet.add(Tweet(tweetId, timeStamp++))
        tweets[userId] = tweet 
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val getLatestTweets = PriorityQueue<Tweet>()
        val followees = followers.getOrDefault(userId, mutableSetOf())

        followees.add(userId)

        followees.forEach { followId ->
            val tweetOfUserId = tweets.getOrDefault(followId, mutableListOf())
            tweetOfUserId.forEach {
                getLatestTweets.offer(it)
            }
        }

        val result = mutableListOf<Int>()
        var count = 0
        while (getLatestTweets.isNotEmpty() && count < 10) {
            result.add(getLatestTweets.poll().id)
            count++
        }
        return result
    }

    fun follow(followerId: Int, followeeId: Int) {
        val followee = followers.getOrDefault(followerId, mutableSetOf())
        followee.add(followeeId)
        followers[followerId] = followee
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        followers[followerId]?.remove(followeeId)
    }
}



/**
 * Your Twitter object will be instantiated and called as such:
 * var obj = Twitter()
 * obj.postTweet(userId,tweetId)
 * var param_2 = obj.getNewsFeed(userId)
 * obj.follow(followerId,followeeId)
 * obj.unfollow(followerId,followeeId)
 */