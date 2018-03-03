import java.util.*

fun main(args: Array<String>) {
    val expressionCount = readIntFromStdIn()
    val expressionList = mutableListOf<String>()
    for (i in 0 until expressionCount) {
        val expression = readLine()
        if (expression != null)
            expressionList.add(expression)
    }

    for (expression in expressionList) {
        println(if (isBalanced(expression)) "YES" else "NO")
    }
}

fun readIntFromStdIn(): Int = try {
    readLine()?.toInt() ?: readIntFromStdIn()
} catch (e: InputMismatchException) {
    readIntFromStdIn()
}

fun isBalanced(expression: String): Boolean {
    if (expression.length % 2 == 1) return false
    val bracketStack = Stack<Char>()
    for (c in expression) {
        when (c) {
            '(' -> bracketStack.push(')')
            '[' -> bracketStack.push(']')
            '{' -> bracketStack.push('}')
            else -> {
                if (bracketStack.isEmpty() || bracketStack.pop() != c) {
                    return false
                }
            }
        }
    }
    return bracketStack.isEmpty()
}