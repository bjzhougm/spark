package sparkSql

import org.apache.spark.sql.SparkSession

object DataFrameCase {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("DataFrameCase").master("local[2]").getOrCreate()

    val personRDD=spark.sparkContext.textFile("/Users/zhouguimin/IdeaProjects/spark/src/main/resources/people.txt");

    //导入隐式转换
    import spark.implicits._
    val personDF=personRDD.map(_.split(",")).map(p=>people(p(0),p(1).toInt)).toDF()

    personDF.printSchema()

    personDF.show()

    //指定行数不省略
    personDF.show(30,false);

    //前2条
    personDF.take(2)

    //前2条
    personDF.head(2)

    //第一条
    personDF.first()

    //查询name
    personDF.select("name").show();

    //年龄大于19
    personDF.filter("age>19").show()

    //年龄大于19
    personDF.where("age>19").show()

    //查询name不为空
    personDF.filter("name ='' OR name =null").show()

    //截取字符串 name首字母为M
    personDF.filter("SUBSTRING(name,0,1)='M'").show()

    //按name升序
    personDF.sort(personDF.col("name")).show()

    //按name降序
    personDF.sort(personDF.col("name").desc).show()

    //按name和id排序
    personDF.sort("name","id")

    //按name升序，age降序
    personDF.sort(personDF.col("name").asc,personDF.col("age").desc).show()


    //创建第二个DF
    val personDF2=personRDD.map(_.split(",")).map(p=>people(p(0),p(1).toInt)).toDF()


    //内连接 按id 关联
    personDF.join(personDF2,personDF.col("id")===personDF2.col("id"),"inner").show()

    spark.stop()
  }

  case class people(name:String,age:Int)

}
