package org.example.tp1;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


@WebServlet("/ListItems")
public class ListItems extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

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
        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        out.println("<table border='1'>"
                + "<tr>"
                + "<th>Items</th>"
                + "<th>Number</th>"

                + "</tr>");
        for (String itemm : items.keySet()) {
            out.println("<tr>"
                    + "<td>" + itemm + "</td>"
                    + "<td>" + items.get(itemm) + "</td>"

                    + "</tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
        }





}