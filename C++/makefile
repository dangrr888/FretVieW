all: Note utility_funcs FbImpl FretBoard Scale
	g++ -o FretView main.cpp FbImpl.o FretBoard.o Note.o Scale.o utility_funcs.o instructions/printInstructions.o messages/printMessage.o scales/blues_scales.o scales/major_pent_scales.o scales/major_scales.o scales/minor_pent_scales.o scales/minor_scales.o scales/natural_scales.o scales/prefixed_notes.o scales/scale_category_str.o

clean:
	rm *.o *~ FretView scales/*.o scales/*~ instructions/*.o instructions/*~ messages/*.o messages/*~

Scale:
	g++ -c Scale.cpp

FretBoard:
	g++ -c FretBoard.cpp

FbImpl:
	g++ -c FbImpl.cpp

utility_funcs:
	g++ -c utility_funcs.cpp

Note:
	g++ -c Note.cpp
