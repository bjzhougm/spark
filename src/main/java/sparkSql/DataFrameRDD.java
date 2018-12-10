package sparkSql;

import lombok.Data;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataFrameRDD {

    public static void main(String[] args) {

        //初始化一个Spark
        SparkSession spark = SparkSession.builder().appName("DataFrameRDD").master("local[2]").getOrCreate();
        //Reflection(spark);
        program(spark);
        spark.stop();
    }

    private static void program(SparkSession spark) {

        JavaRDD<String> peopleRDD = spark.sparkContext()
                .textFile("/Users/zhouguimin/IdeaProjects/spark/spark-warehouse/person.txt", 1)
                .toJavaRDD();


        // 定义schema
        String schemaString = "id name age";

        // 创建schema
        List<StructField> fields = new ArrayList<>();

        for (String fieldName : schemaString.split(" ")) {
            StructField field = DataTypes.createStructField(fieldName, DataTypes.StringType, true);
            fields.add(field);
        }

        StructType schema = DataTypes.createStructType(fields);

        // 转换成row
        JavaRDD<Row> rowRDD = peopleRDD.map((Function<String, Row>) record -> {
            String[] attributes = record.split(",");
            return RowFactory.create(attributes[0], attributes[1].trim(),attributes[2]);
        });

        // 为RDD加上schema
        Dataset<Row> peopleDataFrame = spark.createDataFrame(rowRDD, schema);

        // 为DataFrame创建临时视图
        peopleDataFrame.createOrReplaceTempView("people");

        // 用spark Sql 运行 **注意如果不注册临时视图是不能用sql的，用filter或where
        Dataset<Row> results = spark.sql("SELECT * FROM people");

        results.show();

    }


    private static void Reflection(SparkSession spark) {
        //从文本文件中创建一个person的RDD
        JavaRDD<Person> personRDD = spark.read()
                .textFile("/Users/zhouguimin/IdeaProjects/spark/spark-warehouse/person.txt")
                .javaRDD()
                .map(line->{
                    String[] parts =line.split(",");
                    Person person =new Person();
                    person.setId(Integer.parseInt(parts[0].trim()));
                    person.setName(parts[1]);
                    person.setAge(Integer.parseInt(parts[2].trim()));
                    return person;
                });


        // 将javaRDD转化为DataFrame
        Dataset<Row> peopleDF = spark.createDataFrame(personRDD, Person.class);

        // 注册dataFrame为临时视图
        peopleDF.createOrReplaceTempView("Person");

        // 以sparkSql方式执行
        Dataset<Row> teenagersDF = spark.sql("SELECT * FROM Person WHERE age BETWEEN 13 AND 25");

        teenagersDF.show();
    }


    @Data
    static class Person implements Serializable {

        private int id;

        private String name;

        private int age;
    }
}
