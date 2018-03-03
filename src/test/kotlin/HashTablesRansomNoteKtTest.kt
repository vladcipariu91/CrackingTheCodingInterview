import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

internal class HashTablesRansomNoteKtTest {

    @Test
    fun canWriteRansomNote() {
        var availableWords = "give me one grand today night".split(" ")
        var ransomNote = "give one grand today".split(" ")
        assertTrue(canWriteRansomNote(availableWords, ransomNote))

        availableWords = "two times three is not four".split(" ")
        ransomNote = "two times two is four".split(" ")
        assertFalse(canWriteRansomNote(availableWords, ransomNote))
    }
}