package pe.mil.ejercito.lib.utils.componets.helpers;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CommonHelper
 * <p>
 * CommonHelper class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE EJERCITO DEL PERÚ APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author ejercito
 * @author cbaciliod@ejercito.mil.pe
 * @since 9/03/2024
 */

@UtilityClass
public class CommonHelper {

    private final String PAGE = "?page=";
    private final String LIMIT = "&limit=";
    private final String PAGE_LIMIT = "?page=1&limit=";
    private final Random random = new Random();


    public static String getRandomUuid() {
        return UUID.randomUUID().toString();
    }

    public int generateRandom(int vMin, int vMax) {
        return vMin + random.nextInt(vMax - vMin + 1);
    }


    public static boolean applyRegex(String regex, String value) {

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }


    public static BigInteger longToBigInteger(long value) {
        return BigInteger.valueOf(value);
    }

    public static boolean bigIntegerIsGreaterThan(BigInteger value1, BigInteger value2) {
        return (value1.compareTo(value2) > 0);
    }

    public static BigDecimal divideAndRounding(BigDecimal value1, BigDecimal value2) {
        return value1.divide(value2, RoundingMode.CEILING);
    }

    public static BigDecimal getLastPage(BigInteger totalRecords, String limit) {
        return (bigIntegerIsGreaterThan(totalRecords, BigInteger.ZERO)) ? divideAndRounding(new BigDecimal(totalRecords), new BigDecimal(limit)) : new BigDecimal(0);
    }

    public static BigInteger getNextPageNumber(String page) {
        return new BigInteger(page).add(BigInteger.valueOf(1L));
    }

    public static BigInteger previousPageNumber(String page) {
        return new BigInteger(page).subtract(BigInteger.valueOf(1L));
    }

    public static String getNextPageNumber(BigInteger nextPageNumber, BigInteger lastPage, String limit) {
        return (nextPageNumber.compareTo(lastPage) > 0) ? null : PAGE + nextPageNumber + LIMIT + limit;
    }

    public static String getPreviousPageNumber(BigInteger previousPageNumber, BigInteger lastPage, String limit) {
        return (previousPageNumber.compareTo(lastPage) > 0) ? null : PAGE + previousPageNumber + LIMIT + limit;
    }

    public static String getLastPage(BigDecimal lastPage, String limit) {
        return lastPage.compareTo(BigDecimal.ZERO) == 0 ? null : (PAGE + lastPage + LIMIT + limit);
    }


    public static String getFirstPage(BigInteger totalRecords, String limit) {
        return (totalRecords.compareTo(BigInteger.ZERO) == 0) ? null : PAGE_LIMIT + limit;
    }

}