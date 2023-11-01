package leetcode.stack.reverse_linked_list

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun reverseList(head: ListNode?): ListNode? {
    var currentHead: ListNode? = head
    var previewHead: ListNode? = null

    // nextを退避（currentのnextがpreviewになるので、元のnextとの繋がりが絶たれるため）
    // → previewをcurrent.nextに設定（逆矢印になる）
    // → 次へ（currentをnextする）
    // 終了条件について：currentにpreviewを設定している（currentの矢印を付けなおしている）ので、
    // currentが終端を過ぎる（nullになる）まで続ける
    while (currentHead != null) {
        val next = currentHead.next
        currentHead.next = previewHead
        previewHead = currentHead
        currentHead = next
    }
    // ループ抜けたときにはcurrentがnullになっている（終端を過ぎている）ので、
    // previewを返す。
    // ひっくり返ってるので、previewが始点になる。
    return previewHead
}