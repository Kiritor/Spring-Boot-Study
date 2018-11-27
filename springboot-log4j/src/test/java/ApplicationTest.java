import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationTest.class)
public class ApplicationTest {
    private Logger logger = LogManager.getLogger(getClass());

    @Test
    public void test() throws Exception {
        logger.info("输出info");
        logger.debug("输出debug");
        logger.error("输出error");
    }

}
