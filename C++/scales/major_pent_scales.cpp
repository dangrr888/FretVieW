#include "major_pent_scales.hpp"
#include <vector>
#include <string>

using std::vector; using std::string;

const vector<string>& MajPent_Ab()
{
  static const char* const aMajPent_Ab[] = {"Ab", "Bb", "C", "Eb", "F"};
  static const vector<string> vMajPent_Ab(aMajPent_Ab, aMajPent_Ab + sizeof(aMajPent_Ab)/sizeof(*aMajPent_Ab));
  return vMajPent_Ab;
}

const vector<string>& MajPent_A()
{
  static const char* const aMajPent_A[] = {"A", "B", "C#", "E", "F#"};
  static const vector<string> vMajPent_A(aMajPent_A, aMajPent_A + sizeof(aMajPent_A)/sizeof(*aMajPent_A));
  return vMajPent_A;
}

const vector<string>& MajPent_As()
{
  return MajPent_Bb();
}

const vector<string>& MajPent_Bb()
{
  static const char* const aMajPent_Bb[] = {"Bb", "C", "D", "F", "G"};
  static const vector<string> vMajPent_Bb(aMajPent_Bb, aMajPent_Bb + sizeof(aMajPent_Bb)/sizeof(*aMajPent_Bb));
  return vMajPent_Bb;
}

const vector<string>& MajPent_B()
{
  static const char* const aMajPent_B[] = {"B", "C#", "Eb", "F#", "Ab"};
  static const vector<string> vMajPent_B(aMajPent_B, aMajPent_B + sizeof(aMajPent_B)/sizeof(*aMajPent_B));
  return vMajPent_B;
}

const vector<string>& MajPent_Bs()
{
  return MajPent_C();
}

const vector<string>& MajPent_Cb()
{
  return MajPent_B();
}

const vector<string>& MajPent_C()
{
  static const char* const aMajPent_C[] = {"C", "D", "E", "G", "A"};
  static const vector<string> vMajPent_C(aMajPent_C, aMajPent_C + sizeof(aMajPent_C)/sizeof(*aMajPent_C));
  return vMajPent_C;
}

const vector<string>& MajPent_Cs()
{
  static const char* const aMajPent_Cs[] = {"C#", "E", "F", "Ab", "Bb"};
  static const vector<string> vMajPent_Cs(aMajPent_Cs, aMajPent_Cs + sizeof(aMajPent_Cs)/sizeof(*aMajPent_Cs));
  return vMajPent_Cs;
}

const vector<string>& MajPent_Db()
{
  return MajPent_Cs();
}

const vector<string>& MajPent_D()
{
  static const char* const aMajPent_D[] = {"D", "F", "F#", "A", "B"};
  static const vector<string> vMajPent_D(aMajPent_D, aMajPent_D + sizeof(aMajPent_D)/sizeof(*aMajPent_D));
  return vMajPent_D;
}

const vector<string>& MajPent_Ds()
{
  return MajPent_Eb();
}

const vector<string>& MajPent_Eb()
{
  static const char* const aMajPent_Eb[] = {"Eb", "F#", "G", "Bb", "C"};
  static const vector<string> vMajPent_Eb(aMajPent_Eb, aMajPent_Eb + sizeof(aMajPent_Eb)/sizeof(*aMajPent_Eb));
  return vMajPent_Eb;
}

const vector<string>& MajPent_E()
{
  static const char* const aMajPent_E[] = {"E", "G", "Ab", "B", "C#"};
  static const vector<string> vMajPent_E(aMajPent_E, aMajPent_E + sizeof(aMajPent_E)/sizeof(*aMajPent_E));
  return vMajPent_E;
}

const vector<string>& MajPent_Es()
{
  return MajPent_F();
}

const vector<string>& MajPent_Fb()
{
  return MajPent_E();
}

const vector<string>& MajPent_F()
{
  static const char* const aMajPent_F[] = {"F", "Ab", "A", "C", "D"};
  static const vector<string> vMajPent_F(aMajPent_F, aMajPent_F + sizeof(aMajPent_F)/sizeof(*aMajPent_F));
  return vMajPent_F;
}

const vector<string>& MajPent_Fs()
{
  static const char* const aMajPent_Fs[] = {"F#", "A", "Bb", "C#", "Eb"};
  static const vector<string> vMajPent_Fs(aMajPent_Fs, aMajPent_Fs + sizeof(aMajPent_Fs)/sizeof(*aMajPent_Fs));
  return vMajPent_Fs;
}

const vector<string>& MajPent_Gb()
{
  return MajPent_Fs();
}

const vector<string>& MajPent_G()
{
  static const char* const aMajPent_G[] = {"G", "Bb", "B", "D", "E"};
  static const vector<string> vMajPent_G(aMajPent_G, aMajPent_G + sizeof(aMajPent_G)/sizeof(*aMajPent_G));
  return vMajPent_G;
}

const vector<string>& MajPent_Gs()
{
  return MajPent_Ab();
}
