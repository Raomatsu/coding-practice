package leetcode.heap_priority_queue

fun main(){
    var array = IntArray(4)
    array[0] = 4
    array[1] = 5
    array[2] = 8
    array[3] = 2

    var obj = KthLargest(3, array)
    print(obj.add(3))
    print(obj.add(5))
    print(obj.add(10))
    print(obj.add(9))
    print(obj.add(4))
}

class KthLargest(k: Int, nums: IntArray) {

    val asc = k
    var numList = nums.toList().toMutableList()

    fun add(`val`: Int): Int {
        numList.add(`val`)
        numList.sortByDescending { it }
        return numList[asc-1]
    }

}