package Scale;
import Scale.Note.*;

interface FretBoardInt
{
    void add(Note n);
    void remove(Note n);
    void clear();

    int num_notes();
    void display_notes();
    void display_grid(int num_frets);
}