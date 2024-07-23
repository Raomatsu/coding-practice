package b1_1

fun main() {
    val num = readLine()!!.toInt()

    val users = List(num) {
        val params = readLine()!!.split(" ")
        User(
            nickname = params[0],
            old = params[1].toInt(),
            birth = params[2],
            state = params[3]
        )
    }

    users.forEach { user ->
        output(user)
    }
}

data class User(
    val nickname: String,
    val old: Int,
    val birth: String,
    val state: String,
)

fun output(user: User) {
    println(
"""User{
nickname : ${user.nickname}
old : ${user.old}
birth : ${user.birth}
state : ${user.state}
}"""
    )
}