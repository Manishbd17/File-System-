package design.filesystem;

import design.filesystem.classes.Directory;
import design.filesystem.classes.File;

/**
 * Hello world!
 *
 */
public class FileSystem 
{
    public static void main( String[] args )
    {
        File file1 = new File("file1.txt",500);
        File file2 = new File("file2.txt",300); 
        
        Directory directory1 = new Directory("documents");
        directory1.addEntity(file1);
        directory1.addEntity(file2);
        
        File file3 = new File("file3.txt",700);
        Directory rootDirectory = new Directory("rootDirectory");
        rootDirectory.addEntity(directory1);
        rootDirectory.addEntity(file3);
        
        System.out.println("Total Size of directory " + rootDirectory.getSize());
        
    }
}
