# Name-Surfer

# This project was implemented up to milestone 3, no need for the graphics part (NameSurferGraph).

Overview of the NameSurfer project
Against all bureaucratic stereotypes, the Social Security Administration, provides a neat web site showing the distribution of names chosen for children over the last 100 years in the United States ( http://www.ssa.gov/OACT/babynames/ ). The Social Security Administration provides data that shows the 1000 most popular boy and girl names for children at 10 year intervals. The data can be boiled down to a single text file (NamesData.txt) that looks something like this:
...
         Sam 58 69 99 131 168 236 278 380 467 408 466
         Samantha 0 0 0 0 0 0 272 107 26 5 7
         Samara 0 0 0 0 0 0 0 0 0 0 886
         Samir 0 0 0 0 0 0 0 0 920 0 798
         Sammie 537 545 351 325 333 396 565 772 930 0 0
         Sammy 0 887 544 299 202 262 321 395 575 639 755
         Samson 0 0 0 0 0 0 0 0 0 0 915
         Samuel 31 41 46 60 61 71 83 61 52 35 28
Sandi 0 0 0 0 704 864 621 695 0 0 0 Sandra 0 942 606 50 6 12 11 39 94 168 257 ...
Each line of the file begins with the name, followed by the rank of that name in each of the 11 decades since 1900, counting the current one: 1900, 1910, 1920, and so on up to 2000. A rank of 1 indicates the most popular name that year, while a rank of 997 indicates a name that is not very popular. A 0 entry means the name did not appear in the top 1000 names for that year and therefore indicates a name that is even less popular. The elements on each line are separated from each other by a single space. The lines happen to be in alphabetical order, but nothing in the assignment depends on that fact. As you can see from the small excerpt from the file, the name Sam was #58 in the first decade of the 1900s and is slowly moving down. Samantha popped on the scene in the 1960s (possibly because the show Bewitched, which had a main character names Samantha ran on television during those years) and is moving up strong to #7. Samir barely appears in the 1980s (at rank #920), but by the current decade is up to #798. The database counts children born in the United States, so trends in particular names tend to reflect the evolution of ethnic communities over the years.
The goal of this assignment is to create a program that graphs these names over time, as shown in the sample run in Figure 1. In this diagram, the user has just typed Samantha into the box marked ―Name‖ and then clicked on the ―Graph‖ button, having earlier done exactly the same thing for the name Sam . Whenever the user enters a name, the NameSurfer program creates a new plot line showing how that name has fared over the decades. Clicking on the ―Clear‖ button removes all the plot lines from the graph so that the user can enter more names without all the old names cluttering up the display.
To give you more experience working with classes that interact with one another, the NameSurfer application as a whole is broken down into several separate class files, as follows:
NameSurfer —This is the main program class that ties together the application. It has the responsibility for creating the other objects and for responding to the buttons at the bottom of the window, but only to the point of redirecting those events to the objects represented by the other classes.
NameSurferConstants —This interface is provided for you and defines a set of constants that you can use in the rest of the program simply by having your classes implement the NameSurferConstants interface, as they do in the starter files. The NameSurferConstants interface therefore has the same role that MinesConstants did in Assignment #5.– 3 – NameSurferEntry —This class ties together all the information for a particular name. Given a NameSurferEntry object, you can find out what name it corresponds to and what its popularity rank was in each decade.
NameSurferDataBase —This class keeps track of all the information stored in the data files, but is completely separate from the user interface. It is responsible for reading in the data and for locating the data associated with a particular name.
NameSurferGraph —This class is a subclass of GCanvas that displays the graph of the various names by arranging the appropriate GLine and GLabel objects on the screen, just as with the various graphical programs you’ve written this quarter.
Even though the class structure sounds complicated, the NameSurfer application code is about the same size as Yahtzee . Even if the scale of the project is comparable to the last assignment, the wise course is to start on the assignment soon and keep up with the milestones described in this handout.

# Milestone 1: Assemble the GUI interactors
If you look at the bottom of Figure 1, you will see that the region along the SOUTH edge of the window contains several interactors: a JLabel , a JTextField , and three JButtons . Since putting up interactors is something you haven't done in previous assginments, you probably want to work on this step before it becomes complicated with all the other parts of the assignment. Thus, your first milestone is simply to add the interactors to the window and create an implementation for the actionPerformed method that allows you to check whether you can detect button clicks and read what’s in the text field.
The simplest strategy to check whether your program is working is to change the definition of the NameSurfer class so that it extends ConsoleProgram instead of Program , at least for the moment. You can always change it back later. Once you have made that change, you can then use the console to record what’s happening in terms of the interactors to make sure that you’ve got them right. For example, Figure 2 shows a possible transcript of the commands used to generate the output from Figure 1, in which the user has just completed the following actions:
1. Entered the name Sam in the text field and clicked the Graph button.
2. Entered the name Samantha in the text field and then typed the E NTER key.
3. Clicked the Clear button.
The hard part about reaching this milestone is understanding how interactors work. Once you do, writing the code is quite straightforward – it's only 10 to 15 lines of code.

# Milestone 2: Implement the NameSurferEntry class
The starter file for the NameSurferEntry class appears in full as Figure 3 on the following page. As with the other files supplied with this assignment, the starter file includes definitions for all of the public methods we expect you to define. The method definitions in the starter files, however, do nothing useful, although they occasionally include a return statement that gives back a default value of the required type. In Figure 3, for example, the getRank method always returns 0 to satisfy the requirement that the method returns an int as defined in its header line.
Methods that will eventually become part of the program structure but that are temporarily unimplemented are called stubs. Stubs play a very important role in program development because they allow you to set out the structure of a program even before you write most of the code. As you implement the program, you can go through the code and replace stubs with real code as you need it. The NameSurferEntry class encapsulates the information pertaining to one name in the database. That information consists of two parts:
1. The name itself, such as "Sam" or "Samantha"
2. A list of 11 values indicating the rank of that name in each of the decades from 1900 to 2000,
inclusive
The class definition begins with a constructor that creates an entry from the line of data that appears in the NamesData.txt file. For example, the entry for Sam looks like this:
         Sam 58 69 99 131 168 236 278 380 467 408 466
The idea behind the design of this constructor is that it should be possible to read a line of data from the file and then create a new entry for it using code that looks like this:
String line = rd.readLine();
NameSurferEntry entry = new NameSurferEntry(line);
The implementation of the constructor has to divide up the line at the spaces, convert the digit strings to integers (using Integer.parseInt ), and then store all of this information as the private state of the object in such a way that it is easy for the getName and getRank methods to return the appropriate values.
The last method in the starter implementation of NameSurferEntry is a toString method whose role is to return a human-readable representation of the data stored in the entry. For example, if the variable entry contains the NameSurferEntry data for Sam , you might want entry.toString() to return a string like this:
"Sam [58 69 99 131 168 236 278 380 467 408 466]"
Defining toString for a class has the wonderful advantage that it makes it possible to print out objects of that class using println , just as you do for primitive values. Whenever Java needs to convert an object to a string, it always calls its toString method to do the job. The default definition of toString in the Object class doesn’t supply much useful information, and you will find that your debugging sessions get much easier if you can look easily at the values of your objects.
To show that you’ve got NameSurferEntry implemented correctly, you might want to write a very simple test program that creates an entry from a specific string and then verifies that the other methods work as they are supposed to.

# Milestone 3: Implement the NameSurferDataBase class
The next step in the process is to implement the NameSurferDataBase class, which contains two public entries:
A constructor that takes the name of a data file and uses that to read in the entire set of data from the file into internal data structures that allow the class to keep track of all the records as a database.
A findEntry method that takes a name, looks it up in the stored database, and returns the NameSurferEntry for that name, or null if that name does not appear.
The code for this part of the assignment is not particularly difficult. The challenging part lies in figuring out how you want to represent the data so that you can implement the findEntry method as simply and as efficiently as possible.
To test this part of the program, you can add a line of code or two to the NameSurfer program so that it creates the NameSurferDataBase and then change the code for the button handlers so that clicking the ―Graph‖ button looks up the current name in the data base and then displays the corresponding entry (using its toString method).
 
