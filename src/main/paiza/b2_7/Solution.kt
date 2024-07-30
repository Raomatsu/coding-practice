package b2_7

fun main() {
    val (maxY, maxX, robotsNum, moveNum) = readln().split(" ").map { it.toInt() }

    val levelUpPoints = List(10) {
        readln().split(" ").map { it.toInt() }.let {
            Pair(it[0], it[1])
        }
    }

    val robots = List(robotsNum) {
        readln().split(" ").map { it.toInt() }.let {
            Robot(
                level = it[2],
                x = it[0],
                y = it[1]
            )
        }
    }

    List(moveNum) {
        readln().split(" ").let {
            val robot = robots[it[0].toInt()-1]
            robot.moveTo(it[1])
            robot.levelUpOrNot(levelUpPoints)
        }
    }

    robots.forEach {
        it.output()
    }

}

class Robot(
    var level: Int,
    var x: Int,
    var y: Int,
) {
    fun moveTo(direction: String) {
        when(direction) {
            "N" -> y -= getMoveDistance()
            "S" -> y += getMoveDistance()
            "E" -> x += getMoveDistance()
            "W" -> x -= getMoveDistance()
        }
    }

    fun levelUpOrNot(levelUpPoints: List<Pair<Int, Int>>) {
        levelUpPoints.forEach {
            if (x == it.first && y == it.second && level <= 4) {
                level ++
            }
        }
    }

    fun output() {
        println("$x $y $level")
    }

    private fun getMoveDistance(): Int {
        return when(level) {
            1 -> 1
            2 -> 2
            3 -> 5
            4 -> 10
            else -> throw IllegalStateException()
        }
    }
}