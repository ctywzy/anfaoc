import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wzy.graduate.project.anfaoc.service.AnfaocServiceStarterApp;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AnfaocServiceStarterApp.class)
public abstract class TestRunningConfig {

}
