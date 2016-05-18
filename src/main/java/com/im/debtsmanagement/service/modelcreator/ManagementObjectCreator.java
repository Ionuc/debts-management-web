package com.im.debtsmanagement.service.modelcreator;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.im.debtsmanagement.api.ManagementObject;


public abstract class ManagementObjectCreator<OBJECT extends ManagementObject> {

	public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/mm/dd");
	public static final DateFormat MongoDATE_FORMAT = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");

	public abstract List<String> getAllFields();

	public abstract OBJECT getNewObject();

	public void setValue(OBJECT object, String field, Object value) {
		try {
			Field f = object.getClass().getDeclaredField(field);
			f.setAccessible(true);
			Object trasnformedObject = transformObject(value, f.getType());
			f.set(object, trasnformedObject);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected Object transformObject(Object object, Class<?> clazz) {
		if (clazz.isAssignableFrom(Date.class)) {
			try {
				return DATE_FORMAT.parse(object.toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (clazz.isAssignableFrom(BigDecimal.class)) {
			return new BigDecimal(object.toString());
		}
		if (Boolean.class.isAssignableFrom(clazz) || boolean.class.isAssignableFrom(clazz)) {
			return Boolean.valueOf(object.toString());
		}
		if (Integer.class.isAssignableFrom(clazz) || int.class.isAssignableFrom(clazz)) {
			return Integer.valueOf(object.toString());
		}
		if (clazz.isAssignableFrom(String.class)) {
			return object.toString();
		}
		return null;
	}
}
