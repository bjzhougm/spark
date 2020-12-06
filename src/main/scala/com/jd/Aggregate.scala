package com.jd

import org.apache.spark.sql.SparkSession

/**
  * https://www.cnblogs.com/Gxiaobai/p/11437739.html
  */
object Aggregate {

  def main(args: Array[String]): Unit = {

    val sparkSession = SparkSession.builder().master("local").appName("Aggregate").getOrCreate();

    val rdd1 = sparkSession.sparkContext.parallelize(Seq(("a", 2), ("a", 5), ("a", 4), ("b", 5), ("c", 3), ("b", 3), ("c", 6), ("a", 8)), 4)

    val r1 = rdd1.aggregate((0))(
      (u, c) => (u + c._2),
      (r1, r2) => (r1 + r2)
    )
    println(r1)

    sparkSession.close()
  }
}
