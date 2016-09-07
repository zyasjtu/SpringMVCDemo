package annotation;

import java.lang.annotation.*;

/**
 * Created by z673413 on 2016/9/7.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LogAnnotation {
    String value() default "value";
}
