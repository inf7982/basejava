import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    private int arraySize = 0;
    private Resume[] storage = new Resume[10000];

    public void update(Resume resume) {
        int index = getIndex(resume.uuid);
        if (index == -1) {
            System.out.println("UPDATE ERROR: Резюме не найдено");
        } else {
            storage[index] = resume;
        }
    }

    public void clear() {
        Arrays.fill(storage, 0, arraySize, null);
        arraySize = 0;
    }

    public void save(Resume resume) {
        if (getIndex(resume.uuid) != -1) {
            System.out.println("SAVE ERROR: Резюме " + resume.uuid + " уже существует");
        } else if (arraySize == storage.length) {
            System.out.println("SAVE ERROR: Массив переполнен");
        } else {
            storage[arraySize] = resume;
            arraySize++;
        }
    }

    public Resume get(String uuid) {
        if (getIndex(uuid) == -1) {
            System.out.println("GET ERROR: Резюме не найдено");
            return null;
        }
        return storage[getIndex(uuid)];
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("DELETE ERROR: Резюме не найдено");
        } else {
            storage[index] = storage[arraySize - 1];
            storage[arraySize - 1] = null;
            arraySize--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        return Arrays.copyOf(storage, arraySize);
    }

    public int size() {
        return arraySize;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < arraySize; i++) {
            if (storage[i].toString() == uuid)
                return i;
        }
        return -1;
    }
}