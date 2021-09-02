package com.yuqijun.localservice.util;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DbDataProviderUtil {


    private List<String> provider = new ArrayList<>();

    static {
        String [] provider =  {"彭万里","范长江","黄强辉","冯兴国","高尚德","赵进喜","王子久","张石山","吴家栋","王仁兴"};

        String [] crateUserId = {"10101011","10101012","10101013","10101014","10101015","10101016","10101017","10101018","10101019","10101020"};

        String [] storeId = {"10000001","10000002","10000003","10000004","10000005","10000006","10000007","10000008","10000009","10000010"};

        String [] updateUserId = {"10101011","10101012","10101013","10101014","10101015","10101016","10101017","10101018","10101019","10101020"};

        String [] goodDiscription = {"透出蒸熟后薄如纸的面皮,犹如翡翠一般","透出蒸熟后薄如纸的面皮,犹如翡翠一般","透出蒸熟后薄如纸的面皮,犹如翡翠一般","透出蒸熟后薄如纸的面皮,犹如翡翠一般","透出蒸熟后薄如纸的面皮,犹如翡翠一般","透出蒸熟后薄如纸的面皮,犹如翡翠一般","透出蒸熟后薄如纸的面皮,犹如翡翠一般",
        "透出蒸熟后薄如纸的面皮,犹如翡翠一般","透出蒸熟后薄如纸的面皮,犹如翡翠一般","透出蒸熟后薄如纸的面皮,犹如翡翠一般"
        };

        Double [] goodPrice = {23.12,34.10,34.80,87.00,40.00,29.00,77.00,99.00,89.00,10.00};

        int  [] seals  = {145,43,35,234,563,67,89,543,235,350};

        String [] goodsAvatar =  {"https://t12.baidu.com/it/u=69502277,2833229765&fm=58","https://t12.baidu.com/it/u=3019424894,3860768112&fm=58","https://t10.baidu.com/it/u=3671922858,1005056123&fm=58","https://t11.baidu.com/it/u=415661104,570125042&fm=58","https://t11.baidu.com/it/u=578376256,3974178006&fm=58","https://t12.baidu.com/it/u=4278664709,2294911957&fm=58","https://t12.baidu.com/it/u=2943898856,1069922359&fm=58","https://t10.baidu.com/it/u=1514460402,161593930&fm=58","https://t10.baidu.com/it/u=2850463044,3639636867&fm=58","https://t12.baidu.com/it/u=4185456401,584239421&fm=58","https://t10.baidu.com/it/u=926366145,2419061747&fm=58"};

        String [] remark =  {"香辣可口","香辣可口","香辣可口","香辣可口","香辣可口","香辣可口","香辣可口","香辣可口","香辣可口","香辣可口","香辣可口"};

    }

    /* 生成商品工具类 */

    public static void providerGoods(){
        String str = "INSERT INTO tb_goods VALUES ( "+  ""   +" )";
    }
}
