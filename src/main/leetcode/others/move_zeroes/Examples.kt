package leetcode.others.move_zeroes

fun moveZeroes2(nums: IntArray): Unit {
    var insertPos = 0

    nums.forEach {
        // リストを全部見て、0以外のを前から順に詰めてく
        if (it != 0) {
            nums[insertPos] = it
            insertPos ++
        }
    }

    // 残りを0で埋める
    for(i in insertPos until nums.size) {
        nums[i] = 0
    }
//    whileを使うパターン
//    while(insertPos < nums.size) {
//        nums[insertPos] = 0
//        insertPos ++
//    }
}