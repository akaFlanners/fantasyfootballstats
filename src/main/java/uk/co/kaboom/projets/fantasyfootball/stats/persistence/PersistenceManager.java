package uk.co.kaboom.projets.fantasyfootball.stats.persistence;

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

     private static final Logger LOG = LoggerFactory.getLogger(PersistenceManager.class);

     private final String persistencePath;

     public PersistenceManager(String path) {
          this.persistencePath = path;
     }

     public void persistToFile(final String dataToPersist) {
          try {
               Path target = Paths.get(persistencePath);

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
               LOG.error("Problem creating path or file or directory: " + persistencePath);
               e.printStackTrace();
          }
          catch (SecurityException e) {
               LOG.error("Security violation detected with: " + persistencePath);
               e.printStackTrace();
          }
     }

}
