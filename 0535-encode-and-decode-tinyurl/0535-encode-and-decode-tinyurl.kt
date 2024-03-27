class Codec() {
    // Encodes a URL to a shortened URL.
    private lateinit var late: String 
    fun encode(longUrl: String): String {
        late = longUrl 
        return ""
    }

    // Decodes a shortened URL to its original URL.
    fun decode(shortUrl: String): String {
        return late
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * var obj = Codec()
 * var url = obj.encode(longUrl)
 * var ans = obj.decode(url)
 */