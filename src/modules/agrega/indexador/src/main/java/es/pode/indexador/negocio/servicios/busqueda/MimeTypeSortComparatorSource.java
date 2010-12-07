/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.pode.indexador.negocio.servicios.busqueda;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.ScoreDocComparator;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.SortComparatorSource;

/**
 *
 * @author build
 */
public class MimeTypeSortComparatorSource implements SortComparatorSource {

    public static String PRIORITYLISTITEM = "mimetypesortcomparatorsource.item";
    public static String PROPSFILE = "/indexador.properties";
    private static final Logger logger = Logger.getLogger(MimeTypeSortComparatorSource.class);


    private HashMap<String,Integer> priorities = new HashMap<String,Integer>(30);
    private Properties props;

    private void loadPriorities(){

    }

    public MimeTypeSortComparatorSource() {
        //open properties file
        try {
        props = new Properties();

        java.io.InputStream is = this.getClass().getResourceAsStream(
		PROPSFILE);
        props.load(is);
        is.close();
        } catch (IOException ioe) {
            logger.error("Cannot find [["+ PROPSFILE +"]] with the sorting comparator properties!!!");
        }

        //load priority list
        int i=1;
        String priorityitem = props.getProperty(PRIORITYLISTITEM+i);
        while (priorityitem!=null){
            priorities.put(priorityitem, i++);
            priorityitem = props.getProperty(PRIORITYLISTITEM+i);
        }

    }


    public ScoreDocComparator newComparator(final IndexReader reader, final String str) throws IOException {

        return new ScoreDocComparator() {
            public int compare(ScoreDoc scoreDoc1, ScoreDoc scoreDoc2) {
                try {
                    final Document doc1 = reader.document(scoreDoc1.doc);
                    final Document doc2 = reader.document(scoreDoc2.doc);

                    String[] formatsDoc1 = doc1.getValues("formato");
                    String[] formatsDoc2 = doc2.getValues("formato");

                    if (formatsDoc1==null || formatsDoc1.length==0 ) return 1;
                    if (formatsDoc2==null || formatsDoc2.length==0 ) return -1;


                    String[] stringsToLookFor = priorities.keySet().toArray(new String[]{});
                    
                    ArrayList<String> doc1Founds = new ArrayList<String>();
                    if (formatsDoc1.length>0) {
                        for (int i=0;i<stringsToLookFor.length;i++) { //all formats
                            int j=0;
                            while (j<formatsDoc1.length && formatsDoc1[j].trim().indexOf(stringsToLookFor[i].trim())==-1
                                    ){
                                j++;
                            }
                            if (j>0) j--;
                            if (formatsDoc1[j].trim().indexOf(stringsToLookFor[i].trim())>-1 ) {
                                doc1Founds.add(stringsToLookFor[i]);
                                logger.debug("DOC1 added "+stringsToLookFor[i]);
                            }
                        }
                    }

                    ArrayList<String> doc2Founds = new ArrayList<String>();
                    if (formatsDoc2.length>0) {
                        for (int i=0;i<stringsToLookFor.length;i++) { //all formats
                            int j=0;
                            while (j<formatsDoc2.length && formatsDoc2[j].trim().indexOf(stringsToLookFor[i].trim())==-1
                                    ){
                                j++;

                            }
                            if (j>0) j--;
                            if (formatsDoc2[j].trim().indexOf(stringsToLookFor[i].trim())>-1 ) {
                                doc2Founds.add(stringsToLookFor[i]);
                               logger.debug("DOC2 added "+stringsToLookFor[i]);
                            }
                        }
                    }

                    ///
                    /// Warning! Highest priority means minimun number
                    ///

                    //We have in doc1Founds and doc2Founds all information to analyze
                    //first comparation is the highest priority term
                    // if equal
                    //    second comparation about the size (less terms)... less size higher priority

                    //looking for highest level in both docs
                    int highestlevelDoc1 = Integer.MAX_VALUE;
                    for (String term: doc1Founds){
                        if (priorities.containsKey(term) && priorities.get(term)< highestlevelDoc1 ){
                            highestlevelDoc1 = priorities.get(term);
                        }
                    }

                    int highestlevelDoc2 = Integer.MAX_VALUE;
                    for (String term: doc2Founds){
                        if (priorities.containsKey(term) && priorities.get(term)< highestlevelDoc2 ){
                            highestlevelDoc2 = priorities.get(term);
                        }
                    }

                    
                    if (highestlevelDoc1<highestlevelDoc2) { //doc1 wins
                        return -1;
                    } else
                    if (highestlevelDoc1>highestlevelDoc2) { //doc2 wins
                        return 1;
                    } else { //equal level ... so second comparation
                        if (formatsDoc1.length>formatsDoc2.length){ //doc2 wins
                            return 1;
                        } else {        //doc1 wins if equal or with less formats
                            return -1;
                        }

                    }

                } catch (IOException e) {
                    logger.error("(MimeTypeSortComparatorSource)...newComparator : Cannot reading lucene index", e);
                }
                return 0;
            }

            public Comparable sortValue(ScoreDoc scoreDoc) {
                return new Float(scoreDoc.doc);
            }

            public int sortType() {
                return SortField.STRING;
            }

        };


    }


}
