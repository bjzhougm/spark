package sparkSql

import org.apache.spark.sql.types._
import org.apache.spark.sql._

object DataFrameRDDApp {

  def main(args: Array[String]): Unit = {
    val spark =SparkSession.builder().appName("DataFrameRDDApp").master("local[2]").getOrCreate();

    //inferReflection(spark)

    program(spark)

    spark.stop();
  }

  def program(spark: SparkSession)={

    //RDD=>DataFrame
    val rdd = spark.sparkContext.textFile("/Users/zhouguimin/IdeaProjects/spark/spark-warehouse/person.txt");

    val rowRDD = rdd.map(_.split(",")).map(p => Row(p(0).toInt, p(1), p(2).toInt));


    val schema = StructType(StructField("id", IntegerType, true) :: StructField("name", StringType, true) :: StructField("age", IntegerType, true) :: Nil)

    // Apply the schema to the RDD
    val personDF = spark.createDataFrame(rowRDD, schema);

    personDF.printSchema();

    personDF.show();
  }


   def inferReflection(spark: SparkSession) = {

     //RDD=>DataFrame
     val rdd = spark.sparkContext.textFile("/Users/zhouguimin/IdeaProjects/spark/spark-warehouse/person.txt");

     import spark.implicits._
     val infoDF = rdd.map(_.split(",")).map(p => Info(p(0).toInt, p(1), p(2).toInt)).toDF();

     infoDF.show();

     infoDF.filter(infoDF.col("age") > 18).show();

     infoDF.createOrReplaceTempView("infos");

     spark.sql("select * from infos where age >18").show();
  }

  case class Info(id:Int, name:String, age:Int)
}
