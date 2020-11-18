package cmk.code.leecode;

/**
 *在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
 *
 * 至少有一个空座位，且至少有一人坐在座位上。
 *
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 *
 * 返回他到离他最近的人的最大距离。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximize-distance-to-closest-person
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code_894 {
    public static void main(String[] args) {
        int[] seats = new int[]{0,1,1,0,1,1,0,1};
        System.out.println(maxDistToClosest(seats));
    }

    public static int maxDistToClosest(int[] seats) {
        if (seats == null || seats.length < 2) {
            return -1;
        }
        int maxSeat = -1;
        int leftMaxSeat = -1;
        int rightMaxSeat = -1;

        // 获取左边界最大位置
        if (seats[0] == 0) {
            for (int i = 0; i < seats.length; i++) {
                leftMaxSeat ++ ;
                if (seats[i] == 1) {
                    break;
                }
            }
        }
        // 获取右边界最大位置
        if (seats[seats.length -1] == 0) {
            for (int i = seats.length -1; i >=0; i--) {
                rightMaxSeat ++ ;
                if (seats[i] == 1) {
                    break;
                }
            }
        }
        int midMaxSeat = -1;
        int seat1 = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                seat1 = i;
            } else {
                midMaxSeat = i - seat1;
                if (maxSeat == -1) {
                    maxSeat = midMaxSeat;
                } else {
                    maxSeat = Math.max(midMaxSeat, maxSeat);
                }
            }
        }
        System.out.println("leftMaxSeat=" + leftMaxSeat + "， rightMaxSeat=" + rightMaxSeat + "， maxSeat=" +maxSeat);
        return Math.max(Math.max(leftMaxSeat, rightMaxSeat), maxSeat/2 + maxSeat%2);
    }


}
