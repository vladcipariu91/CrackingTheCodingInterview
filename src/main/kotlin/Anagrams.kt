fun main(args: Array<String>) {
    println(makeAnagrams(readLine()!!, readLine()!!))
}

// https://www.hackerrank.com/challenges/ctci-making-anagrams
fun makeAnagrams(first: String, second: String): Int {
    val array = IntArray(26)

    for (c: Char in first) {
        ++array[c - 'a']
    }

    for (c: Char in second) {
        --array[c - 'a']
    }

    return array.sumBy { Math.abs(it) }
}