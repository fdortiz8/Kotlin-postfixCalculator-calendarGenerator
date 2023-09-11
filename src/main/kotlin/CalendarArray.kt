
import java.time.YearMonth

class CalendarArray {

  fun generate(month: YearMonth): Array<IntArray> {
    val daysInMonthArray = ArrayList<Int>(42)
    val finalArray = Array(6){IntArray(7)}

    val yearMonth = month

    val daysInMonth = yearMonth.lengthOfMonth()

    val firstOfMonth = yearMonth.atDay(1)

    val dayOfWeek = firstOfMonth.getDayOfWeek().getValue()

    val daysInPrevMonth = yearMonth.minusMonths(1).lengthOfMonth()

    for(i in 1..42) {
      if ( i <= dayOfWeek) {
        daysInMonthArray.add(daysInPrevMonth - (dayOfWeek - i))
      }
      else if (i > (daysInMonth + dayOfWeek)) {
        daysInMonthArray.add((i - dayOfWeek) % daysInMonth)
      }
      else {
        daysInMonthArray.add(i - dayOfWeek)
      }
    }
    var x = 0
    for (i in 0..5) {
      for(j in 0..6) {
        finalArray[i][j] = daysInMonthArray[x]
        x++
      }
    }

    for (i in finalArray.indices) {
      println(finalArray[i].contentToString())
    }
    return finalArray
  }
}