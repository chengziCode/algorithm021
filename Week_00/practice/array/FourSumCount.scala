package practice.array

import scala.collection.mutable


// 四数之和
object FourSumCount {

  def fourSumCount(A: Array[Int], B: Array[Int], C: Array[Int], D: Array[Int]): Int = {
    val map = new mutable.HashMap[Int, Int]
    var cnt = 0

    A.foreach(a => {
      B.foreach(b => {
        val sum_for_ab = a + b
        val count = map.getOrElse(sum_for_ab, 0)
        map.put(sum_for_ab, count + 1)
      })
    })

    C.foreach(c => {
      D.foreach(d => {
        val sum_for_cd = -(c + d)
        if (map.contains(sum_for_cd)) cnt += map.getOrElse(sum_for_cd, 0)
      })
    })
    cnt
  }
}
