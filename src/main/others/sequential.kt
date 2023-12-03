package others

const val NO_ANSWER_NUM = -1

fun sequentialSearch(nums: IntArray, target: Int): Int {
    nums.forEachIndexed { it, index ->
        if (it == target) return index
    }

    return NO_ANSWER_NUM
}

fun getMin(nums: IntArray): Int {
    var min = Int.MAX_VALUE

    nums.forEach {
        if (it < min) min = it
    }

    return min
}

fun getMinKOrMore(numsA: IntArray, numsB: IntArray,  k: Int): Int {
    var minValue = Int.MAX_VALUE

    numsA.forEach { numA ->
        numsB.forEach { numB ->
            if (numA + numB in k until minValue) minValue = numA + numB
        }
    }

    return minValue
}

