import com.example.ch3.fortest.TestBean;
import com.example.ch3.fortest.TestConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //1.在junit环境下提供 Spring TestContext Framework功能
@ContextConfiguration(classes={TestConfig.class}) //2.@ContextConfiguration用来加载配置ApplicationContext,classes属性用来加载配置类
@ActiveProfiles("prod")//3.ActiveProfiles用来声明活动的Profiles
public class DemoBeanIntegrationTests {

    @Autowired //4.Autowired注入Bean
    private TestBean testBean;

    @Test //5.测试代码
    public void prodBeanShouleInject(){
        String eexpected = "from production profile";
        String actual = testBean.getContent();
        Assert.assertEquals(eexpected,actual); //校验结果是否与预期的一致
        //System.out.println(eexpected+","+actual);
    }
}
