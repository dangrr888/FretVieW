all: scale_category_str prefixed_notes

clean:
	rm *.o *~

prefixed_notes: scales	
	g++ -c prefixed_notes.cpp

scale_category_str:
	g++ -c scale_category_str.cpp

scales:
	g++ -c major_scales.cpp
	g++ -c minor_scales.cpp
	g++ -c major_pent_scales.cpp
	g++ -c minor_pent_scales.cpp
	g++ -c blues_scales.cpp
	g++ -c natural_scales.cpp