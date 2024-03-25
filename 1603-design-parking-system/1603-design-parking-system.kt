class ParkingSystem(big: Int, medium: Int, small: Int) {

    private val hashMap = hashMapOf(1 to big, 2 to medium, 3 to small)
    fun addCar(carType: Int): Boolean {
        val result = hashMap[carType]!! > 0
        hashMap[carType]= hashMap[carType]!! - 1
        return result 
    }

}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * var obj = ParkingSystem(big, medium, small)
 * var param_1 = obj.addCar(carType)
 */