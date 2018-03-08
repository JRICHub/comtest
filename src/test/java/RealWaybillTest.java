import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RealWaybillTest {
    double distance;
    @Test
    public void getDistanceTest(){
        //104.657623,30.58501
       distance =  RealWaybill.getDistance(120.371262,36.076049, 119.918534,36.302146  );
       System.out.println(distance);
    }

    @BeforeTest
    public void beforeTest() throws Exception {
        System.out.println("BeforeTest+");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest+");
    }
}
