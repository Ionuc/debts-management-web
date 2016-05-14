package com.im.debtsmanagement.connection;

import java.net.UnknownHostException;
import com.mongodb.*;
import com.mongodb.client.MongoDatabase;

public final class MongodbConnectionFactory {

	private MongodbConnectionFactory()
	{
	}
	
	public static MongoDatabase create()
	{
		MongoClientURI uri  = new MongoClientURI("mongodb://ionut.mesaros:ionut.mesaros@ds057954.mongolab.com:57954/debts_management"); 
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
        return db;
	}
}
