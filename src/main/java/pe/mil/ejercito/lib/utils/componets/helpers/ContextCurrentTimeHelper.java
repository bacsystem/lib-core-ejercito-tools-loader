package pe.mil.ejercito.lib.utils.componets.helpers;

import lombok.experimental.UtilityClass;

import java.sql.Timestamp;

/**
 * ContextCurrentTimeHelper
 * <p>
 * ContextCurrentTimeHelper class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE EJERCITO DEL PERÚ APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author ejercito
 * @author cbaciliod@ejercito.mil.pe
 * @since 26/02/2024
 */

@UtilityClass
public class ContextCurrentTimeHelper {
    public static Timestamp getTimestamp(long time) {
        return new Timestamp(time);
    }

    public static long getStarTime() {
        return System.currentTimeMillis();
    }

    public static long getTotalTime(long starTime) {
        return System.currentTimeMillis() - starTime;
    }
}