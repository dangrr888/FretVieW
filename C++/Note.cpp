#include "Note.hpp"
#include <vector>
#include <string>
#include <stdexcept>

using std::vector; using std::string;
using std::domain_error;

/*
  configuration of fret entries: 
  (E_1st, E_2nd, A_1st, A_2nd, D_1st, D_2nd, G_1st, G_2nd, b_1st, b_2nd, e_1st, e_2nd)
*/

Note Note::Ab()
{
  int pAb[] = {4,16,11,23,6,18,1,13,9,21,4,16};
  vector<int> Ab(pAb, pAb + 12);

  return Note("Ab", "G#", Ab);
}

Note Note::A()
{
  int pA[] ={5,17,12,24,7,19,2,14,10,22,5,17};
  vector<int> A(pA, pA + 12);

  return Note("A", "A", A);
}

Note Note::As()
{
  int pAs[] ={6,18,1,13,8,20,3,15,11,23,6,18};
  vector<int> As(pAs, pAs + 12);

  return Note("A#", "Bb", As);
}

Note Note::Bb()
{
  int pBb[] ={6,18,1,13,8,20,3,15,11,23,6,18};
  vector<int> Bb(pBb, pBb + 12);

  return Note("Bb", "A#", Bb);
}

Note Note::B()
{
  int pB[] ={7,19,2,14,9,21,4,16,12,24,7,19};
  vector<int> B(pB, pB + 12);

  return Note("B", "Cb", B);
}

Note Note::Bs()
{
  int pBs[] ={8,20,3,15,10,22,5,17,1,13,8,20};
  vector<int> Bs(pBs, pBs + 12);

  return Note("B#", "C", Bs);
}

Note Note::Cb()
{
  int pCb[] ={7,19,2,14,9,21,4,16,12,24,7,19};
  vector<int> Cb(pCb, pCb + 12);

  return Note("Cb", "B", Cb);
}

Note Note::C()
{
  int pC[] ={8,20,3,15,10,22,5,17,1,13,8,20};
  vector<int> C(pC, pC + 12);

  return Note("C", "B#", C);
}

Note Note::Cs()
{
  int pCs[] ={9,21,4,16,11,23,6,18,2,14,9,21};
  vector<int> Cs(pCs, pCs + 12);

  return Note("C#", "Db", Cs);
}

Note Note::Db()
{
  int pDb[] ={9,21,4,16,11,23,6,18,2,14,9,21};
  vector<int> Db(pDb, pDb + 12);

  return Note("Db", "C#", Db);
}

Note Note::D()
{
  int pD[] ={10,22,5,17,12,24,7,19,3,15,10,22};
  vector<int> D(pD, pD + 12);

  return Note("D", "D", D);
}

Note Note::Ds()
{
  int pDs[] ={11,23,6,18,1,13,8,20,4,16,11,23};
  vector<int> Ds(pDs, pDs + 12);

  return Note("D#", "Eb", Ds);
}

Note Note::Eb()
{
  int pEb[] ={11,23,6,18,1,13,8,20,4,16,11,23};
  vector<int> Eb(pEb, pEb + 12);

  return Note("Eb", "D#", Eb);
}

Note Note::E()
{
  int pE[] ={12,24,7,19,2,14,9,21,5,17,12,24};
  vector<int> E(pE, pE + 12);

  return Note("E", "Fb", E);
}

Note Note::Es()
{
  int pEs[] ={1,13,8,20,3,15,10,22,6,18,1,13};
  vector<int> Es(pEs, pEs + 12);

  return Note("E#", "F", Es);
}

Note Note::Fb()
{
  int pFb[] ={12,24,7,19,2,14,9,21,5,17,12,24};
  vector<int> Fb(pFb, pFb + 12);

  return Note("Fb", "E", Fb);
}

Note Note::F()
{
  int pF[] ={1,13,8,20,3,15,10,22,6,18,1,13};
  vector<int> F(pF, pF + 12);

  return Note("F", "E#", F);
}

Note Note::Fs()
{
  int pFs[] ={2,14,9,21,4,16,11,23,7,19,2,14};
  vector<int> Fs(pFs, pFs + 12);

  return Note("F#", "Gb", Fs);
}

Note Note::Gb()
{
  int pGb[] ={2,14,9,21,4,16,11,23,7,19,2,14};
  vector<int> Gb(pGb, pGb + 12);

  return Note("Gb", "F#", Gb);
}

Note Note::G()
{
  int pG[] ={3,15,10,22,5,17,12,24,8,20,3,15};
  vector<int> G(pG, pG + 12);

  return Note("G", "G", G);
}

Note Note::Gs()
{
  int pGs[] = {4,16,11,23,6,18,1,13,9,21,4,16};
  vector<int> Gs(pGs, pGs + 12);

  return Note("G#", "Ab", Gs);
}

Note Note::strToNote(const string& s)
{
  if(s == "Ab")
    return Ab();
  else if(s == "A")
    return A();
  else if(s == "A#")
    return As();
  else if(s == "Bb")
    return Bb();
  else if(s == "B")
    return B();
  else if(s == "B#")
    return Bs();
  else if(s == "Cb")
    return Cb();
  else if(s == "C")
    return C();
  else if(s == "C#")
    return Cs();
  else if(s == "Db")
    return Db();
  else if(s == "D")
    return D();
  else if(s == "D#")
    return Ds();
  else if(s == "Eb")
    return Eb();
  else if(s == "E")
    return E();
  else if(s == "E#")
    return Es();
  else if(s == "Fb")
    return Fb();
  else if(s == "F")
    return F();
  else if(s == "F#")
    return Fs();
  else if(s == "Gb")
    return Gs();
  else if(s == "G")
    return G();
  else if(s == "G#")
    return Gs();
  else
    throw domain_error("Note does not exist!");
}

bool Note::valid_key(const string& key)
{
  if(key == "Ab" || key == "A" || key == "A#" ||
     key == "Bb" || key == "B" || key == "B#" ||
     key == "Cb" || key == "C" || key == "C#" ||
     key == "Db" || key == "D" || key == "D#" ||
     key == "Eb" || key == "E" || key == "E#" ||
     key == "Fb" || key == "F" || key == "F#" ||
     key == "Gb" || key == "G" || key == "G#")
    return true;
  else
    return false;
}
