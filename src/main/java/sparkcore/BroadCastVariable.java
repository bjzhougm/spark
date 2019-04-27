package sparkcore;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.VoidFunction;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhougm
 * Date: 2019-04-21
 * Time: 09:57
 */
public class BroadCastVariable {

    public static void main(String[] args) {

        SparkConf conf = new SparkConf().setAppName("BroadCast").setMaster("local[2]");

        JavaSparkContext sc = new JavaSparkContext(conf);

        final int factor = 3;

        List<Integer> numberList  = Arrays.asList(1,2,3,4,5);

        JavaRDD<Integer> numbers = sc.parallelize(numberList);

        JavaRDD multipleNumbers = numbers.map(new Function<Integer, Integer>() {
            @Override
            public Integer call(Integer v1) throws Exception {
                return v1 * factor;
            }
        });

        multipleNumbers.foreach(new VoidFunction<Integer>() {
            @Override
            public void call(Integer t) throws Exception {
                System.out.println(t);
            }
        });

        sc.close();

    }
}
