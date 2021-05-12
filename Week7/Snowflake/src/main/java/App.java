import java.util.Random;

public class App {
    public static void main(String[] args) {
        Random random = new Random(System.currentTimeMillis());

        SnowflakeCreator snowflakeCreator = new SnowflakeCreator(5L, 5L, random.nextInt(4095));
        System.out.println();
        System.out.println("---------------------------------=-------------");
        System.out.println("DatacenterId: " + snowflakeCreator.getDatacenterId());
        System.out.println("WorkId: " + snowflakeCreator.getWorkerId());
        System.out.println("seqId: " + snowflakeCreator.nextId());




    }
}
