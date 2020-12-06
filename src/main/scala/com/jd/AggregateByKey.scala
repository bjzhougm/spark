package com.jd

import org.apache.spark.{SparkConf, SparkContext}

/**
  * https://blog.csdn.net/sunhaiting666/article/details/105809539
  * https://blog.csdn.net/qq_35440040/article/details/82691794
  */
object AggregateByKey {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("aggregateByKey")
    val sc = new SparkContext(conf)
    val list = List((1, 2), (2, 7), (1, 3),(1,1), (2, 8), (3, 9), (3, 10), (1, 4), (1, 5), (2, 6), (2, 11), (3, 12), (3, 13))
    val listRDD = sc.parallelize(list, 2)
    println(listRDD.getNumPartitions)

    val rs = listRDD.aggregateByKey(0)((a, b) => {
      println("diyige" + a + "," + b)
      math.max(a, b)
    }, (x, y) => {
      println("dierge" + x + "," + y)
      x + y
    }).collect().foreach(println)
  }
}

