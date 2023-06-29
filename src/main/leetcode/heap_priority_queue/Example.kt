package leetcode.heap_priority_queue

import java.util.PriorityQueue

fun main() {
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

class KthLargestExample(
    val k: Int,
    val nums: IntArray
) {

    // コンストラクタ引数からヒープを初期化（優先度は自然順=昇順）
    private val heap = PriorityQueue<Int>()

    init {
        nums.forEach {
            heap.add(it)
        }
    }

    /**
     * 引数をヒープに追加
     * 要素数がkになるまで先頭から=小さい順に削除
     * k個になったら、先頭要素が解
     */
    fun add(v: Int): Int {
        heap.offer(v)
        // 最も大きい3つだけを比べられれば良いため、それ以外は消しても構わない。（後続で使ったりもないので）
        while (heap.size > k) heap.poll()
        return heap.peek()
    }
}