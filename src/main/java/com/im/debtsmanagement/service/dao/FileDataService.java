package com.im.debtsmanagement.service.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.im.debtsmanagement.model.ManagementObject;
import com.im.debtsmanagement.model.User;

/**
 * Service used to read / write into a file
 */
@Service
public class FileDataService {

	private static final String FILE_PATH = "D:\\Proiecte\\debts_management\\file";
	private static final String FILE_NAME = "track-file.txt";
	private static final String FILE_ABSOLUTE_PATH = FILE_PATH + "/"
			+ FILE_NAME;
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	public void writeInfo(String message) {
		
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(
					FILE_ABSOLUTE_PATH, true)));
			out.println(message);
		} catch (IOException e) {
		} finally {
			out.close();
		}
	}
	
	private String getCurrentDate()
	{
		Date date = new Date();
		return DATE_FORMAT.format(date);
	}
	
	private StringBuilder createBaseStringBuilder(User loggedUser, String classCaller)
	{
		return new StringBuilder()
		.append("[").append(getCurrentDate()).append("]")
		.append(" ").append(classCaller).append(" , ")
		.append("user ").append(loggedUser.getUsername()).append(" did operation: ");
	}
	
	public void writeCreateInfo(ManagementObject managementObject, String table, User loggedUser, String classCaller) {
		StringBuilder str = createBaseStringBuilder(loggedUser, classCaller)
				.append("Into table ").append(table)
				.append(" was added object ").append(managementObject.getModelObjectDescription());
		writeInfo(str.toString());
	}
	
	public void writeUpdateInfo(ManagementObject oldObject, ManagementObject newObject, String table, User loggedUser, String classCaller) {
		StringBuilder str = createBaseStringBuilder(loggedUser, classCaller)
				.append("Into table ").append(table)
				.append(" was updated object ").append(oldObject.getModelObjectDescription())
				.append(" with values : ").append(newObject.getModelObjectDescription());
		writeInfo(str.toString());
	}
	
	public void writeDeleteInfo(String id, String table, User loggedUser, String classCaller) {
		StringBuilder str = createBaseStringBuilder(loggedUser, classCaller)
				.append("Into table ").append(table)
				.append(" was deleted object with id").append(id);
		writeInfo(str.toString());
	}
}
