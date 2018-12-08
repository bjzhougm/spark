package sparkSql

import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql._
import org.apache.spark.{SparkConf, SparkContext}

object RDD2DataFrameBySchema {

  def main(args: Array[String]): Unit = {

    /**
      * 创建SparkConf对象
      * 设置AppName
      * 设置主机为local
      * AppName的名字在程序监控页面可以看到
      * local为本地测试用
      */
    val conf = new SparkConf().setAppName("Spark App Rdd2DataFrame").setMaster("local");

    val sc = new SparkContext(conf);

    val sqlContext= new SQLContext(sc);

    val lineRDD = sc.textFile("/Users/zhouguimin/IdeaProjects/spark/spark-warehouse/person.txt");

    /**
      * 如果schema中制定了除String以外别的类型
      * 在构建rowRDD的时候要注意指定类型
      * 例如:Integer.valueOf(split(2))
      */

    val rowRDD = lineRDD.map { x => {
      val split = x.split(",")
      RowFactory.create(split(0),split(1),Integer.valueOf(split(2)))
    } }


    val schema = StructType(List(
      StructField("id",StringType,true),
      StructField("name",StringType,true),
      StructField("age",IntegerType,true)
    ))

    /**
      * 把schema和row结合
      */
    val df = sqlContext.createDataFrame(rowRDD, schema);

    df.show()

    df.printSchema()

    df.select(df.col("name"),df.col("age")).where(df.col("age").gt(19)).show()

    sc.stop()
  }
}
