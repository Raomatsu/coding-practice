package others

/**
 * 1+2+...+Nを返す
 */
fun test1(N: Int): Int {
    if (N == 0) return 0
    return N + test1(N + 1)
}

fun euclid(m: Int, n: Int): Int {
    if (n == 0) return m

    return euclid(n, m % n)
}

fun main() {
    print(euclid(15, 12))
}