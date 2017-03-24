package MissingLoanDocuments;

import java.io.*;
import java.util.*;

public class MissingLoanDocumentsImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fn = "D:\\EclipseWorkspace\\Learning\\src\\BlendLabsCodingChallenge\\input001.txt";
		//String fn = args[0];
		String line;
		Map<String, ArrayList<String>> appDocsMap = new HashMap<String, ArrayList<String>>();
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
					ArrayList<String> docsList = new ArrayList<String>();
					docsList.addAll(appDocsMap.get(arr[3]));
					docsList.add(arr[2]);
					appDocsMap.put(arr[3], docsList);
				}
				else {
					ArrayList<String> docsList = new ArrayList<String>();
					docsList.add(arr[2]);
					appDocsMap.put(arr[3],docsList);
				}
			}
			br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		MissingLoanDocumentsImplementation mldi = new MissingLoanDocumentsImplementation();
		List<String> docTypesList = new ArrayList<String>();
		docTypesList.addAll(docTypes);
		Collections.sort(docTypesList);
		mldi.findMissingDocTypes(appDocsMap, docTypesList);
		/*for (String s : appDocsMap.keySet()){
			System.out.println(s+": "+appDocsMap.get(s));
		}*/
	}
	
	public void findMissingDocTypes(Map<String, ArrayList<String>> appDocsMap, List<String> docTypesList ) {
		Map<String, ArrayList<String>> docIDMap = new HashMap<String, ArrayList<String>>();
		for(String docType: docTypesList) {
			for (String appId: appDocsMap.keySet()) {
				if (docTypeNotFound(docType, appDocsMap.get(appId))){
					if (docIDMap.containsKey(docType)){
						ArrayList<String> idList = new ArrayList<String>();
						idList.addAll(docIDMap.get(docType));
						idList.add(appId);
						docIDMap.put(docType, idList);
					}
					else {
						ArrayList<String> idList = new ArrayList<String>();
						idList.add(appId);
						docIDMap.put(docType, idList);
					}
				}
			}
		}
		printOutput(docIDMap, docTypesList);
	}
	
	public boolean docTypeNotFound(String docType, List<String> docTypes) {
		
		boolean flag = true;
		for(String doc: docTypes){
			if (doc.equals(docType)){
				flag = false;
				return flag;
			}
		}
		return flag;
	}
	
	public void printOutput(Map<String, ArrayList<String>> docIDMap, List<String> docTypesList) {
		for (String doc : docTypesList){
			ArrayList<String> idList = new ArrayList<String>();
			idList.addAll(docIDMap.get(doc));
			Collections.sort(idList);
			System.out.println(doc);
			for(String id: idList){
				System.out.print(id+" ");
			}
			System.out.println();
		}
	}
}
