package com.mehmetpekdemir.accountservice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Configuration
@EnableCassandraRepositories
public class CassandraConfiguration extends AbstractCassandraConfiguration {

	@Value("${spcloud.cassandra.keyspace.name}")
	private String keyspaceName;

	@Value("${spcloud.cassandra.port}")
	private int port;

	@Value("${spcloud.cassandra.contact.point}")
	private String contactPoints;

	@Value("${spcloud.cassandra.getEntityBasePackages}")
	private String basepackages;

	@Value("${spcloud.cassandra.username}")
	private String username;

	@Value("${spcloud.cassandra.password}")
	private String password;

	@Override
	protected String getKeyspaceName() {
		return keyspaceName;
	}

	@Override
	protected int getPort() {
		return port;
	}

	@Override
	protected String getContactPoints() {
		return contactPoints;
	}

	@Override
	public SchemaAction getSchemaAction() {
		return SchemaAction.CREATE_IF_NOT_EXISTS;
	}

	@Override
	public String[] getEntityBasePackages() {
		return new String[] { basepackages };
	}

	@Override
	public CassandraClusterFactoryBean cluster() {
		CassandraClusterFactoryBean cassandraClusterFactoryBean = super.cluster();
		cassandraClusterFactoryBean.setUsername(username);
		cassandraClusterFactoryBean.setPassword(password);
		return cassandraClusterFactoryBean;
	}

}
