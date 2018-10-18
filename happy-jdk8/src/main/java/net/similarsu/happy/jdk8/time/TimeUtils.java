package net.similarsu.happy.jdk8.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * time utils with jdk8
 * @author similarsu
 */
public class TimeUtils {
    private TimeUtils(){

    }

    /**
     * translate date to instant
     * @param date
     * @return
     */
    public static Instant date2Instant(Date date){
        return date.toInstant();
    }

    /**
     * translate instant to date
     * @param instant
     * @return
     */
    public static Date instant2Date(Instant instant){
        return Date.from(instant);
    }

    /**
     *  translate localDateTime to instant
     * @param localDateTime
     * @return
     */
    public static Instant ldt2instant(LocalDateTime localDateTime){
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant();
    }

    /**
     *  translate instant to localDateTime
     * @param instant
     * @return
     */
    public static LocalDateTime instant2ldt(Instant instant){
        return LocalDateTime.ofInstant(instant,ZoneId.systemDefault());
    }


    /**
     * translate localDate to locatDateTime
     * @param localDate
     * @return
     */
    public static LocalDateTime ld2ldt(LocalDate localDate){
        return localDate.atStartOfDay();
    }

    /**
     * translate localDateTime to date
     * @param localDateTime
     * @return
     */
    public static Date ldt2Date(LocalDateTime localDateTime){
        return instant2Date(ldt2instant(localDateTime));
    }

    /**
     * translate date to localDateTime
     * @param date
     * @return
     */
    public static LocalDateTime date2ldt(Date date){
        return instant2ldt(date2Instant(date));
    }

    /**
     * translate localDate 2 date
     * @param localDate
     * @return
     */
    public static Date ld2Date(LocalDate localDate){
        return ldt2Date(ld2ldt(localDate));
    }
}
