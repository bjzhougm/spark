package com.jd

import org.apache.spark.sql.SparkSession

/**
  * jianshu.com/p/d7552ea4f882
  */
object CombineByKey {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder.appName("CombineByKey").master("local").getOrCreate()
    val inputRdd = spark.sparkContext.parallelize(Seq(("maths", 50), ("maths", 60), ("english", 65), ("physics", 66), ("physics", 61), ("physics", 87)), 3)

    val reduced = inputRdd.combineByKey(
      (mark) => {
        println(s"Create combiner -> ${mark}")
        (mark, 1)
      },
      (acc: (Int, Int), v) => {
        println(s"""Merge value : (${acc._1} + ${v}, ${acc._2} + 1)""")
        (acc._1 + v, acc._2 + 1)
      },
      (acc1: (Int, Int), acc2: (Int, Int)) => {
        println(s"""Merge Combiner : (${acc1._1} + ${acc2._1}, ${acc1._2} + ${acc2._2})""")
        (acc1._1 + acc2._1, acc1._2 + acc2._2)
      }
    )
    reduced.collect().foreach(println)
  }
}
