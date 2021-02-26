package city.spmc.annoations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Event {
    String Event();
    String lastEdited();
    double version();
}