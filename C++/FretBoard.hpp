#ifndef GUARD_FRETBOARD_H
#define GUARD_FRETBOARD_H

//RAII class 

#include <tr1/memory>
#include "Note.hpp"
#include <vector>
#include <cstddef>
#include <iostream>
#include "FbImpl.hpp"

class FretBoard
{
  friend class Scale;
  friend class CustomScale;

public:
  void add(const Note&); //add note to current scale
  void remove(const Note&); //remove note from current scale
  void clear(); //clear all notes stored in current scale

  std::size_t num_notes() const; //returns number of notes stored in current scale
  void display_notes(std::ostream&) const; //display notes stored in current scale
  void display_grid(std::ostream&, std::size_t) const; //displays Fretboard grid

private:
  explicit FretBoard() //default constructor by RAII
    : pImpl(new FbImpl) //constructs new implementation object
  {}

  explicit FretBoard(const std::vector<Note>&); //construct FretBoard using a vector of 
                                                //Note objects

  FretBoard(const FretBoard& rhs) //copy constructor - performs deep copy
    : pImpl(new FbImpl(*rhs.pImpl))
  {}

  FretBoard& operator=(FretBoard); //copy assignment operator using ``copy and swap''

  std::vector<std::string> make_string(std::size_t, const std::string&, std::size_t) const; //called by display() - constructs strings to be displayed

  std::tr1::shared_ptr<FbImpl> pImpl; //pointer to implementation object (``pimpl idiom'')
};

#endif
