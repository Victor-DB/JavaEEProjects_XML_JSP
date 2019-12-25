import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Этот сервлет (класс) назначает куки в браузер клиента
 */
public class SetCookiesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * В методе doGet() будем назначать (имитировать) пользователю случайные куки.
         * Чтобы назначить куки нужно сначала создать объект класса Cookie
         * В конструкторе задаём ключ (название куки: some_id) и значение (123)
         */
        Cookie cookie1 = new Cookie("some_id", "123");
        Cookie cookie2 = new Cookie("some_name", "Tom");

        /**
         * Зададим срок действия куки в секундах = 1 день
         */
        cookie1.setMaxAge(24 * 60 * 60);
        cookie2.setMaxAge(24 * 60 * 60);


        /**
         * Чтобы добавить куки в браузер клиента нам нужно на объекте ответ (response) вызвать метод addCookie()
         * и ему передать в качесте аргумента наш куки (cookie1)
         */
        response.addCookie(cookie1);
        response.addCookie(cookie2);
    }
}
