class Cashier(n: Int, discount: Int, products: IntArray, prices: IntArray) {

    private var productsPrices = mapOf<Int, Int>()
    private val discountByN = discount
    private val noOfCustomerHaveDiscount = n
    private var customerCnt = 1

    init {
        productsPrices = products.zip(prices).toMap()
    }


    fun getBill(product: IntArray, amount: IntArray): Double {
        var bill: Double = 0.0
        product.forEachIndexed { index, i ->
            bill += productsPrices[i]!! * amount[index]
        }
        if (customerCnt % noOfCustomerHaveDiscount == 0) {
            bill *= (100 - discountByN) / 100.0
        }
        customerCnt++
        return bill
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * var obj = Cashier(n, discount, products, prices)
 * var param_1 = obj.getBill(product,amount)
 */