/**
 * ユーザー情報
 */
data class User(
    val userId: String,
    val age: Int,
    val item: String
)

/**
 * 変換後後ユーザー情報
 */
data class ConvertUser(
    val userId: String,
    val age: Int,
    val items: List<String>
)

/**
 * 縦持ちのユーザー情報を横持ちに変換
 */
fun convert(): List<ConvertUser>? {

    val users = listOf(
        User("1", 10,"アイテム１"),
        User("1", 10,"アイテム２"),
        User("1", 10,"アイテム３"),
        User("2", 15,"アイテム５"),
        User("2", 15,"アイテム６")
    )

    // 縦持ちを横持ちに変換
    val cnvUsers = users.groupBy(
        keySelector = { "${it.userId}/${it.age}" },
        valueTransform = { it.item }
    ).map {
        ConvertUser(
            it.key.split("/")[0],
            it.key.split("/")[1].toInt(),
            it.value
        )
    }

    println(cnvUsers)

    val cnvUsers2 = users.groupBy {
        "${it.userId}/${it.age}"
    }.map {
        ConvertUser(
            it.value.first().userId,
            it.value.first().age,
            it.value.map {
                user -> user.item
            }
        )
    }

    println(cnvUsers2)

    return cnvUsers
}