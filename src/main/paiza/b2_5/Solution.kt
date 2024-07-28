package b2_5

fun main() {
    val (playersNum, turnsNum) = readln().split(" ").map { it.toInt() }

    val players = List(playersNum) {
        /**
         * hp である hp_i,
         * 技 1 の発生フレーム F1_i , 攻撃力 A1_i
         * 技 2 の発生フレーム F2_i , 攻撃力 A2_i
         * 技 3 の発生フレーム F3_i , 攻撃力 A3_i が半角スペース区切りで与えられます。
         */
        readln().split(" ").map { it.toInt() }.let {
            Player(
                hp = it[0],
                actions = listOf(
                    Player.Action(
                        type = if (it[1] == 0 && it[2] == 0) Player.ActionType.EMPOWER else Player.ActionType.ATTACK,
                        frame = it[1],
                        power = it[2]
                    ),
                    Player.Action(
                        type = if (it[3] == 0 && it[4] == 0) Player.ActionType.EMPOWER else Player.ActionType.ATTACK,
                        frame = it[3],
                        power = it[4]
                    ),
                    Player.Action(
                        type = if (it[5] == 0 && it[6] == 0) Player.ActionType.EMPOWER else Player.ActionType.ATTACK,
                        frame = it[5],
                        power = it[6]
                    )
                )
            )
        }
    }

    List(turnsNum) {
        readln().split(" ").map { it.toInt() }.let { actionInfo ->
            /**
             * 技を使ったプレイヤーの番号 P1_i と P1_i が選んだ技の番号 T1_i
             * 技を使ったプレイヤーの番号 P2_i と P2_i が選んだ技の番号 T2_i
             */
            val player1 = players[actionInfo[0]-1]
            val player2 = players[actionInfo[2]-1]

            // どちらかが退場していた場合、何も起こらない
            if (player1.hp == 0 || player2.hp == 0) return@let

            val player1Action = player1.actions[actionInfo[1]-1]
            val player2Action = player2.actions[actionInfo[3]-1]

            // 両方攻撃系の技の場合、攻撃判定とダメージ計算を行う
            if (player1Action.type == Player.ActionType.ATTACK && player2Action.type == Player.ActionType.ATTACK) {
                when {
                    // player2の発生の方が早い場合
                    player2Action.frame < player1Action.frame -> player1.takeDamage(player2Action)
                    // player1の発生の方が早い場合
                    player1Action.frame < player2Action.frame -> player2.takeDamage(player1Action)
                    // 発生が同じ場合
                    else -> {}
                }
            }

            // 強化系の技が含まれる場合、それぞれの行動を実行する
            else if (player1Action.type == Player.ActionType.EMPOWER && player2Action.type == Player.ActionType.ATTACK) {
                player1.empower()
                player1.takeDamage(player2Action)
            }
            else if (player1Action.type == Player.ActionType.EMPOWER && player2Action.type == Player.ActionType.EMPOWER) {
                player1.empower()
                player2.empower()
            }
            else if (player1Action.type == Player.ActionType.ATTACK && player2Action.type == Player.ActionType.EMPOWER) {
                player2.empower()
                player2.takeDamage(player1Action)
            }
        }
    }
    print(players.filter { it.hp > 0 }.size)
}

data class Player(
    var hp: Int,
    val actions: List<Action>
) {
    data class Action(
        val type: ActionType,
        var frame: Int,
        var power: Int,
    )

    enum class ActionType {
        ATTACK,
        EMPOWER;
    }

    fun empower() {
        this.actions.forEach { action ->
            if (action.type == ActionType.ATTACK) {
                val frameCalcResult = action.frame - 3
                action.frame = if (frameCalcResult < 1) 1 else frameCalcResult
                action.power += 5
            }
        }
    }

    fun takeDamage(attack: Action) {
        if (attack.type == ActionType.EMPOWER) throw IllegalArgumentException()
        val hpCalcResult = hp - attack.power
        hp = if (hpCalcResult < 0) 0 else hpCalcResult
    }
}