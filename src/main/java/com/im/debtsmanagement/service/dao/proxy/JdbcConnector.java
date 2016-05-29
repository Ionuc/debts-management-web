package com.im.debtsmanagement.service.dao.proxy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.im.debtsmanagement.api.ManagementObject;
import com.im.debtsmanagement.connection.JdbcConnectionFactory;
import com.im.debtsmanagement.service.modelcreator.ManagementObjectCreator;

public class JdbcConnector implements ProxyConnector {

	public static final String NAME = "jdbc-connector";

	private final Connection conn;

	public JdbcConnector() {

		conn = JdbcConnectionFactory.get();
	}

	@Override
	public <OBJECT extends ManagementObject> OBJECT create(ManagementObjectCreator<OBJECT> creator,
			List<String> columnNames, List<String> columnValues, String tableName) {
		StringBuilder fieldBuilder = new StringBuilder("Insert into `" + tableName + "`");

		processInsertStringBuilder(fieldBuilder, columnNames, "`");
		fieldBuilder.append(" values ");
		processInsertStringBuilder(fieldBuilder, columnValues, "'");

		PreparedStatement stmt = null;
		try {
			String stmtString = fieldBuilder.toString();
			stmt = conn.prepareStatement(stmtString, Statement.RETURN_GENERATED_KEYS);
			System.out.println(stmtString);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				List<OBJECT> objects = get(creator, tableName, "id", String.valueOf(generatedKeys.getLong(1)));
				return objects.stream().findFirst().orElse(null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	private StringBuilder processInsertStringBuilder(StringBuilder stringBuilder, List<String> values,
			String separator) {
		stringBuilder.append("(");
		for (String value : values) {
			stringBuilder.append(separator).append(value).append(separator).append(" ,");
		}
		stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), ")");
		return stringBuilder;
	}

	@Override
	public <OBJECT extends ManagementObject> void update(ManagementObjectCreator<OBJECT> creator, String id,
			List<String> columnNames, List<String> columnValues, String tableName) {
		StringBuilder strBuilder = new StringBuilder("Update `" + tableName + "` set ");

		for (int i = 0; i < columnNames.size(); i++) {
			String columnName = columnNames.get(i);
			String columnValue = columnValues.get(i);
			strBuilder.append("`").append(columnName).append("`='").append(columnValue).append("' ");
			if (i != columnNames.size() - 1) {
				strBuilder.append(", ");
			}
		}
		strBuilder.append("where `id`=").append(id).append(";");

		PreparedStatement stmt;
		try {
			String stmtString = strBuilder.toString();
			stmt = conn.prepareStatement(stmtString);
			System.out.println(stmtString);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String tableName, String id) {
		PreparedStatement stmt;
		try {

			StringBuilder str = new StringBuilder("Delete from ").append(tableName).append(" where id='").append(id)
					.append("'");
			stmt = conn.prepareStatement(str.toString());
			stmt.executeUpdate();
			System.out.println(str.toString());

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	@Override
	public <OBJECT extends ManagementObject> List<OBJECT> get(ManagementObjectCreator<OBJECT> creator, String tableName,
			String columnName, String columnValue) {
		Statement stmt;
		ResultSet rs = null;
		List<OBJECT> objects = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			String statementString = "Select * from " + tableName + columnName != null && columnValue != null
					? " where `" + columnName + "` = \"" + columnValue + "\"" : "";
			rs = stmt.executeQuery(statementString);

			while (rs.next()) {
				OBJECT object = creator.getNewObject();
				for (String field : creator.getAllFields()) {
					creator.setValue(object, field, rs.getObject(field));
				}
				objects.add(object);
				return objects;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objects;

	}

	@Override
	public <OBJECT extends ManagementObject> List<OBJECT> getAll(ManagementObjectCreator<OBJECT> creator,
			String tableName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType() {
		return NAME;
	}
}
