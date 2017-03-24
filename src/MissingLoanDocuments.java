import java.io.*;
import java.util.*;

public class MissingLoanDocuments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String fn = "C:\\Users\\arunp\\Downloads\\BlendLabsCodingChallenge\\input002.txt";
		String fn = args[0];
		String line;
		Map<String, String> appDocsMap = new HashMap<String, String>();
		Set<String> docTypes = new HashSet<String>();
		try {
			FileReader fileReader = new FileReader(fn);
			BufferedReader br = new BufferedReader(fileReader);
			/** Leaving File Header aside. */
			br.readLine();
			while((line = br.readLine()) != null){
				String[] arr = line.split(",");
				docTypes.add(arr[2]);
				if(appDocsMap.containsKey(arr[3])){
					appDocsMap.put(arr[3],(appDocsMap.get(arr[3])+","+(arr[2])));
				}
				else {
					appDocsMap.put(arr[3],arr[2]);
				}
			}
			br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		ImplementListOfHashMaps ilhm = new ImplementListOfHashMaps();
		ilhm.findMissingDocTypes(appDocsMap, docTypes);
		/*for (String s : appDocsMap.keySet()){
			System.out.println(s+": "+appDocsMap.get(s));
		}*/
	}
	
	public void findMissingDocTypes(Map<String, String> appDocsMap, Set<String> docTypes ) {
		Map<String, String> docIDMap = new HashMap<String, String>();
		List<String> docTypesList = new ArrayList<String>();
		docTypesList.addAll(docTypes);
		Collections.sort(docTypesList);
		for(String docType: docTypesList) {
			for (String appId: appDocsMap.keySet()) {
				if (docTypeNotFound(docType, appDocsMap.get(appId))){
					if (docIDMap.containsKey(docType)){
						docIDMap.put(docType, (docIDMap.get(docType)+","+appId));
					}
					else {
						docIDMap.put(docType, appId);
					}
				}
			}
		}
		printOutput(docIDMap, docTypesList);
	}
	
	public boolean docTypeNotFound(String docType, String docTypes) {
		String [] docs = docTypes.split(",");
		boolean flag = true;
		for(String doc: docs){
			if (doc.equals(docType)){
				flag = false;
				return flag;
			}
		}
		return flag;
	}
	
	public void printOutput(Map<String, String> docIDMap, List<String> docTypesList) {
		for (String doc : docTypesList){
			String[] ids = docIDMap.get(doc).split(",");
			Arrays.sort(ids);
			System.out.println(doc);
			for(String id: ids){
				System.out.print(id+" ");
			}
			System.out.println();
		}
	}
}
