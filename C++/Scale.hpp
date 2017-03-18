#ifndef GUARD_SCALE_H
#define GUARD_SCALE_H

//defines the Scale and CustomScale classes, 
//which are interface classes for FretBoard
//containing designed for fixed and 
//custom based scales respectively

#include "scales/prefixed_notes.hpp"
#include "FretBoard.hpp"
#include <tr1/memory>
#include "Note.hpp"
#include <vector>
#include <string>
#include <iostream>
#include <cstddef>

class Scale //interface class for FretBoard designed for fixed scales
{
public:
  explicit Scale() //default constructor creates empty Scale
    : pFb(new FretBoard), category(), key()
  {}

  explicit Scale(const std::string& cat, const std::string& k) //constructor taking scale category and key
    : pFb(new FretBoard(generateNotes(prefixed_notes(cat,k)))), category(cat), key(k) //adds notes of specified scale to resource
  {}

  Scale(const Scale& rhs) //Copy Constructor - perform deep copy of FretBoard resource
    : pFb(new FretBoard(*rhs.pFb)), category(rhs.category), key(rhs.key)
  {}

  Scale& operator=(Scale); //Copy Assignment Operator - perform deep copy of FretBoard resource using copy and swap
  
  virtual ~Scale() {}; //virtual destructor for inheritence hierarchy

  virtual void add(const Note&); //adds note to current scale
  virtual void remove(const Note&); //removes note from current scale
  virtual void clear(); //clears all notes from current scale

  std::size_t num_notes() const; //returns number of notes in current scale

  virtual void display(std::ostream&, std::size_t); //displays Scale object

protected:
  explicit Scale(const std::tr1::shared_ptr<FretBoard>& ptr) //hack in order to initialise pFb in CustomScale::CustomScale(const vector<string>&)
    : pFb(ptr)
  {}

  static std::vector<Note> generateNotes(const std::vector<std::string>&); //helper function to construct notes described by a vector<string>
  std::tr1::shared_ptr<FretBoard> pFb; //pointer to FretBoard resource
                                       //FretBoard is private (Scale and CustomScale are friends) hence RAII object is protected rather than private
  void display_grid(std::ostream&, std::size_t) const; //displays fretboard grid, called by display
  void display_notes(std::ostream&) const; //displays notes in current scale, called by display

private:
  std::string category; //type of (fixed) scale currently stored in Scale object
  std::string key; //key of (fixed) scale currently stored in Scale object
};

class CustomScale : public Scale //interface class for FretBoard designed for custom scales
{
public:
  explicit CustomScale() //default constructor invokes Scale::Scale()
  {}
  
  explicit CustomScale(const std::vector<std::string>& notes) //constructs CustomScale using const vector<string>& 
    : Scale(std::tr1::shared_ptr<FretBoard>(new FretBoard(generateNotes(notes)))) //calls Scale::Scale(const tr1::shared_ptr<FretBoard>&)
  {}
  
  CustomScale(const CustomScale& rhs) //Copy Constructor - perform deep copy using Scale::Scale(const Scale&)
    : Scale(rhs) 
  {}

  CustomScale& operator=(const CustomScale&); //Copy Assignment operator - perform deep copy using Scale::operator=(const Scale&)

  void add(const Note&); //add note to current scale
  void remove(const Note&); //remove note to current scale
  void clear(); //clear all notes from current scale

  void display(std::ostream&, std::size_t) const; //displays Scale object
};

#endif
