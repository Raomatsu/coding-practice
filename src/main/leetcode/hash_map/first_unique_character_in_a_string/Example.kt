package leetcode.hash_map.first_unique_character_in_a_string

fun firstUniqChar2(s: String): Int {
    val charToRepeatNum = mutableMapOf<Char, Int>()

    s.forEach { char ->
        // 文字と登場回数を登録
        charToRepeatNum.put(
            char,
            // 文字で引いて、あれば加算、なければ初登場として1を設定
            charToRepeatNum[char]?.let {it + 1 } ?: 1
        )
    }

    for ((index, char) in s.withIndex()) {
        // 登場回数が1の最初の文字を見つけて、インデックス返す。見つからなければ-1返す
        if (charToRepeatNum[char] == 1) return index
    }
    return -1
}