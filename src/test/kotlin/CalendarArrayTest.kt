

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.YearMonth
import kotlin.test.fail

class CalendarArrayTest {
  @Test
  internal fun `current month`() {
    val expectedArray = arrayOf(
      intArrayOf(28, 29, 30, 31, 1, 2, 3),
      intArrayOf(4, 5, 6, 7, 8, 9, 10),
      intArrayOf(11, 12, 13, 14, 15, 16, 17),
      intArrayOf(18, 19, 20, 21, 22, 23, 24),
      intArrayOf(25, 26, 27, 28, 29, 30, 1),
      intArrayOf(2, 3, 4, 5, 6, 7, 8)
    )

    val actualArray = CalendarArray().generate(YearMonth.of(2023, 4))
    Assertions.assertArrayEquals(expectedArray, actualArray)

  }
//  @Test
//  internal fun `previous month`() {
//    val expectedArray = arrayOf(
//      intArrayOf(30, 1, 2, 3, 4, 5, 6),
//      intArrayOf(7, 8, 9, 10, 11, 12, 13),
//      intArrayOf(14, 15, 16, 17, 18, 19, 20),
//      intArrayOf(21, 22, 23, 24, 25, 26, 27),
//      intArrayOf(28, 29, 30, 31, 1, 2, 3),
//      intArrayOf(4, 5, 6, 7, 8, 9, 10)
//    )
//
//    val actualArray = CalendarArray().generate(YearMonth.of(2023,3))
//    Assertions.assertArrayEquals( expectedArray, actualArray)
//  }
}