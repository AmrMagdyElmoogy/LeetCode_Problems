class BrowserHistory(homepage: String) {

    val history = mutableListOf(homepage)
    var tabView = 0
    fun visit(url: String) {
        history.add(url)
        if (history.size - tabView == 1)
            tabView++
        else {
            history.removeAll(history.subList(tabView + 1, history.size - 1))
            tabView = history.size - 1
        }
    }

    fun back(steps: Int): String {
        tabView -= steps
        if (tabView < 0)
            tabView = 0
        return history[tabView]
    }

    fun forward(steps: Int): String {
        tabView += steps
        if (tabView > history.size - 1)
            tabView = history.size - 1
        return history[tabView]
    }

}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * var obj = BrowserHistory(homepage)
 * obj.visit(url)
 * var param_2 = obj.back(steps)
 * var param_3 = obj.forward(steps)
 */