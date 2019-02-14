package com.spring.inaction.config.database;

import javax.sql.DataSource;

/**
 * Created by mberhe on 2/13/19.
 */
public interface DatabaseConfig {
    DataSource createDataSource();
}
