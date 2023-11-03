package leetcode.hash_map.unique_email_addresses

fun numUniqueEmails2(emails: Array<String>): Int {
    var emailsSet = hashSetOf<String>()


    emails.forEach { email ->
        // 各メアドについて、整形してhaseSetに追加していく
        var res = ""
        var emailStrNumber = 0

        while(email[emailStrNumber] != '+' && email[emailStrNumber] != '@') {
            //local nameの整形
            // "."の除去
            if(email[emailStrNumber] != '.') res += email[emailStrNumber]
            emailStrNumber ++
        }

        // "@"まで進める
        while(email[emailStrNumber] != '@') emailStrNumber ++

        // 連結
        res += email.substring(emailStrNumber)

        // 重複排除
        emailsSet.add(res)
    }

    return emailsSet.size
}
