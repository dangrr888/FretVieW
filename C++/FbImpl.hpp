#ifndef GUARD_FBIMPL_H
#define GUARD_FBIMPL_H

#include "Note.hpp"
#include <vector>
#include <iostream>

class FbImpl //RAII object class - implementation object for FretBoard Class
{
  friend class FretBoard;

  explicit FbImpl() //default constructor generates empty FretBoard grid
    : data(generateFretBoard()) 
  {}

  static std::vector<std::vector<int> > generateFretBoard(); //utilised by FbImpl object to generate empty FretBoard grid 

  std::vector<std::vector<int> > data; //main resource for FretBoard
  std::vector<Note> notes; //notes currently superimposed
};

#endif


