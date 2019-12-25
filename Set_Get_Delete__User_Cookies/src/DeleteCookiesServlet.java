import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Этот сервлет (класс) удаляеи куки
 */
public class DeleteCookiesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Чтобы удалить куки, их надо перезаписать
     * Ключ some_id должен совпадать потому что мы его перезаписываем
     * Для удаления куки запускаем метод cookie.setMaxAge(0), т.е. срок действи куки будет 0 секунд
     * Поэтому браузер клиента сразу же удалит куки из своей памяти
     * Добавляем новые куки response.addCookie(cookie)
     * Можно удалить куки при закрытии браузера cookie.setMaxAge(-1)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("some_id", "");

        //куки удаляются немедленно
        cookie.setMaxAge(0);

        //куки удаляются при закрытии браузера
        // cookie.setMaxAge(-1);

        response.addCookie(cookie);
    }
}
