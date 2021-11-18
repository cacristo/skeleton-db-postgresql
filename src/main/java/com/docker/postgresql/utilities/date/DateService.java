package com.docker.postgresql.utilities.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Interface responsible to manage {@link LocalDateTime} and {@link LocalDate}
 */
public interface DateService {

    /**
     * @return {@link LocalDateTime#now()}
     */
    LocalDateTime now();

    /**
     * @return {@link LocalDate} today
     */
    LocalDate today();

    /**
     * @return {@link Date} today
     */
    Date todayDate();
}
