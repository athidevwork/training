package org.training.patterns;

public class ClassicSingleton {
	private static ClassicSingleton instance = null;
	
	protected ClassicSingleton() {
		// Exists only to defeat instantiation.
	}
	
	public static ClassicSingleton getInstance() {
		if(instance == null) {
			synchronized(ClassicSingleton.class) {
				if (instance == null) 
					instance = new ClassicSingleton();
			}
		}
		return instance;
	}
}
