
fun main(args: Array<String>) {
    // Listの初期化
    val list: List<Int> = listOf(1, 2, 3)
    val listMt: MutableList<Int> = mutableListOf(1, 2, 3)

    // Setの初期化
    val set: Set<Int> = setOf(1, 2, 3)
    val setMt: MutableSet<Int> = mutableSetOf(1, 2, 3)

    // Mapの初期化
    val map: Map<String, Int> = mapOf("one" to 1, "two" to 2)
    val mapMt: MutableMap<String, Int> = mutableMapOf("one" to 1, "two" to 2)

    // List -> Map変換
    val listToMap = list.associateBy({it}, {"test${it}"})
    // Map -> Map変換
    val mapToMap = map.map { it.key to it.value.toString() }.toMap()

    // 表示１
    listToMap.forEach { (t, u) -> println("listからMap変換 t:${t} u:${u}") }
    // 表示２
    mapToMap.forEach { (t, u) -> println("MapからMap変換 t:${t} u:${u}") }

    val ex: Throwable = if (args == null) {
        NullPointerException()
    } else {
        NumberFormatException()
    }

    when(ex) {
        is Exception -> println("ぬるぽです")
        else -> println("その他例外です")
    }


    println("Hello World!")
}