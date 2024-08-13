package sequntial_search.b141

fun main() {
    val N = readln().toInt()
    val flowerList = FlowerList(
        list = List(N * 2){
            Flower(readln().toInt())
        }.toMutableList()
    )
    flowerList.sort()
    println(flowerList.swapNum)
}

data class FlowerList(
    val list: MutableList<Flower>,
    var swapNum: Int = 0,
) {

    fun sort() {
        for (index in 0 .. list.lastIndex) {
            // 置くべき色
            val color = getAdaptColorOf(index)
            // 動かす要素の特定
            val targetFlowerIndex = getTargetIndexOf(index, color)

            // 実際に動かす
            if (index == targetFlowerIndex) continue
            for (i in targetFlowerIndex downTo index + 1) {
                val temp = list[i]
                list[i] = list[i - 1]
                list[i - 1] = temp
                swapNum++
            }
        }
    }

    private fun getAdaptColorOf(index: Int): Int {
        return if (index < list.size / 2) {
            index + 1
        } else {
            index - (list.size / 2) + 1
        }
    }

    private fun getTargetIndexOf(index: Int, color: Int): Int {
        var targetIndex = 0
        for (i in index .. list.lastIndex) {
            if (list[i].color == color) {
                targetIndex = i
                break
            }
        }
        return targetIndex
    }
}

data class Flower(
    val color: Int
)

