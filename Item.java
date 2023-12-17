import java.text.SimpleDateFormat;
import java.util.Date;

public class Item {
    private String name;
    private double score;
    private int checkInNumber; // 签到次数
    private String checkInTime; // 新增签到时间属性

    public Item(String name, double score) {
        this.name = name;
        this.score = score;
        this.checkInNumber = 0;
        this.checkInTime = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getCheckInTime() { // 新增获取签到时间方法
        return checkInTime;
    }

    public void checkIn() { // 新增签到方法
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = formatter.format(now);
        this.checkInTime = time;
        this.checkInNumber ++;
        System.out.println("Check-in successful. Check-in time: " + time);
    }

    @Override
    public String toString() {
        return "Sports{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", checkInNumber=" + checkInNumber +
                ", checkInTime='" + checkInTime + '\'' + // 输出签到时间
                '}';
    }
}
