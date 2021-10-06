#!/bin/sh

# 0: /Users/amy/code/autograding/bash-python-autograder-2.sh
# 1: /Users/amy/code/autograding/HomeworkOne1/taylormichael_5522_2776863_SelectionSort-for-Homework-1
# 2: HomeworkOne1
# 3: taylormichael
#4: 
#echo "0: $0"
#echo "1: $1"
#echo "2: $2"
#echo "3: $3"



studentFolder=$1
classFolderOut="${studentFolder}/out"
mkdir $classFolderOut
cd $studentFolder

studentName=$3

javac -d out ${studentFolder}/SelectionSort.java > "$studentName-compilingSelectionSort.txt"
#javac -d out MySelectionSort.java
javac -d out -cp out:junit-platform-console-standalone-1.8.1.jar JUnitTestSelectionSort.java > "$studentName-compilingJUnit.txt"
java -jar junit-platform-console-standalone-1.8.1.jar --class-path out -c JUnitTestSelectionSort --details=verbose  --reports-dir=$studentFolder> "${3}-RunningJUnit.txt"
