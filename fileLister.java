import java.io.File;

public class fileLister {

	static String[] TYPES = new String[]{"jpg", "png", "gif", "mp4", "mp3", "exe", "psd", "html", "xml", "pdf", "class", "java"};
	static int[] typeCountArray = new int[TYPES.length];

	public static void main (String args[]){

		File f = new File("fileLister.java");

		String filePath = f.getAbsolutePath();
		String homeDirectoryPath = filePath.substring(0,filePath.lastIndexOf('/'));  //Gets the path of home directory by ignoring the filename in filePath. 

		getTypesCount(homeDirectoryPath);

		printTypesCount();
		
		printAllFilesInDirectory(homeDirectoryPath);
		
	}

	//Gets the extension of a file given a filePath as the argument. 
	public static String getExtension(String filePath){
		int indexOfDot = filePath.lastIndexOf('.');
		String extension = filePath.substring(indexOfDot+1);
		extension = extension.toLowerCase();
		return extension;
	}

	//Prints typesCount array. 
	public static void printTypesCount(){
		for (int i=0; i<TYPES.length; i++){
			System.out.println(TYPES[i] + " " + typeCountArray[i]);
		}
	}

	//Counts the number of files of each type specified in TYPES array. 
	public static void getTypesCount(String path){
		File directoryPath = new File(path);
		File[] allPaths = directoryPath.listFiles();

		for (int j=0; j<allPaths.length; j++){	
			if (allPaths[j].isDirectory()==false){
				String extension = getExtension(allPaths[j].toString());
				
			for (int i=0; i<TYPES.length; i++){
				if(extension.equals(TYPES[i])){
					typeCountArray[i]++;
					break;
						}
					}
				}	
				else {
					getTypesCount(allPaths[j].toString());
				}
	}
	}

	//Prints all the files in a directory given the path of a directory. 
	public static void printAllFilesInDirectory(String path){
		File directoryPath = new File(path);
		File[] allPaths = directoryPath.listFiles();

		for(int i=0; i<allPaths.length;i++){
			if (allPaths[i].isDirectory()){
				int numberOfAllFiles = countAllFiles(allPaths[i].toString(),0);
				int numberOfDirectFiles = countDirectFiles(allPaths[i].toString());
				System.out.println(numberOfAllFiles + " " + numberOfDirectFiles + " d " + allPaths[i]);
				printAllFilesInDirectory(allPaths[i].toString());
			}
			else{
				System.out.println("0 0 f " + allPaths[i]);
			}
		}
	}

	//Counts the number of all files in a directory including the ones that are not directly under it. Give the arguments path of a directory and 0.
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

		return numberOfTotalFiles;
	}

	//Counts the number of files directly under a directory given the path of a directory. 
	public static int countDirectFiles(String path){
		File directory = new File(path);
		File[] allPaths = directory.listFiles();

		int numberOfDirectFiles=0;

		for(int i=0; i<allPaths.length;i++){
			if(allPaths[i].isDirectory()==false){
				numberOfDirectFiles++;
			}
		}

		return numberOfDirectFiles;
	}
}