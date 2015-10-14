Welcome!

If you choose to accept the task before you Congratulations!

This exercise is fairly simple, but will allow you to showcase your
programming, research and algorithm skills. You will need to write two methods loadData() and find() for
a program that finds zip codes of people by searching on the first N letters
of their last names.

For instance, let's say you wanted all the zip codes for all the people who's
last name starts with 'J', or "Jo" or 'Sm', as in "Smith", "Smarts" or "Smalls".

In this zip you will find three classes:

  Main.java
  AbstractUserZipCodeFinder.java
  UserZipCodeFinder.java

and a datafile dataFile.csv

The dataFile.csv contains a large set of Last names and corresponding zip codes, and the Main,
and AbstractUserZipCodeFinder have boilerplate code already written to run tests on the code you will write.

IMPORTANT: The dataFile.csv does contain duplicate last names and zip code pairs! (After all, there are many people in
the same zip code with the same last name) You should be prepared to account for this.

The only class you need to worry about is UserZipCodeFinder.java, in which you will find two
unimplemented methods loadData() and find(). The goal of this exercise is to optimize how long
it takes to run the find() method for various inputs. There is no need to worry about how much time your
loadData() method takes to prepare and load the data into whatever datastructure you want to use
in the find() method.

Both loadData() and find() are automatically called as part
of a test program when you run Main, and results will be printed for you.

For instance, I wrote an implementation of loadData() and find() and here are my
results from running Main on my 2015 MacBook Pro running in debug mode through Intellij IDEA:

-------------------------------
Searching for names that start with '' returned 399287 results and took 55ms
Searching for names that start with 'A' returned 12721 results and took 1ms
Searching for names that start with 'B' returned 39652 results and took 4ms
Searching for names that start with 'Ba' returned 8584 results and took 0ms
Searching for names that start with 'Jo' returned 2199 results and took 0ms
Searching for names that start with 'Smi' returned 475 results and took 0ms
Searching for names that start with 'Bra' returned 2363 results and took 0ms
Searching for names that start with 'P' returned 20481 results and took 1ms
Searching for names that start with 'Perkins' returned 234 results and took 0ms
------------------------------


If you have any issues getting started or questions please don't hesistate to reach out to me. I am happy to also help
you setup this project in Intellij and walk you through how to run it.
