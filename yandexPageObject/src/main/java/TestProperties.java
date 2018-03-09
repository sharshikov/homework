import java.io.FileInputStream;
        import java.io.IOException;
        import java.util.Properties;

public class TestProperties {
    static Properties property = new Properties();
    private TestProperties() {
        try {
            property.load(new FileInputStream("src/main/resources/app.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Properties getProperty(){
        return new TestProperties().property;
    }
}
