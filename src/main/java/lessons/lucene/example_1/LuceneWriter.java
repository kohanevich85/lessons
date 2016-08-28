package lessons.lucene.example_1;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;

public class LuceneWriter {
    String pathToIndex = "";
    IndexWriter indexWriter = null;

    private LuceneWriter() {
    }

    public LuceneWriter(String pathToIndex) {
        this.pathToIndex = pathToIndex;
    }

    public boolean openIndex(){
        try {
            //Open the directory so lucene knows how to deal with it
            Directory dir = FSDirectory.open(Paths.get(pathToIndex));
            //Chose the analyzer we are going to use to write documents to the index. We need to specify the version
            //of the Lucene index type we want to use
            //Create an index writer configuration. Same thing here with the index version
            IndexWriterConfig iwc = new IndexWriterConfig();
            //we are always going to overwrite the index that is currently in the directory
            iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
            //let's open that index and get a writer to hand back to the main code
            indexWriter = new IndexWriter(dir, iwc);
            return true;
        } catch (Exception e) {
            System.out.println("Threw an exception trying to open the index for writing: " + e.getClass() + " :: " + e.getMessage());
            return false;
        }
    }

    public void addPark(Park park){
        Document doc = new Document();
        doc.add(new TextField("name", park.getname(), Field.Store.YES));
        doc.add(new StoredField("coordinates", park.getPos().toString()));
        try {
            indexWriter.addDocument(doc);
        } catch (IOException ex) {
            System.out.println("Threw an exception trying to add the doc: " + ex.getClass() + " :: " + ex.getMessage());
        }
        System.out.println( park.getname() );
    }

    public void finish(){
        System.out.println("about to close the writer");
        try {
            //commit the document to the index
            indexWriter.commit();
            //now close it off and release the lock
            indexWriter.close();
        } catch (IOException ex) {
            System.out.println("We had a problem closing the index: " + ex.getClass() + " :: " + ex.getLocalizedMessage());
        }
    }
}
