import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RealWaybillTest {
    double distance;
    @Test
    public void getDistanceTest(){
        //104.657623,30.58501
       distance =  RealWaybill.getDistance(104.06774,30.54005, 88.876578,29.264941  );
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
