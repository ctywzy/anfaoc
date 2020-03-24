import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wzy.graduate.project.anfaoc.service.AnfaocServiceStarterApp;
import wzy.graduate.project.anfaoc.service.AnfaocServiceStarterAutoConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AnfaocServiceStarterApp.class)
@Import(AnfaocServiceStarterAutoConfig.class)
@ComponentScan({"wzy.graduate.project.anfaoc.service*"})
public abstract class TestRunningConfig {

}
