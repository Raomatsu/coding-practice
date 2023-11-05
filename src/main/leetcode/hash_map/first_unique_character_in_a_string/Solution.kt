package leetcode.hash_map.first_unique_character_in_a_string

fun main() {
    print(firstUniqChar("aabb"))
}

/**
 * 3つ以上にsplitできたら2個以上出てきてるってことよなという
 */
fun firstUniqChar(s: String): Int {
    var i = 0
    while(i < s.length) {
        if(s.split(s[i]).size <= 2) return i
        i ++
    }

    return -1
}