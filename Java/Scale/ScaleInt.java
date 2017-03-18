package Scale;
import Scale.Note.*;

interface ScaleInt
{
    void add(Note n);
    void remove(Note n);
    void clear();
    int num_notes();
    void display(int num_frets);
}