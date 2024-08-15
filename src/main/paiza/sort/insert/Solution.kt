package main.paiza.sort.insert

fun main() {
    val size = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.toMutableList()

    // 挿入ソート
    // 整列済みの列に未整列の要素を入れ込んでいく

    // 整列済みリストに要素を加えていく
    // 入れる位置が決まる（対象の要素が比較先の整列済み要素より大きくなる）まで、整列済み要素は右にずらしていく
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
