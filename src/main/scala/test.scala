/**
  * Created by time on 17/3/3.
  */
import java.sql.ResultSet

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable
import sql._

object test {
  def getAimAns(res: ArrayBuffer[mutable.HashMap[String, Any]]) = {
    val sz = res.size
    val ans = ArrayBuffer[mutable.HashMap[String, Any]]()
    for (i <- 0 until sz if (res(i)("type") == "0") ) {
      // println("i, sz" + i + ", " + sz)
      if (i+1 >= sz || (res(i+1)("type") == "0")) {
        ans += res(i)
      }
    }
    ans
  }


  def main(args: Array[String]): Unit = {
    val str = " select * from IM"
    val res = sql.select(str)
    val ans = getAimAns(res)
    var i = 0
    for (x <- ans if i<10) {
      i+=1
      println(ans(i)("uid") + "  " + ans(i)("type") +"  " +ans(i)("msg"))
    }
  }
}
