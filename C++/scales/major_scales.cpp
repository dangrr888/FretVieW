#include "major_scales.hpp"
#include <vector>
#include <string>

using std::vector; using std::string;

//alter to remove unnecessary functions

const vector<string>& Maj_Ab()
{
  static const char* const aMaj_Ab[] = {"Ab", "Bb", "C", "C#", "Eb", "F", "G"};
  static const vector<string> vMaj_Ab(aMaj_Ab, aMaj_Ab + sizeof(aMaj_Ab)/sizeof(*aMaj_Ab));
  return vMaj_Ab;
}

const vector<string>& Maj_A()
{
  static const char* const aMaj_A[] = {"A", "B", "C#", "D", "E", "F#", "Ab"};
  static const vector<string> vMaj_A(aMaj_A, aMaj_A + sizeof(aMaj_A)/sizeof(*aMaj_A));
  return vMaj_A;
}

const vector<string>& Maj_As()
{
  return Maj_Bb();
}

const vector<string>& Maj_Bb()
{
  static const char* const aMaj_Bb[] = {"Bb", "C", "D", "Eb", "F", "G", "A"};
  static const vector<string> vMaj_Bb(aMaj_Bb, aMaj_Bb + sizeof(aMaj_Bb)/sizeof(*aMaj_Bb));
  return vMaj_Bb;
}

const vector<string>& Maj_B()
{
  static const char* const aMaj_B[] = {"B", "C#", "Eb", "E", "F#", "Ab", "Bb"};
  static const vector<string> vMaj_B(aMaj_B, aMaj_B + sizeof(aMaj_B)/sizeof(*aMaj_B));
  return vMaj_B;
}

const vector<string>& Maj_Bs()
{
  return Maj_C();
}

const vector<string>& Maj_Cb()
{
  return Maj_B();
}

const vector<string>& Maj_C()
{
  static const char* const aMaj_C[] = {"C", "D", "E", "F", "G", "A", "B"};
  static const vector<string> vMaj_C(aMaj_C, aMaj_C + sizeof(aMaj_C)/sizeof(*aMaj_C));
  return vMaj_C;
}

const vector<string>& Maj_Cs()
{
  static const char* const aMaj_Cs[] = {"C#", "Eb", "F", "F#", "Ab", "Bb", "C"};
  static const vector<string> vMaj_Cs(aMaj_Cs, aMaj_Cs + sizeof(aMaj_Cs)/sizeof(*aMaj_Cs));
  return vMaj_Cs;
}

const vector<string>& Maj_Db()
{
  return Maj_Cs();
}

const vector<string>& Maj_D()
{
  static const char* const aMaj_D[] = {"D", "E", "F#", "G", "A", "B", "C#"};
  static const vector<string> vMaj_D(aMaj_D, aMaj_D + sizeof(aMaj_D)/sizeof(*aMaj_D));
  return vMaj_D;
}

const vector<string>& Maj_Ds()
{
  return Maj_Eb();
}

const vector<string>& Maj_Eb()
{
  static const char* const aMaj_Eb[] = {"Eb", "F", "G", "Ab", "Bb", "C", "D"};
  static const vector<string> vMaj_Eb(aMaj_Eb, aMaj_Eb + sizeof(aMaj_Eb)/sizeof(*aMaj_Eb));
  return vMaj_Eb;
}

const vector<string>& Maj_E()
{
  static const char* const aMaj_E[] = {"E", "F#", "Ab", "A", "B", "C#", "Eb"};
  static const vector<string> vMaj_E(aMaj_E, aMaj_E + sizeof(aMaj_E)/sizeof(*aMaj_E));
  return vMaj_E;
}

const vector<string>& Maj_Es()
{
  return Maj_F();
}

const vector<string>& Maj_Fb()
{
  return Maj_E();
}

const vector<string>& Maj_F()
{
  static const char* const aMaj_F[] = {"F", "G", "A", "Bb", "C", "D", "E"};
  static const vector<string> vMaj_F(aMaj_F, aMaj_F + sizeof(aMaj_F)/sizeof(*aMaj_F));
  return vMaj_F;
}

const vector<string>& Maj_Fs()
{
  static const char* const aMaj_Fs[] = {"F#", "Ab", "Bb", "B", "C#", "Eb", "F"};
  static const vector<string> vMaj_Fs(aMaj_Fs, aMaj_Fs + sizeof(aMaj_Fs)/sizeof(*aMaj_Fs));
  return vMaj_Fs;
}

const vector<string>& Maj_Gb()
{
  return Maj_Fs();
}

const vector<string>& Maj_G()
{
  static const char* const aMaj_G[] = {"G", "A", "B", "C", "D", "E", "F#"};
  static const vector<string> vMaj_G(aMaj_G, aMaj_G + sizeof(aMaj_G)/sizeof(*aMaj_G));
  return vMaj_G;
}

const vector<string>& Maj_Gs()
{
  return Maj_Ab();
}
