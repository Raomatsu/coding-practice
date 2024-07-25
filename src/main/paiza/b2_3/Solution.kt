package b2_3

// 自分の得意な言語で
// Let's チャレンジ！！
fun main(args: Array<String>) {
    val dataList = readLine()!!.split(" ")

    // 地点の数
    val pointNum = dataList[0].toInt()
    // 移動の回数
    val moveNum = dataList[1].toInt()
    // 開始地点
    val startPoint = dataList[2].toInt()

    // 各地点の情報
    val pointInfoList = List(pointNum) {
        readLine()!!.split(" ").let {
            PointInfo(
                value = it[0],
                firstRoute = it[1]!!.toInt(),
                secondRoute = it[2]!!.toInt()
            )
        }
    }

    // 各移動の情報（1or2どっちを選ぶか）
    val moveInfoList = List(moveNum) {
        readLine()!!.toInt()
    }

    val printStr = buildString {
        var currentPointIndex = startPoint-1
        moveInfoList.forEach {
            val currentPoint = pointInfoList[currentPointIndex]
            append(
                currentPoint.value
            )
            currentPointIndex = if (it == 1) currentPoint.firstRoute -1  else currentPoint.secondRoute -1
        }
        // 最後の地点への移動、でループ処理は終わっているため、最後の地点の値を文字列に加える
        append(
            pointInfoList[currentPointIndex].value
        )
    }
    print(printStr)
}

data class PointInfo(
    val value: String,
    val firstRoute: Int,
    val secondRoute: Int,
)