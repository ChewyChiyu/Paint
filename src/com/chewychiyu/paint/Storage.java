package com.chewychiyu.paint;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Storage{
	
	private static final String DOWNLOADS = System.getProperty("user.home") +  "/Downloads/";
	private static final boolean KEEP_EXIST = true;
	private static final String KEY_IDENTIFIER = "!--key@^&*@#%)(&$#^)(@$#&)(*@(!^#@&--!";
	private static final String VALUE_IDENTIFIER_START = "!--value@)#()*@()@#()&$*(&($@)#(--!";
	private static final String VALUE_IDENTIFIER_CLOSE = "!--value*#@(*(@#*()$@)(#$*)@#(#*#&$&@(*--!";

	private static File file = new File(DOWNLOADS + "paint_storage" + ".txt");
	
	public Storage(){
		if(!file.exists()){
			try{ file.createNewFile(); }catch(Exception e) { }
		}
	}
	
	public static String get(String key){
		if(!key_exists(key)) { return null; }
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			StringBuilder sb = new StringBuilder();
			String line = "";
			while((line = br.readLine()) != null){
				if(line.equals(KEY_IDENTIFIER+key)){
					br.readLine();
					while((line = br.readLine()) != null && !line.equals(VALUE_IDENTIFIER_CLOSE)){
						 sb.append(line);
					}
				}
			}
			br.close();
			return sb.toString();
		}catch(Exception e) { return null; }
	}
	
	public static void put(String key, String value){
		if(key_exists(key)){
			remove(key);
		}
		
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter(file,KEEP_EXIST));
			bw.write(KEY_IDENTIFIER+key);
			bw.newLine();
			bw.write(VALUE_IDENTIFIER_START);
			bw.newLine();
			bw.write(value);
			bw.newLine();
			bw.write(VALUE_IDENTIFIER_CLOSE);
			bw.newLine();
			bw.close();
		}catch(Exception e) { }
		
	}
	
	public static void remove(String key){
		if(!key_exists(key)) { return; }
		try{
			
			File temp = File.createTempFile(file.getName(), ".tmp");
			BufferedReader br = new BufferedReader(new FileReader(file));
			BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
			String line = "";
			while((line = br.readLine()) != null){
				if(line.equals(KEY_IDENTIFIER+key)){ // start toggle over
					while((line = br.readLine()) != null && !line.equals(VALUE_IDENTIFIER_CLOSE)){
						 br.readLine();
					}
				}else{
					bw.write(line);
					bw.newLine();
				}
				
			}
			temp.renameTo(file);
			bw.close();
			br.close();
		}catch(Exception e) {  }
	}
	
 	public static boolean key_exists(String key){
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			while((line = br.readLine())!=null){
				if(line.equals(KEY_IDENTIFIER+key)){
					br.close();
					return true;
				}
			}
			br.close();
			return false;
		}catch(Exception e) { e.printStackTrace(); return false; }
	}
	
	
}
