package leetcode.dynamic_programming.unique_paths

fun main() {

}
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (head == null) return head

    var dummyHead = ListNode(0)
    dummyHead.next = head

    var length = 0
    var ptr: ListNode? = head

    while (ptr != null) {
        length++
        ptr = ptr.next
    }

    var i = k % length

    if (i == 0) return head

    ptr = dummyHead
    var temp: ListNode? = head

    for (m in 1..length) {
        ptr = ptr?.next
        if (m == length - i) {
            temp = ptr
        }
    }

    // 1- set new head
    var newHead = temp?.next
    // 2- link old tail to old head, ptr is the tail node after the above for loop
    ptr?.next = head
    // 3- link the (i+1)-th node to null
    temp?.next = null

    return newHead
}