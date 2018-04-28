package com.calm.spring.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 
 */

/**
 * 
 * <pre>
 * 。
 * </pre>
 * 
 * @author chenzhuo
 * @version 1.00.00
 * 
 *          <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 *          </pre>
 */
@Configuration
public class DataSourceConfiguration {

	@Primary
	@Bean("primaryDataSources")
	@ConfigurationProperties(prefix = "spring.datasource")
	public javax.sql.DataSource primaryDataSources() {
		return DataSourceBuilder.create().build();
	}

	@Bean("otherDataSources")
	@ConfigurationProperties(prefix = "spring.other-datasource")
	public javax.sql.DataSource otherDataSources() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "primaryJdbcTemplate")
	public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSources") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean(name = "otherJdbcTemplate")
	public JdbcTemplate secondaryJdbcTemplate(@Qualifier("otherDataSources") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
