package chapter01

import scala.io.Source

/**
  * Created by IntelliJ IDEA.
  * User: zhougm
  * Date: 2019-04-20
  * Time: 17:58
  */
object LazyTest {

  def main(args: Array[String]): Unit = {

    readFile()

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

  def readFile()= {
    lazy val file = Source.fromFile("/Users/zhouguimin/IdeaProjects/spark/src/main/resources/people.txt");
    println("===========scala=======")
    for (line <- file.getLines()) {
      println(line)
    }
  }
}
