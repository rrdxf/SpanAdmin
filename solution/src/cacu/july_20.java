package cacu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class july_20 {
    public static void main(String[] args) {
        List<String> pathList = Arrays.asList(
                "/etc/hosts",
                "/etc/kubernetes/ssl/certs",
                "/root"
        );
        Map<String , Map> mapTree = pathListToMap(pathList);
    }

    private static Map<String, Map> pathListToMap(List<String> pathList) {
        Map<String,Map> res = new HashMap<>();
        Map<String,Map> flag = null;
        for(String ss : pathList){
            String sss [] = ss.split("/");
            res.put(ss,fun(0,sss,res));
        }

        return null;
    }

    private static Map fun(int i, String[] sss, Map<String, Map> res) {
        if (i == sss.length){
            return new HashMap();
        }
        Map<String,Map> map = res.get(sss[i]);
        if (map == null){
            map = new HashMap<>();

        }
        res.put(sss[i],map);
        return null;
    }


}
