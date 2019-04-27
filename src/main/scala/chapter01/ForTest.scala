package chapter01

/**
  * Created by IntelliJ IDEA.
  * User: zhougm
  * Date: 2019-04-20
  * Time: 18:48
  */
object ForTest {


  def main(args: Array[String]): Unit = {
    doubleForX()
  }


  /**
    * for循环是开界的，它的一般形式为： for(; <条件表达式>; )语句；
    * 初始化总是一个赋值语句,它用来给循环控制变量赋初值；
    * 条件表达式是一个关系表达式,它决定什么时候退出循环：
    * 先外层循环取值,开始内层循环,循环完之后外层再取第二个值
    */
  def forX(): Unit ={
    for(x<-1 to 10)
      println("num is  "+x)
  }


  def doubleForX(){
    for(i<- 1 to 2;j<-1 to 2){
      print((i*100+j)+" ");
    }
  }

  // for循环嵌套;加条件
  def conditionForX(){
    for(i<- 1 to 2;j<- 1 to 2;if(i!=j)){
      print((i*100+j)+" ");
    }
  }

}
