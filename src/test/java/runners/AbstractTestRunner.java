package runners;
import lombok.extern.slf4j.Slf4j;
import org.junit.AfterClass;
import org.junit.BeforeClass;

@Slf4j
public class AbstractTestRunner {

    @BeforeClass
    public static void setUp() {
        log.info("Set up");
    }

    @AfterClass
    public static void tearDown() {
        log.info("Tear down");
    }
}
