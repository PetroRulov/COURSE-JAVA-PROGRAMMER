package lesson7.generics.containers.service.annotations;

import java.lang.annotation.*;

/**
 * Created by prulov on 26.06.2016.
 */
@Documented // marked (by this annotation) class fall in JavaDoc
@Inherited // this annotation to be inherited by all descendants of the marked class
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {

    String info() default "CheckingObject";
    boolean upLoad() default false;
}
