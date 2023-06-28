package leetcode.stack.valid_parentheses

fun main() {
        val result = isValid(")")
        print(result)
}

/**
 * splitした配列に対して下記操作を行う
 * ① 開きカッコの場合：
 *      ・スタックの1番上にそれを積む
 *      ・次へ進む
 * ② 閉じカッコの場合
 *      ・スタックの一番上の開きカッコと対応するか検査
 *      　　・あってれば次へ進む
 *      　　・誤ってればfalseを返す
 * 最後の文字までいったとき、スタックに残ってればfalse
 */
fun isValid(s: String): Boolean {
    val openBrackets = listOf('(', '{', '[')
    val closeBrackets = listOf(')', '}', ']')

    val list = s.toList()

    var stack = mutableListOf<Char>()
    list.forEach {
        if (openBrackets.contains(it)) {
            stack.add(it)

        } else if (closeBrackets.contains(it)) {
            // TODO stackが空でないことの判定も行わないと、")"みたいなケースでNoSuchElementExceptionが発生する
            if (it == ')' && stack.last() != '(') return false
            if (it == '}' && stack.last() != '{') return false
            if (it == ']' && stack.last() != '[') return false

            stack.removeLast()
        }
    }

    return stack.isEmpty()
}
