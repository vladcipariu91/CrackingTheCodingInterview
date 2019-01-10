package sorting

var swapNumber: Int = 0

fun main(args: Array<String>) {
    bubbleSort(arrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1))
}

fun bubbleSort(a: Array<Int>) {
    for (i in 0 until a.size) {
        for (j in 0 until a.size - 1) {
            if (a[j] > a[j + 1]) {
                swap(a, j, j + 1)
                swapNumber++
            }
        }
        println()
        printArray(a)
    }
//    println("Array is sorted in $swapNumber swaps")
//    println("First element is ${a[0]}")
//    println("Last element is ${a[a.size - 1]}")
//    println()
//    printArray(a)
}

private fun printArray(a: Array<Int>) {
    for (x in a) {
        print("$x ")
    }
}

private fun swap(a: Array<Int>, x: Int, y: Int) {
    val aux = a[x]
    a[x] = a[y]
    a[y] = aux
}
