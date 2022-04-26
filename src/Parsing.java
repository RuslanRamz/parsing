import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parsing {
    public static Document getPage() throws IOException {
        String url = "https://stopgame.ru/games/PC/best";
        Document page = Jsoup.parse(new URL(url),10000 );
        return page;
    }
    public static void main(String[] args) throws IOException {
        Document page = getPage();
        Elements list = page.select("div[class=items]");
        // список
        Elements bloc = list.select("div[data-key]");
        // ячейка
        Elements games = bloc.select("div[class=caption caption-bold]");
        // ненужная строка

        for(Element game: games) {
            String name = game.select("div[class=caption caption-bold]").text();
            System.out.println("Game:  " + name );
        }

    }
}
