package sparkSql

import org.apache.spark.sql.SparkSession

object DataFrameApp {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("DataFrameApp").master("local[2]").getOrCreate();

    //将json文件加载到dataFrame
    val peopleDF =spark.read.format("json").load("/Users/zhouguimin/IdeaProjects/spark/src/main/resources/people.json");

    peopleDF.printSchema();

    //默认输出20条
    peopleDF.show();


    //select name from table
    peopleDF.select("name").show();


    //select name,age+10 as age2 from table
    peopleDF.select(peopleDF.col("name"),(peopleDF.col("age")+10).as("age2")).show()


    //过滤age>19
    peopleDF.filter(peopleDF.col("age")>19).show();


    //select age,count(*) from table
    peopleDF.groupBy(peopleDF.col("age")).count().show();

    spark.stop();

  }

}
