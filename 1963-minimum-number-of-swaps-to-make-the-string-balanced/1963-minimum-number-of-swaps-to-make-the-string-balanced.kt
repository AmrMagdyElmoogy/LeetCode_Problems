class Solution {
    fun minSwaps(s: String): Int {
        var cntOfSwap = 0
        var right = s.length - 1
        var closingBracket = 0
        var openingBracket = 0
        var sb = StringBuilder(s)

        for (i in 0..<sb.length) {
            when (sb[i]) {
                ']' -> closingBracket++
                '[' -> openingBracket++
            }
            if (closingBracket > openingBracket) {
                while (right > i && sb[right] == ']')
                    right--
                sb.swap(i, right)
                closingBracket--
                openingBracket++
                cntOfSwap++
            }
        }
        return cntOfSwap
    }
}

fun StringBuilder.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}