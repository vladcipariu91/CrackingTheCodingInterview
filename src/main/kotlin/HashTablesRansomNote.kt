fun main(args: Array<String>) {
    val ints = readIntsFromStdIn()
    val wordsFromMagazine = readStringFromStdIn(ints[0])
    val ransomNote = readStringFromStdIn(ints[1])

    print(if (canWriteRansomNote(wordsFromMagazine, ransomNote)) "Yes" else "No")
}

fun canWriteRansomNote(wordsFromMagazine: List<String>, ransomNote: List<String>): Boolean {
    if (wordsFromMagazine.size < ransomNote.size) return false

    val availableWords = HashMap<String, Int>()
    for (word in wordsFromMagazine) {
        val wordCount: Int = availableWords[word] ?: 0
        availableWords.put(word, wordCount + 1)
    }

    for (ransomWord in ransomNote) {
        var wordCount = availableWords[ransomWord]
        if (wordCount != null) {
            --wordCount
            if (wordCount <= 0) {
                availableWords.remove(ransomWord)
            } else {
                availableWords.put(ransomWord, wordCount)
            }
        } else {
            return false
        }
    }

    return true
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