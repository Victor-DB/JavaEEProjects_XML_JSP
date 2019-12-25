import somePackage.Cart;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        /**
         * Создаём обект session для хранения данных о пользователе
         * Сессия открывается при запросе клиента поэтому используем метод гет к запросу
         */
        HttpSession session = request.getSession();


        /**
         * В качестве атрибута будем передавать не просто число а целый объект класса Cart
         * Этот объект будем получать из нашей ссессии session
         * Если ничего не будем получать, то будем создавать новый объект
         * Если будем получать что-то, то будем этот объект как-то модифицировать
         */
        Cart cart = (Cart) session.getAttribute("cart");


        /**
         * Получим значения корзины (имя и количество) из URL-параметров
         *
         */
        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));


        /**
         * Запишем полученные из корзины параметры в сессию
         * Для этого создадим новый объект класса Cart  и зададим ему количество
         */
        if(cart == null) {
            cart = new Cart();
            cart.setName(name);
            cart.setQuantity(quantity);
        }


        /**
         * Записываем сессию пользователя с его корзиной:
         */
        session.setAttribute("cart", cart);

        /**
         *
         */

        getServletContext().getRequestDispatcher("/showCart.jsp").forward(request, response);


    }
}
