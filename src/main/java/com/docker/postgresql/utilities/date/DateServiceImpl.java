package com.docker.postgresql.utilities.date;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Service responsible to manage {@link LocalDateTime} and {@link LocalDate}
 */
@Component
public class DateServiceImpl implements DateService {

    /**
     * @see DateService#now() for more info
     */
    public LocalDateTime now() {
        return DateUtil.now();
    }

    /**
     * @see DateService#today() for more info
     */
    public LocalDate today() {
        return DateUtil.today();
    }

    /**
     * @see DateService#todayDate() for more info
     */
    public final Date todayDate() {
        return new Date();
    }

}