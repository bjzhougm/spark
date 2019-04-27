package chapter01

import java.io.{BufferedReader, InputStreamReader}

/**
  * Created by IntelliJ IDEA.
  * User: zhougm
  * Date: 2019-04-20
  * Time: 18:27
  */
object DoWhileTest {

  def main(args: Array[String]): Unit = {
    doWhile()
  }


  /**
    * 与while循环所不同的是，它先执行一次循环语句，然后再去判断
    */
  def doWhile(): Unit ={
    var line = "";
    do {
      println("doWhile:请输入信息，退出程序请输入：\"\" ");
      val br = new BufferedReader(new InputStreamReader(System.in))
      line = br.readLine()
      println("输入的内容:" + line);
      br.close()
    } while(line != "");
  }
}
