package sparkSql;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;


public class SparkSession2 {
   public static void main(String[] args) {
        /* SparkSession spark = SparkSession.builder().appName("Spark2").master("local[2]").getOrCreate();
        JavaRDD<String> input = spark.sparkContext().textFile("/data/json/part-r-00000.txt",
                1).toJavaRDD().map(x -> x.split("____")[1]);
        JavaRDD<Book> books = input.map(new Function<String, Book>() {
            public Book call(String s) throws Exception {
                JSONObject jsons = new JSONObject(s);
                Book book = new Book();

                book.setBookid(jsons.get("bookId").toString());
                book.setConyent(jsons.get("content").toString());
                book.setContentStartPos(jsons.get("contentStartPos").toString());
                book.setCoord(jsons.get("coord").toString());
                book.setId(jsons.get("id").toString());
                book.setLineColor(jsons.get("lineColor").toString());
                book.setLineType(jsons.get("lineType").toString());
                book.setLineWidth(jsons.get("lineWidth").toString());
                book.setNoteCatalog(jsons.get("noteCatalog").toString());
                book.setNoteLabels(jsons.get("noteLabels").toString());
                book.setNoteOrigin(jsons.get("noteOrigin").toString());
                book.setNotePath(jsons.get("notePath").toString());
                book.setNotePostil(jsons.get("notePostil").toString());
                book.setNoteType(jsons.get("noteType").toString());
                book.setPageAngle(jsons.get("pageAngle").toString());
                book.setPageHeight(jsons.get("pageHeight").toString());
                book.setPageIndex(jsons.get("pageIndex").toString());
                book.setPageWidth(jsons.get("pageWidth").toString());
                book.setPdfId(jsons.get("pdfId").toString());
                book.setUpdateTime(jsons.get("updateTime").toString());
                book.setUserName(jsons.get("userName").toString());
                book.setSourceType(jsons.get("sourceType").toString());

                return book;
            }
        });

        Dataset<Row> bookdf = spark.createDataFrame(books,Book.class);
        bookdf.createOrReplaceTempView("book");
        bookdf.show();
        Dataset<Row> bIddf = spark.sql("select bookid from book");
        bIddf.show();
        spark.close();*/
    }
}