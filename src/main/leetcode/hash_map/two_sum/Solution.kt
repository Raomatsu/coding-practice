package leetcode.hash_map.two_sum

fun main() {
    test(listOf(2,7,11,15), 9)
    test(listOf(3,2,4), 6)
}


fun twoSum(nums: IntArray, target: Int): IntArray {
    // numsを順番に取り出し、「自身以外の要素と足し算する」操作をする。
    // targetに一致したらbreakする
    var index1 = 0
    var index2 = 0
    for ( (index, num) in nums.withIndex() ) {
        if(index1 != index2 && nums[index1] + nums[index2] == target) break
        index1 = index
        for( (innerIndex, innerNum) in nums.withIndex()) {
            index2 = innerIndex

            if(index == innerIndex) continue

            if(num + innerNum == target) break
        }
    }

    val result = IntArray(2)
    result[0] = index1
    result[1] = index2
    return result
}

fun test(nums: List<Int>, target: Int){
    val numsArray = IntArray(nums.size)
    nums.forEachIndexed { index, it ->
        numsArray[index] = it
    }

    val result = twoSum(numsArray, target).toList()
    print(result)
}