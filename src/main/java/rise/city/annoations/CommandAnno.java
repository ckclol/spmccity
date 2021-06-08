package rise.city.annoations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CommandAnno {
    String cmd();
    String lastEdited();
    double version();
}
