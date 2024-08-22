package main.paiza.prime_num.eratosthenes

import kotlin.math.floor

fun main() {
    /**
     * エラストテネスのふるい
     * 自然数Nについて、N以下の素数を洗い出す方法。
     * N以下の数から全ての合成数をふるい落とすことで、素数のみを残す
     */
    val N = readln().toInt()

    // 要素数N+1の配列を用意（array[1]を1に対応させる）
    // 素数であれば、要素としてtrueが入る、とする。
    // はじめは全てtrueと考える。
    // ただし、1は素数ではないため、falseを入れる。
    // あと0も含まれるが、これも素数とかではないため、falseを入れる
    val isPrimeList = (listOf(false,false) + List(N-1) { true }).toMutableList()

    // 合成数をfalseにしていく
    // 多分Nの平方根まで調べれば十分なのでは...?
    for (i in 2 .. floor(Math.sqrt(N.toDouble())).toInt()) {
        var multiple = 2
        while (i * multiple <= N) {
            isPrimeList[i * multiple] = false
            multiple ++
        }
    }

    if(isPrimeList[N]) println("YES") else println("NO")
}