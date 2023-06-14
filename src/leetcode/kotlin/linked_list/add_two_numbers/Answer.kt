package leetcode.kotlin.linked_list.add_two_numbers

class Answer {
    fun hasCycle(head: ListNode?): Boolean {
        var fast = head
        var slow = head

        // 終端に辿り着くまでポインタを進める。
        // 終端に辿り着いたら循環していないということなのでfalse
        // ポインタを進める中でfastとslowが同じ要素になった場合、循環しているということなのでtrue
        while (fast != null) {
            // fastは2つ飛ばしなので、1つ先がnull=終端であればその場でfalseを返して終了
            if (fast.next == null) return false

            fast = fast.next?.next
            slow = slow?.next
            if(fast == slow) return true
        }
        return false
    }
}

class ListNode(
    // 当該要素がもつ値
    var `val`: Int
) {
    // 次の要素
    var next: ListNode? = null
}