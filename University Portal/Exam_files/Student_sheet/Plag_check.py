import os
import sys
from difflib import SequenceMatcher


all_answer = []
all_answer_name = []
plagiarism_percentage=60
# with open("1.txt") as f1:
#     content1 = f1.readlines()
# print(type(content1))
#
# f2=open("2.txt","r")
# content2 = f2.readlines()
# print(type(content2))
#
# all_answer.append(content1)
# all_answer.append(content2)
# print(all_answer)

Folder_path = r"D:\College\Projects\Mine\University Portal\Exam_files\Student_sheet"
def list_file(dir):
    all_file = os.listdir(dir)
    # print(all_file)
    file_ex = r".txt"
    for name in all_file:
        if(name.find(file_ex)!=-1):
            all_answer_name.append(name)

list_file(Folder_path)
# print(all_answer_name)

def add_ans():
    for file_name in all_answer_name:
        with open(file_name) as f:
            context = f.readlines()
            answer=[]
            for x in context:
                answer.append((x.replace("\n", "")).lower())
            all_answer.append(answer)

add_ans()
# print(all_answer)

plag_dict = {}

for i in range(0 , len(all_answer)):
    current_sheet=all_answer[i]
    copiedfrom = []
    for j in range(1,len(current_sheet)):
        current_answer=current_sheet[j]
        for i1 in range(0,len(all_answer)):
            temp_sheet=all_answer[i1]
            if(i==i1):
                continue
            for j1 in range(1,len(temp_sheet)):
                tocheckanswer=temp_sheet[j1]
                similarity=(SequenceMatcher(None, current_answer, tocheckanswer).ratio())*100

                if(similarity>plagiarism_percentage):
                    # print(str(current_sheet[0])+ " ==== " +str(temp_sheet[0]))
                    copiedfrom.append(temp_sheet[0])
                    # print(copiedfrom)
                    break

        plag_dict[current_sheet[0]]=copiedfrom

print(plag_dict.items())

report_path = r"D:\College\Projects\Mine\University Portal\Exam_files"

with open("D:\\College\\Projects\\Mine\\University Portal\\Exam_files\\report.txt",'w') as f1:
    f1.write("Plagiarism Level is "+str(plagiarism_percentage)+" or higher \n\n")
    f1.write("ROLL NO \t\t\t\t COPIED FROM\n\n")
    keys=list(plag_dict.keys())
    for item in keys:
        f1.write(str(item)+" \t\t\t\t\t "+str(list(plag_dict.get(item)))+"\n")
