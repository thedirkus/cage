package objects;

import java.util.HashMap;
import java.util.List;

import dynamic.Parameterizable;

public abstract class Card implements Parameterizable{

	String					_name;
	String					_thumbnailImage;
	String					_detailImage;
	String					_paramImage;
	HashMap<String, String> _parameters;
	
	public Card() {
		
		_parameters = new HashMap<String, String>();
	}
	
	
	
	
	public String get_name() {
		return _name;
	}




	public void set_name(String _name) {
		this._name = _name;
	}




	public String get_thumbnailImage() {
		return _thumbnailImage;
	}




	public void set_thumbnailImage(String _thumbnailImage) {
		this._thumbnailImage = _thumbnailImage;
	}




	public String get_detailImage() {
		return _detailImage;
	}




	public void set_detailImage(String _detailImage) {
		this._detailImage = _detailImage;
	}




	public String get_paramImage() {
		return _paramImage;
	}




	public void set_paramImage(String _paramImage) {
		this._paramImage = _paramImage;
	}




	public void set(String param, String value) {
		
		_parameters.put(param, value);
	}
	
	public String get(String param) {
		
		return _parameters.get(param);
	}	
	
	public List<String> getParameters() {
		
		return (List<String>) _parameters.keySet();
	}
	
}
