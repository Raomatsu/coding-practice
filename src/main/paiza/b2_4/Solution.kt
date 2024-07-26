package b2_4

fun main() {
    val (bravesNum, eventsNum) = readln().split(" ").let {
        Pair(it[0].toInt(), it[1].toInt())
    }

    val braves = List(bravesNum) {
        readln().split(" ").let {
            Brave(
                level = it[0].toInt(),
                hp = it[1].toInt(),
                attack = it[2].toInt(),
                defence = it[3].toInt(),
                speed = it[4].toInt(),
                intelligence = it[5].toInt(),
                fortune = it[6].toInt()
            )
        }
    }.toMutableList()

    /**
     * levelup h a d s c f
     * レベルが 1 上昇
     * 体力が h 上昇
     * 攻撃力が a 上昇
     * 防御力が d 上昇
     * 素早さが s 上昇
     * 賢さが c 上昇
     * 運が f 上昇
     *
     * muscle_training h a
     * 体力が h 上昇
     * 攻撃力が a 上昇
     *
     * running d s
     * 防御力が d 上昇
     * 素早さが s 上昇
     *
     * study c
     * 賢さが c 上昇
     *
     * pray f
     * 運が f 上昇
     *
     */
    val events = List(eventsNum) {
        // to_1 event_1
        readln().split(" ")
    }

    events.forEachIndexed() { index, event ->
        val targetIndex = event[0].toInt() - 1
        // 対象を抽出
        val target = braves[targetIndex]

        // イベントの種類によってパラメータを変化させる
        val updatedTarget = target.getUpdatedBrave(event)

        // 勇者データ上書き
        braves[targetIndex] = updatedTarget
    }

    braves.forEach {
        // パラメータを1行ずつ出力
        it.output()
    }
}

data class Brave(
    val level: Int,
    val hp: Int,
    val attack: Int,
    val defence: Int,
    val speed: Int,
    val intelligence: Int,
    val fortune: Int,
) {
    fun getUpdatedBrave(eventSet: List<String>): Brave {
        return when(eventSet[1]) {
            "levelup" -> this.copy(
                level = level + 1,
                hp = hp + eventSet[2].toInt(),
                attack = attack + eventSet[3].toInt(),
                defence = defence + eventSet[4].toInt(),
                speed = speed + eventSet[5].toInt(),
                intelligence = intelligence + eventSet[6].toInt(),
                fortune = fortune + eventSet[7].toInt()
            )

            "muscle_training" -> this.copy(
                hp = hp + eventSet[2].toInt(),
                attack = attack + eventSet[3].toInt()
            )

            "running" -> this.copy(
                defence = defence + eventSet[2].toInt(),
                speed = speed + eventSet[3].toInt()
            )

            "study" -> this.copy(
                intelligence = intelligence + eventSet[2].toInt()
            )

            "pray" -> this.copy(
                fortune = fortune + eventSet[2].toInt()
            )

            else -> throw IllegalArgumentException()
        }
    }

    fun output() {
        println(
            "${this.level} ${this.hp} ${this.attack} ${this.defence} ${this.speed} ${this.intelligence} ${this.fortune}"
        )
    }
}