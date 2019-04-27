package chapter01

/**
  * Created by IntelliJ IDEA.
  * User: zhougm
  * Date: 2019-04-20
  * Time: 18:59
  */
object ExceptionTest {

  def main(args: Array[String]): Unit = {

    divide(100,2)

  }


  /**
    * scala可以在方法名前通过@throws(classOf[ArithmeticException])
    * 来指定抛出指定的异常
    * 也可以throw 抛出异常 throw关键字主要用于抛出自定义异常
    * @param a
    * @param b
    */
  //@throws(classOf[ArithmeticException])
  def divide(a:Int, b:Int) = {
    try{
      a/b
      if(a<b)
        throw new ArithmeticException("You are not eligible")
      val arr = Array(1,2)
      arr(10)
    }catch{
      case e: ArithmeticException => println("ArithmeticException === "+e)
      case ex: Exception => println("Exception ===== " + ex)
      case th: Throwable => println("found a unknown exception ==== "+ th)
      case _ : Throwable => println("Unknown exception")
    }
    finally{
      println("Finaly block always executes")
    }
    println("Rest of the code is executing...")
  }
}
