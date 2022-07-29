package solutions;

/*
Необходимо отсортировать csv-файл по первому полю, можно считать, что оно целочисленное.
 Первое поле (ключ) может иметь не уникальное значение. Длинны каждой из строк могут отличаться.
 Привести два решения.

 */

import java.io.*;
import java.util.*;


class sortFID implements Comparable<sortFID> {
    private int FID;
    private int start;
    private int end;

    public sortFID(int FID, int start, int end) {
        this.FID = FID;
        this.start = start;
        this.end = end;
    }
    public String toString() {
        return "{FID:"+FID+" ;start:"+start+" ;end:"+end+"}";
    }

    public int getFID() {
        return FID;
    }
    public int getStart() {
        return start;
    }
    public int getEnd() {
        return end;
    }

    @Override
    public int compareTo(sortFID anotherObject) {
        return Integer.compare(this.getFID(), anotherObject.getFID());
    }
}

public class Task4 {


    public static void sortSmallCSV(String path) throws IOException {
        InputStream inputStream = new FileInputStream(path);
        List<List<String>> lines = readCsv(inputStream);
        Comparator<List<String>> comparator = createComparator(0, 1);
        lines.sort(comparator);
        OutputStream outputStream = new FileOutputStream("sortedSmallCSV.csv");
        String header = "FID;SERIAL_NUM;MEMBER_CODE;ACCT_TYPE;OPENED_DT;ACCT_RTE_CDE;REPORTING_DT;CREDIT_LIMIT";
        writeCsv(header, lines, outputStream);
    }


    private static void writeCsv(
            String header, List<List<String>> lines, OutputStream outputStream)
            throws IOException {
        Writer writer = new OutputStreamWriter(outputStream);
        writer.write(header);
        for (List<String> list : lines) {
            for (int i = 0; i < list.size(); i++) {
                writer.write(list.get(i));
                if (i < list.size() - 1) {
                    writer.write(";");
                }
            }
            writer.write("\n");
        }
        writer.close();

    }

    private static List<List<String>> readCsv(
            InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream));
        List<List<String>> lines = new ArrayList<List<String>>();

        // Skip header
        String line = reader.readLine();

        while (true) {
            line = reader.readLine();
            if (line == null) {
                break;
            }
            List<String> list = Arrays.asList(line.split(";"));
            lines.add(list);
        }
        return lines;
    }

    private static <T extends Comparable<? super T>> Comparator<List<T>>
    createComparator(int... indices) {
        return createComparator(Task4.<T>naturalOrder(), indices);
    }

    private static <T extends Comparable<? super T>> Comparator<T>
    naturalOrder() {
        return new Comparator<T>() {
            @Override
            public int compare(T t0, T t1) {
                return t0.compareTo(t1);
            }
        };
    }

    private static <T> Comparator<List<T>> createComparator(
            final Comparator<? super T> delegate, final int... indices) {
        return new Comparator<List<T>>() {
            @Override
            public int compare(List<T> list0, List<T> list1) {
                for (int i = 0; i < indices.length; i++) {
                    T element0 = list0.get(indices[i]);
                    T element1 = list1.get(indices[i]);
                    int n = delegate.compare(element0, element1);
                    if (n != 0) {
                        return n;
                    }
                }
                return 0;
            }
        };
    }


    public static void sortCSVBig(String path) throws IOException {
        List<sortFID> csv = new ArrayList<>();
        int FID = 0;
        int byteCount = 1;
        boolean seanStartOnce = false;
        StringBuilder numberString = new StringBuilder();
        int intervalStart = 0;
        int intervalEnd;

        //Reading csv
        try (InputStream inpStr = new FileInputStream(path);) {
            while (true) {
                int byteRead = inpStr.read();
                if (byteRead == -1) {
                    break;
                } //exit if end of file
                char charRead = (char) byteRead;
                if (charRead == ';' && !seanStartOnce) {
                    FID = Integer.parseInt(numberString.toString());
                    intervalStart = byteCount - numberString.length();
                    seanStartOnce = true;
                }
                if ((char) byteRead == '\n') {
                    intervalEnd = byteCount;
                    csv.add(new sortFID(FID, intervalStart, intervalEnd));
                    numberString = new StringBuilder();
                    seanStartOnce = false;
                    byteCount++;
                    continue;
                }
                if (!seanStartOnce) numberString.append(charRead);
                byteCount++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        //Sorting csv
        Comparator<sortFID> fidComparator = Comparator.comparing(sortFID::getFID);
        csv.sort(fidComparator);

        //Writing csv
        String outputName = "sortedBigCSV.csv";
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try (OutputStream outputFile = new FileOutputStream(outputName)) {
            int i = 0;
            do {
                if (csv.size() == i) break;
                sortFID csv_i = csv.get(i);
                byte[] rowBuffer = new byte[csv_i.getEnd() - csv_i.getStart()];
                InputStream inputStr = new FileInputStream(path);
                inputStr.skipNBytes(csv_i.getStart() - 1);
                if (inputStr.read(rowBuffer) == -1) break;
                byte[] newLine = "\n".getBytes();
                output.write(rowBuffer);
                output.write(newLine);
                outputFile.write(output.toByteArray(), 0, output.toByteArray().length);
                output.reset();
                i++;
            } while (true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
