package design.filesystem.classes;

import design.filesystem.interfaces.FileSystemEntity;

public class File implements FileSystemEntity {

	private String name; 
	private long size; 
	
	public File(String name,long size) {
		this.name=name; 
		this.size=size; 
	}
	
	@Override
	public long getSize() {
		
		return size ;
	}

}
