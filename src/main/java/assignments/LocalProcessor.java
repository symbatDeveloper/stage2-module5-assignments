package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 10_000_000_000_000L;
    private String ProcessorVersion;
    private Integer valueOfCheap;
   private Scanner informationScanner;
    private LinkedList<String> ArrayList = new LinkedList<>();
    private StringBuilder stringBuilder;

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationscanner, LinkedList<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        ProcessorVersion = processorVersion;
        if(informationScanner ==null){
        throw new IllegalStateException();
        }
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationscanner;
        ArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(LinkedList<String> stringList) {
       for(String string : stringList){
          if(string != null){
              string.hashCode();
          }
        }

    }

    @FullNameProcessorGeneratorAnnotation
    public String ProcessorGenerator(LinkedList<String> stringList) {
            stringBuilder = new StringBuilder();
            for(String str : stringList){
                stringBuilder.append(str).append(' ');
            }

        return stringBuilder.toString();
    }

    @ReadFullProcessorNameAnnotation
    public void Read(File file) throws FileNotFoundException {
            informationScanner = new Scanner(file);
        try {
            informationScanner = new Scanner(new File("test.txt"));
            while (informationScanner.hasNext()) {
                ProcessorVersion = String.valueOf(informationScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (informationScanner != null) {
                informationScanner.close();
            }
        }
    }
}
