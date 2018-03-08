import java.math.BigDecimal;
import java.math.RoundingMode;

public class RealWaybill {
    public static final double EARTH_RADIUS = 6378137;




    /**
     * 计算直线距离
     *
     * @param fromLat
     * @param fromLng
     * @param toLat
     * @param toLng
     * @return
     */
    public static double getDistance(double fromLng,double fromLat, double toLng,  double toLat) {
        double result;
        fromLat = fromLat * Math.PI / 180.0;
        toLat = toLat * Math.PI / 180.0;
        double a = fromLat - toLat;
        double b = (fromLng - toLng) * Math.PI / 180.0;
        double sa2, sb2;
        sa2 = Math.sin(a / 2.0);
        sb2 = Math.sin(b / 2.0);
        result = 2 * EARTH_RADIUS * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(fromLat) * Math.cos(toLat) * sb2 * sb2));
        BigDecimal decimal = new BigDecimal(result);
        return decimal.setScale(4, RoundingMode.HALF_UP).doubleValue();
    }
}
