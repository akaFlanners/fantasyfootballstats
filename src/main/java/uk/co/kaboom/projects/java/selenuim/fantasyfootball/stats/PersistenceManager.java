package uk.co.kaboom.projects.java.selenuim.fantasyfootball.stats;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersistenceManager {
	
	private static final Logger logger = LoggerFactory.getLogger(PersistenceManager.class);

	String PERSISTENCE_PATH;
	
	public PersistenceManager(String path) {
		this.PERSISTENCE_PATH = path;
	}
	
	public void persistToFile(String dataToPersist) {
		try {
			Path target = Paths.get(PERSISTENCE_PATH);
			
			if(Files.notExists(target)) {
				if(Files.notExists(target.getParent())) {
					Files.createDirectories(target.getParent());
				}
				target = Files.createFile(target);
			}

			//writer.close() will be called automatically via AutoClosable interface.
			try (BufferedWriter writer = Files.newBufferedWriter(target, StandardCharsets.UTF_8, StandardOpenOption.WRITE)) { 
				writer.write(dataToPersist);
			}
		}
		catch (IOException | InvalidPathException e) {
			logger.error("Problem creating path or file or directory: " + PERSISTENCE_PATH);
			e.printStackTrace();
		}
		catch (SecurityException e) {
			logger.error("Security violation detected with: " + PERSISTENCE_PATH);
			e.printStackTrace();
		}
	}
	
	
	
}
