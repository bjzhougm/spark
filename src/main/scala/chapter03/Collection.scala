package chapter03

object Collection {

  /**
    * Scala教程(三)数组、元组、列表
    * 1 集合操作
    * 1.1 Tuple
    * Tuple(元组)结合多个固定元素数量在一起，
    * 使它们可以被传来传去作为一个整体。
    * 不像一个数组或列表，
    * 元组可以容纳不同类型的对象。
    * 元组的访问元素的索引是从1开始，
    * 而且是不可改变的。
    */

  def tuple(): Unit = {
    //元组声明
    val triple =(100,"Scala","Spark","JAVA","Hadoop");
    println(triple._1);
    println(triple._2);
    println(triple._3);
    println(triple._4)
    println(triple._5)
  }

  def main(args: Array[String]): Unit = {
    tuple()
  }

}
