import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        String ss="201810";
        System.out.println(getDateFormat(ss));
    }

    public static String getDateFormat(String data){
        StringBuilder sb=new StringBuilder();
        if(data.length()==6){
            sb.append(data.substring(0,4));
            sb.append('-');
            sb.append(data.substring(4,6));
            sb.append("-01 00:00:00");
        }
        return sb.toString();
    }

    /*public static  String getDateFormat(String data){
        Long longData =Long.parseLong(data);
        Date date = new Date(longData);
        System.out.println(date);
        DateFormat dateFormat = DateFormat.getDateTimeInstance();
        return dateFormat.format(date);
    }*/
}
