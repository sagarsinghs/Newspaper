package sangamsagar.newspapertime.PopularChannels.Fragments.Model;

public class Channel {

    String index,name;
    int image;
    public Channel()
    {

    }

    public Channel(String index,int image,String name)
    {
        this.image=image;
        this.index=index;
        this.name=name;
    }

    public String getIndex() {
        return index;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
