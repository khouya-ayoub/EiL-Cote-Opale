package annotations;

import java.lang.annotation.Documented;

@Documented
public @interface Todo {
    enum Importance {
        MINEUR, IMPORTANT, MAJEUR, CRITIQUE
    }

    Importance importance() default Importance.MINEUR;
    String[] description();
    String assigneA();
    String dateAssignation();
}
