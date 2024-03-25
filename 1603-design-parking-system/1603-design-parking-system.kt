class ParkingSystem(big: Int, medium: Int, small: Int) {

    private var bigSlot = big
    private var mediumSlot = medium
    private var smallSlot = small
    fun addCar(carType: Int): Boolean {
        return when (carType) {
            1 -> bigSlot-- > 0
            2 -> mediumSlot-- > 0
            else -> smallSlot-- > 0
        }
    }

}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * var obj = ParkingSystem(big, medium, small)
 * var param_1 = obj.addCar(carType)
 */