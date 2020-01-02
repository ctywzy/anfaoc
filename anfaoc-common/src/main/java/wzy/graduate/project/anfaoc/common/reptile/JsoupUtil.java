package wzy.graduate.project.anfaoc.common.reptile;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class JsoupUtil {
    public static final String Url = "https://www.huanqiu.com/";
    public static final Connection conn;

    static {
        conn = Jsoup.connect(Url);
    }

}
