import java.io.File;

public class p1 {

	public static void main (String args[]){

		printAllFilesInDirectory(args[0]);
		
	}

	public static void printAllFilesInDirectory(String path){
		File directoryPath = new File(path);
		File[] allPaths = directoryPath.listFiles();

		for(int i=0; i<allPaths.length;i++){
			if (allPaths[i].isDirectory()){
				printAllFilesInDirectory(allPaths[i].toString());
				System.out.println("d " + allPaths[i]);
			}
			else{
				System.out.println("f " + allPaths[i]);
			}
		}
	}
}