package lab2;

public class ConfigurationManager {
    private static final ConfigurationManager instance = new ConfigurationManager ();
    private String theme;
    private String language;
    private ConfigurationManager(){
        loadConfigurationSettings();
    }
    public static ConfigurationManager getInstance () {
        return instance ;
        }

    public String getConfigurationSettings () {
        return instance.language + instance.theme;
        }

    private void loadConfigurationSettings () {
        // logic to load configuration settings from a file
        this.theme = "Dark theme";
        this.language = "Arabic";
        }
    public void setLanguage(String language){
        this.language = language;
    }
    public void setTheme(String theme){
        this.theme = theme;
    }
    public String getLanguage() {
        return language;
    }
    public String getTheme() {
        return theme;
    }

    @Override
    public String toString() {
        return "ConfigurationManager{" +
                "theme='" + theme + '\'' +
                ", language='" + language + '\'' +
                '}';}
}

class Main2{
    public static void main(String[] args) {
        // create two instances
        ConfigurationManager instance1 = ConfigurationManager.getInstance();
        ConfigurationManager instance2 = ConfigurationManager.getInstance();
        // chack if they are share the same attributes
        System.out.println(instance2.equals(instance1));
        // print attributes
        System.out.println(instance1.toString());
        // set the theme and language
        instance2.setLanguage("English");
        instance2.setTheme("light theme");
        System.out.println(instance1.toString());
        // make new instances to see if it takes the new defults values
        ConfigurationManager instance3 = ConfigurationManager.getInstance();
        System.out.println(instance3.toString());


    }
}
