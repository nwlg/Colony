/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.pode.indexador.negocio.servicios.busqueda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.apache.log4j.Logger;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.ScoreDocComparator;
import org.apache.lucene.search.SortComparatorSource;
import org.apache.lucene.search.SortField;

/**
 * Custom alphabetical sorter
 * White spaces and empty entries at the end
 *
 * @author Fernando Garcia
 */
public class AlphabeticalSortComparatorSource implements SortComparatorSource {

    private static final Logger logger = Logger.getLogger(AlphabeticalSortComparatorSource.class);


    public ScoreDocComparator newComparator(final IndexReader reader, final String str) throws IOException {

        return new ScoreDocComparator() {
            public int compare(ScoreDoc scoreDoc1, ScoreDoc scoreDoc2) {
                try {
                    final Document doc1 = reader.document(scoreDoc1.doc);
                    final Document doc2 = reader.document(scoreDoc2.doc);
                    final String strVal1 = doc1.get(str).trim();
                    final String strVal2 = doc2.get(str).trim();

                    if (strVal1.equals("")) return -1;
                    if (strVal2.equals("")) return 1;

                    int result = strVal1.compareTo(strVal2);

                    if (result == 0) {
                       // logger.debug("---- They are EQUAL");
                         return 1; //equals but don't send a cero
                    }
                    else if (result > 0) {
                       // logger.debug("---- strVal2>strVal1");
                         return -1;
                            //2 before that 1
                    }
                    else if (result < 0) {
                      //  logger.debug("---- strVal1>strVal2");
                        return 1;
                         //1 before that 2
                    }
                } catch (IOException e) {
                    logger.error("(AlphabeticalSortComparatorSource)...newComparator : Cannot reading lucene index", e);
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
