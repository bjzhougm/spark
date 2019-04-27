package chapter02


object BasicScala {

  /**
    * 1.定义函数
    * 1.1函数语法
    * 定义函数:def关键字
    * 函数名:max
    * 括号():参数列表
    * :Int 返回结果
    * 大括号{}表示函数体
    *
    */
  def max(x:Int,y:Int):Int={
    if(x<y){
      return y;
    }
    return x;
  }



  /**
    * 1.2 匿名函数
    * 不需要给每一个函数命名，正如你不需要给每个数字命名一样。以下是一个匿名函数
    * 函数进行运算后进行返回
    * def addA(x:Int):Int = x + 200
    */

  val add = (x:Int) => x+100;



  /**
    * 定义了 Int=>String的函数f
    *
    * 下面是函数体
    * myInt => "The value of myInt is: " + myInt.toString()
    *
    */
  val f: Int => String = myInt => "The value of myInt is: " + myInt.toString()


  /**
    * 1.3 递归函数
    * println(fac(3))
    */

  def fac(n:Int):Int = if (n <= 1) 1 else n*fac(n:Int)

  /**
    * 1.4 函数默认参数
    * println("combine result ===="+combine("I love you"))
    */

  def combine(content:String,left:String="[",right:String="]"):String=left+content+right;



  /**
    * 1.5 传递多参数
    *
    *  注意返回值
    *  scala 中没有i++ 和i--
    */


  def connected(args : Int*) = {
    var result = 0;
    for(arg <-args){
      result +=arg;
    }
    result;
  }




  /**
    * 2 控制程序流程
    * 2.1 if else
    */

  def min(x:Int ,y:Int):Int={
    if(x<y){
      return x;
    }
    return y;
  }


  /**
    *
    * 2.2
    * while循环
    *
    */
  def While()={
    var x = 100
    var y = 298
    while (x != 0) {
      val temp = x
      x = y % x
      y = temp
    }
  }







  def main(args: Array[String]): Unit = {

  }

}
