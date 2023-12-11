class Solution {
fun minFlips(s: String): Int {
        val original = StringBuilder(s)
        original.append(s)
        val alt1 = StringBuilder()
        val alt2 = StringBuilder()
        val n = s.length

        for (i in 0 until original.length) {
            alt1.append(if (i % 2 == 0) '0' else '1')
            alt2.append(if (i % 2 == 0) '1' else '0')
        }

        var (l, diff1) = 0 to 0
        var (res, diff2) = original.length to 0
        for (i in 0 until original.length) {
            if (original[i] != alt1[i]) {
                diff1++
            }
            if (original[i] != alt2[i]) {
                diff2++
            }

            if (i - l + 1 > n) {
                if (original[l] != alt1[l])
                    diff1--
                if (original[l] != alt2[l])
                    diff2--
                l++
            }

            if (i - l + 1 == n) {
                res = minOf(minOf(res, diff1), diff2)
            }
        }
        return res
    }
}