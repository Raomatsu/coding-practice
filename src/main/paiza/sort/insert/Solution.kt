package main.paiza.sort.insert

fun main() {
    val size = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.toMutableList()

    // 挿入ソート
    // 整列済みの列に未整列の要素を入れ込んでいく

    // 左端を整列済みとする
    // 1つ追加する=比べて、右に入れる方を決める
    for (targetIndex in 1 .. list.lastIndex) {
        val target = list[targetIndex]
        var compareIndex = targetIndex - 1
        while (compareIndex >= 0 && list[compareIndex] > target) {
            list[compareIndex + 1] = list[compareIndex]
            compareIndex --
        }
        list[compareIndex + 1] = target
        println(list.joinToString(" "))
    }
}
