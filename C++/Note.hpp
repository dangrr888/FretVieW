#ifndef GUARD_NOTE_H
#define GUARD_NOTE_H

//struct to contain data on positions and names of specific notes on the fretboard

#include <vector>
#include <string>
#include <iostream>

class Note
{
  friend void plotter(const Note&, std::vector<std::vector<int> >&, int);

public:
  static Note Ab(); //static member functions to return Note object for specific notes
  static Note A();
  static Note As();
  static Note Bb();
  static Note B();
  static Note Bs();
  static Note Cb();
  static Note C();
  static Note Cs();
  static Note Db();
  static Note D();
  static Note Ds();
  static Note Eb();
  static Note E();
  static Note Es();
  static Note Fb();
  static Note F();
  static Note Fs();
  static Note Gb();
  static Note G();
  static Note Gs();

  Note(const std::string& s) //implicit conversion from string to a Note 
  {
    *this = Note::strToNote(s);
  }

  static bool valid_key(const std::string&); //checks whether string is a valid name for a note
  std::string name() const {return n;} //returns name of note
  std::string alias() const {return a;} //returns alias of note

private:
  explicit Note(const std::string& noteName, const std::string& altName, const std::vector<int>& f) //private constructor to prevent ceation of new notes
    : n(noteName), a(altName), frets(f) {}

  static Note strToNote(const std::string&); //implementation function called by Note::Note(const string&)

  std::string n; //note name
  std::string a; //note alias
  std::vector<int> frets; //vector containing fret numbers for specific note
};

#endif
