package sangamsagar.newspapertime.Model;

public class Tab1Object {

    String content,author,title,description,published,url_image,url;
    public Tab1Object()
    {

    }
    public Tab1Object(String author,String title,String description,String published,String content,String url_image,String url)
    {
    this.author=author;
    this.content=content;
    this.description=description;
    this.published=published;
    this.title=title;
    this.url_image=url_image;
    this.url = url;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPublished() {
        return published;
    }

    public String getUrl_image()
    {
        return url_image;
    }

    public String getUrl()
    {
        return url;
    }
}
