package leetcode.linked_list.remove_duplicates_from_sorted_list

fun deleteDuplicates(head: ListNode?): ListNode? {
    if(head?.next == null) return head

    var h = head
    // リストの終端まで
    while(h?.next != null) {
        // 同じ数字が並んでいれば、2つ目のは飛ばしてリンクする
        if (h.`val` == h.next!!.`val`) {
            h.next = h.next!!.next
        } else {
            // 同じ数字が続いていなければ、次の数字について見る。
            // elseになってるのは...被りは何連続であるかわからないので、今見てるやつが1つになるまでは次にいっちゃいけない。
            h = h.next
        }
    }
    return h
}

fun deleteDuplicates2(head: ListNode?): ListNode? {
    if(head?.next == null) return head

    var currentHead = head
    while(currentHead?.next != null) {
        if(currentHead.`val` == currentHead.next!!.`val`) {
            currentHead.next = currentHead.next!!.next
        } else {
            currentHead = currentHead?.next
        }
    }

    return head
}

