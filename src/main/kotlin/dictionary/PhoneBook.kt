package dictionary

import java.util.*


fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val phoneBook = mutableMapOf<String, Int>()
    for (i in 0 until n) {
        val name = scanner.next()
        val phone = scanner.nextInt()
        phoneBook[name] = phone
    }

    while (scanner.hasNext()) {
        val s = scanner.next()
        phoneBook[s]?.let {
            println("$s=$it")
        } ?: println("Not found")
    }
    scanner.close()
}