package com.im.debtsmanagement.service.dao.proxy;

public final class ProxyConnectorFactory {

	private ProxyConnectorFactory() {
	}

	public static ProxyConnector create(String connectorType) {
		if (JdbcConnector.NAME.equals(connectorType)) {
			return new JdbcConnector();
		}
		if (MongodbConnector.NAME.equals(connectorType))
		{
			return new MongodbConnector();
		}
		throw new UnsupportedOperationException("Cannot instantiate proxy connector for type " + connectorType);
	}
}
