import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
internal class BalancedBracketsKtTest(private val expression: String,
                                      private val expected: Boolean) {

    @Test
    fun isBalanced() {
        Assert.assertEquals(expected, isBalanced(expression))
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun expressionProvider(): Collection<Any> {
            return listOf(arrayOf("{()[][{}]}({}{[]})({)}()[][()][{}]{[({})[]]}((){)}", false),
                    arrayOf("{[()]}{[(])}{{[[(())]]}}", false),
                    arrayOf("({(){}[]})[]", true))
        }
    }
}