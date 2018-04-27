/**
 * 
 */
package com.calm.spring.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calm.spring.entity.News;

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
public interface NewsJpaService extends JpaRepository<News, Long> {

	News findByTitle(String title);
}
