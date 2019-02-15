import com.phone.etl.Utils.IpParsingUtil;

/**
 * @description 用于测试Ip解析(纯真数据库和淘宝ip解析)
 * @author: 赵燕钦
 * @create: 2018-11-28 20:32:33
 **/
public class IpTest {
    public static void main(String[] args) {
        //测试纯真数据库的解析ip逻辑是否正确
//        System.out.println(IpParsingUtil.ipParser("192.168.91.7"));
        //测试淘宝ip解析网站逻辑是否正确
        System.out.println(IpParsingUtil.ipParser2("http://ip.taobao.com/service/getIpInfo.php?ip=123.234.45.43",
                "utf-8"));
    }
}
