#include "prefixed_notes.hpp"
#include "major_scales.hpp"
#include "minor_scales.hpp"
#include "major_pent_scales.hpp"
#include "minor_pent_scales.hpp"
#include "blues_scales.hpp"
#include "natural_scales.hpp"
#include "../constants.hpp"
#include <vector>
#include <string>
#include <stdexcept>

using std::vector; using std::string;
using std::domain_error;

//returns a vector<string> containing letters of notes in 
//scale of a specified category and key
const vector<string>& prefixed_notes(const string& category, const string& key)
{
  if(key == "Ab" || key == "G#")
    return prefixed_notes_Ab(category);
  else if(key == "A")
    return prefixed_notes_A(category);
  else if(key == "Bb" || key == "A#")
    return prefixed_notes_Bb(category);
  else if(key == "B" || key == "Cb")
    return prefixed_notes_B(category);
  else if(key == "C" || key == "B#")
    return prefixed_notes_C(category);
  else if(key == "C#" || key == "Db")
    return prefixed_notes_Cs(category);
  else if(key == "D")
    return prefixed_notes_D(category);
  else if(key == "Eb" || key == "D#")
    return prefixed_notes_Eb(category);
  else if(key == "E" || key == "Fb")
    return prefixed_notes_E(category);
  else if(key == "F" || key == "E#")
    return prefixed_notes_F(category);
  else if(key == "F#" || key == "Gb")
    return prefixed_notes_Fs(category);
  else if(key == "G")
    return prefixed_notes_G(category);
  else
    throw domain_error("prefixed_notes:unrecognised key");
}

//functions that return a vector<string> containing
//letters of notes in scale of a specified category
//in specified key(in function name)

const vector<string>& prefixed_notes_Ab(const string& category)
{
  if(category == header_maj)
    return Maj_Ab();
  else if(category == header_min)
    return Min_Ab();
  else if(category == header_maj_pent)
    return MajPent_Ab();
  else if(category == header_min_pent)
    return MinPent_Ab();
  else if(category == header_blu)
    return Blu_Ab();
  else if(category == header_nat)
    return Nat_Ab();
  else
    throw domain_error("prefixed_notes_Ab:unrecognised category");
}

const vector<string>& prefixed_notes_A(const string& category)
{
  if(category == header_maj)
    return Maj_A();
  else if(category == header_min)
    return Min_A();
  else if(category == header_maj_pent)
    return MajPent_A();
  else if(category == header_min_pent)
    return MinPent_A();
  else if(category == header_blu)
    return Blu_A();
  else if(category == header_nat)
    return Nat_A();
  else
    throw domain_error("prefixed_notes_B:unrecognised category");
}

const vector<string>& prefixed_notes_Bb(const string& category)
{
  if(category == header_maj)
    return Maj_Bb();
  else if(category == header_min)
    return Min_Bb();
  else if(category == header_maj_pent)
    return MajPent_Bb();
  else if(category == header_min_pent)
    return MinPent_Bb();
  else if(category == header_blu)
    return Blu_Bb();
  else if(category == header_nat)
    return Nat_Bb();
  else
    throw domain_error("prefixed_notes_Bb:unrecognised category");
}

const vector<string>& prefixed_notes_B(const string& category)
{
  if(category == header_maj)
    return Maj_B();
  else if(category == header_min)
    return Min_B();
  else if(category == header_maj_pent)
    return MajPent_B();
  else if(category == header_min_pent)
    return MinPent_B();
  else if(category == header_blu)
    return Blu_B();
  else if(category == header_nat)
    return Nat_B();
  else
    throw domain_error("prefixed_notes_B:unrecognised category");
}

const vector<string>& prefixed_notes_C(const string& category)
{
  if(category == header_maj)
    return Maj_C();
  else if(category == header_min)
    return Min_C();
  else if(category == header_maj_pent)
    return MajPent_C();
  else if(category == header_min_pent)
    return MinPent_C();
  else if(category == header_blu)
    return Blu_C();
  else if(category == header_nat)
    return Nat_C();
  else
    throw domain_error("prefixed_notes_C:unrecognised category");
}

const vector<string>& prefixed_notes_Cs(const string& category)
{
  if(category == header_maj)
    return Maj_Cs();
  else if(category == header_min)
    return Min_Cs();
  else if(category == header_maj_pent)
    return MajPent_Cs();
  else if(category == header_min_pent)
    return MinPent_Cs();
  else if(category == header_blu)
    return Blu_Cs();
  else if(category == header_nat)
    return Nat_Cs();
  else
    throw domain_error("prefixed_notes_Cs:unrecognised category");
}

const vector<string>& prefixed_notes_D(const string& category)
{
  if(category == header_maj)
    return Maj_D();
  else if(category == header_min)
    return Min_D();
  else if(category == header_maj_pent)
    return MajPent_D();
  else if(category == header_min_pent)
    return MinPent_D();
  else if(category == header_blu)
    return Blu_D();
  else if(category == header_nat)
    return Nat_D();
  else
    throw domain_error("prefixed_notes_D:unrecognised category");
}

const vector<string>& prefixed_notes_Eb(const string& category)
{
  if(category == header_maj)
    return Maj_Eb();
  else if(category == header_min)
    return Min_Eb();
  else if(category == header_maj_pent)
    return MajPent_Eb();
  else if(category == header_min_pent)
    return MinPent_Eb();
  else if(category == header_blu)
    return Blu_Eb();
  else if(category == header_nat)
    return Nat_Eb();
  else
    throw domain_error("prefixed_notes_Eb:unrecognised category");
}

const vector<string>& prefixed_notes_E(const string& category)
{
  if(category == header_maj)
    return Maj_E();
  else if(category == header_min)
    return Min_E();
  else if(category == header_maj_pent)
    return MajPent_E();
  else if(category == header_min_pent)
    return MinPent_E();
  else if(category == header_blu)
    return Blu_E();
  else if(category == header_nat)
    return Nat_E();
  else
    throw domain_error("prefixed_notes_E:unrecognised category");
}

const vector<string>& prefixed_notes_F(const string& category)
{
  if(category == header_maj)
    return Maj_F();
  else if(category == header_min)
    return Min_F();
  else if(category == header_maj_pent)
    return MajPent_F();
  else if(category == header_min_pent)
    return MinPent_F();
  else if(category == header_blu)
    return Blu_F();
  else if(category == header_nat)
    return Nat_F();
  else
    throw domain_error("prefixed_notes_F:unrecognised category");
}

const vector<string>& prefixed_notes_Fs(const string& category)
{
  if(category == header_maj)
    return Maj_Fs();
  else if(category == header_min)
    return Min_Fs();
  else if(category == header_maj_pent)
    return MajPent_Fs();
  else if(category == header_min_pent)
    return MinPent_Fs();
  else if(category == header_blu)
    return Blu_Fs();
  else if(category == header_nat)
    return Nat_Fs();
  else
    throw domain_error("prefixed_notes_Fs:unrecognised category");
}

const vector<string>& prefixed_notes_G(const string& category)
{
  if(category == header_maj)
    return Maj_G();
  else if(category == header_min)
    return Min_G();
  else if(category == header_maj_pent)
    return MajPent_G();
  else if(category == header_min_pent)
    return MinPent_G();
  else if(category == header_blu)
    return Blu_G();
  else if(category == header_nat)
    return Nat_G();
  else
    throw domain_error("prefixed_notes_G:unrecognised category");
}
