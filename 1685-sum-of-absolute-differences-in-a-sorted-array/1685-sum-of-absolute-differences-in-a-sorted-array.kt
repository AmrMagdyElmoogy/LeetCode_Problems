class Solution {
    fun getSumAbsoluteDifferences(nums: IntArray): IntArray {
        val prefixSum = nums.constructPrefixSum()
        val result = IntArray(nums.size) { 0 }
        var leftSum = 0
        var rightSum = 0
        var leftCount = 0
        var rightCount = 0
        var leftTotal = 0
        var rightTotal = 0
        var size = nums.size
        for (i in 0 until nums.size) {
            leftSum = prefixSum[i]
            rightSum = prefixSum[size - 1] - prefixSum[i]
            leftCount = i + 1
            rightCount = size - 1 - i
            leftTotal = leftCount * nums[i] - leftSum
            rightTotal =rightSum - rightCount * nums[i]
            result[i] = leftTotal + rightTotal
        } 
        return result 
    }

    fun IntArray.constructPrefixSum(): IntArray {
        val list = IntArray(this.size) { 0 }
        list[0] = this[0]
        for (i in 1 until this.size) {
            list[i] = list[i - 1] + this[i]
        }
        return list
    }
}