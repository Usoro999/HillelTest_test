    package Config;

    import org.testng.annotations.DataProvider;

    import java.util.*;
    public class DataProviderClass {

        @DataProvider(name = "userData")
        public Object[][] userData(){
            return new Object[][]{
                    {},
                    {}

            };
        }
        static List< String > stringList = new ArrayList<>();
        static List< Integer > intList = new ArrayList<>();

        static {
            stringList.add("Moloko");
            stringList.add("Kefir");
            stringList.add("Kolbasa");
            stringList.add("voda");

            intList.add(71119900);
            intList.add(82239876);
            intList.add(713119900);
            intList.add(122395876);
        }

        public static String getRandomString() {
            return stringList.get(new Random().nextInt(stringList.size()));
        }

        public static Integer getRandomInt() {
            return intList.get(new Random().nextInt(intList.size()));
        }

    }
