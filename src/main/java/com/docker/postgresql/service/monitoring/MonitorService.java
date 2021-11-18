package com.docker.postgresql.service.monitoring;

import java.util.List;

/**
 * Interface to check the state of the API
 */
public interface MonitorService {
    /**
     * Check if the database is online (possible to realise one connection)
     *
     * @return true if online, otherwise is false
     */
    boolean isDatabaseOnline();

    /**
     * Check if each call of third party connection is established successfully!
     *
     * @return empty if everything is OK, otherwise one element by unsuccessful connection.
     */
    List<String> isConnectionEstablished();
}
