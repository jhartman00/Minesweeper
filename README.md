
# Minesweeper

I built a version of minesweeper you can play in your console!  
- The game is set to a 9x9 board by default but by uncommenting line 20 and lines 23-38 in the board.java file instead of just starting the game, the program will ask you the dimensions of the board you want to play.  This feature is in beta as when the board is drawn larger than 9x9 it doesnt print as well
- If you want a list of the mines generated (as shown in the demo video) you should uncomment line 73 in the board.java file

## Authors

- [@jhartman00](https://www.github.com/jhartman00)


## Demo

https://youtu.be/PmbWr2v_N4Y

## Running the Program

1. To try this project for yourself make sure you have Java installed on your computer.  If you don't you can go to https://www.java.com/en/download/ to get it for free!
    - Windows: https://www.youtube.com/watch?v=IJ-PJbvJBGs
    - Mac: https://www.youtube.com/watch?v=pxi3iIy4F5A
2. Clone the directory or download the zip file to a location of your choosing.
3. Open a terminal/command shell in the src/main/java/ folder
4. Run the command to compile the program "javac main.java"
5. To run the program run the command "java main"

## Once the program is running

1. When the program is running you will see a prompt asking how many mines you want on the field. You can enter any number as long as it is within 1 and 80 (or row*col-1 if custom) inclusive.
2. After that it will generate the board
    - The top row shows the column numbers
    - The first column shows the row numbers
    - The top and bottom rows are just there as spacers and aren't part of the playable board.
3. Next you will get a promt "Set/unset mines marks or claim a cell as free"
     - The format of the command is column row free/mine
     - If you mark a spot as free and there is a mine in that spot, the game ends and you will get the message "You stepped on a mine and failed!"
     - If you mark a spot as mine you will see an * symbol appear on the board.  If you change your mind you can use the same command x x mine to unset that mine marker
     - If you mark a spot as free and there isn't a mine the program will check the surrounding spaces.  
         - If any of them have a mine, the spot you marked will get a number 1-8 representing how many mines are around that spot.  
         - If there are not mines surrounding the spot marked, the program will run the same check on all 8 spaces around the origional mark and subsequently do so in every direction until it reaches a spot in which there is at least one mine surrounding the spot.  The program will mark all the spots without a mine surrounding it with /.
4. Once either all the mines have been marked you will have won the game and will get the message "Congratulations! You found all the mines!"

  
## A few things to note

1. As stated before, sizing the board larger than 9x9 may have some formatting issues however the game should play correctly.
2. If you resize the board to 1x1 the game will not work correctly and you will be unable to win.

## FAQ

#### Questions?

Feel free to email me at jamiehartman00@gmail.com or jhartman1@tulane.edu, and I will get back to you as soon as possible.


## Lessons Learned

Like all projects this one had its own set of unique challenges.  Printing the board in a readable way was a little challenging at first however I was able to figure out a pretty good way to do it. If i were to redo this project I would probably add color to the console and/or a UI that is more plesant to interact with.  The second challenge was the recursive spot checker algorithm.  I learned a lot while making this algorithm so in the future I think similar algorithms will be easier to write.

## Want more?

Check out my website at https://jamiehartman-com.stackstaging.com/

<h3 align="left">Connect with me:</h3>
<p align="left">
<a href="https://linkedin.com/in/jamiehartman00" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/linked-in-alt.svg" alt="jamiehartman00" height="30" width="40" /></a>
<a href="https://instagram.com/jamie_hartman99" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/instagram.svg" alt="jamie_hartman99" height="30" width="40" /></a>
<a href="https://github.com/jhartman00" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/github.svg" alt="jamiehartman00" height="30" width="40" /></a>
</p>

<h3 align="left">Languages and Tools:</h3>
<p align="left"> <a href="https://getbootstrap.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/bootstrap/bootstrap-plain-wordmark.svg" alt="bootstrap" width="40" height="40"/> </a> <a href="https://www.cprogramming.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/c/c-original.svg" alt="c" width="40" height="40"/> </a> <a href="https://www.w3schools.com/cpp/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/cplusplus/cplusplus-original.svg" alt="cplusplus" width="40" height="40"/> </a> <a href="https://www.w3schools.com/css/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/css3/css3-original-wordmark.svg" alt="css3" width="40" height="40"/> </a> <a href="https://git-scm.com/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="git" width="40" height="40"/> </a> <a href="https://www.w3.org/html/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/html5/html5-original-wordmark.svg" alt="html5" width="40" height="40"/> </a> <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/javascript/javascript-original.svg" alt="javascript" width="40" height="40"/> </a> <a href="https://www.mathworks.com/" target="_blank" rel="noreferrer"> <img src="https://upload.wikimedia.org/wikipedia/commons/2/21/Matlab_Logo.png" alt="matlab" width="40" height="40"/> </a> <a href="https://www.mysql.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="40" height="40"/> </a> <a href="https://nodejs.org" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/nodejs/nodejs-original-wordmark.svg" alt="nodejs" width="40" height="40"/> </a> <a href="https://pandas.pydata.org/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/2ae2a900d2f041da66e950e4d48052658d850630/icons/pandas/pandas-original.svg" alt="pandas" width="40" height="40"/> </a> <a href="https://www.php.net" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/php/php-original.svg" alt="php" width="40" height="40"/> </a> <a href="https://www.postgresql.org" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original-wordmark.svg" alt="postgresql" width="40" height="40"/> </a> <a href="https://www.python.org" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/python/python-original.svg" alt="python" width="40" height="40"/> </a> <a href="https://pytorch.org/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/pytorch/pytorch-icon.svg" alt="pytorch" width="40" height="40"/> </a> <a href="https://scikit-learn.org/" target="_blank" rel="noreferrer"> <img src="https://upload.wikimedia.org/wikipedia/commons/0/05/Scikit_learn_logo_small.svg" alt="scikit_learn" width="40" height="40"/> </a> <a href="https://seaborn.pydata.org/" target="_blank" rel="noreferrer"> <img src="https://seaborn.pydata.org/_images/logo-mark-lightbg.svg" alt="seaborn" width="40" height="40"/> </a> <a href="https://www.sqlite.org/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/sqlite/sqlite-icon.svg" alt="sqlite" width="40" height="40"/> </a> <a href="https://svelte.dev" target="_blank" rel="noreferrer"> <img src="https://upload.wikimedia.org/wikipedia/commons/1/1b/Svelte_Logo.svg" alt="svelte" width="40" height="40"/> </a> <a href="https://www.tensorflow.org" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/tensorflow/tensorflow-icon.svg" alt="tensorflow" width="40" height="40"/> </a> </p>


<h3 align="left">Support:</h3>
<p><a href="https://www.buymeacoffee.com/jamiehartman"> <img align="left" src="https://cdn.buymeacoffee.com/buttons/v2/default-yellow.png" height="50" width="210" alt="jamiehartman" /></a></p><br><br>
