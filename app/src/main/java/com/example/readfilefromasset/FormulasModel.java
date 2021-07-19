package com.example.readfilefromasset;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class FormulasModel implements Serializable {

	@SerializedName("formulae")
	private String formulae;

	@SerializedName("url")
	private String url;

	public String getFormulae(){
		return formulae;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"FormulasModel{" + 
			"formulae = '" + formulae + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}