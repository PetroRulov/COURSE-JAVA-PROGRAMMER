import domain.Data;
import interfaces.BLI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prulov on 25.04.2016.
 */
public class BL implements BLI {

    private List<Data> dataList;

    public BL() {

    }

    public void init(){

        dataList = new ArrayList<>();
        Data d = new Data();
        Data c = new Data();
        Data b = new Data();
        d.setData("URRRA!!!");
        c.setData("COMMON!!!");
        b.setData("BLA! BLA! BLA!");
        dataList.add(d);
        dataList.add(c);
        dataList.add(b);
    }

    @Override
    public List<Data> getData(){
        if(dataList == null){
            init();
        }
        return new ArrayList<>(dataList);
    }
}
