import java.util.*

class Twitter {
    private val followers: MutableMap<Int, MutableSet<Int>> = mutableMapOf() // userId -> Set of followerIds
    private val tweets: MutableMap<Int, MutableList<Tweet>> = mutableMapOf() // userId -> List of tweets

    private var timestamp = 0

    data class Tweet(val tweetId: Int, val timestamp: Int)

    fun postTweet(userId: Int, tweetId: Int) {
        tweets.putIfAbsent(userId, mutableListOf())
        tweets[userId]?.add(Tweet(tweetId, timestamp++))
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val feed = PriorityQueue<Tweet> { a, b -> b.timestamp - a.timestamp }
        val followees = followers.getOrDefault(userId, mutableSetOf())
        followees.add(userId) 

        followees.forEach { followeeId ->
            tweets.getOrDefault(followeeId, mutableListOf()).forEach { tweet ->
                feed.offer(tweet)
            }
        }

        val newsFeed = mutableListOf<Int>()
        var count = 0
        while (!feed.isEmpty() && count < 10) {
            newsFeed.add(feed.poll().tweetId)
            count++
        }

        return newsFeed
    }

 
    fun follow(followerId: Int, followeeId: Int) {
        followers.putIfAbsent(followerId, mutableSetOf())
        followers[followerId]?.add(followeeId)
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