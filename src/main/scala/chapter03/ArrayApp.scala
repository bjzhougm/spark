package chapter03

import scala.collection.mutable.ArrayBuffer

object ArrayApp {

  def main(args: Array[String]): Unit = {
    /**
      * 1.1 定义数组
      *
      * 所谓数组，就是相同数据类型的元素按一定顺序排列的集合，
      * 就是把有限个类型相同的变量用一个名字命名，
      * 然后用编号区分他们的变量的集合，
      * 这个名字称为数组名，编号称为下标。
      */


    // 声明Int类型、String类型数组
    val number = new Array[Int](10);

    //> number  : Array[Int] = Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

    val stringArray = new Array[String](10);
    //> stringArray  : Array[String] = Array(null, null, null, null, null, null,null, null, null, null)


    // 声明并赋值

    val strArray = Array("Hello","World");
    //> strArray  : Array[String] = Array(Hello, world)

    //重新指定值
    strArray(0)="one";

    //打印 strArray

    for(i<- 0 until(strArray.length)){
      println(i +" strArray value ====:" +strArray(i))
    }

    //> res0: Array[String] = Array(One, world)

    //for循环便利元素
    for(i<- 0 until(stringArray.length)){
      println(i +":" +stringArray(i))
    }

    /**
      * 2 动态数组ArrayBuffer
      */

    //2.1 定义动态数组
    var buffer = new ArrayBuffer[Int]();

    //> buffer  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
    // 2.2用+=在尾端添加元素

    buffer+=1;
    //> res1: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1)

    //2.3末端追加多个元素
    buffer+=(1,2,3,4,5);
    //> res2: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 1, 2, 3, 5)

    //2.4 末端追加集合
    buffer ++=Array(4,6,7,8)
    //res3: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 1, 2, 3, 5,8, 13, 21)

    //2.5 添加元素

    //在第2个元素后添加元素6
    buffer.insert(2,6)


    //for循环便利元素
    for(i<- 0 until(buffer.length)){
      println(i +"   buffer value ===:" +buffer(i))
    }

    // 在第2个元素后添加多个元素
    buffer.insert(2, 7,8,9)

    //> res6: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 1, 7, 8, 9, 6, 2)


    /**
      * 2.6 删除元素
      */


    // 删除位置是第2个元素
    buffer.remove(2)
    //> res7: Int = 7

    //> res8: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 1, 8,9, 6,2)

    // 从第3个元素开始移除3个元素
    buffer.remove(2, 3)
    //> res9: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 1, 2)

    /**
      * 2.7 将动态数据转为数组
      */
    // 将数组缓冲转换为Array
    buffer.toArray
    buffer.foreach(println)
    //> res10: Array[Int] = Array(1, 1, 2)

    /**
      * 3 yield关键字及排序
      *
      *
      * 3.1 yield关键字
      * yield关键字 for循环中的 yield会把当前的元素记下来，保存在集合中，循环结束后将返回该集合。
      * Scala中 for循环是有返回值的。如果被循环的是 Map，
      * 返回的就是  Map，被循环的是 List，返回的就是 List，以此类推。
      *
      */


    // 声明元素
    val nums = Array(2,3,5,7,11)
    //> nums  : Array[Int] = Array(2, 3, 5, 7, 11)
    // nums中的元素都*2，并返回新的集合
    var result = for(elem <-nums) yield 2 * elem
    //> result  : Array[Int] = Array(4, 6, 10, 14, 22)

    // 生成nums集合中值对2取余为0的数，乘2，返回新的集合
    for(elem <-nums if elem %2  == 0) yield elem *2
    //> res11: Array[Int] = Array(4)
    nums.filter(_ % 2 == 0).map { 2*_}
    //> res12: Array[Int] = Array(4)

  }

}
