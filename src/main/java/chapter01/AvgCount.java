package chapter01;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AvgCount {

    @Setter
    @Getter
    public Integer total;

    @Setter
    @Getter
    public Integer num;

    public AvgCount(Integer x,Integer y){

    }

    public String avg(){
        return "";
    }
}

