import java.util.*

// read n Ts from n lines
fun readIntFromStdIn(): Int = try {
    readLine()?.toInt() ?: readIntFromStdIn()
} catch (e: InputMismatchException) {
    readIntFromStdIn()
}

fun readStringFromStdIn(wordCount: Int): List<String> {
    val result = readLine()?.split(' ')
    return if (result == null || result.size != wordCount) {
        println("Please input $wordCount words separated by spaces")
        readStringFromStdIn(wordCount)
    } else {
        result
    }
}

fun readIntsFromStdIn(): List<Int> {
    return try {
        readLine()?.split(' ')?.map { it.toInt() } ?: readIntsFromStdIn()
    } catch (e: NumberFormatException) {
        readIntsFromStdIn()
    }
}