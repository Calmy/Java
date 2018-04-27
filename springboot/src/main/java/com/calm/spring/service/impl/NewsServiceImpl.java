/**
 * 
 */
package com.calm.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.calm.spring.service.NewsService;

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
@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	@Qualifier("primaryJdbcTemplate")
	JdbcTemplate jdbcTemplate;

	/*
	 * (non-Javadoc)
	 * @see com.calm.spring.service.NewsService#getNewsCount()
	 */
	@Override
	public Integer getNewsCount() {
		return jdbcTemplate.queryForObject("select count(1) from news_all", Integer.class);
	}

}
