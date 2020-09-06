# Code Review: Mars Rover
#Part 1
A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is
curiously rectangular, must be navigated by the rovers so that their on board cameras can get a
complete view of the surrounding terrain to send back to Earth.

A rover&#39;s position and location is represented by a combination of x and y co-ordinates and a letter
representing one of the four cardinal compass points. The plateau is divided up into a grid to
simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom
left corner and facing North.

In order to control a rover, NASA sends a simple string of letters. The possible letters are &#39;L&#39;, &#39;R&#39; and
&#39;M&#39;. &#39;L&#39; and &#39;R&#39; makes the rover spin 90 degrees left or right respectively, without moving from its
current spot. &#39;M&#39; means move forward one grid point, and maintain the same heading.
Assume that the square directly North from (x, y) is (x, y+1).

# Input
The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are
assumed to be 0,0.

The rest of the input is information pertaining to the rovers that have been deployed. Each rover
has two lines of input. The first line gives the rover&#39;s position, and the second line is a series of
instructions telling the rover how to explore the plateau.

The position is made up of two integers and a letter separated by spaces, corresponding to the x
and y co-ordinates and the rover&#39;s orientation.

Each rover will be finished sequentially, which means that the second rover won&#39;t start to move
until the first one has finished moving.

# Output
The output for each rover should be its final co-ordinates and heading.

Input and Output

<b>Test Input:</b>

5 5<br/>
1 2 N<br/>
LMLMLMLMM<br/>
3 3 E<br/>
MMRMMRMRRM<br/>

<b>Expected Output:</b>

1 3 N<br/>
5 1 E<br/>

TEST
====

gradle test

