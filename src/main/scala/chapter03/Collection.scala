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


  /**
    * Array(数组)，一种数据结，
    * 其中存储相同类型的元素的固定大小的连续集合。
    * 数组用于存储数据的集合，
    * 但它往往是更加有用认为数组作为相同类型的变量的集合。
    */
  def array():Unit ={
    val array =Array(2,4,6,8,10);
    for (i <- 0 until(array.length)){
      print(array(i));
    }

    for(element<-array) {
      println(element)
    }
  }

  /**
    * Map是键/值对的集合。
    * 任何值可以根据它的键进行检索。
    * 键是在映射唯一的，
    * 但值不是唯一的。
    * 映射也被称为哈希表。
    */
  def map():Unit={
      val books =Map("java"->"《Java编程思想》、《JavaWeb技术内幕》","JavaScript"->"《JavaScript权威指南》","Oracle"->"《从入门到精通》")
      for ((key,value)<-books){
        println("类型:"+key+"====>书名"+value);
      }

      for ((key,_)<-books){
        println("类型:=====>"+key)
      }
  }

  def main(args: Array[String]): Unit = {
    //tuple()
    //array()
    map();
  }



}
