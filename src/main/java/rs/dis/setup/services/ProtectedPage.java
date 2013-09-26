/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.dis.setup.services;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import rs.dis.setup.entities.TipKorisnika;


/**
 *
 * @author mateja
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ProtectedPage {

    TipKorisnika getRole() default TipKorisnika.NONE;
}
