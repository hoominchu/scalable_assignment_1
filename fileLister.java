import java.io.File;

public class fileLister {

	static String[] TYPES = new String[]{"jpg", "png", "gif", "mp4", "mp3", "exe", "psd", "html", "xml", "pdf", "class", "java"};
	static int[] typeCountArray = new int[TYPES.length];

	public static void main (String args[]){

		File f = new File("fileLister.java");

		String filePath = f.getAbsolutePath();
		String homeDirectoryPath = filePath.substring(0,filePath.lastIndexOf('/'));  //Gets the path of home directory by ignoring the filename in filePath. 

		printAllFilesInDirectory(homeDirectoryPath);
		
	}

	//Prints all the files in a directory given directory path. 
	public static void printAllFilesInDirectory(String path){
		File directoryPath = new File(path);
		File[] allPaths = directoryPath.listFiles();

		for(int i=0; i<allPaths.length;i++){
			if (allPaths[i].isDirectory()){
				System.out.println("d " + allPaths[i]);
				printAllFilesInDirectory(allPaths[i].toString());
			}
			else{
				System.out.println("f " + allPaths[i]);
			}
		}
	}
}