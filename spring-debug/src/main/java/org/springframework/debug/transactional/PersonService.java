package org.springframework.debug.transactional;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author kenny
 * @date 2021-12-23
 */
public class PersonService implements ApplicationContextAware {

	private PersonDao personDao;

	private ApplicationContext applicationContext;

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public void insert() throws Exception {
		personDao.insert();
	}

	public void update() throws Exception {
		personDao.update(1, "张三5");

		PersonService personService = applicationContext.getBean(PersonService.class);
		personService.updateForNew();

//		personDao.updateByHibernate(1, "张三e");

//		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
//			@Override
//			public void afterCommit() {
//				try {
		// 验证 hibernate 下 afterCommit 不会提交 增删改 操作
		// mybatis 下会提交
//					personDao.update(1, "张三6");
//					personDao.updateByHibernate(2, "李四e");
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				throw new NoTransactionException("测试在afterCommit抛出TransactionException");
//			}
//		});
	}

	public void updateForNew() {
		personDao.update(1, "张三new");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
