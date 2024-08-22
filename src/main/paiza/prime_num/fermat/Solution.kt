package main.paiza.prime_num.fermat

fun main() {
    /**
     * フェルマーの小定理を利用する。
     * 「pが素数である場合、a^p-1 ≡ 1 (mod p)」
     * これの対偶
     * 「a^p-1 !≡ 1 (mod p) の場合、pは素数でない（合成数）」
     * を利用する。
     * ただし、これで「pは素数である」を確実に言えるわけではない。ので、確率的に素数判定を行うことになる。
     * 例えば、561は合成数である（らしい）が、2^560 ≡ 1 (mod 560)が成り立つ。
     */
    val N = readln().toInt()
    val a = 2
    if (Math.pow(a.toDouble(), (N - 1).toDouble()) % N != 1.0) println("NO") else println("YES")
}