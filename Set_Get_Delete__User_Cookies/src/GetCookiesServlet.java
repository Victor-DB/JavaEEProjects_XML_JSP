import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Данный сервлет (класс) считывает куки (которые были записаны в классе SetCookiesServlet)
 */
public class GetCookiesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Браузер в каждом запросе посылает куки обратно серверу
     * Берём запрос от клиента (request) и вызываем на нём метод getCookies() чтобы получить куки от клиента
     * Запишем куки в массив
     * Выведем значение и имя для каждого куки
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        PrintWriter pw = response.getWriter();
        pw.println("<html>");

        for(Cookie cookie : cookies) {
            pw.println("<h1>" + cookie.getName() + " : " +  cookie.getValue() + "</h1>");
        }
        pw.println("</html>");
    }
}
