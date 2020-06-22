import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.MyMvcConfig;
import com.example.service.DemoService;

//测试用例
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyMvcConfig.class})
@WebAppConfiguration("src/main/resources") //1.声明加载的ApplicationContext是一个WebApplicationContext，指定文本资源的位置在src/main/resources目录
public class TestControllerIntegrationTests {
    //2.MockMvc模拟mvc对象
    private MockMvc mockMvc;

    //3.测试中注入的Bean
    @Autowired
    private DemoService demoService;

    //4.注入WebApplicationContext
    @Autowired
    WebApplicationContext wac;

    //5.注入模拟的http session
    @Autowired
    MockHttpSession session;

    //6.注入模拟的http request
    @Autowired
    MockHttpServletRequest request;

    @Before //7.@Before测试开始前进行的初始化工作
    public void setup() {
        mockMvc =
                MockMvcBuilders.webAppContextSetup(this.wac).build(); //2
    }

    @Test
    public void testNormalController() throws Exception{
        //8.模拟向/normal进行get请求
        mockMvc.perform(get("/normal"))
                //9.预期控制返回状态为200
                .andExpect(status().isOk())
                //10.预期view名称为page
                .andExpect(view().name("page"))
                //11.预期页面转向真正的路径为/WEB-INF/classes/views/page.jsp
                .andExpect(forwardedUrl("/WEB-INF/classes/views/page.jsp"))
                //12.预期model里的值为demoservice.saySomething()返回值hello
                .andExpect(model().attribute("msg", demoService.saySomething()));

    }

    @Test
    public void testRestController() throws Exception{
        //13.模拟向/testRest进行get请求
        mockMvc.perform(get("/testRest"))
                .andExpect(status().isOk())
                //14.预期返回值的类型为text/plain;charset=UTF-8
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                //15.预期返回值的内容为demoservice.saySomething()返回值hello
                .andExpect(content().string(demoService.saySomething()));
    }

}
