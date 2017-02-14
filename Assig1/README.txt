Project 1
Team member: Quoc Ho Lam, Erin Leger, Zixin Luo, Nata Vacheishvili

Our program can be compiled using Eclipse. Simply, import the unzipped "CS4341Assignment1" folder as an Eclipse project.

To execute the program, you need to run the "astar.java".
In the zipped file, we included the 5 world that we have created called:
"world1", "world2", "world3", "world4","world5".

Once you start the program, it will first ask you to enter the filename that
contains the world. If you try to test any worlds other than the 5 world we
created, you need to make sure you put the file under the "CS4341Assignment1"
folder.
After entering the filename, you can enter the number of heuristic function you want
to use. There are 6 heuristic functions exist with the nunmbers 1 through 6 corresponding to each of them.
Then enter your input, we will get the optimal path with visited nodes from goal to start.
It also includes the actions taken from start to goal, the branching factor, # of
expanded nodes, and the score.

As the result of the worlds we tested, we do get identical score and number of actions for
heuristic 1-5 as the professor mentioned in the instruction. We display print out the nodes along the path from the goal to the start.
Though the robot is moving to the correct nodes for any world, the resulting directions are sometimes wrong for a few certain cases. For instance, one issue 
we found was that sometimes the program would say that the robot "turned left" and then "move forward", when in reality it did not turn and only 
moved forward. This can be seen be running the program and giving it the file "test.txt". The produced nodes will be a valid path from start to goal, 
but the directions themselves are wrong. 