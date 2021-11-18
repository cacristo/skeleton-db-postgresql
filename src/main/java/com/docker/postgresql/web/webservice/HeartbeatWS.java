package com.docker.postgresql.web.webservice;

import com.docker.postgresql.service.monitoring.MonitorService;
import com.docker.postgresql.web.dto.SimpleResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Web Service to check the state of the API
 */
@RestController
@RequestMapping
public class HeartbeatWS {
    private static final Logger LOG = LoggerFactory.getLogger(HeartbeatWS.class);

    @Autowired
    MonitorService monitorService;

    @Autowired
    public HeartbeatWS() {
        /* empty constructor */
    }

    /**
     * Check if the API is alive.
     *
     * @return {@link SimpleResponseDTO <String>}
     */
    @GetMapping(value = "/is-alive")
    public SimpleResponseDTO isAlive() {
        LOG.info("HeartbeatWS.isAlive '/is-alive'");
        return new SimpleResponseDTO(200, "DB-PostgreSQL is alive!");
    }

    /**
     * Check if the API is online (check database access).
     *
     * @return {@link SimpleResponseDTO <String>}
     */
    @GetMapping(value = "/is-online")
    public SimpleResponseDTO isOnline() {
        LOG.info("HeartbeatWS.isOnline '/is-online'");
        if (monitorService.isDatabaseOnline()) {
            return new SimpleResponseDTO(200, "DB-PostgreSQL is online!");
        }
        return new SimpleResponseDTO(404, "The database is down!");
    }

    /**
     * Check if each call of third party connection is established successfully.
     *
     * @return {@link SimpleResponseDTO <String>}
     */
    @GetMapping(value = "/is-connection-established")
    public SimpleResponseDTO isConnectionEstablished() {
        LOG.info("HeartbeatWS.isConnectionEstablished '/is-connection-established'");
        List<String> connectionEstablished = monitorService.isConnectionEstablished();
        if (connectionEstablished.isEmpty()) {
            return new SimpleResponseDTO(200, "All connections established successfully!");
        }
        String message = "Impossible to establish connection to: ";
        return new SimpleResponseDTO(404, message.concat(String.join(", ", connectionEstablished).concat(".")));
    }
}
