public class SportAndHobbyImpl implements PersonInterface, SportInterface, HobbyInterface {
    private String MyFavoriteSport;
    private String MyHobby;
    private String Name;
    private int Age;
    public SportAndHobbyImpl(String Name, int Age, String MyFavoriteSport, String MyHobby) {
        this.MyFavoriteSport = MyFavoriteSport;
        this.MyHobby = MyHobby;
        this.Name = Name;
        this.Age = Age;
    }
    public int getAge() {
        return this.Age;
    }
    public String getName() {
        return this.Name;
    }
    @Override
    public String whatIsMyHobby() {
        return this.MyHobby;
    }

    @Override
    public void setMyHobby(String hobby) {
        this.MyHobby = hobby;
    }

    @Override
    public void setName(String myName) {
        this.Name = myName;
    }

    @Override
    public void setAge(int myAge) {
        this.Age = myAge;
    }

    @Override
    public String getMyFavoriteSport() {
        return this.MyFavoriteSport;
    }

    @Override
    public void setMyFavoriteSport(String sportName) {
        this.MyFavoriteSport = sportName;
    }

    @Override
    public int howMuchItCostToPlayThisSport() {
        return this.Age * 10;
    }
}
