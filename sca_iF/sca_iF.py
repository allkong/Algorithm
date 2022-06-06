from tkinter import *
import heapq

root = Tk()
root.title("스카iF")
root.geometry("300x250+700+200")

def btnclick():
    rooms=[]
    ans = list(map(int, txt.get("1.0", "end-1c").replace('\n', ' ').split(' ')))

    for i in range(0, len(ans)-1, 2):
        rooms.append(ans[i:i+2])

    rooms = sorted(rooms, key=lambda x: x[0])

    q = []
    for room in rooms:
        if q and q[0] <= room[0]:
            heapq.heappop(q)
        heapq.heappush(q, room[1])

    arg1 = len(q)
    print(rooms[0][1])
    label2.config(text="{}개".format(arg1))


label1 = Label(root, text="스터디룸 관리\n")

txt = Text(root, width=30, height=10)
txt.insert(END, "예약 시간을 입력하세요")

btn1 = Button(root, width=10, height=8, text="CLICK", command=btnclick)

frame_room = LabelFrame(root, text="필요한 스터디룸")
label2 = Label(frame_room, text="")

label1.pack()
frame_room.pack(side="top")
label2.pack(side="top")
btn1.pack(side="right")
txt.pack(side="left")

root.mainloop()