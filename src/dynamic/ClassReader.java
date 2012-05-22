package dynamic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ClassReader {
	
	
	public static final String CLASSPATH =
			ClassReader.class.getResource("/").getPath();
	
	
	public static List<Class<?>> getAll(Class<?> target) {
		String crasspath = CLASSPATH.replace("%20", " ");
		File path = new File(crasspath);
		return search(path, target);
	}
	
	
	public static List<String> getNames(Class<?> target) {
		
		List<Class<?>> classes = getAll(target);
		List<String>   names   = new ArrayList<String>();
		
		for (Class<?> cls : classes)
			names.add(cls.getName());
		
		return names;
	}
	
	
	public static Object getNew(Class<?> cls) {
		
		try                 { return cls.newInstance(); }
		catch (Exception e) { return null; }
	}
	
	
	public static Object getNew(String className) {
		
		try                 { return Class.forName(className).newInstance(); }
		catch (Exception e) { return null; }
	}
	
	
	public static Class<?> subclassOf(Class<?> target, File file) {
		
		try {
			file = new File(file.toString().replace("%20", " "));
			String crasspath = CLASSPATH.replace("%20", " ");
			String path  = file.toString();
			int    start = path.indexOf(crasspath) + crasspath.length();
			int    end   = path.lastIndexOf(".class");
			
			path = path.substring(start, end);
			path = path.replace(File.separatorChar, '.');
			
			Class<?> cls = Class.forName(path);
			
			if (target.isAssignableFrom(cls) && getNew(cls) != null)
				return cls;
			
		}
		catch (ClassNotFoundException          e) { }
		catch (StringIndexOutOfBoundsException e) { }
		
		return null;
	}
	
	
	//------------------------------------------------------------------------//
	
	
	private static List<Class<?>> search(File file, Class<?> target) {

		List<Class<?>> classes = new ArrayList<Class<?>>();
		file = new File(file.toString().replace("%20", " "));
		String crasspath = CLASSPATH.replace("%20", " ");
		
		if (file.isFile()) {
			
			Class<?> cls = subclassOf(target, file);
			
			if (cls != null)
				classes.add(cls);
			
		} else if (file.isDirectory()) {

			for (File child : file.listFiles()) {
				classes.addAll(search(child, target));
			}
		}
		
		return classes;
	}
}