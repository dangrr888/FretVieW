#include "blues_scales.hpp"
#include <vector>
#include <string>

using std::vector; using std::string;

const vector<string>& Blu_Ab()
{
  static const char* const aBlu_Ab[] = {"Ab", "B", "C#", "D", "Eb", "F#"};
  static const vector<string> vBlu_Ab(aBlu_Ab, aBlu_Ab + sizeof(aBlu_Ab)/sizeof(*aBlu_Ab));
  return vBlu_Ab;
}

const vector<string>& Blu_A()
{
  static const char* const aBlu_A[] = {"A", "C", "D", "Eb", "E", "G"};
  static const vector<string> vBlu_A(aBlu_A, aBlu_A + sizeof(aBlu_A)/sizeof(*aBlu_A));
  return vBlu_A;
}

const vector<string>& Blu_As()
{
  return Blu_Bb();
}

const vector<string>& Blu_Bb()
{
  static const char* const aBlu_Bb[] = {"Bb", "C#", "Eb", "E", "F", "Ab"};
  static const vector<string> vBlu_Bb(aBlu_Bb, aBlu_Bb + sizeof(aBlu_Bb)/sizeof(*aBlu_Bb));
  return vBlu_Bb;
}

const vector<string>& Blu_B()
{
  static const char* const aBlu_B[] = {"B", "D", "E", "F", "F#", "A"};
  static const vector<string> vBlu_B(aBlu_B, aBlu_B + sizeof(aBlu_B)/sizeof(*aBlu_B));
  return vBlu_B;
}

const vector<string>& Blu_Bs()
{
  return Blu_C();
}

const vector<string>& Blu_Cb()
{
  return Blu_B();
}

const vector<string>& Blu_C()
{
  static const char* const aBlu_C[] = {"C", "Eb", "F", "F#", "G", "Bb"};
  static const vector<string> vBlu_C(aBlu_C, aBlu_C + sizeof(aBlu_C)/sizeof(*aBlu_C));
  return vBlu_C;
}

const vector<string>& Blu_Cs()
{
  static const char* const aBlu_Cs[] = {"C#", "E", "F#", "G", "Ab", "B"};
  static const vector<string> vBlu_Cs(aBlu_Cs, aBlu_Cs + sizeof(aBlu_Cs)/sizeof(*aBlu_Cs));
  return vBlu_Cs;
}

const vector<string>& Blu_Db()
{
  return Blu_Cs();
}

const vector<string>& Blu_D()
{
  static const char* const aBlu_D[] = {"D", "F", "G", "Ab", "A", "C"};
  static const vector<string> vBlu_D(aBlu_D, aBlu_D + sizeof(aBlu_D)/sizeof(*aBlu_D));
  return vBlu_D;
}

const vector<string>& Blu_Ds()
{
  return Blu_Eb();
}

const vector<string>& Blu_Eb()
{
  static const char* const aBlu_Eb[] = {"Eb", "F#", "Ab", "A", "Bb", "C#"};
  static const vector<string> vBlu_Eb(aBlu_Eb, aBlu_Eb + sizeof(aBlu_Eb)/sizeof(*aBlu_Eb));
  return vBlu_Eb;
}

const vector<string>& Blu_E()
{
  static const char* const aBlu_E[] = {"E", "G", "A", "Bb", "B", "D"};
  static const vector<string> vBlu_E(aBlu_E, aBlu_E + sizeof(aBlu_E)/sizeof(*aBlu_E));
  return vBlu_E;
}

const vector<string>& Blu_Es()
{
  return Blu_F();
}

const vector<string>& Blu_Fb()
{
  return Blu_E();
}

const vector<string>& Blu_F()
{
  static const char* const aBlu_F[] = {"F", "Ab", "Bb", "B", "C", "Eb"};
  static const vector<string> vBlu_F(aBlu_F, aBlu_F + sizeof(aBlu_F)/sizeof(*aBlu_F));
  return vBlu_F;
}

const vector<string>& Blu_Fs()
{
  static const char* const aBlu_Fs[] = {"F#", "A", "B", "C", "C#", "E"};
  static const vector<string> vBlu_Fs(aBlu_Fs, aBlu_Fs + sizeof(aBlu_Fs)/sizeof(*aBlu_Fs));
  return vBlu_Fs;
}

const vector<string>& Blu_Gb()
{
  return Blu_Fs();
}

const vector<string>& Blu_G()
{
  static const char* const aBlu_G[] = {"G", "Bb", "C", "C#", "D", "F"};
  static const vector<string> vBlu_G(aBlu_G, aBlu_G + sizeof(aBlu_G)/sizeof(*aBlu_G));
  return vBlu_G;
}

const vector<string>& Blu_Gs()
{
  return Blu_Ab();
}
