package study.ian.mathutils;

import android.graphics.PointF;

public class MathUtils {

    /*
        get center point of the two points
    */
    public static PointF getCenterPoint(PointF p0, PointF p1) {
        PointF p = new PointF();

        p.x = (p0.x + p1.x) / 2;
        p.y = (p0.y + p1.y) / 2;
        return p;
    }

    /*
        get cross point with four points, first pair is firstLineP0 and firstLineP1,
        second pair is secondLineP0 and secondLineP1
     */
    public static PointF getCrossPoint(PointF firstLineP0, PointF firstLineP1,
                                       PointF secondLineP0, PointF secondLineP1) {
        PointF p = new PointF();

        // calculate slope
        float m0 = (firstLineP1.y - firstLineP0.y) / (firstLineP1.x - firstLineP0.x);
        float m1 = (secondLineP1.y - secondLineP0.y) / (secondLineP1.x - secondLineP0.x);

        // calculate constant
        float c0 = firstLineP0.y - m0 * firstLineP0.x;
        float c1 = secondLineP0.y - m1 * secondLineP0.x;

        p.x = (c0 - c1) / (m1 - m0);
        p.y = m1 * p.x + c1;
        return p;
    }

    /*
        get cross point with line(firstLineP0, firstLineP1)
        and one slope(secondSlope) for secondLineP0
     */
    public static PointF getCrossPoint(PointF firstLineP0, PointF firstLineP1,
                                       PointF secondLineP0, float secondSlope) {
        PointF p = new PointF();

        // calculate slope
        float m0 = (firstLineP1.y - firstLineP0.y) / (firstLineP1.x - firstLineP0.x);

        // calculate constant
        float c0 = firstLineP0.y - m0 * firstLineP0.x;
        float c1 = secondLineP0.y - secondSlope * secondLineP0.x;

        p.x = (c0 - c1) / (secondSlope - m0);
        p.y = secondSlope * p.x + c1;
        return p;
    }

    /*
        get cross point with three points,
        the slope for secondLineP0 is perpendicular to line form by firstLineP0 and firstLineP1
    */
    public static PointF getCrossPoint(PointF firstLineP0, PointF firstLineP1, PointF secondLineP0) {
        // calculate slope
        float m0 = (firstLineP1.y - firstLineP0.y) / (firstLineP1.x - firstLineP0.x);
        float m1 = -1 / m0;
        return getCrossPoint(firstLineP0, firstLineP1, secondLineP0, m1);
    }
}
