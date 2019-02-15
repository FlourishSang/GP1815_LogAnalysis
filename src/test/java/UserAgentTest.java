import com.phone.etl.Utils.UserAgentParserUtil;

/**
 * @Description
 * @Author cqh <caoqingghai@1000phone.com>
 * @Version V1.0
 * @Since 1.0
 * @Date 2018/11/28 14：22
 */
public class UserAgentTest {
    public static void main(String[] args) {
   UserAgentParserUtil.AgentInfo agentInfo = UserAgentParserUtil.parserUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
        System.out.println(agentInfo);
    }
}