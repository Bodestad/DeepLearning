package SAR;

import org.datavec.api.util.ClassPathResource;
import org.deeplearning4j.models.embeddings.inmemory.InMemoryLookupTable;
import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.plot.BarnesHutTsne;
import org.deeplearning4j.text.sentenceiterator.BasicLineIterator;
import org.deeplearning4j.text.sentenceiterator.FileSentenceIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.CommonPreprocessor;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Gustav Bodestad.
 * 2017-02-06.
 */
public class Main {



    private static Logger log = LoggerFactory.getLogger(Word2VecSAR.class);

    public static void main(String[] args) throws Exception {

        // Gets Path to Text file
        // text file generated from chinese posts "", e.g. words detected by stanfords word parser
        // each post gets one line in the document
        // one document represents one forum
        String filePath = new ClassPathResource("PI_worker_issues_all_Word2Vec.txt").getFile().getAbsolutePath();

        log.info("Load & Vectorize Sentences....");
        // Strip white space before and after for each line
//        SentenceIterator iter = new BasicLineIterator(filePath);
        SentenceIterator iter = new FileSentenceIterator(new File(filePath));

        // Split on white spaces in the line to get words
        TokenizerFactory t = new DefaultTokenizerFactory();

        /*
            CommonPreprocessor will apply the following regex to each token: [\d\.:,"'\(\)\[\]|/?!;]+
            So, effectively all numbers, punctuation symbols and some special symbols are stripped off.
            Additionally it forces lower case for all tokens.
         */
        t.setTokenPreProcessor(new CommonPreprocessor());
// stop words remover StopWordsRemover.loadDefaultStopWords(language)
        //import org.apache.spark.ml.feature.StopWordsRemover;
        log.info("Building model....");

        //for (int i = 0; i < 5; i++) {

        Word2Vec vec = new Word2Vec.Builder()
                .minWordFrequency(1)
                .iterations(1)
                .layerSize(50)
                .seed(42)
                .windowSize(3)// 3 or 2 seems to work best for this case
                .iterate(iter)
                .tokenizerFactory(t)
                .build();

        //log.info("Fitting Word2Vec model with i=" + i + " ....");
        //System.out.println("Fitting Word2Vec model with i=" + i + " ....");
        vec.fit();

        log.info("Writing word vectors to text file....");

        // Write word vectors to file
        WordVectorSerializer.writeWordVectors(vec, "pathToWriteto.txt");

        // Prints out the closest 10 words to "day". An example on what to do with these Word Vectors.
        log.info("Closest Words to issues:");
        Collection<String> lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("?", 5);
        System.out.println("5 Words closest to '?': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("???", 5);
        System.out.println("5 Words closest to '???': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("?", 5);
        System.out.println("5 Words closest to '?': " + lst);
        lst = vec.wordsNearest("?", 5);
        System.out.println("5 Words closest to '?': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("?", 5);
        System.out.println("5 Words closest to '?': " + lst);
        lst = vec.wordsNearest("???", 5);
        System.out.println("5 Words closest to '???': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);
        lst = vec.wordsNearest("??", 5);
        System.out.println("5 Words closest to '??': " + lst);

        //UiServer server = UiServer.getInstance();
        //System.out.println("Started on port " + server.getPort());

        //trying tsne-kod without really understanding it!!
        // } //for-loop

        BarnesHutTsne tsne = new BarnesHutTsne.Builder()
                .theta(0.5).learningRate(1000).setMaxIter(300) //setMaxIter(1000)
                .build();
        //log.info("Loading word vectors");
        //Word2Vec vec = WordVectorSerializer.loadGoogleModel(new File(args[0]), true,true);
        //log.info("Loaded word vectors");
        InMemoryLookupTable table = (InMemoryLookupTable) vec.lookupTable();
        //tsne.plot(table.getSyn0(),2,new ArrayList<>(vec.vocab().words()));
        tsne.fit(table.getSyn0());
        tsne.saveAsFile(new ArrayList<>(vec.vocab().words()), "SARCSV_PI_worker_issues_all.csv");


    }


}
