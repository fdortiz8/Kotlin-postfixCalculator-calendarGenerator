import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.fail

class PostfixCalculatorTest {
  @Test
  internal fun `test addition`() {
    assertEquals(12.0, PostfixCalculator().parse("8 4 +"), 0.001)
  }
  @Test
  internal fun `test addition double`() {
    assertEquals(7.3, PostfixCalculator().parse("4.2 3.1 +"),0.001)
  }
  @Test
  internal fun `test subtraction`() {
    assertEquals(6.0, PostfixCalculator().parse("9 3 -"), 0.001)
  }
  @Test
  internal fun `test subtraction double`() {
    assertEquals(4.2, PostfixCalculator().parse("9.6 5.4 -"), 0.001)
  }
  @Test
  internal fun `test multiplication`() {
    assertEquals(12.0, PostfixCalculator().parse("4 3 *"), 0.001)
  }
  @Test
  internal fun `test multiplication double`() {
    assertEquals(10.89, PostfixCalculator().parse("3.3 3.3 *"), 0.001)
  }
  @Test
  internal fun `test division`() {
    assertEquals(4.0, PostfixCalculator().parse("16 4 /"),0.001)
  }
  @Test
  internal fun `test division double`() {
    assertEquals(3.333, PostfixCalculator().parse("10 3 /"), 0.001)
  }
  @Test
  internal fun `test exponential`() {
    assertEquals(81.0, PostfixCalculator().parse("3 4 ^"), 0.001)
  }
  @Test
  internal fun `test exponential double`() {
    assertEquals(51.416, PostfixCalculator().parse("3.3 3.3 ^"), 0.001)
  }
  @Test
  internal fun `assignment question`() {
    assertEquals(170.0, PostfixCalculator().parse("5 6 2 ^ 2 - *"), 0.001)
  }
  @Test
  internal fun `RPN Incorrect format`() {
    assertFailsWith<IllegalArgumentException> {
      PostfixCalculator().parse("1 + 4")
    }
  }
  @Test
  internal fun `RPN Invalid Expression`() {
    assertFailsWith<IllegalArgumentException> {
      PostfixCalculator().parse("")
    }
  }
  @Test
  internal fun `RPN Unknown operator`() {
    assertFailsWith<IllegalArgumentException> {
      PostfixCalculator().parse("4 23 !")
    }
  }
}