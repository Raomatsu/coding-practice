package leetcode.dynamic_programming.unique_paths2

fun main() {
    print(
        uniquePathsWithObstacles(arrayOf(
            intArrayOf(0,0,0),
            intArrayOf(0,1,0),
            intArrayOf(0,0,0)
        ))
    )
}

fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    val row = IntArray(obstacleGrid[0].size)
    row[0] = 1
    for (r in obstacleGrid)
        for (x in r.indices)
            if (r[x] != 0) row[x] = 0
            else if (x > 0) row[x] += row[x - 1]
    return row.last()
}