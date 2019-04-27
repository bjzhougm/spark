package com.jd

import org.apache.spark.{SparkConf, SparkContext}

object helloSpark {

  def main(args: Array[String]): Unit = {
    //设置本机Spark配置
    val conf = new SparkConf().setAppName("wordCount").setMaster("local")
    //创建Spark上下
    val sc = new SparkContext(conf)
    //从文件中获取数据
    val input = sc.textFile("/Users/zhouguimin/IdeaProjects/spark/src/main/resources/person.txt",1)
    //分析并排序输出统计结果
    input.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey((x, y) => x + y).sortBy(_._2,false).foreach(println _)
  }

}
