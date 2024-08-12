package sequntial_search.menu3.q8

fun main() {
    val n = readln().toInt()
    val students = List(n) {
        readln().split(" ").let { Student(it[0], it[1].toInt()) }
    }
    val (k, l) = readln().split(" ").map { it.toInt() }

    val passedStudents = mutableListOf<String>()
    students.forEach { if (it.score in k .. l) passedStudents.add(it.name) }
    passedStudents.forEach {
        println(it)
    }
}

data class Student(
    val name: String,
    val score: Int,
)

