import java.util.*
import kotlin.math.pow

class PostfixCalculator {

  fun parse(expression: String): Double {
    val numQueue = LinkedList<Double>()
    val parsedString = LinkedList<String>()

//    if(expression.isEmpty()) {
//      print("Expression is empty")
//      throw IllegalArgumentException()
//    }

    parsedString.addAll(expression.split(" "))

    try{
      while(!parsedString.isEmpty()) {
        val currVal = parsedString.pollFirst()

        when(currVal) {
          "+" -> numQueue.addLast(numQueue.pollLast() + numQueue.pollLast())
          "-" ->{
            val last = numQueue.pollLast()
            val secondLast = numQueue.pollLast()
            numQueue.addLast(secondLast - last)
          }
          "*" -> numQueue.addLast(numQueue.pollLast() * numQueue.pollLast())
          "/" -> {
            val last = numQueue.pollLast()
            var secondLast = numQueue.pollLast()
            numQueue.addLast(secondLast / last)
          }
          "^" -> {
            val last = numQueue.pollLast()
            val secondLast = numQueue.pollLast()
            numQueue.addLast(secondLast.pow(last))
          }
          else -> {
            try{
              numQueue.addLast(currVal.toDouble())
            } catch (e: IllegalArgumentException) {
              throw IllegalArgumentException()
            }
          }
        }
      }
    } catch(e: IllegalArgumentException) {
      throw IllegalArgumentException()
    }


    return numQueue.pollFirst()
  }
}