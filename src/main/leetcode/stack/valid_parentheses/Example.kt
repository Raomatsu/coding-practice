package leetcode.stack.valid_parentheses

import java.util.*

fun main() {
    val result = isValidExample("({[]})")
    print(result)
}

fun isValidExample(s: String): Boolean {
    val list = s.toList()

    // Stackを使う
    var stack = Stack<Char>()
    list.forEach {
        if (it == '(' || it == '{' || it == '[') stack.push(it)
        // stackが空でないことの判定を入れることでNoSuchElementExceptionを回避
        else if (it == ')' && !stack.empty() && stack.peek() == '(') stack.pop()
        else if (it == '}' && !stack.empty() && stack.peek() == '{') stack.pop()
        else if (it == ']' && !stack.empty() && stack.peek() == '[') stack.pop()
        else return false
    }
    return stack.empty()
}
