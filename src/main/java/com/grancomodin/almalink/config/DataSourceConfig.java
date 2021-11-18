package com.grancomodin.almalink.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sqlite.SQLiteDataSource;

@Configuration
public class DataSourceConfig {
    @Bean(destroyMethod = "", name = "EmbeddedDataSource")
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.sqlite.JDBC");
                 // Ruta de archivo SQLite, puede ser una ruta absoluta o una ruta relativa
 // datasourcebuilder.url ("jdbc: sqlite: c: / ... omitido ... / principal / recursos / estático / db \\ normal.db");
        dataSourceBuilder.url("jdbc:sqlite:src/main/resources/static/db/normal.sql");
        dataSourceBuilder.type(SQLiteDataSource.class);
        return dataSourceBuilder.build();
    }
}
