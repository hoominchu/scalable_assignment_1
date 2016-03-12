import java.io.File;

public class p3 {

	public static void main (String args[]){

		printAllFilesInDirectory(args[0]);
		
	}

	public static void printAllFilesInDirectory(String path){
		File directoryPath = new File(path);
		File[] allPaths = directoryPath.listFiles();

		for(int i=0; i<allPaths.length;i++){
			if (allPaths[i].isDirectory()){
				int numberOfAllFiles = countAllFiles(allPaths[i].toString(),0);
				int numberOfDirectFiles = countDirectFiles(allPaths[i].toString());
				System.out.println(numberOfAllFiles + " " + numberOfDirectFiles + " " + " d " + allPaths[i]);
				printAllFilesInDirectory(allPaths[i].toString());
			}
			else{
				System.out.println("0 0 f " + allPaths[i]);
			}
		}
	}

	public static int countAllFiles(String path, int numberOfFilesInParentDirectory){
		File directory = new File(path);
		File[] allPaths = directory.listFiles();

		int numberOfDirectFiles=0, numberOfTotalFiles=numberOfFilesInParentDirectory, numberOfDirectories=0;

		for(int i=0; i<allPaths.length;i++){
			if(allPaths[i].isDirectory()==false){
				numberOfDirectFiles++;
			}
		}

		numberOfTotalFiles=numberOfFilesInParentDirectory+numberOfDirectFiles;

		for(int i=0; i<allPaths.length;i++){
			if (allPaths[i].isDirectory()) {
				numberOfTotalFiles = countAllFiles(allPaths[i].toString(),numberOfTotalFiles);
			}
		}

		return (numberOfTotalFiles);
	}

	public static int countDirectFiles(String path){
		File directory = new File(path);
		File[] allPaths = directory.listFiles();

		int numberOfDirectFiles=0, numberOfTotalFiles=0, numberOfDirectories=0;

		for(int i=0; i<allPaths.length;i++){
			if(allPaths[i].isDirectory()==false){
				numberOfDirectFiles++;
			}
		}

		return numberOfDirectFiles;
	}
}