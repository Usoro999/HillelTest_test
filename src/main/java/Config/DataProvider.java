    package Config;

    import java.util.*;

    public class DataProvider {
        static List< String > stringList = new ArrayList<>();
        static List< Integer > intList = new ArrayList<>();

        static {
            stringList.add("Moloko");
            stringList.add("Kefir");

            intList.add(71119900);
            intList.add(82239876);
        }

        public static String getRandomString() {
            return stringList.get(new Random().nextInt(stringList.size()));
        }

        public static Integer getRandomInt() {
            return intList.get(new Random().nextInt(intList.size()));
        }

    }
