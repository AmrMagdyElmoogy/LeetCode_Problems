class MyCalendar() {
    private var calender = mutableListOf(0 to 0)
    fun book(start: Int, end: Int): Boolean {
        if (calender[0].first == 0) {
            calender[0] = Pair(start, end)
        } else {
            calender.forEach {
                if (intersect(it, Pair(start,end)))
                    return false
            }
            calender.add(Pair(start, end))
        }
        return true
    }
    
    private fun intersect(event1: Pair<Int,Int>, event2: Pair<Int,Int>): Boolean{
        return !(event1.first >= event2.second || event2.first >=event1.second)
    }
}
/**
 * Your MyCalendar object will be instantiated and called as such:
 * var obj = MyCalendar()
 * var param_1 = obj.book(start,end)
 */