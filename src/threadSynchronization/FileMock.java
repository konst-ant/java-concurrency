package threadSynchronization;

/**
 * Created by kantipin on 19.04.2016.
 */
public class FileMock {

    private String content[];
    int index;

    public FileMock(int lines, int bufferSize) {
        content = new String[lines];
        for (int i = 0; i < lines; i++) {
            StringBuffer buf = new StringBuffer(bufferSize);
            for(int j=0; j<bufferSize; j++) {
                int indice = (int)Math.random()*255;
                buf.append((char)indice);
            }
            content[i] = buf.toString();
        }
        index=0;
    }

    public boolean hasMoreLines() {
        return (index < content.length);
    }

    public String getLine() {
        if (hasMoreLines()) {
            System.out.println("MockFile: producing line " + (index+1));
            return content[index++];
        }
        return null;
    }
}
