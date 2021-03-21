package fr.esiea.ex4A;

public class User {

    private final String uName;
    private final String uMail;
    private final String uTweeter;
    private final String uCountry;
    private final String uSex;
    private final String uSexPref;

    public User(String uName, String uMail, String uTweeter, String uCountry, String uSex, String uSexPref){
        this.uName = uName;
        this.uMail = uMail;
        this.uTweeter = uTweeter;
        this.uCountry = uCountry;
        this.uSex = uSex;
        this.uSexPref = uSexPref;
    }

    public String getuName() {
        return uName;
    }

    public String getuMail() {
        return uMail;
    }

    public String getuTweeter() {
        return uTweeter;
    }

    public String getuCountry() {
        return uCountry;
    }

    public String getuSex() {
        return uSex;
    }

    public String getuSexPref() {
        return uSexPref;
    }

}
