package com.qinh.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

/**
 * @author Qh
 * @version 1.0
 * @date 2021-09-13-23:50
 */
//@Configuration
public class CustomizeDataSourceInitializer {
    @Value("classpath:sql/createTable.sql")
    private Resource sqlScriptSchema;
//    @Value("classpath:sql/data.sql")
//    private Resource sqlScriptData;

    //@Bean
    public DataSourceInitializer dataSourceInitializer(final DataSource dataSource){
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource);
        dataSourceInitializer.setDatabasePopulator(databasePopulator());
        return dataSourceInitializer;
    }

    private DatabasePopulator databasePopulator(){
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(sqlScriptSchema);
//        populator.addScript(sqlScriptData);
//        populator.addScript(sqlScriptProcedure);
//这里可以加入其它的sql脚本文件

        return populator;
    }
}
