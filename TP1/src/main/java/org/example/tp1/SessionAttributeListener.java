package org.example.tp1;

import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

public class SessionAttributeListener implements HttpSessionAttributeListener {


    @Override
    public void attributeAdded(HttpSessionBindingEvent event ){
        System.out.println(
                "Attribute added: "
                        + event.getName()
                        + " = "
                        + event.getValue()
        );
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println(
                "Attribute modified: "
                        + event.getName()
                        + " = "
                        + event.getSession().getAttribute(event.getName())
        );
    }
    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println(
                "Attribute removed: "
                        + event.getName()
                        + " = "
                        + event.getValue()
        );
    }

}
