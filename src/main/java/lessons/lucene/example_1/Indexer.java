package lessons.lucene.example_1;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.SimpleFSDirectory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Indexer {
    private IndexWriter writer;

    public Indexer(String indexDir) throws IOException {
        Directory dir = FSDirectory.open(Paths.get(indexDir));
        writer = new IndexWriter(dir, new IndexWriterConfig());
    }

    public void close() throws IOException {
        writer.close(); //4
    }

    public int index(String dataDir) throws Exception {
        Files.list(Paths.get(dataDir)).map(Path::toFile).filter(Indexer::acceptFile)
                .forEach(this::indexFile);
        return writer.numDocs(); //5
    }

    static boolean acceptFile(File f) {
        return !f.isDirectory() && !f.isHidden() && f.exists() && f.canRead() && f.getName().endsWith(".txt");
    }

    protected Document getDocument(File f) throws IOException {
        Document doc = new Document();
        doc.add(new Field("contents", new FileReader(f), new FieldType())); //7
        //doc.add(new Field("filename", f.getCanonicalPath(), Field.Store.YES, NOT_ANALYZED));//8
        return doc;
    }

    private void indexFile(File f) {
        try {
            System.out.println("Indexing " + f.getCanonicalPath());
            Document doc = getDocument(f);
            if (doc != null) {
                writer.addDocument(doc); //9
            }
        } catch (IOException e) {
            // TODO:
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            throw new Exception("Usage: java " + Indexer.class.getName()
                    + " <index dir> <data dir>");
        }
        String indexDir = args[0]; //1
        String dataDir = args[1]; //2
        long start = System.currentTimeMillis();
        Indexer indexer = new Indexer(indexDir);
        int numIndexed = indexer.index(dataDir);
        indexer.close();
        long end = System.currentTimeMillis();
        System.out.println("Indexing " + numIndexed + " files took "
                + (end - start) + " milliseconds");
    }
}
