package binary

import java.util.*
import kotlin.math.max


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    var n = scan.nextLine().trim().toInt()

    // n to binary
    // we have to mirror the result of this to get to the correct binary number
    var counter = 0
    var maxConsecutiveOnes = 0
    while (n > 0) {
        print(n % 2)
        if (n % 2 == 1) {
            counter++
            if (counter > maxConsecutiveOnes) {
                maxConsecutiveOnes = counter
            }
        } else {
            counter = 0
        }
        n /= 2
    }

    println()
    println("counter value is $maxConsecutiveOnes")
}