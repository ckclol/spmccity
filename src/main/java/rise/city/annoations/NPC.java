package rise.city.annoations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface NPC {
    String npcname();
    String lastEdited();
    double version();
    String loc();
}
