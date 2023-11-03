package leetcode.hash_map.unique_email_addresses

fun main() {
    val emails = arrayOf("test.email+alex@leetcode.com","test.email.leet+alex@code.com")
    print(numUniqueEmails(emails))

}
fun numUniqueEmails(emails: Array<String>): Int {
    return emails.map{
        val splitEmail = it.split("@")
        val localName = splitEmail[0]
        val formattedLocalName = localName.split("+")[0].replace(".", "")

        "${formattedLocalName}@${splitEmail[1]}"

    }.toSet().size
}