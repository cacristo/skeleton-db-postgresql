package com.docker.postgresql.service.monitoring;

import com.docker.postgresql.repository.monitoring.OnlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service to check the state of the API
 */
@Service
public class MonitorServiceImpl implements MonitorService {
    @Autowired
    OnlineRepository onlineRepository;

    /**
     * @see MonitorService#isDatabaseOnline() form more information.
     */
    @Override
    public boolean isDatabaseOnline() {
        try {
            return onlineRepository.isOnline();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @see MonitorService#isConnectionEstablished() form more information.
     */
    @Override
    public List<String> isConnectionEstablished() {
        List<String> connectionErrorList = new ArrayList<>();
        // add here each call of third party connection, in case of error add error:
        // "ABC API"
        return connectionErrorList;
    }
}
