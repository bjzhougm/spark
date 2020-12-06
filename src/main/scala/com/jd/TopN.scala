package com.jd

import org.apache.spark.sql.Row
import org.apache.spark.{SparkConf, SparkContext}

object TopN {

  def main(args: Array[String]): Unit = {

    val sc = new SparkContext(new SparkConf().setAppName("TopN").setMaster("local[2]"));

    val rddText = sc.textFile("/Users/zhouguimin/IdeaProjects/spark/src/main/resources/TopN.txt",1);

    //val rowrdd = rddtext.map(m => Row(m.split(" ")(0), m.split(" ")(1), m.split(" ")(2).toInt))

    val classRdd = rddText.map(
      x => {
        val classname = x.split(",")(0)
        val name = x.split(",")(1)
        val grade = x.split(",")(2).toInt
        (classname,(name, grade))
      }).groupByKey
    //根据key聚合分组得到
    classRdd.foreach(x => println("============================="+x))
    classRdd.map(m => {
      val classname = m._1
      val top3 = m._2.toArray.sortWith(_._2 > _._2).take(3)
      (classname, top3)
    }).foreach(m => {println(m._1 + "班级的前3名的成绩为");m._2.foreach(x => println(x))})
  }
}
