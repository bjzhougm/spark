package chapter02

import scala.io.{Source, StdIn}


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
    */

  //函数进行运算后进行返回
  def addA(x:Int):Int= x + 200;

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
    *
    */

  def fac(n:Int):Int = if (n <= 1) 1 else n*fac(n:Int)

  //println(fac(3));


  /**
    * 1.4 函数默认参数
    */

  def combine(content:String,left:String="[",right:String="]"):String=left+content+right;
  //println("combine result ===="+combine("I love you"))


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
    * 1.6 lazy关键字
    *
    * 使用lazy修饰一个val成员时，
    * 其赋值情况是在需要时才赋值的(by need)
    * 因为Scala中成员与方法是等价的(除了private[this]成员)
    *
    * private定义的变量是可以在另外一个对象中通过该类的对象所访问到，
    * 而private[this]仅仅可以被同一个类的同一个对象访问，
    * private 在某种程度上破坏了面向对象的封装性，
    * private[this]仅仅可以被this访问到，这样才符合面向对象的编程
    *
    */

  def readFile()={
    lazy val file=Source.fromFile("/Users/zhouguimin/IdeaProjects/spark/spark-warehouse/person.txt");
    println("===========scala=======")
    for (line <- file.getLines()){
      println(line)
    }


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
    while ( {
      x != 0
    }) {
      val temp = x
      x = y % x
      y = temp
    }
  }

  /**
    * 与while循环所不同的是，它先执行一次循环语句，然后再去判断
    */
  def doWhile(): Unit ={
    var line = "";
    do {
      println("doWhile：请输入信息，退出程序请输入：\"\"");
      line = ""// StdIn();
      println("输入的内容：" + line);
    } while(line != "");
  }


  /**
    * for循环是开界的，它的一般形式为： for(; <条件表达式>; )语句；
    * 初始化总是一个赋值语句,它用来给循环控制变量赋初值；
    * 条件表达式是一个关系表达式,它决定什么时候退出循环：
    */
  def forX(): Unit ={
    for(x<-1 to 10)
      println("num is  "+x)
  }


  def doubleForX(){
    for(i<- 1.to(2);j<-1.to(2)){
      print((i*100+j)+" ");
    }
  }

  // for循环嵌套;加条件
  def doubleforx(){
    for(i<- 1.to(2);j<-1.to(2);if(i!=j)){
      print((i*100+j)+" ");
    }
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
      var arr = Array(1,2)
      arr(10)
    }catch{
      case e: ArithmeticException => println(e)
      case ex: Exception =>println(ex)
      case th: Throwable=>println("found a unknown exception"+th)
      case _ => println("Unknown exception")
    }
    finally{
      println("Finaly block always executes")
    }
    println("Rest of the code is executing...")
  }

  def main(args: Array[String]): Unit = {

    divide(100,0)

  }

}
