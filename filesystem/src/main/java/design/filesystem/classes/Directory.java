package design.filesystem.classes;

import java.util.ArrayList;
import java.util.List;

import design.filesystem.interfaces.FileSystemEntity;

public class Directory implements FileSystemEntity {
	
	private String name; 
	private List<FileSystemEntity> contents; 
	
	public Directory(String name) {
		this.name = name; 
		this.contents = new ArrayList<>();
	}
	
	public void addEntity(FileSystemEntity entity) {
		contents.add(entity);
	}

	@Override
	public long getSize() {
		long totalSize = 0;
		for(FileSystemEntity entity : contents) {
			totalSize += entity.getSize();
		}
		return totalSize;
	}

}
