import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Item {
    private String name;
    private double score;
    private int checkInNumber; // 签到次数
    private String checkInTime; // 新增签到时间

    public Item(String name, double score) {
        this.name = name;
        this.score = score;
        this.checkInNumber = 0;
        this.checkInTime = "";
    }

    public String getName() {
        return name;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public void checkIn(String username) { // 新增签到方法
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = formatter.format(now);
        this.checkInTime = time;
        this.checkInNumber =checkInNumber(name);
        System.out.println("Check-in successful. Check-in time: " + time+" Check-in numbers:"+checkInNumber);
    }

    public String toString() {
        return "Sports{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", checkInNumber=" + checkInNumber +
                ", checkInTime='" + checkInTime + '\'' + // 输出签到时间
                '}';
    }

    private Integer checkInNumber(String username){
        int i=0;
        try {
            File file = new File("record.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts[0].strip().equals(username)) {
                    i++;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            return null;
        }
        return i;
    }
}
