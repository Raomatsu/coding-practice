package b1_2

/**
 * https://paiza.jp/works/mondai/class_primer/class_primer__find
 */
fun main() {
    val number = readln().toInt()

    val students = List(number) {
        val studentData = readln().split(" ")
        return@List Student(
            name = studentData[0],
            age = studentData[1].toInt(),
            birth = studentData[2],
            state = studentData[3]
        )
    }

    val searchAge = readln().toInt()

    print(findStudentName(searchAge, students))
}

data class Student(
    val name: String,
    val age: Int,
    val birth: String,
    val state: String,
)

fun findStudentName(age: Int, students: List<Student>): String {
    students.forEach {
        if (it.age == age) return it.name
    }
    return ""
}
