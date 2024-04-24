package SourabhMishra.data;



import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;






public class dataReader {

	public  List<HashMap<String, String>> getJesonDataToMap() throws IOException {
		//read json to string
	
	String jsonContent = FileUtils.readFileToString(new File ("C:\\Software\\eclips_workspace\\seleniumMavenFrameworkDesign\\src\\test\\java\\SourabhMishra\\data\\purchaseOrder.json"), StandardCharsets.UTF_8);
	ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		
	return data;
}}
