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



  def main(args: Array[String]): Unit = {

    println(connected(1,2,3,4,5));

  }

}
