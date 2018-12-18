package sparkStream

import org.apache.spark._
import org.apache.spark.streaming._

/**
  * 先在terminal中nc -lk 9999
  * 再启动
  * 之后输入
  */

object SparkStreamTest {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount")
    val ssc = new StreamingContext(conf, Seconds(10))

    val lines = ssc.socketTextStream("127.0.0.1", 9999)

    println("===========Project   Start=================")

    lines.foreachRDD(rdd=>{
      println("===========RDD   Start=================")
      rdd.foreach(x=>println(x))
      println("===========RDD   End=================")
    })
    println("===========Project   End=================")

    ssc.start()

    ssc.awaitTermination()
  }
}