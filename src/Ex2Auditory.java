public class Ex2Auditory implements Comparable {
    
    public int compareTo(Object o) {
        Ex2Auditory auditory = (Ex2Auditory) o;
        return (this.begin < auditory.begin ? -1:1);
    }

    int begin, end;
    Ex2Auditory(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

}
