package sparkcore

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by IntelliJ IDEA.
  * User: zhougm
  * Date: 2019-04-10
  * Time: 08:43
  */
object LocalFile {

  def main(args: Array[String]): Unit = {

    val conf =new SparkConf().setAppName("LocalFile").setMaster("local[2]");

    val sc = new SparkContext(conf);

    val lines = sc.textFile("/Users/zhouguimin/IdeaProjects/spark/src/main/resources/word.txt",1);

    val words = lines.flatMap(line => line.split(" "))

    val pairs = words.map(word => (word,1))

    val wordCounts = pairs.reduceByKey(_ + _)

    wordCounts.foreach(wordCount=>println(wordCount._1+"  appears "+wordCount._2))

  }

}
