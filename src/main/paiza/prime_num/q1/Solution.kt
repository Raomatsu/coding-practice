package main.paiza.prime_num.q1

import kotlin.math.floor

/**
 * 修正したところ
 * ・1は素数でない判定
 * ・Longに変換
 * ・約数の最大値は平方根
 */
fun main() {
    val num = readln().toDouble()
    if (num == 1.0) {
        println("NO")
        return
    }
    for (i in 2 .. floor(Math.sqrt(num)).toInt()) {
        if (num % i == 0.0) {
            println("NO")
            return
        }
    }
    println("YES")
}