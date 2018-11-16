import com.kiritor.mapper.UserMapper2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTest {

    @SuppressWarnings("all")
    @Autowired
    UserMapper2 userMapper2;

    @Test
    public void test_db() {

        //开始进行测试
        assertThat(userMapper2.list().size()).isGreaterThan(1);



    }

}
