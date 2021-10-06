# conda activate Autograder

class color:
   PURPLE = '\033[95m'
   CYAN = '\033[96m'
   DARKCYAN = '\033[36m'
   BLUE = '\033[94m'
   GREEN = '\033[92m'
   YELLOW = '\033[93m'
   RED = '\033[91m'
   BOLD = '\033[1m'
   UNDERLINE = '\033[4m'
   END = '\033[0m'


import sys
import os
import shutil
from shutil import copyfile
import subprocess
from os.path import exists
from glob import glob

cwd = os.getcwd()

def return_list_of_zipped_assignments(submissionsDirectory):
    mySubmissions = []
    for file in os.listdir(submissionsDirectory):
        #print(f"File: {file}")
        if '.zip' in file:
            mySubmissions.append(file)
            #print(f"\t ZIP: {file}")
    return mySubmissions

def convertZipToFolderName(zipFile):
    print(f"Zip File (Original): {zipFile}")
    zipFileList = zipFile.split(" ")
    zipFileStr = "";
    for item in zipFileList:
        zipFileStr+= item
    print(f"Zip File (merged): {zipFileStr}")
    return zipFileStr[:-4]

def unzipSubmission(src,dst):
    #print(f"Source File: {src}, Destination File: {dst}")
    shutil.unpack_archive(src, dst)

def copyInstructorCode(InstructorCode, StudentCode):
    print()
    print(f"{StudentCode}")
    for myfile in os.listdir(InstructorCode):
            srcFile = f"{InstructorCode}/{myfile}"
            dstFile = f"{StudentCode}/{myfile}"
            copyfile(srcFile, dstFile)

def printAutogradeHeader(submissionsDirectory,submissions,mainHomeworkFolder):
    print("----------------------------------------------------")
    print("Starting to Autograde ...")
    gradeString = "Grading " + color.PURPLE + str(len(submissions)) + color.END + f"submissions from {submissionsDirectory}"
    print(gradeString)
    #print(f"\t Grading {Color.PURPLE} + {len(submissions)} submissions from {submissionsDirectory} + ")
    print(f"\t Unzipped Submissions to: {mainHomeworkFolder}")

def makeDir(mainHomeworkFolder):    
    if not os.path.isdir(mainHomeworkFolder):
        os.mkdir(mainHomeworkFolder)

def getStudentName(studentFolder):
    subDirs = studentFolder.split('/')
    nameDir = subDirs[-1];
    lastNameFirstName = nameDir.split("_")[0]
    return lastNameFirstName

def printAutogradeHeader(studentFolder):
    name = getStudentName(studentFolder)
    print(f"Student: {name}")
    print(f"\t Running JUnit Test for: {studentFolder}")

def logSubProcess(result, studentFolder):
    name = getStudentName(studentFolder)
    fileSubprocessResults = open(f"{studentFolder}/subprocess_result.txt", "w") 
    fileSubprocessResults.write(f"{result}")
    fileSubprocessResults.close()
    print()

def runAutoGradeSubProcess(studentFolder):
    name = getStudentName(studentFolder)
    result = subprocess.run(["bash", AUTOGRADE_BASH, studentFolder, ASSIGNMENT_FOLDER, name], text=True)
    return result

def runAutoGrader(studentFolder):
    printAutogradeHeader(studentFolder)
    result = runAutoGradeSubProcess(studentFolder) 
    logSubProcess(result, studentFolder)

def printResults(cwd,assignmentFolder):
    print()
    hmwrkFolders = f"{cwd}/{assignmentFolder}"
    # Directory to Homework Folders: /Users/amy/code/autograding/HomeworkOne001
    print(f"Directory to Homework Folders: {hmwrkFolders}")
    if os.path.isdir(hmwrkFolders):
        print("Yes. This directory exists.")
        paths = glob('{hmwrkFolders}/*')
        for p in paths: 
            print(p)
            print()

    else:
        print("No. This directory does not exist.")
     
def headingForEntireRun(CWD, SUBMISSIONS_DIR,AUTOGRADE_BASH,MAIN_HOMEWORK_DIR,INSTRUCTOR_CODE):
    CWD_PURPLE = color.PURPLE + CWD + color.END
    AUTOGRADE_BASH_PURPLE = color.PURPLE + AUTOGRADE_BASH + color.END
    MAIN_HOMEWORK_DIR_PURPLE = color.PURPLE + MAIN_HOMEWORK_DIR + color.END
    INSTRUCTOR_CODE_PURPLE = color.PURPLE + INSTRUCTOR_CODE + color.END
    SUBMISSIONS_DIR_PURPLE = color.PURPLE + SUBMISSIONS_DIR + color.END
    MAIN_HOMEWORK_DIR_PURPLE = color.PURPLE + MAIN_HOMEWORK_DIR + color.END
    
    print()
    print("--------------------------------------------------------------------------------------------------------")
    print(color.RED + "Let the autograding commence!" + color.END)
    autograder_underlined = color.UNDERLINE + "autograder" + color.END
    print(f"We are running the {autograder_underlined} from:") 
    print(f"\t {CWD_PURPLE}.")
    print(f"The bash script for autograding a single assignment is available at:") 
    print(f"\t {AUTOGRADE_BASH_PURPLE}.")
    print(f"Student code and the results from autograding will be available in:")
    print(f"\t {MAIN_HOMEWORK_DIR_PURPLE}.")
    print(f"My implementation of the assignment is available at:")
    print(f"\t {INSTRUCTOR_CODE_PURPLE}.")
    print(f"The zipped files submitted by students are located at:") 
    print(f"\t {SUBMISSIONS_DIR_PURPLE}.")
    print(f"Note: The original zip files and their extracted contents along with the results of the autograder will be available at:") 
    print(f"\t {MAIN_HOMEWORK_DIR_PURPLE}.")
    print("--------------------------------------------------------------------------------------------------------")
    print()

