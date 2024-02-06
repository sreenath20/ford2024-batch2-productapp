import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DemoTest {
    @BeforeAll
    public void beforeAll(){ // allocated resources for testing
        // initialize test data for all test cases
        System.out.println("**before all test cases**");
    }

    @AfterAll
    public void afterAll(){ // de allocation of resources
        // close test data for all test cases
        System.out.println("**After all test cases**");
    }

    @BeforeEach // to customise data for each test
    public void beforeEach(){
        System.out.println("*Before each*");
    }
    @BeforeEach // to de allocate test data for each test
    public void afterEach(){
        System.out.println("*After each*");
    }

    @Timeout(value = 2, unit = TimeUnit.NANOSECONDS)
    @Test
    @Order(1)
    @DisplayName("Some meaning full name for test case %**^%# :)")
    public void someNameTest2(){
        System.out.println("Test 2");
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6);
        for (Integer i : integerList)System.out.println(i);
    }

    @Test
    @Disabled
    @Order(3)
    public void test1Sample(){
        System.out.println("Test 1");
    }
    @Test
    @Order(2)
    public void test3Should(){
        System.out.println("Test 3");
    }


    @ParameterizedTest
    @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
    void palindromes(String candidate) {
        System.out.println("Candidate :"+candidate);
    }

    @ParameterizedTest
    @CsvSource({
            "apple,         1",
            "banana,        2",
            "'lemon, lime', 0xF1",
            "strawberry,    7000"
    })
    void testWithCsvSource(String fruit, String rank) {
        System.out.println(fruit + ": :"+rank);
    }
    @RepeatedTest(value = 5, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Repeat!")
    void customDisplayName(TestInfo testInfo) {
        System.out.println("Repeat!: " +testInfo.getDisplayName());
    }
}
