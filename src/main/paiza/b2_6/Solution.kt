package b2_6

import kotlin.math.pow

fun main() {
    val (carsNum, actionsNum) = readln().split(" ").map { it.toInt() }
    val cars = List(carsNum) {
        val carInfo = readln().split(" ")
        when(carInfo[0]) {
            "supercar" -> SuperCar(
                fuelAmount = carInfo[1].toInt(),
                fuelEfficiency = carInfo[2].toInt()
            )

            "supersupercar" -> SuperSuperCar(
                fuelAmount = carInfo[1].toInt(),
                fuelEfficiency = carInfo[2].toInt()
            )

            "supersupersupercar" -> SuperSuperSuperCar(
                fuelAmount = carInfo[1].toInt(),
                fuelEfficiency = carInfo[2].toInt()
            )

            else -> throw IllegalArgumentException()
        }
    }

    List(actionsNum) {
        val actionInfo = readln().split(" ")
        val targetCar = cars[actionInfo[0].toInt()-1]

        when(actionInfo[1]) {
            "run" -> targetCar.run()
            "fly" -> targetCar.fly()
            "teleport" -> targetCar.teleport()
            else -> throw IllegalArgumentException()
        }
    }

    cars.forEach { it.output() }
}

open class SuperCar(
    val fuelEfficiency: Int,
    var fuelAmount: Int,
    var mileage: Int = 0,
) {

    fun run() {
        if (fuelAmount == 0) return

        fuelAmount -= 1
        mileage += fuelEfficiency
    }

    open fun fly() { }
    open fun teleport() {}
    fun output() { println(mileage) }
}

class SuperSuperCar(fuelEfficiency: Int, fuelAmount: Int, mileage: Int = 0): SuperCar(fuelEfficiency, fuelAmount, mileage) {
    override fun fly() {
        if (fuelAmount < 5) {
            run()
        } else {
            fuelAmount -= 5
            mileage += Math.pow(fuelEfficiency.toDouble(), 2.0).toInt()
        }
    }
}

class SuperSuperSuperCar(fuelEfficiency: Int, fuelAmount: Int, mileage: Int = 0): SuperCar(fuelEfficiency, fuelAmount, mileage) {
    override fun fly() {
        if (fuelAmount < 5) {
            run()
        } else {
            fuelAmount -= 5
            mileage += 2 * fuelEfficiency.toDouble().pow(2.0).toInt()
        }
    }

    override fun teleport() {
        val useFuelAmount = fuelEfficiency.toDouble().pow(2.0).toInt()
        if (fuelAmount < useFuelAmount) {
            fly()
        } else {
            fuelAmount -= useFuelAmount
            mileage += fuelEfficiency.toDouble().pow(4.0).toInt()
        }
    }
}