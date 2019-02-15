
import com.phone.etl.Utils.LogParserUtil;

import java.util.Map;

/**
 * @Description
 * @Author cqh <caoqingghai@1000phone.com>
 * @Version V1.0
 * @Since 1.0
 * @Date 2018/11/28 15：21
 */
public class LogTest {
    public static void main(String[] args) {
        String log = "61.159.151.121^A1541924731.008^A61.159.151.121^A/qf.png?en=e_pv&p_url=http%3A%2F%2Flocalhost%3A8080%2Fdemo.jsp&p_ref=http%3A%2F%2Flocalhost%3A8080%2Fdemo.jsp&tt=%E6%B5%8B%E8%AF%95%E9%A1%B5%E9%9D%A21&ver=1&pl=website&sdk=js&u_ud=07E02E08-21A2-48A5-9C03-3F234EAB0270&u_sd=3723795D-D53D-4117-B529-824E31B89E77&c_time=1535610846005&l=zh-CN&b_iev=Mozilla%2F5.0%20(Windows%20NT%206.1%3B%20WOW64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F58.0.3029.110%20Safari%2F537.36%20SE%202.X%20MetaSr%201.0&b_rst=1600*900";
        System.out.println(LogParserUtil.parserLog(log));
    }
}