public class Shop {
    private Student[] students;
    private int total = 0;

    public Shop(int numberItems) {
        students = new Student[numberItems];
    }

    private boolean isFull() {
        return total == students.length;
    }

    private boolean isEmpty() {
        return total == 0;
    }

    public boolean add(Student astudent) {
        if (isFull()) {
            return false;
        } else {
            students[total] = astudent;
            total++;
            return true;
        }
    }

    public String list() {
        if (isEmpty()) {
            return "No students in the store";
        } else {
            String listOfStudents = "";
            for (int i = 0; i < total; i++) {
                listOfStudents += i + ": " + students[i] + "\n";
            }
            return listOfStudents;
        }
    }

    public Student find(String name) {

        Student foundStudent =  null;

        if (!isEmpty()) {
            for (int i = 0; i < total; i++)
                if (students[i].getName().equals(name))
                    foundStudent = students[i];
        }
        else {
            return null;
        }
        return foundStudent;
    }
}
