package com.jd

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

object GroupByCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("GroupByCount").setMaster("local")
    Logger.getLogger("org.apache.spark").setLevel(Level.OFF)
    Logger.getLogger("org.apache.hadoop").setLevel(Level.OFF)
    val sc = new SparkContext(conf)
    val lines = sc.textFile("/Users/zhouguimin/IdeaProjects/spark/src/main/resources/people.txt")
    //拼接成（1_25,1）的形式
    val newKeyValue =  lines.map(_.split(",")).map(pvdata => ((pvdata(0)+ "_" + pvdata(1)),1))
    //对上述KV进行统计
    val pvcount = newKeyValue.reduceByKey(_ + _)
    //将拼接符号去掉，组合成形如(Justin,25,1)的形式
    val pvid_age_count = pvcount.map(newkv => (newkv._1.split("_")(0),newkv._1.split("_")(1),newkv._2))
    //结果输出
    // (Andy,25,1)
    // (Michael,25,2)
    // (Justin,32,1)
    pvid_age_count.collect().foreach(println)
  }
}
