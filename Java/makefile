all: scale testers
	javac FretView.java

clean:
	rm *~ *.class FretView Constants/*~ scale_data/*~ messages/*~ Scale/Note/*~ Scale/*~
testers:
	javac testers/test_scale_data.java
	javac testers/testMessage.java
	javac testers/ScaleNote.java
	javac testers/CustomScaleTester.java
	javac Scale/testFbImpl.java
	javac Scale/FretBoardTester.java

scale: note
	javac Scale/Superimpose.java
	javac Scale/FbImpl.java
	javac Scale/FretBoardInt.java
	javac Scale/FretBoard.java
	javac Scale/ScaleInt.java
	javac Scale/Scale.java
	javac Scale/CustomScale.java

note: messages	
	javac Scale/Note/Plotter.java
	javac Scale/Note/NoteInt.java
	javac Scale/Note/Note.java

messages: scale_data
	javac messages/MessageInt.java
	javac messages/Message.java

scale_data: constants
	javac scale_data/Prefixed_Notes.java
	javac scale_data/Major_Scales.java
	javac scale_data/Minor_Scales.java
	javac scale_data/Major_Pent_Scales.java
	javac scale_data/Minor_Pent_Scales.java
	javac scale_data/Blues_Scales.java
	javac scale_data/Natural_Scales.java

constants:
	javac Constants/Constants.java