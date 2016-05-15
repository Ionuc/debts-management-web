package com.im.debtsmanagement.service.dao.proxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.im.debtsmanagement.connection.MongodbConnectionFactory;
import com.im.debtsmanagement.model.ManagementObject;
import com.im.debtsmanagement.service.modelcreator.ManagementObjectCreator;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
@Qualifier("MongodbConnectorConnector")
public class MongodbConnector implements ProxyConnector {

	public static final String NAME = "mongodb-connector";
	private final MongoDatabase mongoDatabase;

	public MongodbConnector() {
		this.mongoDatabase = MongodbConnectionFactory.create();
	}

	@Override
	public <OBJECT extends ManagementObject> OBJECT create(ManagementObjectCreator<OBJECT> managementObjectCreator,
			List<String> columnNames, List<String> columnValues, String tableName) {
		MongoCollection<Document> collection = mongoDatabase.getCollection(tableName);

		Document document = createDocument(columnNames, columnValues);

		collection.insertOne(document);
		OBJECT created = createObject(document, managementObjectCreator);
		created.setId(document.get("_id").toString());
		return created;
	}

	@Override
	public <OBJECT extends ManagementObject> OBJECT update(ManagementObjectCreator<OBJECT> managementObjectCreator,
			String id, List<String> columnNames, List<String> columnValues, String tableName) {
		MongoCollection<Document> collection = mongoDatabase.getCollection(tableName);

		Document document = createDocument(columnNames, columnValues);

		Document filter = new Document();
		filter.append("_id", id);
		collection.updateOne(filter, document);

		return get(managementObjectCreator, tableName, "_id", String.valueOf(id));
	}

	@Override
	public void delete(String tableName, String id) {
		MongoCollection<Document> collection = mongoDatabase.getCollection(tableName);
		Document document = createDocument(Arrays.asList("_id"), Arrays.asList(String.valueOf(id)));
		collection.deleteOne(document);
	}

	@Override
	public <OBJECT extends ManagementObject> OBJECT get(ManagementObjectCreator<OBJECT> managementObjectCreator,
			String tableName, String columnName, String columnValue) {
		MongoCollection<Document> collection = mongoDatabase.getCollection(tableName);
		Document document = createDocument(Arrays.asList(columnName), Arrays.asList(columnValue));
		Document found = collection.find(document).first();
		if (found == null)
		{
			return null;
		}
		return createObject(found, managementObjectCreator);
	}

	@Override
	public <OBJECT extends ManagementObject> List<OBJECT> getAll(
			ManagementObjectCreator<OBJECT> managementObjectCreator, String tableName, String columnName,
			String columnValue) {
		MongoCollection<Document> collection = mongoDatabase.getCollection(tableName);
		Document document = createDocument(Arrays.asList(columnName), Arrays.asList(columnValue));
		List<OBJECT> objects = new ArrayList<OBJECT>();
		for (Document doc : collection.find(document)) {
			objects.add(createObject(doc, managementObjectCreator));
		}
		return objects;
	}

	@Override
	public String getType() {
		return NAME;
	}

	private <OBJECT extends ManagementObject> OBJECT createObject(Document document,
			ManagementObjectCreator<OBJECT> managementObjectCreator) {
		OBJECT object = managementObjectCreator.getNewObject();
		for (String field : managementObjectCreator.getAllFields()) {
			if (field.equals("id"))
			{
				object.setId(document.get("_id").toString());
			}
			else
			{
				Object value = document.get(field);
				managementObjectCreator.setValue(object, field, value);
			}
		}
		return object;
	}

	private Document createDocument(List<String> columnNames, List<String> columnValues) {
		Document document = new Document();
		for (int i = 0; i < columnNames.size(); i++) {
			if (columnNames.get(i).equals("_id"))
			{
				document.append(columnNames.get(i), new ObjectId(columnValues.get(i)));
			}
			else
			{
				document.append(columnNames.get(i), columnValues.get(i));
			}
		}
		return document;
	}
}
