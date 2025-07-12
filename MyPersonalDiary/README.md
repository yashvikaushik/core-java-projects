# 📝 Personal Diary App in Java (with File Handling & Serialization)

A simple **Java-based Diary App** that allows you to add and view personal notes using **file handling** and **object serialization**. This project helps reinforce key Java concepts like classes, arrays, I/O streams, and exception handling.

---

## 📌 Project Highlights

- ✍️ Add diary entries with title, content, and date
- 📂 View all saved diary entries
- 💾 Saves each entry as a `.txt` or `.ser` file
- ⚙️ Uses `Serializable` to store and retrieve `Note` objects
- 🛡️ Skips unwanted files like `.DS_Store` on macOS
- 💥 Exception handling included to prevent crashes

---

## 🔧 Technologies Used

- Java Core
- File Handling (I/O)
- Object Serialization
- OOP (Encapsulation, Classes)
- Exception Handling
- Arrays

---

## 🗂️ Project Structure
PersonalDiary/
├── diary/
│   ├── model/
│   │   └── Note.java             # Serializable Note class
│   ├── dal/
│   │   └── DiaryFileHandler.java # Handles file storage and retrieval
│   └── ui/
│       └── DiaryApp.java         # Main class for user interaction

---

## 👨‍💻 Author

- **Name:** Yashvi Kaushik  
- **GitHub:** [github.com/YashviKaushik](https://github.com/YashviKaushik) *(Replace with actual link if different)*  
- **University:** BTech CSE (AI), Bennett University  
- **Year:** First Year (2025)

---

## 🧠 Learning Goals

- ✅ Practice real-world file handling in Java
- ✅ Understand how `ObjectOutputStream` and `ObjectInputStream` work
- ✅ Manage arrays and exception flow
- ✅ Build confidence using serialization and directory-based storage

---

## ❗ Common Mistakes & Fixes

| Mistake | Fixed By |
|--------|----------|
| ❌ Used `Note[] notes = null` without initializing | ✅ Initialized with `new Note[file.length]` |
| ❌ `NullPointerException` on `notes[index] = obj;` | ✅ Ensured array is allocated before use |
| ❌ Printing raw array: `System.out.println(notes)` | ✅ Added `toString()` in `Note` class and printed each note in a loop |
| ❌ `.DS_Store` file causing errors | ✅ Skipped such files using `if(file[i].getName().contains("DS_Store")) continue;` |

⚠️ Notes
	•	Make sure your project folder has a valid subfolder (e.g., ./notes/) where the serialized files will be stored.
	•	macOS users: .DS_Store is auto-generated — the app safely skips this.


---

## 💡 Sample Output
Choose an option: 3
fileName:2025-07-08.txt
fileName:2025-07-07.txt
Note [Date=2025-07-08, Title=Shopping List, Content=Buy groceries]
Note [Date=2025-07-07, Title=Meeting Notes, Content=Call with team at 4PM]

🤝 Contributing

Pull requests are welcome. For major changes, open an issue first to discuss what you would like to change.

🙋‍♀️ Author
Yashvi Kaushik
📬 Contact
Feel free to reach out for suggestions, questions, or collaboration!

📧 yashvikaushik2525@gmail.com
🔗https://www.linkedin.com/in/yashvi-kaushik/

