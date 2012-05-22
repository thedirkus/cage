package dynamic;

import java.util.List;

public interface Parameterizable {

	public void set(String parameter, String value);
	public String get(String parameter);
	public List<String> getParameterNames();
	
}
