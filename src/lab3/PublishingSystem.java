package lab3;

interface DocumentTemplate extends Cloneable {
    DocumentTemplate clone();
    void customize(String title, String layout, String style);
    void display();
}
class ArticleTemplate implements DocumentTemplate {
    private String title;
    private String layout;
    private String style;
    private String content;

    public ArticleTemplate() {
        this.title = "Default Article";
        this.layout = "Single Column";
        this.style = "Academic";
        this.content = "Article content template...";
    }
    @Override
    public DocumentTemplate clone() {
        ArticleTemplate clone = new ArticleTemplate();
        clone.title = this.title;
        clone.layout = this.layout;
        clone.style = this.style;
        clone.content = this.content;
        return clone;
    }
    @Override
    public void customize(String title, String layout, String style) {
        this.title = title;
        this.layout = layout;
        this.style = style;
        System.out.println("Customizing Article Template...");
    }
    @Override
    public void display() {
        System.out.println("Article: " + title + " | Layout: " + layout + " | Style: " + style);
    }
}
// Client
public class PublishingSystem {
    public static void main(String[] args) {
        DocumentTemplate articlePrototype = new ArticleTemplate();
        DocumentTemplate article1 = articlePrototype.clone();
        article1.customize("I love Dr.Soud", "Two-Column", "Formal");
        article1.display();
        DocumentTemplate article2 = articlePrototype.clone();
        article2.customize("article for lab 3", "One-Column", "Casual");
        article2.display();
    }
}