def getContentsOfFile(fileName):
    lines = []
    lineStr=""
    with open(fileName) as f:
        lines = f.readlines()
    for line in lines:
        lineStr+=line + "\n"
    return lineStr

def combineCodeAndResults(fileName1, fileName2, codeFile1, codeFile2, outputName):
    
    fileName1Str = "";
    try: 
        fileName1Str+= getContentsOfFile(fileName1)
    except FileNotFoundError:
        fileName1Str+= f"{fileName1} not found."
        pass


    fileName2Str = "";
    try: 
        fileName2Str+= getContentsOfFile(fileName2)
    except FileNotFoundError:
        fileName2Str+= f"{fileName2} not found."
        pass
    
    codeFile1Str="";
    try: 
        codeFile1Str+= getContentsOfFile(codeFile1)
    except FileNotFoundError:
        codeFile1Str+= f"{codeFile1} not found."
        pass

    codeFile2Str="";
    try: 
        codeFile2Str+= getContentsOfFile(codeFile2)
    except FileNotFoundError:
        codeFile2Str+= f"{codeFile2} not found."
        pass

    
    f = open(outputName, "a")
    f.write("***********************************\n")
    f.write(codeFile1Str)
    f.write("***********************************\n")
    f.write(codeFile2Str)
    f.write("***********************************\n")
    f.write(fileName1Str)
    f.write("***********************************\n")
    f.write(fileName2Str)
    f.write("***********************************\n")
    f.close()
    
    #open and read the file after the appending:
    #f = open("demofile2.txt", "r")
    #print(f.read())
def outputGradeLog(studentFolder,outputName):
    myFile = f"{studentFolder}/{outputName}"
    try:
        f = open(myFile, "r")
        print(f.read())
    except FileNotFoundError: 
        print(f"FileNotFound + {myFile}")



if __name__ == "__main__":
    CWD = os.getcwd()
    AUTOGRADE_BASH=f"{CWD}/bash-autograde-homeworkOne.sh";
    ASSIGNMENT_FOLDER="Section003/HomeworkOne"
    MAIN_HOMEWORK_DIR = f"{CWD}/{ASSIGNMENT_FOLDER}"
    makeDir(MAIN_HOMEWORK_DIR)
    JUNIT_FILE=f"{CWD}/HomeworkOne-JUnit"
    print(f"JUNIT_FILE: {JUNIT_FILE}")
    SUBMISSIONS_DIR = f"{cwd}/Section003/Homework1-Zip/submissions"

    fileName1 = "minIndexTest.txt"
    fileName2 = "printTest.txt" 
    codeFile1 = "Main.java"
    codeFile2 = "SelectionSort.java"
    outputName = "GradedAssignment.txt"
    
    headingForEntireRun(CWD, SUBMISSIONS_DIR,AUTOGRADE_BASH,MAIN_HOMEWORK_DIR,JUNIT_FILE)

    zipped_submissions_names = return_list_of_zipped_assignments(SUBMISSIONS_DIR)
    for zippedSubmission in zipped_submissions_names:
        extractedZipFileFolder = convertZipToFolderName(zippedSubmission)
        absPathZippedSubmission = f"{SUBMISSIONS_DIR}/{zippedSubmission}"
        absPathExtractedSubmission = f"{MAIN_HOMEWORK_DIR}/{extractedZipFileFolder}"
        print(f"absPathExtractedSubmission: {absPathExtractedSubmission}")
        unzipSubmission(absPathZippedSubmission,absPathExtractedSubmission)
        copyInstructorCode(JUNIT_FILE, absPathExtractedSubmission)
        runAutoGrader(absPathExtractedSubmission)
        combineCodeAndResults(f"{absPathExtractedSubmission}/{fileName1}", f"{absPathExtractedSubmission}/{fileName2}", f"{absPathExtractedSubmission}/{codeFile1}", f"{absPathExtractedSubmission}/{codeFile2}", f"{absPathExtractedSubmission}/{outputName}")
        outputGradeLog(absPathExtractedSubmission, outputName)
    
#printResults(cwd,assignmentFolder)



