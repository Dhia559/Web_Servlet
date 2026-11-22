import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/ListItems")
public class ListItems extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        render(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String item = request.getParameter("newItem");
        HttpSession session = request.getSession();
        Map<String, Integer> items = (Map<String, Integer>)
                session.getAttribute("items");

        if (items == null) {
            items = new HashMap<>();
        }
        if (item != null && !item.trim().isEmpty()) {
            item = item.trim().toLowerCase();
            items.put(item, items.getOrDefault(item, 0) + 1);
        }

        session.setAttribute("items", items);
        response.setContentType("text/html;charset=UTF-8");
        render(request, response);
    }

    private void render(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Map<String, Integer> items = (Map<String, Integer>)
                session.getAttribute("items");
        if (items == null) {
            items = new HashMap<>();
        }

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<form action=\"" + request.getContextPath() + "/ListItems\" method=\"POST\">"
                + "Item: <input type=\"text\" name=\"newItem\"> "
                + "<input type=\"submit\" value=\"Add Item\"></form>");

        out.println("<table border='1'>"
                + "<tr>"
                + "<th>Items</th>"
                + "<th>Number</th>"
                + "</tr>");
        for (String item : items.keySet()) {
            out.println("<tr>"
                    + "<td>" + item + "</td>"
                    + "<td>" + items.get(item) + "</td>"
                    + "</tr>");
        }
        out.println("</table>");

        out.println("<p><a href=\"" + request.getContextPath() + "/form.html\">Home</a></p>");
        out.println("</body></html>");
    }
}
