enum class TestType(
    val value: String,
    val description: String,
    val order: Int
) {
    TYPE_A("a", "タイプ１", 1),
    TYPE_B("b", "タイプ２", 2),
    TYPE_C("c", "タイプ３", 3),
    TYPE_D("d", "タイプ４", 4),
    TYPE_E("e", "タイプ５", 5);

    companion object {
        fun valuesOfOrNull(value: String?): TestType? = values().find { it.value == value }
    }
}

/**
 * ユーザー情報
 */
data class User(
    val userId: String,
    val age: Int,
    val item: String,
    val type: String?
)

/**
 * 変換後後ユーザー情報
 */
data class ConvertUser(
    val userId: String,
    val age: Int,
    val items: List<String>,
    val types: List<TestType?>?
)

/**
 * 縦持ちのユーザー情報を横持ちに変換
 */
fun convert(): List<ConvertUser> {

    val users = listOf(
        User("1", 10,"アイテム１","b"),
        User("1", 10,"アイテム２","a"),
        User("1", 10,"アイテム３","c"),
        User("2", 15,"アイテム５","e"),
        User("2", 15,"アイテム６","d"),
        User("3", 20,"アイテム７",null)
    ).sortedWith(
        compareBy<User> {
            it.userId
        }.thenBy {
            it.age
        }.thenBy {
            TestType.valuesOfOrNull(it.type)?.order
        }
    )

    // 縦持ちを横持ちに変換
//    val cnvUsers = users.groupBy(
//        keySelector = { "${it.userId}/${it.age}" },
//        valueTransform = { it.item }
//    ).map {
//        ConvertUser(
//            it.key.split("/")[0],
//            it.key.split("/")[1].toInt(),
//            it.value,
//        )
//    }

//    println(cnvUsers)

    val cnvUsers2 = users.groupBy {
        "${it.userId}/${it.age}"
    }.map {
        val userList = it.value
        val firstUser = userList.first()
        ConvertUser(
            firstUser.userId,
            firstUser.age,
            userList.map { user -> user.item },
            firstUser.type?.let {
                userList.map { user -> TestType.valuesOfOrNull(user.type) }
            }
        )
    }

    println(cnvUsers2)

    return cnvUsers2
}