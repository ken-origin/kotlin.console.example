
fun main(args: Array<String>) {
    println(args)
    // Listの初期化
    val list: List<Int> = listOf(1, 2, 3)
    val listMt: MutableList<Int> = mutableListOf(1, 2, 3)

    println(listMt)

    // Setの初期化
    val set: Set<Int> = setOf(1, 2, 3)
    val setMt: MutableSet<Int> = mutableSetOf(1, 2, 3)

    println(set)
    println(setMt)

    // Mapの初期化
    val map: Map<String, Int> = mapOf("one" to 1, "two" to 2)
    val mapMt: MutableMap<String, Int> = mutableMapOf("one" to 1, "two" to 2)

    println(mapMt)

    // List -> Map変換
    val listToMap = list.associateBy({it}, {"test${it}"})
    // Map -> Map変換
    val mapToMap = map.map { it.key to it.value.toString() }.toMap()

    // 表示１
    listToMap.forEach { (t, u) -> println("listからMap変換 t:${t} u:${u}") }
    // 表示２
    mapToMap.forEach { (t, u) -> println("MapからMap変換 t:${t} u:${u}") }

    val tests = Math.random().toInt()
    val ex: Throwable = if (tests > 0) {
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